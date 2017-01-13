package baseproject.wx.com.baseproject.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by android_wx on 17/1/10.
 */

public class NetChangeBroadcastReceiver extends BroadcastReceiver {
    private NetChangeInterface anInterface;

    public NetChangeBroadcastReceiver() {
    }

    public NetChangeBroadcastReceiver(NetChangeInterface anInterface) {
        this.anInterface = anInterface;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo mobNetInfo = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
        NetworkInfo wifiNetInfo = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        if (mobNetInfo.isConnected()) {
            if (anInterface != null) {
                anInterface.netIsGPRS();
            }
        } else if (wifiNetInfo.isConnected()) {
            if (anInterface != null) {
                anInterface.netIsWifi();
            }
        } else {
            if (anInterface != null) {
                anInterface.netUnavailable();
            }
        }
    }

    public interface NetChangeInterface {
        void netIsWifi();

        void netIsGPRS();

        void netUnavailable();
    }
}
