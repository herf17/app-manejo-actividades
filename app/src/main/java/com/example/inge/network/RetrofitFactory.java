package com.example.inge.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitFactory {
    private static Retrofit retrofit = null;
    private RetrofitFactory(){}

    public static Retrofit getRetrofit(){
        if(retrofit== null){
            retrofit = new Retrofit.Builder()
                    .baseUrl("http://localhost:8080")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
