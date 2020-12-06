package com.jeem.benefit.exercise.utilities.model;

import java.io.Serializable;

public class User implements Serializable {

    private final String username;
    private final String dateList;

    public User() {
       this(null, null);
    }

    public User(String user, String date) {
        this.username = user;
        this.dateList = date;
    }

    public void addUserLog(String date) {
       // dateList = date;
    }

    public String getDateList() {
        return dateList;
    }

    public String getUsername() {
        return username;
    }
}