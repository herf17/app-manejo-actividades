package com.example.inge.network;


import com.example.inge.model.LoginRespuesta;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface RetrofitServicio {

    @FormUrlEncoded
    @POST("/spring/login")
    Call<LoginRespuesta> autenticar(
            @Field("username") String usuarioid,
            @Field("password") String password
    );
}
