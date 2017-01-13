package baseproject.wx.com.baseproject.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jaiky.imagespickers.ImageConfig;
import com.jaiky.imagespickers.ImageSelector;
import com.jaiky.imagespickers.ImageSelectorActivity;

import java.util.ArrayList;
import java.util.List;

import baseproject.wx.com.baseproject.R;
import baseproject.wx.com.baseproject.base.BaseActivity;
import baseproject.wx.com.baseproject.utils.GlideImageLoader;
import butterknife.BindView;
import butterknife.ButterKnife;

public class ImageSelectActivity extends BaseActivity implements View.OnClickListener {

    @BindView(R.id.button1)
    Button btn1;

    @BindView(R.id.button2)
    Button btn2;

    @BindView(R.id.linearlayout2)
    LinearLayout llContainer;

    @BindView(R.id.textview1)
    TextView tv1;

    private ImageConfig imageConfig;
    public static final int REQUEST_CODE = 123;
    private ArrayList<String> path = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.image_select_activity);
        ButterKnife.bind(this);
        initUI();
    }

    private void initUI() {
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button1:
                imageConfig = new ImageConfig.Builder(new GlideImageLoader())
                        .steepToolBarColor(getResources().getColor(R.color.titleBlue))
                        .titleBgColor(getResources().getColor(R.color.titleBlue))
                        .titleSubmitTextColor(getResources().getColor(R.color.white))
                        .titleTextColor(getResources().getColor(R.color.white))
                        // 开启单选   （默认为多选）
                        .singleSelect()
                        // 裁剪 (只有单选可裁剪)
                        //.crop()
                        // 开启拍照功能 （默认关闭）
                        .showCamera()
                        //设置显示容器
                        .setContainer(llContainer)
                        .requestCode(REQUEST_CODE)
                        .build();
                ImageSelector.open(this, imageConfig);
                break;
            case R.id.button2:
                imageConfig = new ImageConfig.Builder(
                        new GlideImageLoader())
                        .steepToolBarColor(getResources().getColor(R.color.titleBlue))
                        .titleBgColor(getResources().getColor(R.color.titleBlue))
                        .titleSubmitTextColor(getResources().getColor(R.color.white))
                        .titleTextColor(getResources().getColor(R.color.white))
                        // 开启多选   （默认为多选）
                        .mutiSelect()
                        // 多选时的最大数量   （默认 9 张）
                        .mutiSelectMaxSize(9)
                        //设置图片显示容器，参数：、（容器，每行显示数量，是否可删除）
                        .setContainer(llContainer, 4, true)
                        // 已选择的图片路径
                        .pathList(path)
                        // 拍照后存放的图片路径（默认 /temp/picture）
                        .filePath("/temp")
                        // 开启拍照功能 （默认关闭）
                        .showCamera()
                        .requestCode(REQUEST_CODE)
                        .build();
                ImageSelector.open(this, imageConfig);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK && data != null) {
            List<String> pathList = data.getStringArrayListExtra(ImageSelectorActivity.EXTRA_RESULT);

            tv1.setText("");
            for (String path : pathList) {
                tv1.append(path);
                tv1.append("\n");
            }

            path.clear();
            path.addAll(pathList);
        }
    }
}
