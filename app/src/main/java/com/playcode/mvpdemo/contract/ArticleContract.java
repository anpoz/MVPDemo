package com.playcode.mvpdemo.contract;

import com.playcode.mvpdemo.base.BasePresenter;
import com.playcode.mvpdemo.base.BaseView;
import com.playcode.mvpdemo.model.entity.Article;

/**
 * Created by Administrator on 2016/8/20 0020.
 */
public interface ArticleContract {
    interface View extends BaseView<Presenter> {
        void setArticle(Article article);

        void showError();
    }

    interface Presenter extends BasePresenter {
        void getArticleDetail(String id);

        void attachView();

        void detachView();
    }
}
