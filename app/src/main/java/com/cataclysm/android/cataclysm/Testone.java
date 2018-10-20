package com.cataclysm.android.cataclysm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.TwitterCore;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.models.User;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.StringWriter;




public class Testone extends AppCompatActivity {
String profileImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testone);



       TextView textView = (TextView) findViewById(R.id.testone);
//        String username=getIntent().getStringExtra("username");
//        TwitterCore.getInstance().getApiClient().getAccountService().verifyCredentials(true, true, false).enqueue(new Callback<User>() {
//            @Override
//            public void success(Result<User> result) {
//                User user = result.data;
//                profileImage = user.name;
//            }
//
//            @Override
//            public void failure(TwitterException exception) {
//
//            }
//        });


    }
    public void LogoutFromTwitter(View view) {
        TwitterCore.getInstance().getSessionManager().clearActiveSession();
        Intent intent = new Intent(Testone.this, LoginActivity.class);
        startActivity(intent);
    }
}
