package com.playcode.mvpdemo.model.impl;

import com.playcode.mvpdemo.model.StoryListModel;
import com.playcode.mvpdemo.model.entity.ArticleList;
import com.playcode.mvpdemo.model.event.MessageEvent;
import com.playcode.mvpdemo.util.RetrofitHelper;

import org.greenrobot.eventbus.EventBus;

import retrofit2.http.GET;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Administrator on 2016/8/19 0019.
 */
public class StoryListModelImpl implements StoryListModel {
    @Override
    public void loadData() {

        RetrofitHelper.getInstance()
                .getRetrofit()
                .create(API.class)
                .getArticleList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<ArticleList>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                        EventBus.getDefault()
                                .post(new MessageEvent(MessageEvent.GET_ARTICLE_LIST_ERROR));
                    }

                    @Override
                    public void onNext(ArticleList articleList) {
                        EventBus.getDefault()
                                .post(new MessageEvent(MessageEvent.GET_ARTICLE_LIST_SUCCESS, articleList.getStories()));
                    }
                });
    }

    private interface API {
        @GET("api/4/news/latest")
        Observable<ArticleList> getArticleList();
    }
}
