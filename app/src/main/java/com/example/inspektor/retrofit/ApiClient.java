package com.example.inspektor.retrofit;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import android.app.Activity;
import android.app.Application;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.widget.Toast;

import com.example.inspektor.NavUtils;
import com.example.inspektor.activity.VehicleDashboardActivity;
import com.example.inspektor.model.AuthGetLoggedUserRequest;
import com.example.inspektor.model.AuthGetLoggedUserResponse;
import com.example.inspektor.model.AuthRequest;
import com.example.inspektor.model.AuthSignInResponse;
import com.example.inspektor.model.Company;
import com.example.inspektor.repository.UserRepository;
import com.example.inspektor.room.entity.UserEntity;

import java.util.List;
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
    Activity activity;

    private static final String BASE_URL = "http://dev.indoagri.co.id/InspectionRA/";
    private static Retrofit retrofit;

    private static final String TOKEN_SHARED_PREFS = "";

    private UserRepository mUserRepository;

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

    public void setActivity(Activity activity){
        this.activity = activity;
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

                        assert authSignInResponse != null;
                        String accessToken = authSignInResponse.getData().getToken();

                        //Coba pakai SharedPreferences untuk menyimpan token
                        SharedPreferences sharedPreferences = context.getSharedPreferences(TOKEN_SHARED_PREFS, Context.MODE_PRIVATE);
                        sharedPreferences.edit().putString("token", accessToken).apply();

                        String token = sharedPreferences.getString("token", "");

                        Log.e(TAG, "Hasil getToken: " + token );

                        //NEW! 5-12-23
                        getUserData(new AuthGetLoggedUserRequest(token));
//                        Toast.makeText(context, "sPrefsToken: " + token, Toast.LENGTH_SHORT).show();
                    } else {
                        Log.e(TAG, "Username tidak terdaftar/password salah!");
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

    public void getUserData(AuthGetLoggedUserRequest authGetLoggedUserRequest){
        getApiInterface();
        Call<AuthGetLoggedUserResponse> authGetLoggedUserResponseCall = getApiInterface().getUserData(
                "Bearer " + authGetLoggedUserRequest.getToken());

        authGetLoggedUserResponseCall.enqueue(new Callback<AuthGetLoggedUserResponse>() {
            @Override
            public void onResponse(Call<AuthGetLoggedUserResponse> call, Response<AuthGetLoggedUserResponse> response) {
                //Terakhir di sini 4-12-23 habis kirim token lalu terima response UserData lalu insert ke repository
                mUserRepository = new UserRepository(new Application());

                if (response.isSuccessful()){
                    AuthGetLoggedUserResponse userResponse = response.body();

                    assert userResponse != null;
                    String userId = userResponse.getData().getId();
                    String userCode = userResponse.getData().getCode();
                    String userUsername = userResponse.getData().getUsername();
                    String userEmail = userResponse.getData().getEmail();
                    String userFullname = userResponse.getData().getFullname();


                    // TODO: 12/5/2023 Memastikan apakah value pada kolom "Company" benar terisi data. Untuk saat ini hasilnya [] pada DB Browser
                    List<Company> userCompanyList = userResponse.getData().getCompany();

                    Log.e(TAG, "User ID: " + userId);
                    Log.e(TAG, "User Code: " + userCode);
                    Log.e(TAG, "User Username: " + userUsername);
                    Log.e(TAG, "User Email: " + userEmail );
                    Log.e(TAG, "User Fullname: " + userFullname);
                    Log.e(TAG, "User Company: " + userCompanyList);
                    UserEntity userEntity = new UserEntity(userId,userCode, userUsername, userEmail, userFullname, userCompanyList);

                    mUserRepository.insert(userEntity);
                    Log.e(TAG, "Hasil insert repo getUserData: " + userEntity);



//                    NavUtils.redirectToDashboard(activity);

//                        Intent intent = new Intent(activity, VehicleDashboardActivity.class);
//                        activity.startActivity(intent);

//                finish();

                } else {
                    Toast.makeText(context, "Login gagal! ", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<AuthGetLoggedUserResponse> call, Throwable t) {

            }
        });
    }




}
