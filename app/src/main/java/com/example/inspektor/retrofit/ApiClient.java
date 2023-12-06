package com.example.inspektor.retrofit;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.widget.Toast;

import com.example.inspektor.model.GLOBALSendTokenRequest;
import com.example.inspektor.model.AuthGetLoggedUserResponse;
import com.example.inspektor.model.AuthRequest;
import com.example.inspektor.model.AuthSignInResponse;
import com.example.inspektor.model.Company;
import com.example.inspektor.model.MobData;
import com.example.inspektor.model.MobResponse;
import com.example.inspektor.model.ObjPartData;
import com.example.inspektor.model.ObjPartResponse;
import com.example.inspektor.model.PlanData;
import com.example.inspektor.model.PlanResponse;
import com.example.inspektor.model.RunAcctData;
import com.example.inspektor.model.RunAcctResponse;
import com.example.inspektor.model.VecTypeData;
import com.example.inspektor.model.VecTypeResponse;
import com.example.inspektor.repository.MobRepository;
import com.example.inspektor.repository.ObjPartRepository;
import com.example.inspektor.repository.PlanRepository;
import com.example.inspektor.repository.RunAcctRepository;
import com.example.inspektor.repository.UserRepository;
import com.example.inspektor.repository.VecTypeRepository;
import com.example.inspektor.room.entity.MobEntity;
import com.example.inspektor.room.entity.ObjPartEntity;
import com.example.inspektor.room.entity.PlanEntity;
import com.example.inspektor.room.entity.RunAcctEntity;
import com.example.inspektor.room.entity.UserEntity;
import com.example.inspektor.room.entity.VecTypeEntity;

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
    private MobRepository mMobRepository;
    private ObjPartRepository mObjPartRepository;
    private PlanRepository mPlanRepository;
    private RunAcctRepository mRunAcctRepository;
    private VecTypeRepository mVecTypeRepository;

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

                        //  5-12-23
                        getUserData(new GLOBALSendTokenRequest(token));

                        // 6-12-23
                        getMobData(new GLOBALSendTokenRequest(token));

                        // 6-12-23
                        getObjPartData(new GLOBALSendTokenRequest(token));

                        // 6-12-23
                        getPlanData(new GLOBALSendTokenRequest(token));
