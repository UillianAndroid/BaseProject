package baseproject.wx.com.baseproject.base;

import android.app.Activity;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;

import com.garymansell.SweetAlert.SweetAlertDialog;

import baseproject.wx.com.baseproject.receiver.NetChangeBroadcastReceiver;

/**
 * Created by android_wx on 16/12/22.
 */

public class BaseActivity extends Activity implements NetChangeBroadcastReceiver.NetChangeInterface {

    private NetChangeBroadcastReceiver netChangeBroadcastReceiver;
    private SweetAlertDialog sd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        netOnChangeListenner();
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
//        sd = new SweetAlertDialog(this);
//        sd.setCancelable(true);
//        sd.setTitleText("当前是wifi网络状态");
//        sd.setCanceledOnTouchOutside(true);
//        sd.show();
    }

    @Override
    public void netIsGPRS() {
        hideSweetDialog();
        sd = new SweetAlertDialog(this);
        sd.setCancelable(true);
        sd.setTitleText("当前是GPRS网络状态");
        sd.setCanceledOnTouchOutside(true);
        sd.show();
    }

    @Override
    public void netUnavailable() {
        hideSweetDialog();
        sd = new SweetAlertDialog(this);
        sd.setCancelable(true);
        sd.setTitleText("没有网啦！！！");
        sd.setCanceledOnTouchOutside(true);
        sd.show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //结束监听网络
        unregisterReceiver(netChangeBroadcastReceiver);
    }

    private void hideSweetDialog() {
        if (sd != null) {
            sd.cancel();
        }
    }
}
