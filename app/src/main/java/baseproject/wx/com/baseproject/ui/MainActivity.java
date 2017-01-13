package baseproject.wx.com.baseproject.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.garymansell.SweetAlert.SweetAlertDialog;

import baseproject.wx.com.baseproject.R;
import baseproject.wx.com.baseproject.base.BaseActivity;
import baseproject.wx.com.baseproject.service.UpdateAppService;
import baseproject.wx.com.baseproject.utils.StartActivityUtil;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements View.OnClickListener {
    private String apkUrl = "https://o60knd4hs.qnssl.com/Weinei-Android_20161230174404.apk";

    @BindView(R.id.text1)
    public TextView tv1;//图片加载

    @BindView(R.id.text2)
    public TextView tv2;//网络请求

    @BindView(R.id.text3)
    public TextView tv3;//RecyclerView

    @BindView(R.id.text4)
    public TextView tv4;//XRecyclerViewActivity

    @BindView(R.id.text5)
    public TextView tv5;//SweetAlertDialog

    @BindView(R.id.text6)
    public TextView tv6;//拍照，图库

    @BindView(R.id.text7)
    public TextView tv7;//下载

    @BindView(R.id.text8)
    public TextView tv8;//Html5

    @BindView(R.id.text9)
    public TextView tv9;//检查更新


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initOnClick();
    }


    private void initOnClick() {
        tv1.setOnClickListener(this);
        tv2.setOnClickListener(this);
        tv3.setOnClickListener(this);
        tv4.setOnClickListener(this);
        tv5.setOnClickListener(this);
        tv6.setOnClickListener(this);
        tv7.setOnClickListener(this);
        tv8.setOnClickListener(this);
        tv9.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.text1:
                StartActivityUtil.statr(this, ImageLoadActivity.class);
                break;
            case R.id.text2:
                StartActivityUtil.statr(this, HttpRequestActivity.class);
                break;
            case R.id.text3:
                StartActivityUtil.statr(this, ListViewActivity.class);
                break;
            case R.id.text4:
                StartActivityUtil.statr(this, XRecyclerViewActivity.class);
                break;
            case R.id.text5:
                StartActivityUtil.statr(this, SweetAletDialogActivity.class);
                break;
            case R.id.text6:
                StartActivityUtil.statr(this, ImageSelectActivity.class);
                break;
            case R.id.text7:
                StartActivityUtil.statr(this, DownLoaderActiivty.class);
                break;
            case R.id.text8:
                StartActivityUtil.statr(this, WeexActivity.class);
                break;
            case R.id.text9:
                checkAppUpdate();
                break;
        }
    }

    //检查更新
    private void checkAppUpdate() {
        final SweetAlertDialog sweetAlertDialog = new SweetAlertDialog(this, SweetAlertDialog.WARNING_TYPE);
        sweetAlertDialog.setTitleText("发现新版本！");
        sweetAlertDialog.setContentText("为了更好的用户体验，您是否选择更新？");
        sweetAlertDialog.setCancelText("稍后更新");
        sweetAlertDialog.setConfirmText("立即更新");
        sweetAlertDialog.showCancelButton(true);
        sweetAlertDialog.setCancelClickListener(new SweetAlertDialog.OnSweetClickListener() {
            @Override
            public void onClick(SweetAlertDialog sDialog) {
                sweetAlertDialog.cancel();
            }
        });
        sweetAlertDialog.setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
            @Override
            public void onClick(SweetAlertDialog sDialog) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, UpdateAppService.class);
                intent.putExtra(UpdateAppService.INTENT_DOWNLOAD_URL, apkUrl);
                intent.putExtra(UpdateAppService.INTENT_SAVE_NAME, "weinei.apk");
                startService(intent);
                sweetAlertDialog.cancel();
            }
        });
        sweetAlertDialog.show();
    }
}
