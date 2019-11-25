package com.kaream.ehap.quranapp;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ProgressBar;
import android.widget.TextView;

public class SplachActivity extends AppCompatActivity {

    TextView textView ;
    private ProgressBar progressBar ;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splach);
        progressBar = findViewById(R.id.progressBar);
        textView = findViewById(R.id.txt_splachName);
        Typeface typeface = Typeface.createFromAsset(getAssets(),"Fonts/Droid_Sans_Arabic.ttf");
        textView.setTypeface(typeface);
        textView.setText(R.string.app_name);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
                finish();
            }
        },3000);
    }


}
