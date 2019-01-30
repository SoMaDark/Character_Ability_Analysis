package com.example.qrcodescan.myapplication;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

public class Skills extends AppCompatActivity {
private TextView tv_name3,tv_suggest,tv_passive,tv_active,tv_auxiliary,tv_buff;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skills);

        //======================================================================================背景動畫======================================================================================
        ImageView img = (ImageView)findViewById(R.id.swing_play);
        img.setBackgroundResource(R.drawable.background_gif);
        AnimationDrawable progressAnimation = (AnimationDrawable) img.getBackground();
        progressAnimation.start();

        //===================================================================================左上角的小箭頭===================================================================================
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //======================================================================================抓取物件======================================================================================
        tv_name3 = findViewById(R.id.tv_name3);
        tv_suggest = findViewById(R.id.tv_suggest);
        tv_passive = findViewById(R.id.tv_passive);
        tv_active = findViewById(R.id.tv_active);
        tv_auxiliary = findViewById(R.id.tv_auxiliary);
        tv_buff = findViewById(R.id.tv_buff);

        //=================================================================================抓取來自首頁的資料=================================================================================
        Intent intent = this.getIntent();
        Bundle bundle = intent.getExtras();
        String career = bundle.getString("CAREER");
        String name = bundle.getString("NAME");
        String suggest = bundle.getString("SUGGEST");
        String passive = bundle.getString("PK");
        String action = bundle.getString("SK1");
        String auxiliary = bundle.getString("SK2");
        String buff = bundle.getString("BUFF");

        //=================================================================================設定抓取資料的物件=================================================================================
        setTitle(career);
        tv_name3.setText(name.toString());
        tv_suggest.setText(suggest.toString());
        tv_passive.setText(passive.toString());
        tv_active.setText(action.toString());
        tv_auxiliary.setText(auxiliary.toString());
        tv_buff.setText(buff.toString());

    }

    public boolean onOptionsItemSelected(MenuItem item)
    {
        if(item.getItemId() == android.R.id.home)
        {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
