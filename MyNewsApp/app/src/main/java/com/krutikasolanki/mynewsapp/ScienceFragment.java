package com.krutikasolanki.mynewsapp;

import android.annotation.SuppressLint;
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

public class ScienceFragment extends Fragment {
    List<Article> articles;
    RecycleAdapter adapter;
    private RecyclerView scienceRecyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_science, container, false);
        scienceRecyclerView = view.findViewById(R.id.scienceRecyclerView);
        scienceRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        articles = new ArrayList<>();
        adapter = new RecycleAdapter(getContext(), articles);
        scienceRecyclerView.setAdapter(adapter);

        MainActivity mainActivity = (MainActivity) getActivity();
        mainActivity.viewModel.getApiResponseScience().observe(getViewLifecycleOwner(), apiResponse -> {
            articles = apiResponse.getArticles();
            adapter.setArticles(articles);
        });

        return view;
    }
}