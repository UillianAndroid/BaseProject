package baseproject.wx.com.baseproject.ui;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jcodecraeer.xrecyclerview.ProgressStyle;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

import baseproject.wx.com.baseproject.R;
import butterknife.BindView;
import butterknife.ButterKnife;

public class XRecyclerViewActivity extends AppCompatActivity {

    @BindView(R.id.my_list_view1)
    XRecyclerView xRecyclerView;

    List<String> tvs = new ArrayList<String>();
    List<String> ivs = new ArrayList<String>();
    private int refreshTime = 0;
    private int times = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.xrecycler_view_activity);
        ButterKnife.bind(this);
        initUI();
    }

    private void initUI() {
        final MyAdapter myAdapter = new MyAdapter();
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        xRecyclerView.setLayoutManager(layoutManager);

        xRecyclerView.setRefreshProgressStyle(ProgressStyle.BallSpinFadeLoader);
        xRecyclerView.setLoadingMoreProgressStyle(ProgressStyle.BallRotate);
        xRecyclerView.setArrowImageView(R.mipmap.ic_launcher);
        xRecyclerView.setAdapter(myAdapter);
        xRecyclerView.setFootViewText("加载更多", "没有了");
        xRecyclerView.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                Log.d("XRecyclerView", "刷新");
                refreshTime++;
                times = 0;
                new Handler().postDelayed(new Runnable() {
                    public void run() {
                        tvs.clear();
                        for (int i = 0; i < 15; i++) {
                            tvs.add("item" + i + "after " + refreshTime + " times of refresh");
                            ivs.add(ImageLoadActivity.IMAGEURL);
                        }
                        myAdapter.notifyDataSetChanged();
                        xRecyclerView.refreshComplete();

                    }
                }, 2000);            //refresh data here

            }

            @Override
            public void onLoadMore() {
                Log.d("XRecyclerView", "加载更多");
                if (times < 2) {
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            for (int i = 0; i < 15; i++) {
                                tvs.add("item" + (1 + tvs.size()));
                                ivs.add(ImageLoadActivity.IMAGEURL);
                            }
                            xRecyclerView.loadMoreComplete();
                            myAdapter.notifyDataSetChanged();
                        }
                    }, 2000);
                } else {
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            for (int i = 0; i < 9; i++) {
                                tvs.add("item" + (1 + tvs.size()));
                                ivs.add(ImageLoadActivity.IMAGEURL);
                            }
                            xRecyclerView.setNoMore(true);
                            myAdapter.notifyDataSetChanged();
                        }
                    }, 2000);
                }
                times++;

            }
        });
        xRecyclerView.refresh();
    }

    class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = getLayoutInflater().inflate(R.layout.listview_item, null);
            return new MyViewHolder(view);
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            holder.tv.setText(tvs.get(position));
            Glide.with(XRecyclerViewActivity.this).load(ivs.get(position)).into(holder.simpleDraweeView);
        }

        @Override
        public int getItemCount() {
            return tvs.size();
        }

        class MyViewHolder extends RecyclerView.ViewHolder {

            TextView tv;
            ImageView simpleDraweeView;

            public MyViewHolder(View itemView) {
                super(itemView);
                tv = (TextView) itemView.findViewById(R.id.list_view_item_tv);
                simpleDraweeView = (ImageView) itemView.findViewById(R.id.list_view_item_iv);
            }
        }
    }
}
