package com.civilspril.app.com.civilspril.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.civilspril.app.R;
import com.civilspril.app.com.civilspril.fragments.TodaySpiralFragment;

public class HomeActivity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.home_activity);
        addFragment(new TodaySpiralFragment(),"todaySpiral" );


    }
}
