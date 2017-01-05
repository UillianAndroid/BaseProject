package baseproject.wx.com.baseproject.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import baseproject.wx.com.baseproject.R;
import baseproject.wx.com.baseproject.base.BaseActivity;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    @BindView(R.id.text1)
    public TextView tv1;//图片加载

    @BindView(R.id.text2)
    public TextView tv2;//网络请求

    @BindView(R.id.text3)
    public TextView tv3;//RecyclerView

    @BindView(R.id.text4)
    public TextView tv4;//XRecyclerViewActivity

    @BindView(R.id.text5)
    public TextView tv5;//SweetAlertDialog

    @BindView(R.id.text6)
    public TextView tv6;//拍照，图库

    @BindView(R.id.text7)
    public TextView tv7;//下载


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initOnClick();
    }

    private void initOnClick() {
        tv1.setOnClickListener(this);
        tv2.setOnClickListener(this);
        tv3.setOnClickListener(this);
        tv4.setOnClickListener(this);
        tv5.setOnClickListener(this);
        tv6.setOnClickListener(this);
        tv7.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.text1:
                startMyActivity(ImageLoadActivity.class);
                break;
            case R.id.text2:
                startMyActivity(HttpRequestActivity.class);
                break;
            case R.id.text3:
                startMyActivity(ListViewActivity.class);
                break;
            case R.id.text4:
                startMyActivity(XRecyclerViewActivity.class);
                break;
            case R.id.text5:
                startMyActivity(SweetAletDialogActivity.class);
                break;
            case R.id.text6:
                startMyActivity(ImageSelectActivity.class);
                break;
            case R.id.text7:
                startMyActivity(DownLoaderActiivty.class);
                break;
        }
    }

    private void startMyActivity(Class<?> activity) {
        Intent intent = new Intent(MainActivity.this, activity);
        startActivity(intent);
    }

}
