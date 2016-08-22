package com.playcode.mvpdemo.model.impl;

import com.playcode.mvpdemo.model.ArticleModel;
import com.playcode.mvpdemo.model.entity.Article;
import com.playcode.mvpdemo.model.event.MessageEvent;
import com.playcode.mvpdemo.util.RetrofitHelper;

import org.greenrobot.eventbus.EventBus;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Administrator on 2016/8/20 0020.
 */
public class ArticleModelImpl implements ArticleModel {
    @Override
    public void loadArticle(final String id) {
        RetrofitHelper.getInstance()
                .getRetrofit()
                .create(API.class)
                .getArticle(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Article>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        EventBus.getDefault()
                                .post(new MessageEvent(MessageEvent.GET_ARTICLE_HTML_ERROR));
                    }

                    @Override
                    public void onNext(Article article) {
                        EventBus.getDefault()
                                .post(new MessageEvent(MessageEvent.GET_ARTICLE_HTML_SUCCESS, article));
                    }
                });

    }

    interface API {
        @GET("api/4/news/{id}")
        Observable<Article> getArticle(@Path("id") String id);
    }
}
