package com.example.pupil.myfirstproject.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.pupil.myfirstproject.ui.fragments.BaseFragment;

import java.util.List;

public class MyFragmentPagerAdapter extends FragmentPagerAdapter {
    private List<BaseFragment> fragments;

    public MyFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    public void setList(List<BaseFragment> fragments) {
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int i) {
        return fragments.get(i);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return fragments.get(position).getName();
    }
}
