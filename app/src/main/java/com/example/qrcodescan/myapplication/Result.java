package com.example.qrcodescan.myapplication;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

public class Result extends AppCompatActivity {
private TextView tv_name,tv_lv,tv_hp,tv_mp,tv_atk,tv_aspd,tv_matk,tv_sspd,tv_def,tv_mdef,tv_dis;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        //======================================================================================背景動畫======================================================================================
        ImageView img = (ImageView)findViewById(R.id.swing_play);
        img.setBackgroundResource(R.drawable.background_gif);
        AnimationDrawable progressAnimation = (AnimationDrawable) img.getBackground();
        progressAnimation.start();

        //===================================================================================左上角的小箭頭===================================================================================
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //======================================================================================抓取物件======================================================================================
        tv_name = findViewById(R.id.tv_name);
        tv_lv = findViewById(R.id.tv_lv);
        tv_hp = findViewById(R.id.tv_hp);
        tv_mp = findViewById(R.id.tv_mp);
        tv_atk = findViewById(R.id.tv_atk);
        tv_matk = findViewById(R.id.tv_matk);
        tv_def = findViewById(R.id.tv_def);
        tv_mdef = findViewById(R.id.tv_mdef);
        tv_aspd = findViewById(R.id.tv_aspd);
        tv_sspd = findViewById(R.id.tv_sspd);
        tv_dis = findViewById(R.id.tv_dis);

        //=================================================================================抓取來自首頁的資料=================================================================================
        Intent intent = this.getIntent();
        Bundle bundle = intent.getExtras();
        String name = bundle.getString("NAME");
        String career = bundle.getString("CAREER");
        Integer lv = bundle.getInt("LV");
        Integer hp = bundle.getInt("HP");
        Integer mp = bundle.getInt("MP");
        Integer atk = bundle.getInt("ATK");
        Integer matk = bundle.getInt("MATK");
        Integer def = bundle.getInt("DEF");
        Integer mdef = bundle.getInt("MDEF");
        Integer aspd = bundle.getInt("ASPD");
        Integer sspd = bundle.getInt("SSPD");
        Integer dis = bundle.getInt("DIS");

        //=================================================================================設定抓取資料的物件=================================================================================
        setTitle(career);
        tv_name.setText(name.toString());
        tv_lv.setText(lv.toString());
        tv_hp.setText(hp.toString());
        tv_mp.setText(mp.toString());
        tv_atk.setText(atk.toString());
        tv_matk.setText(matk.toString());
        tv_def.setText(def.toString());
        tv_mdef.setText(mdef.toString());
        tv_aspd.setText(aspd.toString());
        tv_sspd.setText(sspd.toString());
        tv_dis.setText(dis.toString());

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
