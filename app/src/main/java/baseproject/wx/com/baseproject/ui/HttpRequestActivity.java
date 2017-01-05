package baseproject.wx.com.baseproject.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lzy.okhttputils.OkHttpUtils;
import com.lzy.okhttputils.callback.StringCallback;

import baseproject.wx.com.baseproject.R;
import baseproject.wx.com.baseproject.bean.Bean;
import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Request;
import okhttp3.Response;

public class HttpRequestActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.editText1)
    EditText editText;

    @BindView(R.id.button1)
    Button btn1;

    @BindView(R.id.text1)
    TextView textView1;

    @BindView(R.id.text2)
    TextView textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.http_request_activity);
        ButterKnife.bind(this);
        initUI();
    }

    private void initUI() {
        btn1.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button1:
                httpGet();
                break;
        }
    }

    private void httpGet() {
        OkHttpUtils.get("http://api.careinner.com/v1/banners/patient_home.json?usage=patient_home&access_token=65debe322c9dad5c7baad5936eb0f41b38cf1a956c64623a5f3aa933f9ece410").execute(new StringCallback() {
            @Override
            public void onResponse(boolean b, String s, Request request, @Nullable Response response) {
                textView2.setText(s);
                Gson gson = new Gson();
                Bean bean = gson.fromJson(s, new TypeToken<Bean>() {
                }.getType());
                textView1.append("Status:");
                for(int i=0;i<bean.getData().getBanners().size();i++){
                    for(int j=0;j<bean.getData().getBanners().get(i).getBanner_files().size();j++){

                    }
                }

                Log.d("HTTP", bean.getData().getBanners().get(0).getId() + "***" + bean.getData().getBanners().get(0).getUsage() + "***" + bean.getData().getBanners().get(0).getStatus());
            }
        });
    }
}
