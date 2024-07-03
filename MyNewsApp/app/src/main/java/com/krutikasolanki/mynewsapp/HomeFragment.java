package com.krutikasolanki.mynewsapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.krutikasolanki.mynewsapp.repository.model.ApiResponse;
import com.krutikasolanki.mynewsapp.repository.model.Article;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {
    List<Article> articles;
    RecycleAdapter adapter;
    private RecyclerView homeRecyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        homeRecyclerView = view.findViewById(R.id.homeRecyclerView);
        homeRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        articles = new ArrayList<>();
        adapter = new RecycleAdapter(getContext(), articles);
        homeRecyclerView.setAdapter(adapter);

        MainActivity mainActivity = (MainActivity) getActivity();
        mainActivity.viewModel.getApiResponseGeneral().observe(getViewLifecycleOwner(), apiResponse -> {
            articles = apiResponse.getArticles();
            adapter.setArticles(articles);
        });

        return view;
    }
}