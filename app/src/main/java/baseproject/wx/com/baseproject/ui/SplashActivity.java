package baseproject.wx.com.baseproject.ui;

import android.os.Bundle;
import android.widget.TextView;

import baseproject.wx.com.baseproject.R;
import baseproject.wx.com.baseproject.base.BaseActivity;
import baseproject.wx.com.baseproject.utils.StartActivityUtil;
import baseproject.wx.com.baseproject.utils.TimeUtil;
import butterknife.BindView;
import butterknife.ButterKnife;

public class SplashActivity extends BaseActivity implements TimeUtil.TimeUtilInterface {

    @BindView(R.id.splashactivity_textview1)
    TextView spleshactivityTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);
        initUI();
    }

    private void initUI() {
        TimeUtil.getInstance(this).CountdownTvShow(this, 1);//倒计时3秒进入首页
    }

    @Override
    public void timerTaskDuration(int duration) {
        if (duration == 1) {
            if (userSP.getIsGuide()) {
                StartActivityUtil.statr(this, GuideActivity.class);
            } else {
                StartActivityUtil.statr(this, MainActivity.class);
            }
            finish();
        }
    }
}
