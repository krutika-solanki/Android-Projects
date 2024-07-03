package com.krutikasolanki.mynewsapp;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;
import com.krutikasolanki.mynewsapp.repository.model.ApiResponse;
import com.krutikasolanki.mynewsapp.repository.model.Article;
import com.krutikasolanki.mynewsapp.viewmodel.NewsViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;
    TabLayout tabLayout;
    TabItem home, sports, science, health, entertainment, technology;
    NewsViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        tabLayout = findViewById(R.id.tabLayout);
        home = findViewById(R.id.home);
        sports = findViewById(R.id.sports);
        science = findViewById(R.id.science);
        health = findViewById(R.id.health);
        entertainment = findViewById(R.id.entertainment);
        technology = findViewById(R.id.technology);
        setSupportActionBar(toolbar);

        viewModel = new ViewModelProvider(this).get(NewsViewModel.class);

        ViewPager fragmentContainer = findViewById(R.id.fragmentContainer);
        PagerAdapter pagerAdapter = new PagerAdapter(getSupportFragmentManager(), 6);
        fragmentContainer.setAdapter(pagerAdapter);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                fragmentContainer.setCurrentItem(tab.getPosition());
                if (tab.getPosition() == 0 || tab.getPosition() == 1 || tab.getPosition() == 2 || tab.getPosition() == 3 || tab.getPosition() == 4 || tab.getPosition() == 5) {
                    pagerAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        fragmentContainer.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
    }
}