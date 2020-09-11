package com.neutron.gadsleaderboard.ui.main;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.neutron.gadsleaderboard.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainFragment extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";

    private PageViewModel pageViewModel;
    private int index;

    public static MainFragment newInstance(int index) {
        MainFragment fragment = new MainFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(ARG_SECTION_NUMBER, index);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        index = 1;
        if (getArguments() != null) {
            index = getArguments().getInt(ARG_SECTION_NUMBER);
        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);
        final RecyclerView rv = root.findViewById(R.id.rv);
        if(index==1) {
            showHours(rv);
        }else{
            showSkilliq(rv);
        }
        return root;
    }

    public void showHours(final RecyclerView rv){
        ApiEndpoints apiEndpoints = ApiClient.getRetrofitInstance().create(ApiEndpoints.class);
        Call<List<HourModel>> call = apiEndpoints.getHour();
        Callback<List<HourModel>> callback = new Callback<List<HourModel>>() {
            @Override
            public void onResponse(Call<List<HourModel>> call, Response<List<HourModel>> response) {
                if (response.isSuccessful()) {
                    HourRecyclerviewAdapter hourRecyclerviewAdapter = new HourRecyclerviewAdapter(getContext(),response.body());
                    rv.setAdapter(hourRecyclerviewAdapter);
                    rv.setLayoutManager(new LinearLayoutManager(getContext()));
                }
            }

            @Override
            public void onFailure(Call<List<HourModel>> call, Throwable t) {
                Log.e("GET HOUR", "Error in Fetching Content");
                //Toast(MainActivity.this,"Connection Error",Toast.LENGTH_LONG).show();
            }
        };
        call.enqueue(callback);
    }

    public void showSkilliq(final RecyclerView rv){
        ApiEndpoints apiEndpoints = ApiClient.getRetrofitInstance().create(ApiEndpoints.class);
        Call<List<SkillModel>> call = apiEndpoints.getSkilliq();
        call.enqueue(new Callback<List<SkillModel>>() {
            @Override
            public void onResponse(Call<List<SkillModel>> call, Response<List<SkillModel>> response) {
                if (response.isSuccessful()) {
                    SkillRecyclerviewAdapter skillRecyclerviewAdapter = new SkillRecyclerviewAdapter(getContext(),response.body());
                    rv.setAdapter(skillRecyclerviewAdapter);
                    rv.setLayoutManager(new LinearLayoutManager(getContext()));
                }
            }

            @Override
            public void onFailure(Call<List<SkillModel>> call, Throwable t) {
                Log.e("GET SKILL","Error in Fetching Content");
            }
        });
    }
}