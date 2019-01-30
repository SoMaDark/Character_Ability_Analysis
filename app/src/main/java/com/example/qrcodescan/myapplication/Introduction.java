package com.example.qrcodescan.myapplication;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

public class Introduction extends AppCompatActivity {
private TextView tv_name2,tv_nickname,tv_gender,tv_birthday,tv_height,tv_color,tv_animal,tv_introduction,nicknames;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introduction);

        //======================================================================================背景動畫======================================================================================
        ImageView img = (ImageView)findViewById(R.id.swing_play);
        img.setBackgroundResource(R.drawable.background_gif);
        AnimationDrawable progressAnimation = (AnimationDrawable) img.getBackground();
        progressAnimation.start();

        //===================================================================================左上角的小箭頭===================================================================================
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //======================================================================================抓取物件======================================================================================
        tv_name2 = findViewById(R.id.tv_name2);
        tv_nickname = findViewById(R.id.tv_nickname);
        tv_gender = findViewById(R.id.tv_gender);
        tv_birthday = findViewById(R.id.tv_birthday);
        tv_height = findViewById(R.id.tv_height);
        tv_color = findViewById(R.id.tv_color);
        tv_animal = findViewById(R.id.tv_animal);
        tv_introduction = findViewById(R.id.tv_introduction);
        nicknames = findViewById(R.id.nicknames);

        //=================================================================================抓取來自首頁的資料=================================================================================
        Intent intent = this.getIntent();
        Bundle bundle = intent.getExtras();
        String name = bundle.getString("NAME");
        String nickname = bundle.getString("NICKNAME");
        String career = bundle.getString("CAREER");
        String gender = bundle.getString("SEX");
        String height = bundle.getString("HEIGHT");
        String birthday = bundle.getString("BIRTHDAY");
        String color = bundle.getString("COLOR");
        String animal = bundle.getString("ANIMAL");
        String introduction = bundle.getString("INTRODUCTION");
        String nickname2 = bundle.getString("NICKNAME2");

        //=================================================================================設定抓取資料的物件=================================================================================
        setTitle(career);
        tv_name2.setText(name.toString());
        tv_nickname.setText(nickname.toString());
        tv_gender.setText(gender.toString());
        tv_birthday.setText(birthday.toString());
        tv_height.setText(height.toString());
        tv_color.setText(color.toString());
        tv_animal.setText(animal.toString());
        tv_introduction.setText(introduction.toString());
        nicknames.setText(nickname2.toString());
    }

    //回到首頁
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
