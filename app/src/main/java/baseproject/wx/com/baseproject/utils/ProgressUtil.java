package baseproject.wx.com.baseproject.utils;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;

import baseproject.wx.com.baseproject.R;


public class ProgressUtil {

    private static Dialog mDialog;

    public static void startProgressBar(Context context) {
        mDialog = new AlertDialog.Builder(context).create();
        mDialog.show();
        LinearLayout viewContent = (LinearLayout) LayoutInflater.from(context)
                .inflate(R.layout.progress_loading, null);
        viewContent.setGravity(Gravity.CENTER);
        ImageView progressIv = (ImageView) viewContent
                .findViewById(R.id.progress_util_iv);
        GlideImageLoader.displayLocalGif(context, R.drawable.loading, progressIv);
        mDialog.setContentView(viewContent);
    }

    public static void stopProgressBar() {
        if (mDialog != null) {
            mDialog.cancel();
            mDialog.dismiss();
            mDialog = null;
        }
    }
}
