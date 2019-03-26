package com.civilspril.app.com.civilspril.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.civilspril.app.R;

public class CategoryDetails extends AppCompatActivity implements View.OnClickListener {
    private ImageView img_back,img;
    private TextView tv_title,tv_body;
    private LinearLayout ll_comment,ll_share,ll_fav,ll_like;

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
        img = findViewById(R.id.img);
        tv_body = findViewById(R.id.tv_body);
        ll_comment = findViewById(R.id.ll_comment);
        ll_share = findViewById(R.id.ll_share);
        ll_fav = findViewById(R.id.ll_fav);
        ll_like = findViewById(R.id.ll_like);

    }
    private void initData(){

    }

    private void setListner(){
        img_back.setOnClickListener(this);
        ll_comment.setOnClickListener(this);
        ll_share.setOnClickListener(this);
        ll_fav.setOnClickListener(this);
        ll_like.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ll_like:

                break;
            case R.id.ll_comment:

                break;
            case R.id.ll_share:

                break;
            case R.id.ll_fav:

                break;
            case R.id.img_back:
                onBackPressed();
                break;
        }

    }
}
