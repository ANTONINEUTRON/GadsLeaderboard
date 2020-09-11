package com.neutron.gadsleaderboard.ui.submission;

import android.content.Context;
import android.util.Log;

import com.neutron.gadsleaderboard.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static android.content.ContentValues.TAG;

public class SubmitApiBuilder {

    private static Retrofit retrofit;
    private static final String BASE_URL = "https://docs.google.com/forms/d/e/";

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

    public  static void submitDetails(UserDetailsModel user, final Context context){
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
                    ShowDialog showDialog = new ShowDialog(context, R.layout.submission_successful_dialog);
                    showDialog.show();
                    Log.i(TAG,"Submitted Successfully "+response.code());
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                ShowDialog showDialog = new ShowDialog(context,R.layout.submission_failed_dialog);
                showDialog.show();
            }
        });
    }
}
