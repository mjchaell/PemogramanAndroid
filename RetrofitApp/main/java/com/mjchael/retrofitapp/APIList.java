package com.mjchael.retrofitapp;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIList {

    @GET("products")
    Call<Products> getAllProducts();

    @GET("users")
    Call<Users> getAllUsers();
}
