package com.neutron.gadsleaderboard.ui.main;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiEndpoints {
    @GET("/api/hours")
    Call<List<HourModel>> getHour();

    @GET("/api/skilliq")
    Call<List<SkillModel>> getSkilliq();
}
