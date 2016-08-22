package com.playcode.mvpdemo.ui.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.playcode.mvpdemo.R;
import com.playcode.mvpdemo.contract.MainContract;
import com.playcode.mvpdemo.model.entity.ArticleList;
import com.playcode.mvpdemo.presenter.MainPresenter;
import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MainContract.View {
    private RecyclerView mRecyclerView;
    private MyAdapter mAdapter;
    private MainContract.Presenter mPresenter;
    private static boolean isClicked = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View view) {
                mPresenter.start();
            }
        });
        //如果Activity承载有Fragment，那么此处应该传入Fragment，让Fragment实现View接口
        new MainPresenter(this);
        init();
        mPresenter.attachView();
        mPresenter.start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.detachView();
    }

    private void init() {
        mRecyclerView = (RecyclerView) findViewById(R.id.rv_data);

        mAdapter = new MyAdapter(this, R.layout.item_my, new ArrayList<ArticleList.StoriesBean>());

        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void showError() {
        Snackbar.make(mRecyclerView, "数据载入出现了错误", Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void setData(List<ArticleList.StoriesBean> storiesBeanList) {
        mAdapter.refresh(storiesBeanList);
    }

    @Override
    public void setPresenter(MainContract.Presenter presenter) {
        mPresenter = presenter;
    }

    private class MyAdapter extends CommonAdapter<ArticleList.StoriesBean> {

        public MyAdapter(Context context, int layoutId, List<ArticleList.StoriesBean> datas) {
            super(context, layoutId, datas);
        }

        @Override
        protected void convert(ViewHolder holder, final ArticleList.StoriesBean item, int position) {
            holder.setText(R.id.tv_title, item.getTitle());
            holder.setOnClickListener(R.id.cv_item, new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ArticleActivity.startArticleActivityWithId(MainActivity.this, item.getId() + "");
                }
            });
            Glide.with(mContext)
                    .load(item.getImages().get(0))
                    .centerCrop()
                    .crossFade()
                    .into((ImageView) holder.itemView.findViewById(R.id.iv_image));
        }

        public void refresh(List<ArticleList.StoriesBean> itemList) {
            mDatas.clear();
            mDatas.addAll(itemList);
            notifyDataSetChanged();
        }

        public void clear() {
            mDatas.clear();
            notifyDataSetChanged();
        }
    }
}
