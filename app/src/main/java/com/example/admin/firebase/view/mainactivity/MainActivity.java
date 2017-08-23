package com.example.admin.firebase.view.mainactivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.admin.firebase.R;
import com.example.admin.firebase.injection.mainactivity.DaggerMainActivityComponent;
import com.example.admin.firebase.model.Movie;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements MainActivityContract.View {

    @Inject
    MainActivityPresenter presenter;
    TextView tvData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DaggerMainActivityComponent.create().inject(this);
        presenter.attachView(this);
        presenter.saveDataToCloud("data");
        tvData = (TextView) findViewById(R.id.tvData);
    }


    @Override
    public void showError(String s) {
    }

    @Override
    public void onDataSaved(boolean isSaved) {

        Log.d("MainActivity", "onDataSaved: " + isSaved);

    }

    public void getData(View view){
        presenter.getDataFromCloud("message");
    }

    public void setTextView(String s) {
        tvData.setText(s);
    }

    public void pushMovie(View view){

        Movie movie = new Movie("Avengers", "", 2015);
        presenter.pushMovieToDb(movie);
    }

    public void getMovie(View view){
        presenter.getMovieFromCloud("movies");
    }

}
