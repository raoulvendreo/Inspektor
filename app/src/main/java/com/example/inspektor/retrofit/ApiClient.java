package com.example.inspektor.retrofit;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import android.content.ContentValues;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.example.inspektor.model.AuthRequest;
import com.example.inspektor.model.AuthSignInResponse;

import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    Context context;

    private static final String BASE_URL = "http://dev.indoagri.co.id/InspectionRA/";
    private static Retrofit retrofit;

    HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
    OkHttpClient okHttpClient = new OkHttpClient
            .Builder()
            .addInterceptor(httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY))
            .connectTimeout(5, TimeUnit.MINUTES)
            .writeTimeout(5, TimeUnit.MINUTES)
            .readTimeout(5, TimeUnit.MINUTES)
            .build();

    public Retrofit retrofit(Context context) {

        this.context = context;
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(okHttpClient)
                    .build();
        }
        return retrofit;
    }

    public ApiInterface getApiInterface() {
        return retrofit.create(ApiInterface.class);
    }

    public void getToken(AuthRequest authRequest){
        getApiInterface();
        Call<AuthSignInResponse> authSignInResponseCall = getApiInterface().getToken(authRequest);

        try{
            authSignInResponseCall.enqueue(new Callback<AuthSignInResponse>() {
                @Override
                public void onResponse(Call<AuthSignInResponse> call, Response<AuthSignInResponse> response) {

                    if (response.isSuccessful()) {
                        AuthSignInResponse authSignInResponse = response.body();

                        String accessToken = authSignInResponse.getData().getToken();

                        Toast.makeText(context, "Token: " + accessToken, Toast.LENGTH_SHORT).show();
                    } else {
                        Log.e(TAG, "onResponse gagal!!!");
                    }

                }

                @Override
                public void onFailure(Call<AuthSignInResponse> call, Throwable t) {
                    Log.e(TAG, "onFailure: " + t.getMessage());
                }
            });
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
