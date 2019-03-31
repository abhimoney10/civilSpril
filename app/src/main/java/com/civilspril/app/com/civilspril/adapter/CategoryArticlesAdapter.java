package com.civilspril.app.com.civilspril.adapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.civilspril.app.com.civilspril.beans.ArticaleData;
import com.civilspril.app.com.civilspril.beans.Categories;
import com.civilspril.app.com.civilspril.fragments.ArticleDetailFragment;

import java.util.ArrayList;

public class CategoryArticlesAdapter extends FragmentPagerAdapter {
    private  ArrayList<ArticaleData> categoriesArrayList;
    private Bundle bndl;
    public static final String ARTICLE_DATA ="articleData";
    public CategoryArticlesAdapter(FragmentManager fm, ArrayList<ArticaleData> categoriesArrayList) {
        super(fm);
        this.categoriesArrayList = categoriesArrayList;
    }

    @Override
    public Fragment getItem(int i) {
         bndl = new Bundle();
         bndl.putSerializable(ARTICLE_DATA, categoriesArrayList.get(i));
        ArticleDetailFragment mArticleDetailFragment = new ArticleDetailFragment();
        mArticleDetailFragment.setArguments(bndl);
        return mArticleDetailFragment;
    }

    @Override
    public int getCount() {
        return categoriesArrayList.size();
    }
}
