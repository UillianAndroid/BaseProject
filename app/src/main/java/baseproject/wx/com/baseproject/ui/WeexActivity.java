package baseproject.wx.com.baseproject.ui;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;

import baseproject.wx.com.baseproject.R;
import butterknife.BindView;
import butterknife.ButterKnife;

public class WeexActivity extends AppCompatActivity {

    @BindView(R.id.webview1)
    WebView mWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weex);
        ButterKnife.bind(this);
        initUI();
    }

    private void initUI() {
        // 设置缓存模式
        mWebView.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
        mWebView.getSettings().setJavaScriptEnabled(true);


        // Use WideViewport and Zoom out if there is no viewport defined
        mWebView.getSettings().setUseWideViewPort(true);
        mWebView.getSettings().setLoadWithOverviewMode(true);

        mWebView.setVerticalScrollBarEnabled(false);
        mWebView.setHorizontalScrollBarEnabled(false);

        // 支持通过js打开新的窗口
        mWebView.getSettings().setJavaScriptCanOpenWindowsAutomatically(false);

        mWebView.loadUrl("www.baidu.com");

        mWebView.setWebChromeClient(new WebChromeClient() {

            @Override
            public boolean onJsAlert(WebView view, String url, String message,
                                     final JsResult result) {
                //Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
                result.cancel();
                mWebView.loadUrl("www.baidu.com");
                return true;
            }

            @Override
            public boolean onJsConfirm(WebView view, String url,
                                       String message, final JsResult result) {
                mWebView.loadUrl("www.baidu.com");
                return true;
            }
        });

        if (Build.VERSION.SDK_INT >= 11) {
            mWebView.setLayerType(WebView.LAYER_TYPE_SOFTWARE, null);
        }

    }
}
