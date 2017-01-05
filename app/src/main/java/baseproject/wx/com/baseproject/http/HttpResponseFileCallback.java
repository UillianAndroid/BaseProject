package baseproject.wx.com.baseproject.http;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.lzy.okhttputils.callback.FileCallback;
import com.lzy.okhttputils.request.BaseRequest;

import java.io.File;

import okhttp3.Call;
import okhttp3.Request;
import okhttp3.Response;

/**
 * @接口File类返回
 * @
 * @Created by android_wx on 17/1/5.
 */

public abstract class HttpResponseFileCallback extends FileCallback {

    public HttpResponseFileCallback(String destFileName) {
        super(destFileName);
    }

    public HttpResponseFileCallback(@NonNull String destFileDir, @NonNull String destFileName) {
        super(destFileDir, destFileName);
    }

    @Override
    public void onBefore(BaseRequest request) {
        super.onBefore(request);
    }

    @Override
    public void upProgress(long currentSize, long totalSize, float progress, long networkSpeed) {
        super.upProgress(currentSize, totalSize, progress, networkSpeed);
    }

    @Override
    public void downloadProgress(long currentSize, long totalSize, float progress, long networkSpeed) {
        super.downloadProgress(currentSize, totalSize, progress, networkSpeed);
    }

    @Override
    public void onResponse(boolean b, File file, Request request, @Nullable Response response) {

    }

    @Override
    public void onAfter(boolean isFromCache, @Nullable File file, Call call, @Nullable Response response, @Nullable Exception e) {
        super.onAfter(isFromCache, file, call, response, e);
    }

    @Override
    public void onError(boolean isFromCache, Call call, @Nullable Response response, @Nullable Exception e) {
        super.onError(isFromCache, call, response, e);
    }

    @Override
    public File parseNetworkResponse(Response response) throws Exception {
        return super.parseNetworkResponse(response);
    }
}
