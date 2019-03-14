package com.civilspril.app.com.civilspril.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.civilspril.app.R;
import com.civilspril.app.com.civilspril.adapter.TopicPagerAdapter;

import org.w3c.dom.Text;

public class TodaySpiralDetailFragment extends Fragment {
    private View mView;
    private ViewPager pager;
    private TextView tv_title;
    private ImageView img_back;

    private TopicPagerAdapter mTopicAdapter;
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         super.onCreateView(inflater, container, savedInstanceState);
        mView = inflater.inflate(R.layout.topiv_detail, null);
        pager = mView.findViewById(R.id.pager);
        tv_title = mView.findViewById(R.id.tv_title);
        img_back = mView.findViewById(R.id.img_back);
        return mView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mTopicAdapter = new TopicPagerAdapter(getActivity().getSupportFragmentManager());
        pager.setAdapter(mTopicAdapter);

        if(!TextUtils.isEmpty(title))
        tv_title.setText(title);

        img_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().onBackPressed();
            }
        });

    }


}
