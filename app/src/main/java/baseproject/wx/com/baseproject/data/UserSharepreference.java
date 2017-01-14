package baseproject.wx.com.baseproject.data;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

/**
 * Created by android_wx on 17/1/14.
 */

public class UserSharepreference {
    private static UserSharepreference userSP;
    private static SharedPreferences sharedPreferences;
    private static Context mContext;
    private Editor editor;

    private UserSharepreference(Context context) {
        if (sharedPreferences == null) {
            sharedPreferences = context.getSharedPreferences("baseProject", Context.MODE_APPEND);
        }
        editor = sharedPreferences.edit();
    }

    public static UserSharepreference getInstabce(Context context) {
        if (userSP == null) {
            userSP = new UserSharepreference(context);
        }
        return userSP;
    }

    //    判断是否进行引导页
    public void setIsGuide(boolean b) {
        editor.putBoolean("isguide", b);
        editor.commit();
    }

    public boolean getIsGuide() {
        return sharedPreferences.getBoolean("isguide", true);
    }
}
