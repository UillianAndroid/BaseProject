package baseproject.wx.com.baseproject.base;

import android.app.Activity;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;

import com.garymansell.SweetAlert.SweetAlertDialog;

import baseproject.wx.com.baseproject.data.UserSharepreference;
import baseproject.wx.com.baseproject.receiver.NetChangeBroadcastReceiver;

/**
 * Created by android_wx on 16/12/22.
 */

public class BaseActivity extends Activity implements NetChangeBroadcastReceiver.NetChangeInterface {

    public UserSharepreference userSP;
    /**
     * 关于SweetAlertDialog几种使用场景，在Activty中直接使用方法
     */
    public SweetAlertDialog loadingSD;//数据加载时弹出，加载完毕隐藏
    public SweetAlertDialog loadErrorSD;//加载数据失败时弹出
    public SweetAlertDialog loadSuccessSD;//成功时弹出,一般的数据加载不需要，使用场景如：上传数据成功弹出
    public SweetAlertDialog waringSD;//警告时弹出提示
    public SweetAlertDialog normalSD;//一般普通的提示信息
    public SweetAlertDialog customImageSD;//自定义图片提示

    private NetChangeBroadcastReceiver netChangeBroadcastReceiver;
    private SweetAlertDialog netChangeSD;//检测网络变化时弹出

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        userSP = UserSharepreference.getInstabce(this);
        netOnChangeListenner();
        initSweetAlertDialog();
    }

    private void initSweetAlertDialog() {
        loadingSD = new SweetAlertDialog(this, SweetAlertDialog.PROGRESS_TYPE);
        loadErrorSD = new SweetAlertDialog(this, SweetAlertDialog.ERROR_TYPE);
        loadSuccessSD = new SweetAlertDialog(this, SweetAlertDialog.SUCCESS_TYPE);
        waringSD = new SweetAlertDialog(this, SweetAlertDialog.WARNING_TYPE);
        normalSD = new SweetAlertDialog(this, SweetAlertDialog.NORMAL_TYPE);
        customImageSD = new SweetAlertDialog(this, SweetAlertDialog.CUSTOM_IMAGE_TYPE);
    }

    //  监听网络状态
    private void netOnChangeListenner() {
        netChangeBroadcastReceiver = new NetChangeBroadcastReceiver(this);
        IntentFilter filter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        registerReceiver(netChangeBroadcastReceiver, filter);
    }


    @Override
    public void netIsWifi() {
        hideSweetDialog();
//        netChangeSD = new SweetAlertDialog(this);
//        netChangeSD.setCancelable(true);
//        netChangeSD.setTitleText("当前是wifi网络状态");
//        netChangeSD.setCanceledOnTouchOutside(true);
//        netChangeSD.show();
    }

    @Override
    public void netIsGPRS() {
        hideSweetDialog();
        netChangeSD = new SweetAlertDialog(this);
        netChangeSD.setCancelable(true);
        netChangeSD.setTitleText("当前是GPRS网络状态");
        netChangeSD.setCanceledOnTouchOutside(true);
        netChangeSD.show();
    }

    @Override
    public void netUnavailable() {
        hideSweetDialog();
        netChangeSD = new SweetAlertDialog(this);
        netChangeSD.setCancelable(true);
        netChangeSD.setTitleText("没有网啦！！！");
        netChangeSD.setCanceledOnTouchOutside(true);
        netChangeSD.show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //结束监听网络
        unregisterReceiver(netChangeBroadcastReceiver);
    }

    private void hideSweetDialog() {
        if (netChangeSD != null) {
            netChangeSD.cancel();
        }
    }
}
