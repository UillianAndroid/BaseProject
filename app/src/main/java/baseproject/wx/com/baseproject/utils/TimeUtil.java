package baseproject.wx.com.baseproject.utils;

import android.app.Activity;
import android.content.Context;

import java.util.Timer;
import java.util.TimerTask;


/**
 * Created by android_wx on 17/1/10.
 */

public class TimeUtil {
    private static Context mContext;
    private int durationInt;
    private Timer timer;
    private TimeUtilInterface timeUtilInterface;
    private static TimeUtil timeUtil = null;
    private static Activity activity;

    public static TimeUtil getInstance(Context context) {
        activity = (Activity) context;
        mContext = context;
        if (timeUtil == null) {
            timeUtil = new TimeUtil();
            return timeUtil;
        }
        return timeUtil;
    }

    //倒计时显示在TextView上（Activity调用TimeUtilInterface接口及传入倒计时时间）
    public void CountdownTvShow(final TimeUtilInterface timeUtilInterface, int duration) {
        timer = new Timer();
        durationInt = duration;
        this.timeUtilInterface = timeUtilInterface;
        //  倒计时
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                activity.runOnUiThread(new Runnable() {

                    @Override
                    public void run() {
                        if (durationInt > 0) {
                            timeUtilInterface.timerTaskDuration(durationInt);
                            durationInt--;
                        } else {
                            timer.cancel();
                        }
                    }
                });
            }
        };
        timer.schedule(timerTask, 1000, 1000);
    }

    public abstract interface TimeUtilInterface {
        void timerTaskDuration(int duration);
    }
}

