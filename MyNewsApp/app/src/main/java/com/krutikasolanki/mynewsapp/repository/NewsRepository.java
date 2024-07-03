package com.krutikasolanki.mynewsapp.repository;


import android.app.Application;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.krutikasolanki.mynewsapp.BuildConfig;
import com.krutikasolanki.mynewsapp.repository.model.ApiResponse;
import com.krutikasolanki.mynewsapp.repository.retrofit.InterfaceAPI;
import com.krutikasolanki.mynewsapp.repository.retrofit.UtilitiesAPI;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewsRepository {
    private MutableLiveData<ApiResponse> apiResponseGeneral;
    private MutableLiveData<ApiResponse> apiResponseEntertainment;
    private MutableLiveData<ApiResponse> apiResponseHealth;
    private MutableLiveData<ApiResponse> apiResponseScience;
    private MutableLiveData<ApiResponse> apiResponseSports;
    private MutableLiveData<ApiResponse> apiResponseTechnology;
    private final InterfaceAPI interfaceAPI;

    public NewsRepository() {
        interfaceAPI = UtilitiesAPI.getAPIInterface();
        apiResponseGeneral = new MutableLiveData<>();
        apiResponseEntertainment = new MutableLiveData<>();
        apiResponseHealth = new MutableLiveData<>();
        apiResponseScience = new MutableLiveData<>();
        apiResponseSports = new MutableLiveData<>();
        apiResponseTechnology = new MutableLiveData<>();
    }

    public LiveData<ApiResponse> getGeneralNews() {
        fetchGeneralNews();
        return apiResponseGeneral;
    }

    public LiveData<ApiResponse> getEntertainmentNews() {
        fetchEntertainmentNews();
        return apiResponseEntertainment;
    }

    public LiveData<ApiResponse> getHealthNews() {
        fetchHealthNews();
        return apiResponseHealth;
    }

    public LiveData<ApiResponse> getScienceNews() {
        fetchScienceNews();
        return apiResponseScience;
    }

    public LiveData<ApiResponse> getSportsNews() {
        fetchSportsNews();
        return apiResponseSports;
    }

    public LiveData<ApiResponse> getTechnologyNews() {
        fetchTechnologyNews();
        return apiResponseTechnology;
    }

    private void fetchGeneralNews() {
        Call<ApiResponse> call = interfaceAPI.getNews("in", "general", BuildConfig.API_KEY);
        call.enqueue(new Callback<ApiResponse>() {
            @Override
            public void onResponse(Call<ApiResponse> call, Response<ApiResponse> response) {
                if (response.isSuccessful()) {
                    apiResponseGeneral.postValue(response.body());
                }
                Log.d("MainActivity.this", "fetchGeneralNews: " + response.body());
            }

            @Override
            public void onFailure(Call<ApiResponse> call, Throwable t) {
                Log.e("MainActivity.this", "onFailure: Operation Failed");
            }
        });
    }

    private void fetchEntertainmentNews() {
        Call<ApiResponse> call = interfaceAPI.getNews("in", "entertainment", BuildConfig.API_KEY);
        call.enqueue(new Callback<ApiResponse>() {
            @Override
            public void onResponse(Call<ApiResponse> call, Response<ApiResponse> response) {
                if (response.isSuccessful()) {
                    apiResponseEntertainment.postValue(response.body());
                }
                Log.d("MainActivity.this", "fetchEntertainmentNews: " + response.body());
            }

            @Override
            public void onFailure(Call<ApiResponse> call, Throwable t) {
                Log.e("MainActivity.this", "onFailure: Operation Failed");
            }
        });
    }

    private void fetchHealthNews() {
        Call<ApiResponse> call = interfaceAPI.getNews("in", "health", BuildConfig.API_KEY);
        call.enqueue(new Callback<ApiResponse>() {
            @Override
            public void onResponse(Call<ApiResponse> call, Response<ApiResponse> response) {
                if (response.isSuccessful()) {
                    apiResponseHealth.postValue(response.body());
                }
                Log.d("MainActivity.this", "fetchHealthNews: " + response.body());
            }

            @Override
            public void onFailure(Call<ApiResponse> call, Throwable t) {
                Log.e("MainActivity.this", "onFailure: Operation Failed");
            }
        });
    }

    private void fetchScienceNews() {
        Call<ApiResponse> call = interfaceAPI.getNews("in", "science", BuildConfig.API_KEY);
        call.enqueue(new Callback<ApiResponse>() {
            @Override
            public void onResponse(Call<ApiResponse> call, Response<ApiResponse> response) {
                if (response.isSuccessful()) {
                    apiResponseScience.postValue(response.body());
                }
                Log.d("MainActivity.this", "fetchScienceNews: " + response.body());
            }

            @Override
            public void onFailure(Call<ApiResponse> call, Throwable t) {
                Log.e("MainActivity.this", "onFailure: Operation Failed");
            }
        });
    }

    private void fetchSportsNews() {
        Call<ApiResponse> call = interfaceAPI.getNews("in", "sports", BuildConfig.API_KEY);
        call.enqueue(new Callback<ApiResponse>() {
            @Override
            public void onResponse(Call<ApiResponse> call, Response<ApiResponse> response) {
                if (response.isSuccessful()) {
                    apiResponseSports.postValue(response.body());
                }
                Log.d("MainActivity.this", "fetchSportsNews: " + response.body());
            }

            @Override
            public void onFailure(Call<ApiResponse> call, Throwable t) {
                Log.e("MainActivity.this", "onFailure: Operation Failed");
            }
        });
    }

    private void fetchTechnologyNews() {
        Call<ApiResponse> call = interfaceAPI.getNews("in", "technology", BuildConfig.API_KEY);
        call.enqueue(new Callback<ApiResponse>() {
            @Override
            public void onResponse(Call<ApiResponse> call, Response<ApiResponse> response) {
                if (response.isSuccessful()) {
                    apiResponseTechnology.postValue(response.body());
                }
                Log.d("MainActivity.this", "fetchTechnologyNews: " + response.body());
            }

            @Override
            public void onFailure(Call<ApiResponse> call, Throwable t) {
                Log.e("MainActivity.this", "onFailure: Operation Failed");
            }
        });
    }
}

