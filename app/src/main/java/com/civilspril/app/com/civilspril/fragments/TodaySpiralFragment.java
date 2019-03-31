package com.civilspril.app.com.civilspril.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.civilspril.app.R;
import com.civilspril.app.com.civilspril.adapter.TopicAdapter;
import com.civilspril.app.com.civilspril.beans.CategoryList;
import com.civilspril.app.com.civilspril.networkManager.ApiController;
import com.civilspril.app.com.civilspril.networkManager.NetworkCallBack;
import com.civilspril.app.com.civilspril.utilsFunctions.URLConstant;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

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

        ApiController apiController = new ApiController(getActivity());
        apiController.getDataFromNetworkGetMethod(URLConstant.CATEGORYS_URL, new NetworkCallBack() {
            @Override
            public void successResponse(JSONObject response) {

            }

            @Override
            public void successResponseString(String response) {
                Log.e("==========", " "+response);

                try {
                    JSONArray jsonArray = new JSONArray(response);
                    JSONObject jsonObject = new JSONObject();
                    jsonObject.put("category", jsonArray);
                    Gson gson = new Gson();
                    CategoryList mCategoryList = gson.fromJson(jsonObject.toString(), CategoryList.class);
                    Log.e("==========", " "+mCategoryList.getCategoryList().size());
                    mTopicAdapter = new TopicAdapter(getActivity(),mCategoryList.getCategoryList());
                    my_recycler_view.setAdapter(mTopicAdapter);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void error() {

            }
        });

    }


}
