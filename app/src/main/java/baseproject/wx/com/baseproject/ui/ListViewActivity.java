package baseproject.wx.com.baseproject.ui;

import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import baseproject.wx.com.baseproject.R;
import baseproject.wx.com.baseproject.base.BaseActivity;
import butterknife.BindView;
import butterknife.ButterKnife;

public class ListViewActivity extends BaseActivity {

    @BindView(R.id.recyclerView1)
    RecyclerView recyclerView;

    List<String> tvs = new ArrayList<String>();
    List<String> ivs = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view);
        ButterKnife.bind(this);
        for (int i = 0; i < 5; i++) {
            tvs.add(i, "文字" + i);
            ivs.add(i, ImageLoadActivity.IMAGEURL);
        }
        initUI();
    }

    private void initUI() {
        MyAdapter myAdapter = new MyAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayout.VERTICAL, true));
        recyclerView.setAdapter(myAdapter);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
    }

    class MyAdapter extends RecyclerView.Adapter<MyViewHold> {


        @Override
        public MyViewHold onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = getLayoutInflater().inflate(R.layout.listview_item, null);
            MyViewHold myViewHold = new MyViewHold(view);
            myViewHold.tv = (TextView) view.findViewById(R.id.list_view_item_tv);
            myViewHold.simpleDraweeView = (ImageView) view.findViewById(R.id.list_view_item_iv);
            return myViewHold;
        }

        @Override
        public void onBindViewHolder(MyViewHold holder, int position) {
            holder.tv.setText(tvs.get(position));
            Glide.with(ListViewActivity.this).load(ivs.get(position)).into(holder.simpleDraweeView);
        }

        @Override
        public int getItemCount() {
            return tvs.size();
        }
    }

    class MyViewHold extends RecyclerView.ViewHolder {

        TextView tv;
        ImageView simpleDraweeView;

        public MyViewHold(View itemView) {
            super(itemView);

        }
    }
}
