package com.playcode.mvpdemo.presenter;

import android.util.Log;

import com.playcode.mvpdemo.contract.MainContract;
import com.playcode.mvpdemo.model.StoryListModel;
import com.playcode.mvpdemo.model.entity.ArticleList;
import com.playcode.mvpdemo.model.event.MessageEvent;
import com.playcode.mvpdemo.model.impl.StoryListModelImpl;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

/**
 * Created by Administrator on 2016/8/19 0019.
 */
public class MainPresenter implements MainContract.Presenter {
    private StoryListModel mModel;
    private MainContract.View mView;
    public static final String TAG = "MainPresenter";

    public MainPresenter(MainContract.View view) {
        mView = view;
        mModel = new StoryListModelImpl();
        mView.setPresenter(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(MessageEvent messageEvent) {
        switch (messageEvent.getMessage()) {
            case MessageEvent.GET_ARTICLE_LIST_SUCCESS:
                mView.setData((List<ArticleList.StoriesBean>) messageEvent.getData());
                break;
            case MessageEvent.GET_ARTICLE_LIST_ERROR:
                mView.showError();
                break;
        }
    }

    @Override
    public void attachView() {
        EventBus.getDefault().register(this);
        Log.d(TAG, "attachView: ");
    }

    @Override
    public void detachView() {
        EventBus.getDefault().unregister(this);
        Log.d(TAG, "detachView: ");
    }

    @Override
    public void start() {
        mModel.loadData();
    }
}
