package baseproject.wx.com.baseproject.ui;

import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import baseproject.wx.com.baseproject.R;
import baseproject.wx.com.baseproject.base.BaseActivity;
import baseproject.wx.com.baseproject.data.Constant;
import baseproject.wx.com.baseproject.utils.StartActivityUtil;
import butterknife.BindView;
import butterknife.ButterKnife;

public class GuideActivity extends BaseActivity {

    @BindView(R.id.guide_viewpager)
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        ButterKnife.bind(this);
        initUI();
    }

    private void initUI() {
        GuideAdapter guideAdapter = new GuideAdapter();
        viewPager.setAdapter(guideAdapter);
    }

    class GuideAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return Constant.guideIvIDs.length;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            View view = getLayoutInflater().inflate(R.layout.activity_guide_iten, null);
            ImageView imageView = (ImageView) view.findViewById(R.id.guide_item_imageview);
            Button button = (Button) view.findViewById(R.id.guide_item_btn);
            imageView.setImageResource(Constant.guideIvIDs[position]);
            if (position == Constant.guideIvIDs.length - 1) {
                button.setVisibility(View.VISIBLE);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        userSP.setIsGuide(false);
                        StartActivityUtil.statr(GuideActivity.this, MainActivity.class);
                        finish();
                    }
                });
            } else {
                button.setVisibility(View.GONE);
            }
            container.addView(view);
            return view;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }
    }
}
