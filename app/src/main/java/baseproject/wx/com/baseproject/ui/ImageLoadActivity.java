package baseproject.wx.com.baseproject.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.facebook.drawee.view.SimpleDraweeView;

import baseproject.wx.com.baseproject.R;
import butterknife.BindView;
import butterknife.ButterKnife;

public class ImageLoadActivity extends AppCompatActivity {

    private String imageUrl = "https://o60knd4hs.qnssl.com/uploads/banner_file/image/4/IMG_3908.JPG";

    @BindView(R.id.simpleDraweeView1)
    SimpleDraweeView simpleDraweeView1;//圆角

    @BindView(R.id.simpleDraweeView2)
    SimpleDraweeView simpleDraweeView2;//方角

    @BindView(R.id.simpleDraweeView3)
    SimpleDraweeView simpleDraweeView3;//带有加载中

    @BindView(R.id.simpleDraweeView4)
    SimpleDraweeView simpleDraweeView4;//自定义角度

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_load);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        simpleDraweeView1.setImageURI(imageUrl);
        simpleDraweeView2.setImageURI(imageUrl);
        simpleDraweeView3.setImageURI(imageUrl);
        simpleDraweeView4.setImageURI(imageUrl);
    }
}
