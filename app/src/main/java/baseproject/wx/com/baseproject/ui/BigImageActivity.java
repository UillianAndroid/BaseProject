package baseproject.wx.com.baseproject.ui;

import android.app.Activity;
import android.os.Bundle;

import baseproject.wx.com.baseproject.R;
import baseproject.wx.com.baseproject.utils.GlideImageLoader;
import baseproject.wx.com.baseproject.view.PinchImageView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class BigImageActivity extends Activity {

    @BindView(R.id.pinchimageview1)
    PinchImageView pinchImageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.big_image_activity);
        ButterKnife.bind(this);
        initUI();
    }

    private void initUI() {
        GlideImageLoader.displayNormalImage(this, ImageLoadActivity.IMAGEURL, pinchImageView);
    }
}
