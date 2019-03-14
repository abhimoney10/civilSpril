package com.civilspril.app.com.civilspril.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.civilspril.app.R;
import com.civilspril.app.com.civilspril.adapter.TopicAdapter;

public class TodaySpiralFragment extends Fragment {
    private View mView;
    private RecyclerView my_recycler_view;
    private TopicAdapter mTopicAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         super.onCreateView(inflater, container, savedInstanceState);
        mView = inflater.inflate(R.layout.today_spiral, null);
        my_recycler_view = mView.findViewById(R.id.my_recycler_view);
        return mView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        LinearLayoutManager layoutManager
                = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        my_recycler_view.setLayoutManager(layoutManager);
        mTopicAdapter = new TopicAdapter(getActivity());
        my_recycler_view.setAdapter(mTopicAdapter);


    }


}
