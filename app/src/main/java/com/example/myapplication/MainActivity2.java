package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.service.autofill.ImageTransformation;
import android.util.Log;
import android.widget.ImageView;

import com.example.myapplication.api.DogAPI;
import com.example.myapplication.api.YandexAPI;
import com.example.myapplication.model.DogResponse;
import com.squareup.picasso.Picasso;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity2 extends AppCompatActivity {

    public static final String DOG_BASE_URL = "https://dog.ceo";
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        imageView = findViewById(R.id.imageView);
        doImageRequest();
    }

    public void doImageRequest() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(DOG_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        DogAPI api = retrofit.create(DogAPI.class);
        api.getMessage().enqueue(new Callback<DogResponse>() {
            @Override
            public void onResponse(Call<DogResponse> call, Response<DogResponse> response) {
                if(response.code() == 200) {
                    Picasso.get().load(response.body().getMessage()).into(imageView);
                }
            }

            @Override
            public void onFailure(Call<DogResponse> call, Throwable t) {

            }
        });
    }
}