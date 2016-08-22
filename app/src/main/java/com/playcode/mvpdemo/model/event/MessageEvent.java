package com.playcode.mvpdemo.model.event;

import android.os.Bundle;

/**
 * Created by anpoz on 2016/8/19.
 */

public class MessageEvent {
    public static final String GET_ARTICLE_LIST_ERROR = "get_article_list_error";
    public static final String GET_ARTICLE_LIST_SUCCESS = "get_article_list_success";
    public static final String GET_ARTICLE_HTML_ERROR="get_article_html_error";
    public static final String GET_ARTICLE_HTML_SUCCESS="get_article_html_success";
    private String mMessage;
    private Object mdata;

    public MessageEvent(String message) {
        mMessage = message;
        mdata = new Bundle();
    }

    public MessageEvent(String message, Object mdata) {
        mMessage = message;
        this.mdata = mdata;
    }

    public String getMessage() {
        return mMessage;
    }

    public void setMessage(String message) {
        mMessage = message;
    }

    public Object getData() {
        return mdata;
    }

    public void setData(Object mdata) {
        this.mdata = mdata;
    }
}
