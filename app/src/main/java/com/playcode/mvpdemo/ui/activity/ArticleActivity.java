package com.playcode.mvpdemo.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.playcode.mvpdemo.R;
import com.playcode.mvpdemo.contract.ArticleContract;
import com.playcode.mvpdemo.model.entity.Article;
import com.playcode.mvpdemo.presenter.ArticlePresenter;

public class ArticleActivity extends AppCompatActivity implements ArticleContract.View {
    private WebView mWebView;
    private ArticleContract.Presenter mPresenter;
    public static final String ARTICLE_ID = "article_id";

    public static void startArticleActivityWithId(Activity activity, String id) {
        Intent intent = new Intent(activity, ArticleActivity.class);
        intent.putExtra(ARTICLE_ID, id);
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article);
        init();
    }

    private void init() {
        String id = getIntent().getStringExtra(ARTICLE_ID);
        mWebView = (WebView) findViewById(R.id.wv_article);
        new ArticlePresenter(this);
        mPresenter.attachView();
        mPresenter.getArticleDetail(id);
        WebSettings settings = mWebView.getSettings();
        settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        settings.setBuiltInZoomControls(false); // 设置显示缩放按钮
        settings.setSupportZoom(false); // 支持缩放
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.detachView();
    }


    @Override
    public void setArticle(Article article) {
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < article.getCss().size(); i++) {
//            sb.append("<link rel=\"stylesheet\" href=\"");
//            sb.append(article.getCss().get(i));
//            sb.append("\" type=“text/css\" >");
//        }
//        sb.append(article.getBody());
//        mWebView.loadDataWithBaseURL("file:///android_asset/", sb.toString(), "text/html; charset=UTF-8", "UTF-8", null);
        mWebView.loadUrl(article.getShare_url());
    }

    @Override
    public void showError() {
        Snackbar.make(mWebView, "Error!", Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void setPresenter(ArticleContract.Presenter presenter) {
        mPresenter = presenter;
    }
}
