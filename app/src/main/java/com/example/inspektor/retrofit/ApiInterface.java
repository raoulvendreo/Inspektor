package com.example.inspektor.retrofit;

import com.example.inspektor.model.AuthGetLoggedUserResponse;
import com.example.inspektor.model.AuthRequest;
import com.example.inspektor.model.AuthSignInResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface ApiInterface {

    @POST("api/v1/auth/sign_in")
    Call<AuthSignInResponse> getToken(
            @Body AuthRequest authRequest);

    @GET("api/v1/auth/logged")
    Call<AuthGetLoggedUserResponse> getUserData(
            @Header("Authorization") String token);

//    @POST("  ")
//    Call<> getUserDataForLogin(@Header);
//
//    @GET("  ")
//    Call<> getVehicle();
//
//    @GET("  ")
//
//
}
