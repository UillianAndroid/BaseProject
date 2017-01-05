package baseproject.wx.com.baseproject.http;

import android.graphics.Bitmap;
import android.support.annotation.Nullable;

import com.lzy.okhttputils.callback.BitmapCallback;
import com.lzy.okhttputils.request.BaseRequest;

import okhttp3.Call;
import okhttp3.Request;
import okhttp3.Response;

/**
 * @接口图片Bitmap类返回
 * @
 * @Created by android_wx on 17/1/5.
 */

public class HttpResponseBitmapCallback extends BitmapCallback {

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
    public void onResponse(boolean b, Bitmap bitmap, Request request, @Nullable Response response) {

    }

    @Override
    public void onAfter(boolean isFromCache, @Nullable Bitmap bitmap, Call call, @Nullable Response response, @Nullable Exception e) {
        super.onAfter(isFromCache, bitmap, call, response, e);
    }

    @Override
    public void onError(boolean isFromCache, Call call, @Nullable Response response, @Nullable Exception e) {
        super.onError(isFromCache, call, response, e);
    }

    @Override
    public Bitmap parseNetworkResponse(Response response) throws Exception {
        return super.parseNetworkResponse(response);
    }
}
