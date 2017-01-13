package baseproject.wx.com.baseproject.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import baseproject.wx.com.baseproject.R;
import baseproject.wx.com.baseproject.base.BaseActivity;
import baseproject.wx.com.baseproject.utils.GlideImageLoader;
import butterknife.BindView;
import butterknife.ButterKnife;

public class ImageLoadActivity extends BaseActivity implements View.OnClickListener {

    public static String IMAGEURL = "https://o60knd4hs.qnssl.com/uploads/banner_file/image/4/IMG_3908.JPG";

    @BindView(R.id.simpleDraweeView1)
    ImageView simpleDraweeView1;//圆角

    @BindView(R.id.simpleDraweeView2)
    ImageView simpleDraweeView2;//方角

    @BindView(R.id.simpleDraweeView3)
    ImageView simpleDraweeView3;//带有加载中

    @BindView(R.id.simpleDraweeView4)
    ImageView simpleDraweeView4;//自定义角度

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_load);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        GlideImageLoader.displayCircleImage(this, IMAGEURL, simpleDraweeView1);
        GlideImageLoader.displayRoundImage(this, IMAGEURL, 10, simpleDraweeView2);
        GlideImageLoader.displayRoundImage(this, IMAGEURL, 20, simpleDraweeView3);
        GlideImageLoader.displayNormalImage(this, IMAGEURL, simpleDraweeView4);
        simpleDraweeView1.setOnClickListener(this);
        simpleDraweeView2.setOnClickListener(this);
        simpleDraweeView3.setOnClickListener(this);
        simpleDraweeView4.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.simpleDraweeView1 || v.getId() == R.id.simpleDraweeView2 || v.getId() == R.id.simpleDraweeView3 || v.getId() == R.id.simpleDraweeView4) {
            Intent intent = new Intent(ImageLoadActivity.this, BigImageActivity.class);
            startActivity(intent);
        }
    }
}
