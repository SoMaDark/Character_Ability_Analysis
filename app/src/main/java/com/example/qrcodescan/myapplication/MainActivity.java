package com.example.qrcodescan.myapplication;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
private EditText edlv;
private Spinner sp_career;
private TextView tv_str,tv_int,tv_vit,tv_dex,tv_agi;
private String[] career = {"主角","劍士","法師","射手","祭司"};
private Button sminus_btn,iminus_btn,vminus_btn,dminus_btn,aminus_btn,lminus_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("請選擇角色");


        //======================================================================================背景動畫======================================================================================
        ImageView img = (ImageView)findViewById(R.id.swing_play);
        img.setBackgroundResource(R.drawable.background_gif);
        AnimationDrawable progressAnimation = (AnimationDrawable) img.getBackground();
        progressAnimation.start();

        //======================================================================================抓取物件======================================================================================
        edlv = findViewById(R.id.edlv);
        sp_career = findViewById(R.id.sp_career);
        tv_str = findViewById(R.id.tv_str);
        tv_int = findViewById(R.id.tv_int);
        tv_vit = findViewById(R.id.tv_vit);
        tv_dex = findViewById(R.id.tv_dex);
        tv_agi = findViewById(R.id.tv_agi);
        sminus_btn = findViewById(R.id.sminus_btn);
        iminus_btn = findViewById(R.id.iminus_btn);
        vminus_btn = findViewById(R.id.vminus_btn);
        dminus_btn = findViewById(R.id.dminus_btn);
        aminus_btn = findViewById(R.id.aminus_btn);
        lminus_btn = findViewById(R.id.lminus_btn);

        //================================================================================添加Spinner功能及物件================================================================================
        ArrayAdapter<String> careersp = new ArrayAdapter<String>(this, R.layout.spinner_item_textsize, career);
        sp_career.setAdapter(careersp);
        sp_career.setOnItemSelectedListener(spncareerchoose);

        //===============================================================================隱藏富有-屬性能力項按鈕================================================================================
        lminus_btn.setVisibility(View.INVISIBLE);
        sminus_btn.setVisibility(View.INVISIBLE);
        iminus_btn.setVisibility(View.INVISIBLE);
        vminus_btn.setVisibility(View.INVISIBLE);
        dminus_btn.setVisibility(View.INVISIBLE);
        aminus_btn.setVisibility(View.INVISIBLE);

        //======================================================================================等級限制======================================================================================
        if(Integer.valueOf(edlv.getText().toString())>500){
            edlv.setText("500");
        }
        else{
            if(Integer.valueOf(edlv.getText().toString())<1){
                edlv.setText("1");
            }
        }
    }



    //========================================================================================Spinner功能========================================================================================
    private Spinner.OnItemSelectedListener spncareerchoose = new Spinner.OnItemSelectedListener() {
                @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
                public void onItemSelected(AdapterView parent, View v, int position, long id) {
                    //每次選擇職業時，隱藏富有-屬性能力項按鈕
                    lminus_btn.setVisibility(View.INVISIBLE);
                    sminus_btn.setVisibility(View.INVISIBLE);
                    iminus_btn.setVisibility(View.INVISIBLE);
                    vminus_btn.setVisibility(View.INVISIBLE);
                    dminus_btn.setVisibility(View.INVISIBLE);
                    aminus_btn.setVisibility(View.INVISIBLE);
                    edlv.setText("1");

                    //預設所有職業角色的基本能力數值
                    switch (sp_career.getSelectedItem().toString()) {
                        case "主角":
                            tv_str.setText("1");
                            tv_int.setText("1");
                            tv_vit.setText("1");
                            tv_dex.setText("1");
                            tv_agi.setText("1");
                            break;
                        case "劍士":
                            tv_str.setText("15");
                            tv_int.setText("5");
                            tv_vit.setText("20");
                            tv_dex.setText("10");
                            tv_agi.setText("10");
                            break;
                        case "法師":
                            tv_str.setText("5");
                            tv_int.setText("20");
                            tv_vit.setText("10");
                            tv_dex.setText("15");
                            tv_agi.setText("10");
                            break;
                        case "射手":
                            tv_str.setText("15");
                            tv_int.setText("5");
                            tv_vit.setText("5");
                            tv_dex.setText("20");
                            tv_agi.setText("15");
                            break;
                        case "祭司":
                            tv_str.setText("10");
                            tv_int.setText("15");
                            tv_vit.setText("10");
                            tv_dex.setText("15");
                            tv_agi.setText("10");
                    }
                }
                public void onNothingSelected(AdapterView parent) {
                }
            };



    //==========================================================================================等級相關==========================================================================================

    //等級提升
    public void lvplus(View v){
        lminus_btn.setVisibility(View.VISIBLE);
        Integer lv = Integer.valueOf(edlv.getText().toString())+1;
        if(lv>500){
            lv = 500;
        }
        edlv.setText(lv.toString());
    }

    //等級下降
    public void lvminus(View v){
        Integer lv = Integer.valueOf(edlv.getText().toString())-1;
        if(lv<=1){
            lv = 1;
            lminus_btn.setVisibility(View.INVISIBLE);
        }
        edlv.setText(lv.toString());
    }



    //=======================================================================================屬性能力項上升=======================================================================================

    //STR
    public void splus(View v){
        sminus_btn.setVisibility(View.VISIBLE);
        Integer STR = Integer.valueOf(tv_str.getText().toString())+1;
        if(STR > 255){
            STR = 255;
            Toast.makeText(this,"STR已達上限值255",Toast.LENGTH_SHORT).show();
        }
        tv_str.setText(STR.toString());
    }

    //INT
    public void iplus(View v){
        iminus_btn.setVisibility(View.VISIBLE);
        Integer INT = Integer.valueOf(tv_int.getText().toString())+1;
        if(INT > 255){
            INT = 255;
            Toast.makeText(this,"INT已達上限值255",Toast.LENGTH_SHORT).show();
        }
        tv_int.setText(INT.toString());
    }

    //VIT
    public void vplus(View v){
        vminus_btn.setVisibility(View.VISIBLE);
        Integer VIT = Integer.valueOf(tv_vit.getText().toString())+1;
        if(VIT > 255){
            VIT = 255;
            Toast.makeText(this,"VIT已達上限值255",Toast.LENGTH_SHORT).show();
        }
        tv_vit.setText(VIT.toString());
    }

    //DEX
    public void dplus(View v){
        dminus_btn.setVisibility(View.VISIBLE);
        Integer DEX = Integer.valueOf(tv_dex.getText().toString())+1;
        if(DEX > 255){
            DEX = 255;
            Toast.makeText(this,"DEX已達上限值255",Toast.LENGTH_SHORT).show();
        }
        tv_dex.setText(DEX.toString());
    }

    //AGI
    public void aplus(View v){
        aminus_btn.setVisibility(View.VISIBLE);
        Integer AGI = Integer.valueOf(tv_agi.getText().toString())+1;
        if(AGI > 255){
            AGI = 255;
            Toast.makeText(this,"AGI已達上限值255",Toast.LENGTH_SHORT).show();
        }
        tv_agi.setText(AGI.toString());
    }



    //=======================================================================================屬性能力項下降=======================================================================================

    //STR
    public void sminus(View v){
        Integer STR = Integer.valueOf(tv_str.getText().toString())-1;
        if(sp_career.getSelectedItem().toString() == "主角" && STR<=1){
            STR = 1;
            Toast.makeText(this,"主角的STR基本能力值下限為1",Toast.LENGTH_SHORT).show();
            sminus_btn.setVisibility(View.INVISIBLE);
        }
        if(sp_career.getSelectedItem().toString() == "劍士" && STR<=15){
            STR = 15;
            Toast.makeText(this,"劍士的STR基本能力值下限為15",Toast.LENGTH_SHORT).show();
            sminus_btn.setVisibility(View.INVISIBLE);
        }
        if(sp_career.getSelectedItem().toString() == "法師" && STR<=5){
            STR = 5;
            Toast.makeText(this,"法師的STR基本能力值下限為5",Toast.LENGTH_SHORT).show();
            sminus_btn.setVisibility(View.INVISIBLE);
        }
        if(sp_career.getSelectedItem().toString() == "射手" && STR<=15){
            STR = 15;
            Toast.makeText(this,"射手的STR基本能力值下限為15",Toast.LENGTH_SHORT).show();
            sminus_btn.setVisibility(View.INVISIBLE);
        }
        if(sp_career.getSelectedItem().toString() == "祭司" && STR<=10){
            STR = 10;
            Toast.makeText(this,"祭司的STR基本能力值下限為10",Toast.LENGTH_SHORT).show();
            sminus_btn.setVisibility(View.INVISIBLE);
        }
            tv_str.setText(STR.toString());
    }

    //INT
    public void iminus(View v){
        Integer INT = Integer.valueOf(tv_int.getText().toString())-1;
        if(sp_career.getSelectedItem().toString() == "主角" && INT<=1){
            INT = 1;
            Toast.makeText(this,"主角的INT基本能力值下限為1",Toast.LENGTH_SHORT).show();
            iminus_btn.setVisibility(View.INVISIBLE);
        }
        if(sp_career.getSelectedItem().toString() == "劍士" && INT<=5){
            INT = 5;
            Toast.makeText(this,"劍士的INT基本能力值下限為5",Toast.LENGTH_SHORT).show();
            iminus_btn.setVisibility(View.INVISIBLE);
        }
        if(sp_career.getSelectedItem().toString() == "法師" && INT<=20){
            INT = 20;
            Toast.makeText(this,"法師的INT基本能力值下限為20",Toast.LENGTH_SHORT).show();
            iminus_btn.setVisibility(View.INVISIBLE);
        }
        if(sp_career.getSelectedItem().toString() == "射手" && INT<=5){
            INT = 5;
            Toast.makeText(this,"射手的INT基本能力值下限為5",Toast.LENGTH_SHORT).show();
            iminus_btn.setVisibility(View.INVISIBLE);
        }
        if(sp_career.getSelectedItem().toString() == "祭司" && INT<=15){
            INT = 15;
            Toast.makeText(this,"祭司的INT基本能力值下限為15",Toast.LENGTH_SHORT).show();
            iminus_btn.setVisibility(View.INVISIBLE);
        }
        tv_int.setText(INT.toString());
    }

    //VIT
    public void vminus(View v){
        Integer VIT = Integer.valueOf(tv_vit.getText().toString())-1;
        if(sp_career.getSelectedItem().toString() == "主角" && VIT<=1){
            VIT = 1;
            Toast.makeText(this,"主角的VIT基本能力值下限為1",Toast.LENGTH_SHORT).show();
            vminus_btn.setVisibility(View.INVISIBLE);
        }
        if(sp_career.getSelectedItem().toString() == "劍士" && VIT<=20){
            VIT = 20;
            Toast.makeText(this,"劍士的VIT基本能力值下限為20",Toast.LENGTH_SHORT).show();
            vminus_btn.setVisibility(View.INVISIBLE);
        }
        if(sp_career.getSelectedItem().toString() == "法師" && VIT<=10){
            VIT = 10;
            Toast.makeText(this,"法師的VIT基本能力值下限為10",Toast.LENGTH_SHORT).show();
            vminus_btn.setVisibility(View.INVISIBLE);
        }
        if(sp_career.getSelectedItem().toString() == "射手" && VIT<=5){
            VIT = 5;
            Toast.makeText(this,"射手的VIT基本能力值下限為5",Toast.LENGTH_SHORT).show();
            vminus_btn.setVisibility(View.INVISIBLE);
        }
        if(sp_career.getSelectedItem().toString() == "祭司" && VIT<=10){
            VIT = 10;
            Toast.makeText(this,"祭司的VIT基本能力值下限為10",Toast.LENGTH_SHORT).show();
            vminus_btn.setVisibility(View.INVISIBLE);
        }
        tv_vit.setText(VIT.toString());
    }

    //DEX
    public void dminus(View v){
        Integer DEX = Integer.valueOf(tv_dex.getText().toString())-1;
        if(sp_career.getSelectedItem().toString() == "主角" && DEX<=1){
            DEX = 1;
            Toast.makeText(this,"主角的DEX基本能力值下限為1",Toast.LENGTH_SHORT).show();
            dminus_btn.setVisibility(View.INVISIBLE);
        }
        if(sp_career.getSelectedItem().toString() == "劍士" && DEX<=10){
            DEX = 10;
            Toast.makeText(this,"劍士的DEX基本能力值下限為10",Toast.LENGTH_SHORT).show();
            dminus_btn.setVisibility(View.INVISIBLE);
        }
        if(sp_career.getSelectedItem().toString() == "法師" && DEX<=15){
            DEX = 15;
            Toast.makeText(this,"法師的DEX基本能力值下限為15",Toast.LENGTH_SHORT).show();
            dminus_btn.setVisibility(View.INVISIBLE);
        }
        if(sp_career.getSelectedItem().toString() == "射手" && DEX<=20){
            DEX = 20;
            Toast.makeText(this,"射手的DEX基本能力值下限為20",Toast.LENGTH_SHORT).show();
            dminus_btn.setVisibility(View.INVISIBLE);
        }
        if(sp_career.getSelectedItem().toString() == "祭司" && DEX<=15){
            DEX = 15;
            Toast.makeText(this,"祭司的DEX基本能力值下限為15",Toast.LENGTH_SHORT).show();
            dminus_btn.setVisibility(View.INVISIBLE);
        }
        tv_dex.setText(DEX.toString());
    }

    //AGI
    public void aminus(View v){
        Integer AGI = Integer.valueOf(tv_agi.getText().toString())-1;
        if(sp_career.getSelectedItem().toString() == "主角" && AGI<=1){
            AGI = 1;
            Toast.makeText(this,"主角的AGI基本能力值下限為1",Toast.LENGTH_SHORT).show();
            aminus_btn.setVisibility(View.INVISIBLE);
        }
        if(sp_career.getSelectedItem().toString() == "劍士" && AGI<=10){
            AGI = 10;
            Toast.makeText(this,"劍士的AGI基本能力值下限為10",Toast.LENGTH_SHORT).show();
            aminus_btn.setVisibility(View.INVISIBLE);
        }
        if(sp_career.getSelectedItem().toString() == "法師" && AGI<=10){
            AGI = 10;
            Toast.makeText(this,"法師的AGI基本能力值下限為10",Toast.LENGTH_SHORT).show();
            aminus_btn.setVisibility(View.INVISIBLE);
        }
        if(sp_career.getSelectedItem().toString() == "射手" && AGI<=15){
            AGI = 15;
            Toast.makeText(this,"射手的AGI基本能力值下限為15",Toast.LENGTH_SHORT).show();
            aminus_btn.setVisibility(View.INVISIBLE);
        }
        if(sp_career.getSelectedItem().toString() == "祭司" && AGI<=10){
            AGI = 10;
            Toast.makeText(this,"祭司的AGI基本能力值下限為10",Toast.LENGTH_SHORT).show();
            aminus_btn.setVisibility(View.INVISIBLE);
        }
        tv_agi.setText(AGI.toString());
    }



    //==========================================================================================切換頁面==========================================================================================

    //計算結果頁面
    public void result(View v){
        String e = edlv.getText().toString().trim();
        if (e.isEmpty()) {
            //若等級欄為空時，則不會跳到計算結果頁面
            Toast.makeText(this, "請輸入等級", Toast.LENGTH_SHORT).show();
        } else {
            if (Integer.valueOf(e) > 500 || Integer.valueOf(e) < 1) {
                //設定等級上限為500，下限為1
                Toast.makeText(this, "等級上限值為500，下限值為1", Toast.LENGTH_SHORT).show();
            } else {
                if(Integer.valueOf(tv_str.getText().toString())>255||Integer.valueOf(tv_int.getText().toString())>255||Integer.valueOf(tv_vit.getText().toString())>255||Integer.valueOf(tv_dex.getText().toString())>255||Integer.valueOf(tv_agi.getText().toString())>255){
                    //所有能力項上限設定為255
                    Toast.makeText(this,"所有能力屬性上限為255",Toast.LENGTH_SHORT).show();
                }
                else{
                    //傳至結果頁面
                    Intent intent = new Intent();
                    intent.setClass(MainActivity.this, Result.class);
                    String care = sp_career.getSelectedItem().toString();

                    Integer lv = Integer.parseInt(edlv.getText().toString());
                    Integer STR = Integer.parseInt(tv_str.getText().toString());
                    Integer INT = Integer.parseInt(tv_int.getText().toString());
                    Integer VIT = Integer.parseInt(tv_vit.getText().toString());
                    Integer DEX = Integer.parseInt(tv_dex.getText().toString());
                    Integer AGI = Integer.parseInt(tv_agi.getText().toString());

                    Integer hp = 0;
                    Integer mp = 0;
                    Integer atk = 0;
                    Integer matk = 0;
                    Integer def = 0;
                    Integer mdef = 0;
                    Integer aspd = 0;
                    Integer sspd = 0;
                    Integer dis = 0;
                    String name = "";

                    Bundle bundle = new Bundle();
                    bundle.putString("CAREER", care);
                    bundle.putInt("LV", lv);
                    if (sp_career.getSelectedItem().toString() == "劍士") {
                        hp = Integer.valueOf(lv + VIT * 3 + STR / 2);
                        mp = Integer.valueOf(lv + INT * 2 + DEX / 2);
                        atk = lv + STR + DEX;
                        matk = lv + INT * 4 + DEX * 1;
                        def = lv + VIT * 2 + STR;
                        mdef = lv + VIT + INT;
                        aspd = lv + AGI * 4;
                        sspd = lv + DEX;
                        dis =  Integer.valueOf(lv + DEX/2);
                        name = "史瓦德·瓦利歐爾";
                    } else {
                        if (sp_career.getSelectedItem().toString() == "法師") {
                            hp = Integer.valueOf(lv + VIT * 2);
                            mp = lv + INT * 2 + DEX;
                            atk = lv + STR * 3 + DEX * 1;
                            matk = lv + INT * 4 + DEX * 1;
                            def = lv + VIT;
                            mdef = lv + INT;
                            aspd = lv + AGI;
                            sspd = lv + DEX * 4;
                            dis =  Integer.valueOf(lv + DEX);
                            name = "麻和子·薇札爾德";
                        } else {
                            if (sp_career.getSelectedItem().toString() == "射手") {
                                hp = Integer.valueOf(lv + VIT * 2);
                                mp = lv + INT + DEX;
                                atk = lv + STR * 1 + DEX * 4;
                                matk = lv + INT * 2 + DEX * 1;
                                def = lv + VIT;
                                mdef = lv + INT;
                                aspd = lv + AGI * 4;
                                sspd = lv + DEX;
                                dis =  Integer.valueOf(lv + DEX*2);
                                name = "柏杰恩·艾爾奇爾";
                            }
                            else{
                                if (sp_career.getSelectedItem().toString() == "祭司") {
                                    hp = Integer.valueOf(lv + VIT * 3);
                                    mp = lv + INT * 2 + DEX * 2;
                                    atk = lv + STR * 2 + DEX * 1;
                                    matk = lv + INT * 3 + DEX * 1;
                                    def = lv + VIT;
                                    mdef = lv + VIT + INT;
                                    aspd = lv + AGI;
                                    sspd = lv + DEX;
                                    dis =  Integer.valueOf(lv + DEX * 2 / 3);
                                    name = "拿克絲·普萊斯特";
                                }
                                else{
                                    if (sp_career.getSelectedItem().toString() == "主角") {
                                        hp = lv + VIT;
                                        mp = lv + INT * 2;
                                        atk = lv + STR;
                                        matk = lv + INT;
                                        def = lv + VIT + STR;
                                        mdef = lv + VIT + INT;
                                        aspd = lv + AGI;
                                        sspd = lv + DEX;
                                        dis =  lv + DEX;
                                        name = "？？？";
                                    }
                                }
                            }
                        }
                    }
                    bundle.putString("NAME", name);
                    bundle.putString("CAREER", sp_career.getSelectedItem().toString());
                    bundle.putInt("HP", hp);
                    bundle.putInt("MP", mp);
                    bundle.putInt("ATK", atk);
                    bundle.putInt("MATK", matk);
                    bundle.putInt("DEF", def);
                    bundle.putInt("MDEF", mdef);
                    bundle.putInt("ASPD", aspd);
                    bundle.putInt("SSPD", sspd);
                    bundle.putInt("DIS",dis);
                    intent.putExtras(bundle);
                    startActivityForResult(intent, 999);
                }
            }
        }
    }

    //技能介紹頁面
    public void skills(View v){
        Intent intent = new Intent();
        intent.setClass(MainActivity.this, Skills.class);
        Bundle bundle = new Bundle();
        String name = "";
        String t_su = "";
        String p_s = "";
        String skill_1 = "";
        String skill_2 = "";
        String buff = "";
        switch (sp_career.getSelectedItem().toString()) {
            case "主角":
                p_s = "首領光環：\n被動技能，提升所有伙伴們各個能力屬性項。";
                name = "？？？";
                break;
            case "劍士":
                p_s = "劍術精通：\n被動技能，相關於提升攻擊力、防禦力、反彈傷害、生命回復量及速度。";
                skill_1 = "劍術技能：\n主動技能，包含一刀流劍術及二刀流劍術相關技能。";
                skill_2 = "騎士技能：\n輔助技能，相關於挑興、上升對自己的仇恨值等技能。";
                buff = "狂劍士：\n增益技能，微幅提升攻擊力、大幅提升雙防、攻擊速度、仇恨值、反彈傷害值。";
                t_su = "建議練法：\n提升STR可提升物理攻擊，提升VIT可提升戰鬥耐力，提升AGI可提升攻擊速度及提升裝備二刀流型態時的攻擊力，提升DEX可微幅提升物理攻擊。";
                name = "史瓦德·瓦利歐爾";
                break;
            case "法師":
                p_s = "魔法精通：\n被動技能，相關於提升魔法攻擊力、魔法詠唱速度、魔力回復量及速度。";
                skill_1 = "魔法技能：\n主動技能，相關炎、水、風、土等四大元素魔法。";
                skill_2 = "巫師技能：\n輔助技能，相關幻術魔法，使敵人暈眩、翻覆魔法等。";
                buff = "大魔導：\n增益技能，大幅提升魔法攻擊、魔法詠唱速度、魔力、回復類魔法技能效果提升。";
                t_su = "建議練法：\n提升INT可提升魔法攻擊及微服提升魔力，提升DEX可提升魔法詠唱速度、閃躲距離及微幅提升魔法攻擊。";
                name = "麻和子·薇札爾德";
                break;
            case "射手":
                p_s = "射箭精通：\n被動技能，相關於提升攻擊力、命中要害率、異常狀態抗性。";
                skill_1 = "射擊技能：\n主動技能，當武器裝備弓或槍械時，才能觸發此技能。";
                skill_2 = "獵人技能：\n輔助技能，相關下降仇恨值、擊退敵人、解除異常狀態技能，召喚森林動物等。";
                buff = "神射手：\n增益技能，大幅提升攻擊力、命中要害傷害值、閃躲距離、異常狀態無效、被召喚的森林動物屬性能力提升。";
                t_su = "建議練法：\n提升DEX可提升物理攻擊及閃躲距離，提升STR可微幅提升物理攻擊，提升AGI可提升攻擊速度。";
                name = "柏杰恩·艾爾奇爾";
                break;
            case "祭司":
                p_s = "聖光精通：\n被動技能，相關於提升魔法攻擊力、魔法防禦、魔力、回復體力及魔力魔法的效果、減少魔力消耗量、魔法冷卻時間。";
                skill_1 = "聖拳技能：\n主動技能，當武器裝備拳套時，可使用近距離肉搏戰技能，使用杖時，可使用光屬性魔法技能。";
                skill_2 = "主教技能：\n輔助技能，相關回復體力、回復魔力、提升能力屬性項等魔法技能。";
                buff = "聖法師：\n增益技能，提升魔力、魔法防禦、回復技能效果、大幅減少魔力消耗量、縮短冷卻時間。";
                t_su = "建議練法：\n提升INT可提升魔法攻擊、魔法防禦及魔力，提升VIT可提升戰鬥耐力及微服提升魔法防禦，提升DEX可提升閃躲距離。";
                name = "拿克絲·普萊斯特";
                break;
        }
        bundle.putString("NAME",name);
        bundle.putString("CAREER", sp_career.getSelectedItem().toString());
        bundle.putString("SUGGEST", t_su);
        bundle.putString("PK", p_s);
        bundle.putString("SK1", skill_1);
        bundle.putString("SK2", skill_2);
        bundle.putString("BUFF", buff);
        intent.putExtras(bundle);
        startActivityForResult(intent, 999);
    }

    //角色簡介頁面
    public void introduction(View v){
        Intent intent = new Intent();
        intent.setClass(MainActivity.this, Introduction.class);
        Bundle bundle = new Bundle();
        String name = "";
        String sex = "";
        String height = "";
        String birthday = "";
        String color = "";
        String animal = "";
        String introduction = "";
        String nickname = "";
        String nickname2 = "";
        switch (sp_career.getSelectedItem().toString()) {
            case "主角":
                name = "？？？";
                sex = "？";
                height = "168cm";
                birthday = "??月??日";
                color = "？色";
                animal = "？";
                introduction = "團體中的首領，曾是天庭的其中一位神之子，為了不被自己要討伐的對象-戴維爾發現，部分的神之力被神官們封印起來，使其變得與凡人沒什麼兩樣。一路上找尋四位志同道合且可靠的伙伴們一起旅行，伙伴們各自有自己的夢想，因此期望在自己達成任務前，讓同行的伙伴們各自達成他們的夢想，反之不需要任何權威或命令，當主角遇難時，伙伴們也會伸出援手保護他，幫助他。";
                nickname = "首領";
                nickname2 = "？？？";
                break;
            case "劍士":
                name = "史瓦德·瓦利歐爾";
                sex = "男";
                height = "177.1cm";
                birthday = "08月18日";
                color = "紅色";
                animal = "虎";
                introduction = "主角的第一位伙伴，在隊伍之中扮演副隊長一職，在戰場上為了保護伙伴們的性命安危而身先士卒，個性熱情、單純、善良、開朗大方、幽默風趣、刻苦耐勞、勇敢、信念堅定，在主角離開後接任隊長一職，繼續帶領著伙伴們旅行。";
                nickname = "副首領";
                nickname2 = "泰格爾";
                break;
            case "法師":
                name = "麻和子·薇札爾德";
                sex = "女";
                height = "157.8cm";
                birthday = "02月23日";
                color = "藍色";
                animal = "鹿";
                introduction = "主角的第二位伙伴，無論是在戰術方面、邏輯思考方面，甚至是日常生活所需都能一手包辦，因此在隊伍之中擔任參謀長一職，十分了解伙伴們的個性和戰鬥特性，個性溫柔、善良、謙虛、穩重、伶俐謹慎、腦袋十分聰明、認真，在主角離開後接任副隊長一職，維繫著伙伴們的關係。";
                nickname = "參謀長";
                nickname2 = "席卡";
                break;
            case "射手":
                name = "柏杰恩·艾爾奇爾";
                sex = "男";
                height = "178.3cm";
                birthday = "10月10日";
                color = "綠色";
                animal = "鷹";
                introduction = "主角的第三位伙伴，擁有一雙十分銳利的眼睛，在隊伍中擔任探長一職，另外擁有與森林動物溝通與生俱來的能力，能夠召喚森林動物協助自己戰鬥，也能託付牠們擔任間諜搜取敵人的資料，亦有探報員一職，在戰場上擔任後援一職，負責解決敵人後續的援助，個性極為冷靜、守時、任何事都算計的十分精準、身手伶俐、嚴守紀律。";
                nickname = "探報長";
                nickname2 = "艾德拉";
                break;
            case "祭司":
                name = "拿克絲·普萊斯特";
                sex = "女";
                height = "164.3cm";
                birthday = "12月25日";
                color = "黃色";
                animal = "兔";
                introduction = "主角的最後一位伙伴，因身為一位祭司，而擔任隊伍的醫護師，個性熱心、善良、活潑開朗，有著無法對受傷的伙伴或較弱勢的人放任不管的個性、很會照顧別人，擁有母性寬厚大方的個性。";
                nickname = "醫護長";
                nickname2 = "邦妮";
                break;

        }
        bundle.putString("NICKNAME2",nickname2);
        bundle.putString("NICKNAME",nickname);
        bundle.putString("CAREER", sp_career.getSelectedItem().toString());
        bundle.putString("NAME", name);
        bundle.putString("SEX", sex);
        bundle.putString("HEIGHT", height);
        bundle.putString("BIRTHDAY", birthday);
        bundle.putString("COLOR", color);
        bundle.putString("ANIMAL", animal);
        bundle.putString("INTRODUCTION", introduction);
        intent.putExtras(bundle);
        startActivityForResult(intent, 999);
    }

}


