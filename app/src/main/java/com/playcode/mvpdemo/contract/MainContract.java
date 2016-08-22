package com.playcode.mvpdemo.contract;

import com.playcode.mvpdemo.base.BasePresenter;
import com.playcode.mvpdemo.base.BaseView;
import com.playcode.mvpdemo.model.entity.ArticleList;

import java.util.List;

/**
 * Created by Administrator on 2016/8/19 0019.
 */
public interface MainContract {

    /**
     * Created by Administrator on 2016/8/19 0019.
     */
    interface View extends BaseView<Presenter> {
        void showError();

        void setData(List<ArticleList.StoriesBean> storiesBeanList);
    }

    /**
     * Created by Administrator on 2016/8/19 0019.
     */
    interface Presenter extends BasePresenter {
        void attachView();

        void detachView();
    }

}
