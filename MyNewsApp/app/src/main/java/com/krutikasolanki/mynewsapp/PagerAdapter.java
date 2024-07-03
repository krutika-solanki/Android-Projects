package com.krutikasolanki.mynewsapp;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class PagerAdapter extends FragmentPagerAdapter {
    int tabCount;

    private HomeFragment homeFragment;
    private SportsFragment sportsFragment;
    private HealthFragment healthFragment;
    private ScienceFragment scienceFragment;
    private EntertainmentFragment entertainmentFragment;
    private TechnologyFragment technologyFragment;

    public PagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
        tabCount = behavior;

        homeFragment = new HomeFragment();
        sportsFragment = new SportsFragment();
        healthFragment = new HealthFragment();
        scienceFragment = new ScienceFragment();
        entertainmentFragment = new EntertainmentFragment();
        technologyFragment = new TechnologyFragment();
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0: return homeFragment;
            case 1: return sportsFragment;
            case 2: return healthFragment;
            case 3: return scienceFragment;
            case 4: return entertainmentFragment;
            case 5: return technologyFragment;
            default: return null;
        }
    }

    @Override
    public int getCount() {
        return tabCount;
    }
}
