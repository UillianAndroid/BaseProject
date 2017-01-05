package baseproject.wx.com.baseproject.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import baseproject.wx.com.baseproject.R;
import baseproject.wx.com.baseproject.utils.NotificationUtil;
import butterknife.BindView;
import butterknife.ButterKnife;

public class DownLoaderActiivty extends AppCompatActivity implements View.OnClickListener {
    private String downloadUrl = "https://github.com/UillianAndroid/BaseProject/archive/master.zip";

    @BindView(R.id.text1)
    TextView textView;

    @BindView(R.id.button1)
    Button btn1;

    @BindView(R.id.button2)
    Button btn2;

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
    }

    private void startDownload() {
        NotificationUtil.notificationForDLAPK(DownLoaderActiivty.this, downloadUrl);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button1:
                startDownload();
                break;
            case R.id.button2:
                break;
        }
    }
}
