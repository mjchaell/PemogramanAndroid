package com.mjchael.retrofitapp;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Users {

    @SerializedName("users")
    ArrayList<User> data;
    @SerializedName("total")
    private int total;
    @SerializedName("limit")
    private int limit;
    @SerializedName("skip")
    private int skip;

    public Users(ArrayList<User> data, int total, int limit, int skip) {
        this.data = data;
        this.total = total;
        this.limit = limit;
        this.skip = skip;
    }

    public ArrayList<User> getData() {
        return data;
    }

}
