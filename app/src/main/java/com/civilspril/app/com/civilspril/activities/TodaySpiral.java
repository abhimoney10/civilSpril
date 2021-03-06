package com.civilspril.app.com.civilspril.activities;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.civilspril.app.R;
import com.civilspril.app.com.civilspril.adapter.CategoryArticlesAdapter;
import com.civilspril.app.com.civilspril.beans.CategoryArticleData;
import com.civilspril.app.com.civilspril.beans.CategoryArticles;
import com.civilspril.app.com.civilspril.networkManager.ApiController;
import com.civilspril.app.com.civilspril.networkManager.NetworkCallBack;
import com.civilspril.app.com.civilspril.utilsFunctions.URLConstant;
import com.google.gson.Gson;

import org.json.JSONObject;

public class TodaySpiral extends AppCompatActivity implements View.OnClickListener {
    private ImageView img_back;
    private TextView tv_title;
    public static final String NAME = "name";
    private Bundle bundle;
    private  String name;
    private ProgressDialog progressDialog;
    private ViewPager pager;
    private  CategoryArticlesAdapter mCategoryArticlesAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.category_details);
        initView();
        initData();
        setListner();
    }
    private void initView(){
        img_back = findViewById(R.id.img_back);
        tv_title = findViewById(R.id.tv_title);
        pager = findViewById(R.id.pager);



    }
    private void initData(){
        bundle = getIntent().getExtras();
        name = bundle.getString(NAME);
        tv_title.setText(name);
        getNetworkData(this );
    }

    private void setListner(){
        img_back.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ll_comment:

                break;
            case R.id.ll_share:

                break;

            case R.id.img_back:
                onBackPressed();
                break;
        }

    }

    private void getNetworkData(Context context){
        progressDialog = new ProgressDialog(context);
        progressDialog.setMessage("Please wait..");
        progressDialog.setIndeterminate(true);
        progressDialog.setCancelable(false);
        progressDialog.show();
      String url =   URLConstant.TODAY_SPIRL_URL;

        ApiController apiController = new ApiController(context);
        apiController.getDataFromNetworkGetMethod(url, new NetworkCallBack() {
            @Override
            public void successResponse(JSONObject response) {
                progressDialog.dismiss();
                Gson gson = new Gson();
                CategoryArticleData categoryArticleData = gson.fromJson(response.toString(), CategoryArticleData.class);
               if(categoryArticleData!=null){
                   mCategoryArticlesAdapter = new CategoryArticlesAdapter(getSupportFragmentManager(),categoryArticleData.getArticaleDataArrayList());
                   pager.setAdapter(mCategoryArticlesAdapter);
                  // Log.e("===!!!!=======", " "+mCategoryList.getmCategoryArticleData().getArticaleDataArrayList().get(0).getTitle());
               }
            }

            @Override
            public void successResponseString(String response) {
              //  Log.e("==========", " "+response);


            }

            @Override
            public void error() {
                progressDialog.dismiss();
            }
        });

    }
}
