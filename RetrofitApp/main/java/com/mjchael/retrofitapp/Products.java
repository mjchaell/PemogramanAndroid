package com.mjchael.retrofitapp;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Products {

    @SerializedName("products")
    ArrayList<Product> data;
    @SerializedName("total")
    private int total;
    @SerializedName("limit")
    private int limit;
    @SerializedName("skip")
    private int skip;

    public Products(ArrayList<Product> data, int total, int limit, int skip) {
        this.data = data;
        this.total = total;
        this.limit = limit;
        this.skip = skip;
    }

    public ArrayList<Product> getData() {
        return data;
    }

}
