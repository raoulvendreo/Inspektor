package com.example.inspektor.retrofit;

import com.example.inspektor.model.AuthGetLoggedUserResponse;
import com.example.inspektor.model.AuthRequest;
import com.example.inspektor.model.AuthSignInResponse;
import com.example.inspektor.model.MobResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface ApiInterface {

    // SIGN IN
    @POST("api/v1/auth/sign_in")
    Call<AuthSignInResponse> getToken(
            @Body AuthRequest authRequest
    );

    // GET LOGGED USER
    @GET("api/v1/auth/logged")
    Call<AuthGetLoggedUserResponse> getUserData(
            @Header("Authorization") String token
    );

    // GET MOB
    @GET("api/v1/mob")
    Call<MobResponse> getMobData(
            @Header("Authorization") String token
    );


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
