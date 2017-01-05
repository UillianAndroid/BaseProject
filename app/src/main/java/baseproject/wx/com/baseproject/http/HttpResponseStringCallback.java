package baseproject.wx.com.baseproject.http;

import android.support.annotation.Nullable;

import com.lzy.okhttputils.callback.StringCallback;
import com.lzy.okhttputils.request.BaseRequest;

import okhttp3.Call;
import okhttp3.Request;
import okhttp3.Response;

/**
 * @接口text文本类返回
 * @注释部分在文本中不考虑，如有特殊需要可开放
 * @Created by android_wx on 17/1/5.
 */

public abstract class HttpResponseStringCallback extends StringCallback {
    @Override
    public void onBefore(BaseRequest request) {
        super.onBefore(request);
    }

//    @Override
//    public void upProgress(long currentSize, long totalSize, float progress, long networkSpeed) {
//        super.upProgress(currentSize, totalSize, progress, networkSpeed);
//    }

    @Override
    public void onResponse(boolean b, String s, Request request, @Nullable Response response) {

    }

    @Override
    public void onAfter(boolean isFromCache, @Nullable String s, Call call, @Nullable Response response, @Nullable Exception e) {
        super.onAfter(isFromCache, s, call, response, e);
    }

//    @Override
//    public void onError(boolean isFromCache, Call call, @Nullable Response response, @Nullable Exception e) {
//        super.onError(isFromCache, call, response, e);
//    }
//
//    @Override
//    public void downloadProgress(long currentSize, long totalSize, float progress, long networkSpeed) {
//        super.downloadProgress(currentSize, totalSize, progress, networkSpeed);
//    }
//
//    @Override
//    public String parseNetworkResponse(Response response) throws Exception {
//        return super.parseNetworkResponse(response);
//    }
}