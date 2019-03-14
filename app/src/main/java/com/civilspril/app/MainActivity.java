package com.civilspril.app;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.civilspril.app.com.civilspril.activities.LoginActivity;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    private Timer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Intent in = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(in);
                finish();

            }
        }, 2000);

    }


}
