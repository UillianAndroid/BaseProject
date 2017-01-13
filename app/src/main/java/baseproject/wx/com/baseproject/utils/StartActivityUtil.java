package baseproject.wx.com.baseproject.utils;

import android.app.Activity;
import android.content.Intent;

/**
 * Created by android_wx on 17/1/9.
 */

public class StartActivityUtil {

    public static void statr(Activity activity, Class<?> aClass) {
        Intent intent = new Intent();
        intent.setClass(activity, aClass);
        activity.startActivity(intent);
    }
}
