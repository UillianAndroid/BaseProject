package baseproject.wx.com.baseproject.ui;

import android.Manifest;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.tbruyelle.rxpermissions.RxPermissions;

import java.io.File;

import baseproject.wx.com.baseproject.R;
import baseproject.wx.com.baseproject.base.BaseActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;
import zlc.season.rxdownload.RxDownload;
import zlc.season.rxdownload.entity.DownloadStatus;
import zlc.season.rxdownload.function.Utils;

import static android.os.Environment.DIRECTORY_DOWNLOADS;
import static android.os.Environment.getExternalStoragePublicDirectory;

public class DownLoaderActiivty extends BaseActivity implements View.OnClickListener {
    @BindView(R.id.text1)
    TextView textView;

    @BindView(R.id.progressbar1)
    ProgressBar mProgress;

    private String saveName = "weixin.apk";
    private String defaultPath = getExternalStoragePublicDirectory(DIRECTORY_DOWNLOADS).getPath();
    private String savePath = Environment.getExternalStorageDirectory() + "/baseProject/";
    private String url = "http://dldir1.qq.com/weixin/android/weixin6330android920.apk";
    private Subscription subscription;
    private RxDownload mRxDownload;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.down_loader_actiivty_activity);
        ButterKnife.bind(this);
        mRxDownload = RxDownload.getInstance()
                .maxThread(10)      //一次同时最大下载数量
                .context(this)      // 自动安装需要Context
                .autoInstall(true); //下载完成自动安装
        initUI();
    }

    private void initUI() {
        textView.setText(url);
    }

    private void start() {
        subscription = RxPermissions.getInstance(this)
                .request(Manifest.permission.WRITE_EXTERNAL_STORAGE)
                .doOnNext(new Action1<Boolean>() {
                    @Override
                    public void call(Boolean granted) {
                        if (!granted) {
                            throw new RuntimeException("no permission");
                        }
                    }
                })
                .observeOn(Schedulers.io())
                .compose(mRxDownload.transform(url, saveName, savePath))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<DownloadStatus>() {
                    @Override
                    public void onStart() {
                        super.onStart();
                    }

                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.w("TAG", e);
                    }

                    @Override
                    public void onNext(final DownloadStatus status) {
                        mProgress.setIndeterminate(status.isChunked);
                        mProgress.setMax((int) status.getTotalSize());
                        mProgress.setProgress((int) status.getDownloadSize());
                    }
                });
    }

    private void pause() {
        Utils.unSubscribe(subscription);
    }

    private void delete() {
        pause();
        mProgress.setProgress(0);
        File file = new File(savePath + saveName);
        Log.e("DownLoaderActiivty", file.getPath());
        if (file.exists()) {
            Log.e("DownLoaderActiivty", "存在！！！");
            file.delete();
        } else {
            Log.e("DownLoaderActiivty", "不存在！！！");
        }
    }

    private void installApk() {
        Uri uri = Uri.fromFile(new File(defaultPath + File.separator + saveName));
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        intent.setDataAndType(uri, "application/vnd.android.package-archive");
        startActivity(intent);
    }

    @OnClick({R.id.button1, R.id.button2, R.id.button3})
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button1:
                delete();
                break;
            case R.id.button2:
                start();
                break;
            case R.id.button3:
                pause();
                break;
        }
    }
}
