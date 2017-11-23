package com.example.yuekaozhongjitest.activity;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

import com.example.yuekaozhongjitest.R;

import java.net.URL;

public class Main2Activity extends AppCompatActivity {

    private VideoView view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        view = (VideoView) findViewById(R.id.biew);
        Intent intent = getIntent();
        String sss = intent.getStringExtra("sss");
        Uri uri=Uri.parse(sss);
        view.setMediaController(new MediaController(this));
        view.setVideoURI(uri);
        view.requestFocus();


    }
}
