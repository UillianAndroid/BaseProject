package baseproject.wx.com.baseproject.utils;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.jaiky.imagespickers.ImageLoader;

import baseproject.wx.com.baseproject.R;

import static com.bumptech.glide.Glide.with;

/**
 * @Glide图片加载 Created by android_wx on 17/1/4.
 */

public class GlideImageLoader implements ImageLoader {

    //    加载圆形图片
    public static void displayCircleImage(Context context, String url, ImageView imageView) {
        with(context)//上下文对象，可Activity，Fragment
                .load(url)//图片url
                .dontAnimate()//不使用glide默认动画
                .fitCenter()//居中填满，根据需要自由设置
                .placeholder(R.mipmap.ic_launcher)//正在加载时占位图，自定义图片
                .error(R.mipmap.ic_launcher)//图片加载失败时显示，自定义图片
                .transform(new GlideCircleTransform(context))//变成圆形图片显示
                .into(imageView);
    }

    //    加载圆角图片
    public static void displayRoundImage(Context context, String url, int round, ImageView imageView) {
        with(context)//上下文对象，可Activity，Fragment
                .load(url)//图片url
                .dontAnimate()//不使用glide默认动画
                .fitCenter()//居中填满，根据需要自由设置
                .placeholder(R.mipmap.ic_launcher)//正在加载时占位图，自定义图片
                .error(R.mipmap.ic_launcher)//图片加载失败时显示，自定义图片
                .transform(new GlideRoundTransform(context, round))//变成圆角图片显示，round圆角大小
                .into(imageView);
    }

    //    加载方形普通图片
    public void displayImage(Context context, String url, ImageView imageView) {
        with(context)//上下文对象，可Activity，Fragment
                .load(url)//图片url
                .dontAnimate()//不使用glide默认动画
                .fitCenter()//居中填满，根据需要自由设置
                .placeholder(R.mipmap.ic_launcher)//正在加载时占位图，自定义图片
                .error(R.mipmap.ic_launcher)//图片加载失败时显示，自定义图片
                .into(imageView);
    }
    public static void displayNormalImage(Context context, String url, ImageView imageView) {
        with(context)//上下文对象，可Activity，Fragment
                .load(url)//图片url
                .dontAnimate()//不使用glide默认动画
                .fitCenter()//居中填满，根据需要自由设置
                .placeholder(R.mipmap.ic_launcher)//正在加载时占位图，自定义图片
                .error(R.mipmap.ic_launcher)//图片加载失败时显示，自定义图片
                .into(imageView);
    }

    /*
     * @在ListView滑动时调用，优化内存资源，防止OOM
     * @如：滑动时关闭请求，滑动停止时请求图片加载
     */
    //    取消请求图片
    public static void cancleRequestImage(Context context) {
        Glide.with(context).pauseRequests();
    }

    //    继续请求图片
    public static void resumeRequestImage(Context context) {
        Glide.with(context).resumeRequests();
    }
}
