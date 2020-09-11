package com.neutron.gadsleaderboard.ui.submission;

import android.util.Log;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static android.content.ContentValues.TAG;

public class SubmitApiBuilder {

    private static Retrofit retrofit;
    private static final String BASE_URL = "https://docs.google.com/forms/d/e/";
    private static int responseCode;

    public static Retrofit getRetrofitInstance(){
        if(retrofit==null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        Log.e(TAG,"oti");
        return  retrofit;
    }

    public  static int submitDetails(UserDetailsModel user){
        SubmitApi submitApi = getRetrofitInstance().create(SubmitApi.class);
        Call<Void> call = submitApi.createPost(
                user.getEmail(),
                user.getFname(),
                user.getLname(),
                user.getGitHub()
        );
        call.enqueue(new Callback<Void>(){
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if(response.isSuccessful()){
                    responseCode = response.code();
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                responseCode = 0;
            }
        });

        return responseCode;
    }
}
