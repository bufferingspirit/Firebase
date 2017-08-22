package com.example.admin.firebase.view.mainactivity;

import com.example.admin.firebase.BasePresenter;
import com.example.admin.firebase.BaseView;

/**
 * Created by Admin on 8/22/2017.
 */

public interface MainActivityContract {

    interface View extends BaseView {

        void onDataSaved(boolean isSaved);
        void setTextView(String s);

    }

    interface Presenter extends BasePresenter<View>{
        void saveDataToCloud(String s);
        String getDataFromCloud(String s);
    }
}
