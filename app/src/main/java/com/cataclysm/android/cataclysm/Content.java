package com.cataclysm.android.cataclysm;

import android.content.Intent;
import android.content.res.Configuration;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import static android.R.attr.x;

public class Content extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    Toolbar toolbar;
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;
    NavigationView navigationView;
    TextView body, username,location;
    ImageView imgy;
    String xusername,xbody,xlocation,ximg;
    int[] myImageList = new int[]{R.drawable.one, R.drawable.two,R.drawable.three,R.drawable.four};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);
        ////////
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        /////////
        location = (TextView) findViewById(R.id.location);
        username = (TextView) findViewById(R.id.username);
        body = (TextView) findViewById(R.id.body);
        imgy = (ImageView) findViewById(R.id.img);
        /////////
        Intent intent = getIntent();
        xbody = intent.getStringExtra("body");
        xusername = intent.getStringExtra("username");
        ximg = intent.getStringExtra("post_img");
        xlocation = intent.getStringExtra("location");
        /////
        location.setText(xlocation);
        body.setText(xbody);
        username.setText(xusername);
       // Picasso.with(getApplicationContext()).load(myImageList[Integer.parseInt(ximg)]).into(imgy);
        ////////
        navigationView = (NavigationView) findViewById(R.id.navview);
        navigationView.setNavigationItemSelectedListener(this);
        drawerLayout = (DrawerLayout) findViewById(R.id.mydrawer);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.drawer_open, R.string.drawer_close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        actionBarDrawerToggle.onConfigurationChanged(newConfig);
    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Intent intent = null;


        return false;
    }
}
