package com.krutikasolanki.mynewsapp.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.krutikasolanki.mynewsapp.repository.NewsRepository;
import com.krutikasolanki.mynewsapp.repository.model.ApiResponse;
import com.krutikasolanki.mynewsapp.repository.model.Article;

import java.util.List;

public class NewsViewModel extends ViewModel {
    private NewsRepository newsRepository;

    public NewsViewModel() {
        newsRepository = new NewsRepository();
    }

    public LiveData<ApiResponse> getApiResponseGeneral() {
        LiveData<ApiResponse> apiResponseLiveData = newsRepository.getGeneralNews();
        return apiResponseLiveData;
    }

    public LiveData<ApiResponse> getApiResponseEntertainment() {
        return newsRepository.getEntertainmentNews();
    }

    public LiveData<ApiResponse> getApiResponseHealth() {
        return newsRepository.getHealthNews();
    }

    public LiveData<ApiResponse> getApiResponseScience() {
        return newsRepository.getScienceNews();
    }

    public LiveData<ApiResponse> getApiResponseSports() {
        return newsRepository.getSportsNews();
    }

    public LiveData<ApiResponse> getApiResponseTechnology() {
        return newsRepository.getTechnologyNews();
    }
}
