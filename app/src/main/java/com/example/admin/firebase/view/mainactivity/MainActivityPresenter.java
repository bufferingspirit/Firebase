package com.example.admin.firebase.view.mainactivity;

import android.util.Log;

import com.example.admin.firebase.model.Movie;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Iterator;
import java.util.List;

import static com.google.android.gms.internal.zzs.TAG;

/**
 * Created by Admin on 8/22/2017.
 */

public class MainActivityPresenter implements MainActivityContract.Presenter{

    MainActivityContract.View view;
    DatabaseReference myRef;
    DatabaseReference movieRef;
    FirebaseDatabase database;

    @Override
    public void attachView(MainActivityContract.View view) {
        database = FirebaseDatabase.getInstance();
        this.view = view;
    }

    @Override
    public void detachView() {

        this.view = null;

    }

    // TODO: 8/22/2017 implement firebase logic to save data
    @Override
    public void saveDataToCloud(String s) {

        //save data

        // Write a message to the database
        //database = FirebaseDatabase.getInstance();
        myRef = database.getReference("message");

        myRef.setValue(s);
        //if saved to cloud
        view.onDataSaved(true);


    }

    public void getDataFromCloud(String s){
        // Read from the database
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                Log.d(TAG, "Value is: " + value);
                view.setTextView(value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });
    }

    Object o;

    @Override
    public void pushMovieToDb(Movie movie) {

        movieRef = database.getReference("movies");

        //saving using default key method
        movieRef.push().setValue(movie);

        //making the key as movie.getName()
        movieRef.child(movie.getName()).setValue(movie);

        for(int i = 0; i<5; i++){
            movieRef.child("Movie" + i).setValue(movie);
        }


    }

    @Override
    public void getMovieFromCloud(String s) {

        //set the priority of the updating
        //movieRef.setPriority(object o);
        List<Movie> movies;

        movieRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot snapShot : dataSnapshot.getChildren()){

                    Movie movie = snapShot.getValue(Movie.class);
                    Log.d(TAG, "onDataChange: " + movie.getName());

                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }
}
