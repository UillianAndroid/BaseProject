package baseproject.wx.com.baseproject;

import android.app.Application;

import com.lzy.okhttputils.OkHttpUtils;

/**
 * Created by android_wx on 16/12/28.
 */

public class MyApplication extends Application {
    private static MyApplication myApplication;

    public static MyApplication getinstance() {
        return myApplication;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        myApplication = this;
        initOkHttp();// 初始化OkHttp
    }

    // 初始化OkHttp
    private void initOkHttp() {
        // 必须调用初始化
        OkHttpUtils.init(this);
        // 以下都不是必须的，根据需要自行选择
        OkHttpUtils.getInstance()//
                .debug("OkHttpUtils") // 是否打开调试
                .setConnectTimeout(OkHttpUtils.DEFAULT_MILLISECONDS) // 全局的连接超时时间
                .setReadTimeOut(OkHttpUtils.DEFAULT_MILLISECONDS) // 全局的读取超时时间
                .setWriteTimeOut(OkHttpUtils.DEFAULT_MILLISECONDS); // 全局的写入超时时间
        // .setCookieStore(new MemoryCookieStore())
        // cookie使用内存缓存（app退出后，cookie消失）
        // .setCookieStore(new PersistentCookieStore())
        // //cookie持久化存储，如果cookie不过期，则一直有效
        // .addCommonHeaders(headers) // 设置全局公共头
        // .addCommonParams(null); // 设置全局公共参数
    }
}
