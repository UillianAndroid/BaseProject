package baseproject.wx.com.baseproject.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.garymansell.SweetAlert.SweetAlertDialog;

import baseproject.wx.com.baseproject.R;
import baseproject.wx.com.baseproject.base.BaseActivity;
import baseproject.wx.com.baseproject.custom.MyPopWindow;
import baseproject.wx.com.baseproject.service.UpdateAppService;
import baseproject.wx.com.baseproject.utils.StartActivityUtil;
import baseproject.wx.com.baseproject.utils.ToastUtil;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

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
    }

    @OnClick({R.id.text1, R.id.text2, R.id.text3, R.id.text4, R.id.text5, R.id.text6, R.id.text7, R.id.text8, R.id.text9, R.id.text10})
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
            case R.id.text10:
                MyPopWindow myPopWindow = new MyPopWindow(this, false, onClickListener);
                myPopWindow.showAtLocation(findViewById(R.id.activity_main), Gravity.BOTTOM, 0, 0);
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

    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.popwindow_top_tv:
                    ToastUtil.shortShow(MainActivity.this, "顶部按钮");
                    break;
                case R.id.popwindow_center_tv:
                    ToastUtil.shortShow(MainActivity.this, "中间按钮");
                    break;
            }
        }
    };

}
