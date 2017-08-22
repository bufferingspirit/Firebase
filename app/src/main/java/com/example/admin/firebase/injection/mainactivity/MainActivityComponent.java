package com.example.admin.firebase.injection.mainactivity;

import com.example.admin.firebase.view.mainactivity.MainActivity;

import dagger.Component;

/**
 * Created by Admin on 8/22/2017.
 */

@Component(modules = MainActivityModule.class)
public interface MainActivityComponent {

    void inject(MainActivity mainActivity);

}
