package com.example.main;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.CompoundButton;

import android.widget.RadioButton;
import android.app.Dialog;
import android.app.AlertDialog;
import android.widget.TabHost;

import android.widget.Toast;

import com.example.schedule.R;


/**
 * Created by dong on 2014/12/16.
 */
public class Main_tab extends TabActivity {

    private TabHost tabhost;
    private RadioButton tab_table,tab_message,tab_me;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acty_home);


        //获取按钮
        tab_table=(RadioButton)findViewById(R.id.rbtn_tab_course);
        tab_message=(RadioButton)findViewById(R.id.rbtn_tab_found);
        tab_me=(RadioButton)findViewById(R.id.rbtn_tab_settings);









        //往tabwidget中添加tab
        tabhost=getTabHost();
        tabhost.addTab(tabhost.newTabSpec("tag1").setIndicator("0").setContent(new Intent(this,Schedule_main.class)));
        tabhost.addTab(tabhost.newTabSpec("tag2").setIndicator("1").setContent(new Intent(this,SearchCourse.class)));
        tabhost.addTab(tabhost.newTabSpec("tag3").setIndicator("2").setContent(new Intent(this, SettingActivity.class)));

        tabhost.setCurrentTab(0);
        //设置监听事件

        //为每个radiobutton监听
        tab_table.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    tabhost.setCurrentTabByTag("tag1");
                    tab_message.setChecked(false);
                    tab_me.setChecked(false);
                }

            }
        });

        tab_message.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    tabhost.setCurrentTabByTag("tag2");
                    tab_table.setChecked(false);
                    tab_me.setChecked(false);
//                    Toast toast=Toast.makeText(Main_tab.this, "此功能正在开发当中。。。。",Toast.LENGTH_SHORT);
//                    toast.show();
                }

            }
        });
        tab_me.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if(compoundButton.isChecked()){
                    tabhost.setCurrentTabByTag("tag3");
                    tab_table.setChecked(false);
                    tab_message.setChecked(false);

                }



            }
        });






    }


}
