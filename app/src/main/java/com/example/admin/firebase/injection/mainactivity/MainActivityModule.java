package com.example.admin.firebase.injection.mainactivity;

import com.example.admin.firebase.view.mainactivity.MainActivity;
import com.example.admin.firebase.view.mainactivity.MainActivityPresenter;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Admin on 8/22/2017.
 */

@Module
public class MainActivityModule {

    @Provides
    MainActivity providesMainActivyt(){
        return new MainActivity();
    }

    @Provides
    // can make class singleton @Singleton
    MainActivityPresenter providesMainActivityPresenter(){

        return new MainActivityPresenter();
    }
}
