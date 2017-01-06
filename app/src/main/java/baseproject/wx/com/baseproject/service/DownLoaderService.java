package baseproject.wx.com.baseproject.service;

import android.app.NotificationManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import java.io.File;

import baseproject.wx.com.baseproject.R;
import cn.aigestudio.downloader.bizs.DLManager;
import cn.aigestudio.downloader.interfaces.SimpleDListener;

/**
 * Created by android_wx on 17/1/5.
 */

public class DownLoaderService extends Service {
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        String url = intent.getStringExtra("url");
        String path = intent.getStringExtra("path");
        final int id = intent.getIntExtra("id", -1);
        final NotificationManager nm = (NotificationManager) getSystemService(Context
                .NOTIFICATION_SERVICE);
        final NotificationCompat.Builder builder = (NotificationCompat.Builder) new NotificationCompat.Builder(this)
                .setSmallIcon(R.mipmap.ic_launcher);

        final int[] length = new int[1];
        DLManager.getInstance(this).dlStart(url, path, null, null, new SimpleDListener() {
                    @Override
                    public void onStart(String fileName, String realUrl, int fileLength) {
                        builder.setContentTitle(fileName);
                        length[0] = fileLength;
                    }

                    @Override
                    public void onProgress(int progress) {
                        builder.setProgress(length[0], progress, false);
                        nm.notify(id, builder.build());
                    }

                    @Override
                    public void onFinish(File file) {
                        nm.cancel(id);
                        /** 下载完成后自动安装apk */
                        if (!file.exists()) {
                            return;
                        }
                        Intent intent = new Intent(Intent.ACTION_VIEW);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        intent.setDataAndType(Uri.parse("file://" + file.toString()),
                                "application/vnd.android.package-archive");
                        startActivity(intent);
                    }

                    @Override
                    public void onError(int status, String error) {
                        super.onError(status, error);
                        Log.d("WX",status+"***"+error);
                    }
                }

        );
        return super.

                onStartCommand(intent, flags, startId);

    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

}