//                        Toast.makeText(context, "sPrefsToken: " + token, Toast.LENGTH_SHORT).show();

                        // 6-12-23
                        getRunAcctData(new GLOBALSendTokenRequest(token));

                        // 6-12-23
                        getVecTypeData(new GLOBALSendTokenRequest(token));




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



    public void getUserData(GLOBALSendTokenRequest globalSendTokenRequest){
        getApiInterface();
        Call<AuthGetLoggedUserResponse> authGetLoggedUserResponseCall = getApiInterface().getUserData(
                "Bearer " + globalSendTokenRequest.getToken());

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
                Log.e(TAG, "onFailure: getUserData gagal!");
            }
        });
    }

    public void getMobData(GLOBALSendTokenRequest globalSendTokenRequest){
        getApiInterface();
        Call<MobResponse> mobResponseCall = getApiInterface().getMobData(
                "Bearer " + globalSendTokenRequest.getToken());

        mobResponseCall.enqueue(new Callback<MobResponse>() {
            @Override
            public void onResponse(Call<MobResponse> call, Response<MobResponse> response) {
                // GET MOB
                mMobRepository = new MobRepository(new Application());
                Log.e(TAG, "sedang mengecek apakah getMobData berhasil atau tidak");

                assert response.body() != null;
                List<MobData> mobDataList = response.body().getData();

                Log.e(TAG, "mobDataList: " + mobDataList);

                for (MobData mobData : mobDataList) {
                    MobEntity mobEntity = new MobEntity();

                    mobEntity.setMobId(mobData.getId());
                    mobEntity.setMobNoInspec(mobData.getNo_inspec());
                    mobEntity.setMobBa(mobData.getBa());
                    mobEntity.setMobRunningAccount(mobData.getRunningAccount());
                    mobEntity.setMobVehicleType(mobData.getVehicleType());
                    mobEntity.setMobObjPart(mobData.getObjPart());
                    mobEntity.setMobDamDate(mobData.getDamDate());
                    mobEntity.setMobStatus(mobData.getStatus());
                    mobEntity.setMobLoc(mobData.getLoc());
                    mobEntity.setMobPhoto(mobData.getPhoto());
                    mobEntity.setMobNote(mobData.getNote());
                    mobEntity.setMobPlanDate(mobData.getPlanDate());
                    mobEntity.setMobCreatedBy(mobData.getCreatedBy());
                    mobEntity.setMobCreatedDate(mobData.getCreatedDate());
                    mobEntity.setMobCreatedTime(mobData.getCreatedTime());
                    mobEntity.setMobZtuagriRunacctId(mobData.getZtuagriRunacctId());
                    mobEntity.setMobZinspecVehicletypeId(mobData.getZinspecVehicletypeId());

                    mMobRepository.insertAll(mobEntity);
                }
            }

            @Override
            public void onFailure(Call<MobResponse> call, Throwable t) {
                Log.e(TAG, "onFailure: getMobData gagal!");
            }
        });
    }

    private void getObjPartData(GLOBALSendTokenRequest globalSendTokenRequest) {
        getApiInterface();
        Call<ObjPartResponse> objPartResponseCall = getApiInterface().getObjPartData(
                "Bearer " + globalSendTokenRequest.getToken());

        objPartResponseCall.enqueue(new Callback<ObjPartResponse>() {
            @Override
            public void onResponse(Call<ObjPartResponse> call, Response<ObjPartResponse> response) {
                mObjPartRepository = new ObjPartRepository(new Application());

                Log.e(TAG, "sedang mengecek apakah getObjPartData berhasil atau tidak");

                assert response.body() != null;
                List<ObjPartData> objPartDataList = response.body().getData();

                for (ObjPartData objPartData : objPartDataList){
                    ObjPartEntity objPartEntity = new ObjPartEntity();

                    objPartEntity.setObjPartId(objPartData.getId());
                    objPartEntity.setObjPartName(objPartData.getObjPart());
                    objPartEntity.setObjPartVehicleType(objPartData.getVehicleType());
                    objPartEntity.setObjPartZinspecVehicletypeId(objPartData.getZinspecVehicletypeId());

                    mObjPartRepository.insert(objPartEntity);
                }
            }

            @Override
            public void onFailure(Call<ObjPartResponse> call, Throwable t) {

            }
        });
    }

    private void getPlanData(GLOBALSendTokenRequest globalSendTokenRequest){
        getApiInterface();
        Call<PlanResponse> planResponseCall = getApiInterface().getPlanData(
                "Bearer " + globalSendTokenRequest.getToken());

        planResponseCall.enqueue(new Callback<PlanResponse>() {
            @Override
            public void onResponse(Call<PlanResponse> call, Response<PlanResponse> response) {
                mPlanRepository = new PlanRepository(new Application());

                Log.e(TAG, "sedang mengecek apakah getPlanData berhasil atau tidak");

                assert response.body() != null;
                List<PlanData> planDataList = response.body().getData();

                for (PlanData planData : planDataList){
                    PlanEntity planEntity = new PlanEntity();

                    planEntity.setPlanId(planData.getId());
                    planEntity.setPlanCompanyCode(planData.getCompanyCode());
                    planEntity.setPlanBA(planData.getBa());
                    planEntity.setPlanRunningAccount(planData.getRunningAccount());
                    planEntity.setPlanStatus(planData.getStatus());
                    planEntity.setPlanDate(planData.getPlanDate());
                    planEntity.setPlanInspectDate(planData.getInspectDate());
                    planEntity.setPlanInspectTime(planData.getInspectTime());
                    planEntity.setPlanZtuagriRunacctId(planData.getZtuagriRunacctId());
                    planEntity.setPlanWeek(planData.getWeek());

                    mPlanRepository.insert(planEntity);
                }
            }

            @Override
            public void onFailure(Call<PlanResponse> call, Throwable t) {

            }
        });
    }

    private void getRunAcctData(GLOBALSendTokenRequest globalSendTokenRequest){
        getApiInterface();
        Call<RunAcctResponse> runAcctResponseCall = getApiInterface().getRunAcctData(
                "Bearer " + globalSendTokenRequest.getToken());

        runAcctResponseCall.enqueue(new Callback<RunAcctResponse>() {
            @Override
            public void onResponse(Call<RunAcctResponse> call, Response<RunAcctResponse> response) {
                mRunAcctRepository = new RunAcctRepository(new Application());

                Log.e(TAG, "sedang mengecek apakah getRunAcctData berhasil atau tidak");

                assert response.body() != null;
                List<RunAcctData> runAcctDataList = response.body().getData();

                for (RunAcctData runAcctData : runAcctDataList){
                    RunAcctEntity runAcctEntity = new RunAcctEntity();

                    runAcctEntity.setRunAcctId(runAcctData.getId());
                    runAcctEntity.setRunAcct(runAcctData.getRunningAccount());
                    runAcctEntity.setRunAcctCompanyCode(runAcctData.getCompanyCode());
                    runAcctEntity.setRunAcctEstate(runAcctData.getEstate());
                    runAcctEntity.setRunAcctAnln1(runAcctData.getAnln1());
                    runAcctEntity.setRunAcctClassRA(runAcctData.getClassRa());
                    runAcctEntity.setRunAcctStatusFlag(runAcctData.getStatusFlag());
                    runAcctEntity.setRunAcctKostl(runAcctData.getKostl());
                    runAcctEntity.setRunAcctClassGroup(runAcctData.getClassGroup());
                    runAcctEntity.setRunAcctLicensePlate(runAcctData.getLicensePlate());
                    runAcctEntity.setRunAcctRunningText(runAcctData.getRunningText());
                    runAcctEntity.setRunAcctEqunr(runAcctData.getEqunr());

                    mRunAcctRepository.insert(runAcctEntity);
                }
            }

            @Override
            public void onFailure(Call<RunAcctResponse> call, Throwable t) {

            }
        });
    }

    private void getVecTypeData(GLOBALSendTokenRequest globalSendTokenRequest){
        getApiInterface();
        Call<VecTypeResponse> vecTypeResponseCall = getApiInterface().getVecTypeData(
                "Bearer " + globalSendTokenRequest.getToken());

        vecTypeResponseCall.enqueue(new Callback<VecTypeResponse>() {
            @Override
            public void onResponse(Call<VecTypeResponse> call, Response<VecTypeResponse> response) {
                mVecTypeRepository = new VecTypeRepository(new Application());

                Log.e(TAG, "sedang mengecek apakah getVecTypeData berhasil atau tidak");

                assert response.body() != null;
                List<VecTypeData> vecTypeDataList = response.body().getData();

                for (VecTypeData vecTypeData : vecTypeDataList){
                    VecTypeEntity vecTypeEntity = new VecTypeEntity();

                    vecTypeEntity.setVecTypeId(vecTypeData.getId());

                    // --- Vehicle_type kok null di database
                    vecTypeEntity.setVecType(vecTypeData.getVecTypeName());
                    // --- Vehicle_type kok null di database

                    vecTypeEntity.setVecTypeCode(vecTypeData.getCode());
                    vecTypeEntity.setVecTypeObjPart(vecTypeData.getObj_part());

                    mVecTypeRepository.insert(vecTypeEntity);
                }
            }

            @Override
            public void onFailure(Call<VecTypeResponse> call, Throwable t) {

            }
        });
    }
}
