package com.civilspril.app.com.civilspril.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.civilspril.app.com.civilspril.fragments.TopicDetailListFragment;

public class TopicPagerAdapter extends FragmentPagerAdapter {
    private String[] header = {"Executive","Legislature","Judiciary","Federal Relation"};
    public TopicPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        return new TopicDetailListFragment();
    }

    @Override
    public int getCount() {
        return header.length;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return header[position];//super.getPageTitle(position);
    }
}
