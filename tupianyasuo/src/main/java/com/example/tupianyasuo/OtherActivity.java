package com.example.tupianyasuo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

public class OtherActivity extends AppCompatActivity {

    private JCVideoPlayerStandard  Showview;
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other);

        Showview= (JCVideoPlayerStandard) findViewById(R.id.showRadio);

        textView= (TextView) findViewById(R.id.tv_title);

        Intent intent = getIntent();
        String url = intent.getStringExtra("URL");
        System.out.println("uuuuuuuuuu"+url);
        String title = intent.getStringExtra("title");

        Showview.setUp(url, Showview.SCREEN_LAYOUT_NORMAL,title);
        textView.setText(title);


    }
}
