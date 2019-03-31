package com.civilspril.app.com.civilspril.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.civilspril.app.R;
import com.civilspril.app.com.civilspril.fragments.TodaySpiralFragment;

public class BaseActivity extends AppCompatActivity {
    protected FrameLayout container;
    protected  BottomNavigationView navigation;
    private Fragment fragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.base_activity);

        container = findViewById(R.id.container);
         navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.today_spiral:
                   // mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.saved_spiral:
                   // mTextMessage.setText(R.string.title_dashboard);
                    Intent intent = new Intent(BaseActivity.this, FavoriteDataList.class);
                    intent.putExtra(CategoryDetails.NAME, "SAVED SPIRAL");
                    startActivity(intent);
                    return true;
                case R.id.premium_quiz:
                    Intent intent1 = new Intent(BaseActivity.this, QuizDataList.class);
                    intent1.putExtra(CategoryDetails.NAME, "PREMIUM QUIZ");
                    startActivity(intent1);
                   // mTextMessage.setText(R.string.title_notifications);
                    return true;
                case R.id.spiral_profile:
                    // mTextMessage.setText(R.string.title_notifications);
                    return true;
            }
            return false;
        }
    };

    public void replaceFragment(Fragment fragment,String tag){
        this.fragment = fragment;
        getSupportFragmentManager()
                .beginTransaction()
                //.setCustomAnimations(R.anim.slide_in_from_bottom, FragmentTransaction.TRANSIT_NONE, FragmentTransaction.TRANSIT_NONE, R.anim.slide_out_to_bottom)
                .replace(R.id.container, fragment, tag)
                .addToBackStack(null)
                .commit();
    }

    public void addFragment(Fragment fragment,String tag){
        this.fragment = fragment;
        getSupportFragmentManager()
                .beginTransaction()
                //.setCustomAnimations(R.anim.slide_in_from_bottom, FragmentTransaction.TRANSIT_NONE, FragmentTransaction.TRANSIT_NONE, R.anim.slide_out_to_bottom)
                .replace(R.id.container, fragment, tag)
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if(fragment instanceof TodaySpiralFragment){
            finish();
        }
    }
}
