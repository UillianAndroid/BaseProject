package baseproject.wx.com.baseproject.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.facebook.drawee.view.SimpleDraweeView;

import baseproject.wx.com.baseproject.R;

public class ImageLoadActivity extends AppCompatActivity {

    private String imageUrl="https://o60knd4hs.qnssl.com/uploads/banner_file/image/4/IMG_3908.JPG";
    private SimpleDraweeView simpleDraweeView1;//圆角图片

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_load);
        initView();
    }

    private void initView() {
        simpleDraweeView1 = (SimpleDraweeView) findViewById(R.id.simpleDraweeView1);
        simpleDraweeView1.setImageURI(imageUrl);
    }
}
