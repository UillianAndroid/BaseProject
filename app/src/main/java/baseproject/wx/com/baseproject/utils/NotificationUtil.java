package baseproject.wx.com.baseproject.utils;

import android.content.Context;
import android.content.Intent;
import android.os.Environment;

import baseproject.wx.com.baseproject.service.DownLoaderService;

/**
 * 通知工具类
 *
 * @author AigeStudio 2015-05-18
 */
public final class NotificationUtil {
    public static void notificationForDLAPK(Context context, String url) {
        notificationForDLAPK(context, url, Environment.getExternalStorageDirectory() + "/baseProject/");
    }

    public static void notificationForDLAPK(Context context, String url, String path) {
        Intent intent = new Intent(context, DownLoaderService.class);
        intent.putExtra("url", url);
        intent.putExtra("path", path);
        intent.putExtra("id", (int) (Math.random() * 1024));
        context.startService(intent);
    }
}
