package baseproject.wx.com.baseproject.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.lzy.okhttputils.OkHttpUtils;
import com.lzy.okhttputils.request.BaseRequest;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import baseproject.wx.com.baseproject.R;
import baseproject.wx.com.baseproject.base.BaseActivity;
import baseproject.wx.com.baseproject.bean.Bean;
import baseproject.wx.com.baseproject.bean.Resp;
import baseproject.wx.com.baseproject.http.HttpResponseStringCallback;
import baseproject.wx.com.baseproject.utils.GsonUtil;
import baseproject.wx.com.baseproject.utils.ProgressUtil;
import baseproject.wx.com.baseproject.xml.PullRespPraser;
import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Request;
import okhttp3.Response;

public class HttpRequestActivity extends BaseActivity implements View.OnClickListener {

    @BindView(R.id.button1)
    Button btn1;

    @BindView(R.id.button2)
    Button btn2;

    @BindView(R.id.text1)
    TextView textView1;

    @BindView(R.id.text2)
    TextView textView2;

    private int TAG;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.http_request_activity);
        ButterKnife.bind(this);
        initUI();
    }

    private void initUI() {
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button1:
                TAG = 1;
                httpGet("http://api.careinner.com/v1/banners/patient_home.json?usage=patient_home&access_token=edca6176605cfe2d07ae8bb9632b145308b600975e8b2d71bcfa6979b0496840");
                break;
            case R.id.button2:
                TAG = 2;
                httpGet("http://wthrcdn.etouch.cn/WeatherApi?citykey=101010100");
                break;
        }
    }

    private void httpGet(String url) {
        OkHttpUtils.get(url).execute(httpResponseStringCallback);
    }

    HttpResponseStringCallback httpResponseStringCallback = new HttpResponseStringCallback() {
        @Override
        public void onBefore(BaseRequest request) {
            super.onBefore(request);
            ProgressUtil.startProgressBar(HttpRequestActivity.this);
        }

        @Override
        public void onResponse(boolean b, String s, Request request, @Nullable Response response) {
            super.onResponse(b, s, request, response);
            textView1.setText("");
            textView2.setText(s);
            if (TAG == 1) {
                Bean bean = GsonUtil.analyzeJson(s);
                textView1.append("状态" + bean.getStatus());
                textView1.append("数据" + bean.getData());
            } else if (TAG == 2) {
                PullRespPraser praser = new PullRespPraser();
                InputStream is = new ByteArrayInputStream(s.getBytes());
                try {
                    Resp resp = praser.parse(is);
                    textView1.setText(resp.toString());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        @Override
        public void onAfter(boolean isFromCache, @Nullable String s, Call call, @Nullable Response response, @Nullable Exception e) {
            super.onAfter(isFromCache, s, call, response, e);
            ProgressUtil.stopProgressBar();
        }
    };
}
