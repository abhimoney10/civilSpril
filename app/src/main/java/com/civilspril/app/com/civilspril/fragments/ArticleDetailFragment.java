package com.civilspril.app.com.civilspril.fragments;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.TextView;

import com.civilspril.app.R;
import com.civilspril.app.com.civilspril.adapter.CategoryArticlesAdapter;
import com.civilspril.app.com.civilspril.beans.ArticaleData;

public class ArticleDetailFragment extends Fragment {
    private View mView;
   private  ArticaleData articaleData;
   private Bundle bndl;
    private WebView webview;
    private String body =null;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.topic_detail_list_items, null);
        return mView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        webview = mView.findViewById(R.id.webview);
        bndl = getArguments();
        articaleData = (ArticaleData) bndl.getSerializable(CategoryArticlesAdapter.ARTICLE_DATA);
        body =  articaleData.getBody();
        webview.loadData(body , "text/html; charset=UTF-8", null);



    }
}
