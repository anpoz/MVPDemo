package com.playcode.mvpdemo.presenter;

import com.playcode.mvpdemo.contract.ArticleContract;
import com.playcode.mvpdemo.model.ArticleModel;
import com.playcode.mvpdemo.model.entity.Article;
import com.playcode.mvpdemo.model.event.MessageEvent;
import com.playcode.mvpdemo.model.impl.ArticleModelImpl;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/**
 * Created by Administrator on 2016/8/20 0020.
 */
public class ArticlePresenter implements ArticleContract.Presenter {
    private ArticleContract.View mView;
    private ArticleModel mModel;

    public ArticlePresenter(ArticleContract.View view) {
        mView = view;
        mModel = new ArticleModelImpl();
        mView.setPresenter(this);
    }

    @Override
    public void start() {
    }

    @Override
    public void getArticleDetail(String id) {
        mModel.loadArticle(id);
    }

    @Override
    public void attachView() {
        EventBus.getDefault().register(this);
    }

    @Override
    public void detachView() {
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(MessageEvent messageEvent) {
        switch (messageEvent.getMessage()) {
            case MessageEvent.GET_ARTICLE_HTML_SUCCESS:
                mView.setArticle((Article) messageEvent.getData());
                break;
            case MessageEvent.GET_ARTICLE_HTML_ERROR:
                mView.showError();
                break;
        }
    }
}
