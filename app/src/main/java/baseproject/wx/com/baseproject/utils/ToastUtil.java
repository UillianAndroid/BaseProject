package baseproject.wx.com.baseproject.utils;

import android.app.Activity;
import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import baseproject.wx.com.baseproject.R;

/**
 * Created by android_wx on 17/1/10.
 */

public class ToastUtil {
    //    系统自带短暂Toast
    public static void shortShow(Context context, String text) {
        Toast.makeText(context, text, Toast.LENGTH_SHORT).show();
    }

    //    系统自带长时间Toast
    public static void longShow(Context context, String text) {
        Toast.makeText(context, text, Toast.LENGTH_LONG).show();
    }

    //    自定义文字短暂Toast
    public static void customShorShow(Context context, String text) {
        Activity activity = (Activity) context;
        View view = activity.getLayoutInflater().inflate(R.layout.toast_custom_show, null);
        TextView showTv = (TextView) view.findViewById(R.id.toast_custom_show_tv);
        showTv.setText(text);
        Toast toast = new Toast(context);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.setView(view);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.show();
    }
//    自定义长时间Toast
}
