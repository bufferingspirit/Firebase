package com.example.admin.firebase.model;

/**
 * Created by Admin on 8/23/2017.
 */

public class Movie {

    String name;
    String director;
    int year;

    public Movie(){};

    public Movie(String name, String director, int year) {
        this.name = name;
        this.director = director;
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
