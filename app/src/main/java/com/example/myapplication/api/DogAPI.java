package com.example.myapplication.api;

import com.example.myapplication.model.DogResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface DogAPI {
    // https://dog.ceo/api/breeds/image/random

    @GET("/api/breeds/image/random")
    Call<DogResponse> getMessage();
}
