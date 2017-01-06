package baseproject.wx.com.baseproject.ui;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import baseproject.wx.com.baseproject.R;
import baseproject.wx.com.baseproject.utils.NotificationUtil;
import butterknife.BindView;
import butterknife.ButterKnife;
import cn.aigestudio.downloader.bizs.DLManager;
import cn.aigestudio.downloader.interfaces.SimpleDListener;

public class DownLoaderActiivty extends AppCompatActivity implements View.OnClickListener {
    private String apkUrl = "https://o60knd4hs.qnssl.com/Weinei-Android_20161230174404.apk";
    private String downloadUrl = "https://github.com/UillianAndroid/BaseProject/archive/master.zip";
    private String savePath = Environment.getExternalStorageDirectory() + "/baseProject/";

    @BindView(R.id.text1)
    TextView textView;

    @BindView(R.id.button1)
    Button btn1;

    @BindView(R.id.button2)
    Button btn2;
    @BindView(R.id.button3)
    Button btn3;

    @BindView(R.id.progressbar1)
    ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.down_loader_actiivty_activity);
        ButterKnife.bind(this);
        initUI();
    }

    private void initUI() {
        textView.setText(downloadUrl);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
    }

    private void startNotifyDownload() {
        NotificationUtil.notificationForDLAPK(DownLoaderActiivty.this, apkUrl);
    }

    private void startProgressDownLoad() {
        DLManager.getInstance(DownLoaderActiivty.this).dlStart(downloadUrl, savePath,
                null, null, new SimpleDListener() {
                    @Override
                    public void onStart(String fileName, String realUrl, int fileLength) {
                        progressBar.setMax(fileLength);
                    }

                    @Override
                    public void onProgress(int progress) {
                        progressBar.setProgress(progress);
                    }
                });
    }

    private void stopProgressDownLoad() {
        DLManager.getInstance(DownLoaderActiivty.this).dlCancel(downloadUrl);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button1:
                startNotifyDownload();
                break;
            case R.id.button2:
                startProgressDownLoad();
                break;
            case R.id.button3:
                stopProgressDownLoad();
                break;
        }
    }
}
