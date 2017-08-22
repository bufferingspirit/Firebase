package com.example.admin.firebase;

/**
 * Created by Admin on 8/22/2017.
 */

public interface BasePresenter <V extends BaseView> {

    void attachView(V view);
    void detachView();
}
