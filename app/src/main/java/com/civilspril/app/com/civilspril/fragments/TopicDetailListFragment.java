package com.civilspril.app.com.civilspril.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.civilspril.app.R;
import com.civilspril.app.com.civilspril.adapter.TopicAdapter;
import com.civilspril.app.com.civilspril.adapter.TopicDetailListAdapter;

public class TopicDetailListFragment extends Fragment {
    private View mView;
    private RecyclerView recycler_view;
    private TopicDetailListAdapter mTopicAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         super.onCreateView(inflater, container, savedInstanceState);
        mView = inflater.inflate(R.layout.topiv_detail_list, null);
        recycler_view = mView.findViewById(R.id.recycler_view);
        return mView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        LinearLayoutManager layoutManager
                = new LinearLayoutManager(getActivity(), OrientationHelper.VERTICAL, false);
        recycler_view.setLayoutManager(layoutManager);
        mTopicAdapter = new TopicDetailListAdapter(getActivity());
        recycler_view.setAdapter(mTopicAdapter);


    }


}
