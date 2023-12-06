package com.example.inspektor.retrofit;

import com.example.inspektor.model.AuthGetLoggedUserResponse;
import com.example.inspektor.model.AuthRequest;
import com.example.inspektor.model.AuthSignInResponse;
import com.example.inspektor.model.MobResponse;
import com.example.inspektor.model.ObjPartResponse;
import com.example.inspektor.model.PlanResponse;
import com.example.inspektor.model.RunAcctResponse;
import com.example.inspektor.model.VecTypeResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface ApiInterface {

    // POST SIGN IN
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

    // GET OBJ PART
    @GET("api/v1/objpart")
    Call<ObjPartResponse> getObjPartData(
            @Header("Authorization") String token
    );

    // GET PLAN
    @GET("api/v1/plan")
    Call<PlanResponse> getPlanData(
            @Header("Authorization") String token
    );

    // GET RUNNING ACCOUNT
    @GET("api/v1/runacct")
    Call<RunAcctResponse> getRunAcctData(
            @Header("Authorization") String token
    );

    // GET VEHICLE TYPE
    @GET("api/v1/vehicletype")
    Call<VecTypeResponse> getVecTypeData(
            @Header("Authorization") String token
    );


}
