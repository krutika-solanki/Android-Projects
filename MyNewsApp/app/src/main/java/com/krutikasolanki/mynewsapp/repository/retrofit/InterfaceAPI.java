package com.krutikasolanki.mynewsapp.repository.retrofit;

import com.krutikasolanki.mynewsapp.repository.model.ApiResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface InterfaceAPI {
    String BASE_URL = "https://newsapi.org/v2/";

    @GET("top-headlines")
    Call<ApiResponse> getNews(
            @Query("country") String country,
            @Query("category") String category,
            @Query("apiKey") String apikey
    );
}
