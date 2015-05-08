package com.example.main;

import java.util.Calendar;


import com.example.db.CourseInfoDB;
import com.example.dialog.ConfirmDialog;
import com.example.dialog.OneWheel;
import com.example.schedule.R;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class SettingActivity extends Activity {

	ImageView imageView;
	TextView title;
	RelativeLayout settingWeek;
	RelativeLayout settingmaxcount,settingmycount,logoutacount;
	RelativeLayout currentTerm;
	TextView curTerm;
	TextView maxNum;
	TextView curWeek;
    TextView account_status;
    TextView user_organization;


    //双击返回键退出
    private long exitTime=0;
    @Override
    public void onBackPressed() {
        if((System.currentTimeMillis()-exitTime)>2000){
            Toast.makeText(this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
            exitTime=System.currentTimeMillis();
        }else{
            super.onBackPressed();
            SettingActivity.this.finish();
            System.exit(0);
        }

    }


    @Override
    protected void onResume() {
        super.onResume();

        refresh();
    }

    @Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_settings);
		title = (TextView) findViewById(R.id.title_txv_title);
		title.setText("课程设置");
		imageView = (ImageView) findViewById(R.id.title_imgv_left_icon);
		currentTerm = (RelativeLayout) findViewById(R.id.setting_rlyt_switch_semester);
		settingWeek = (RelativeLayout) findViewById(R.id.setting_rlyt_cur_week);
		settingmaxcount = (RelativeLayout) findViewById(R.id.setting_rlyt_maxcount);
        settingmycount=(RelativeLayout)findViewById(R.id.setting_item_rlyt_super_account);
        user_organization=(TextView)findViewById(R.id.setting_organization);


        logoutacount=(RelativeLayout)findViewById(R.id.setting_rlyt_logout);
		curWeek=(TextView)findViewById(R.id.setting_txv_cur_week);
		maxNum=(TextView)findViewById(R.id.setting_txv_maxcount);
		curTerm=(TextView)findViewById(R.id.setting_txv_switch_semester);
        imageView.setVisibility(View.INVISIBLE);
        account_status=(TextView)findViewById(R.id.setting_txv_account_status);



        final SharedPreferences courseSettings = getSharedPreferences(
                "course_setting", Activity.MODE_PRIVATE);
		
		//设置账号登陆

        String currentCount=courseSettings.getString("acountStatus","false");


		// 获取当前学期
		String currentTerms = courseSettings.getString("currentTerm",null);
		// 获取周数
		String currentWeek=courseSettings.getString("currentWeek", null);

		// 获取最大节数
		//String maxCourseNum = courseSettings.getString("maxCourseNum",null);

        //获取用户名
		String username=courseSettings.getString("name","请登录");

        //获取用户所在单位
        String organization=courseSettings.getString("organization",null);
        user_organization.setText(organization);

		if(currentTerms!=null){
			curTerm.setText(currentTerms);
		}
		
		if(currentWeek!=null){
			curWeek.setText(currentWeek);
		}
		/*if(maxCourseNum!=null){
			maxNum.setText(maxCourseNum);
		}*/


        if(courseSettings.getString("acountStatus", "false").equals("true")){
            account_status.setText(username);
            logoutacount.setVisibility(View.VISIBLE);
        }else if(courseSettings.getString("acountStatus", "false").equals("false")){
            account_status.setText("请登陆");
            logoutacount.setVisibility(View.INVISIBLE);
        }




        //监听我的账号
        settingmycount.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {


                if(courseSettings.getString("acountStatus", "false").equals("true")){
                    final ConfirmDialog dlg=new ConfirmDialog(SettingActivity.this,R.style.MyDialog,"已有账号登陆，确认要切换账号吗？");
                    dlg.show();
                    dlg.setNegativeButton("取消", new OnClickListener() {

                        @Override
                        public void onClick(View v) {
                            // TODO Auto-generated method stub
                            dlg.cancel();
                        }
                    });
                    dlg.setPositiveButton("确定", new OnClickListener() {

                        @Override
                        public void onClick(View v) {
                            // TODO Auto-generated method stub

                            Intent intent = new Intent();
                            intent.setClass(SettingActivity.this,User_login.class);
                            startActivity(intent);
                            dlg.dismiss();
                        }
                    });
                }else{
                    Intent intent = new Intent();
                    intent.setClass(SettingActivity.this,User_login.class);
                    startActivity(intent);
                }


            }
        });
		
		// 设置当前学期
		currentTerm.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String terms[] = null;
				int year = Calendar.getInstance().get(Calendar.YEAR);
				// 当前学期的索引
				int currentIndex = 0;
				if (terms == null) {
					terms = new String[16];
					for (int i = 0; i < 8; i++) {
						terms[i * 2] = String.valueOf(year + i - 4) + "-"
								+ String.valueOf(year + i - 3) + "-1";
						terms[i * 2 + 1] = String.valueOf(year + i - 4) + "-"
								+ String.valueOf(year + i - 3) + "-2";
					}
				}
				final OneWheel wheel = new OneWheel(SettingActivity.this,
						R.style.MyDialog, terms, currentIndex);

				wheel.show();
				wheel.setTitle("请选择当前学期");
				final String array[]=terms;
				// 设计监听器
				wheel.setPositiveButton("确定", new OnClickListener() {

					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						Editor editor=courseSettings.edit();
						editor.putString("currentTerm",array[wheel.getItemID(0)]);
						editor.commit();
						curTerm.setText(array[wheel.getItemID(0)]);
						wheel.dismiss();
					}
				});
			}
		});

		// 设置当前周数

		settingWeek.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				int currentIndex = 0;
				String[] terms = new String[25];
				for (int i = 0; i < 25; i++) {
					terms[i] = i + 1 + "";
				}
				final OneWheel wheel = new OneWheel(SettingActivity.this,
						R.style.MyDialog, terms, currentIndex);
				wheel.show();
				wheel.setTitle("请选择当前周数");
				final String array[]=terms;
				wheel.setPositiveButton("确定", new OnClickListener() {

					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						Editor editor=courseSettings.edit();
						editor.putString("currentWeek",array[wheel.getItemID(0)]);
						editor.commit();
						curWeek.setText(array[wheel.getItemID(0)]);
						wheel.dismiss();
					}
				});

			}
		});

		// 设置最大节数
		settingmaxcount.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				int currentIndex = 0;
				String[] terms = new String[10];
				for (int i = 0; i < 10; i++) {
					terms[i] = i + 5 + "";
				}
				final OneWheel wheel = new OneWheel(SettingActivity.this,
						R.style.MyDialog, terms, currentIndex);
				wheel.show();
				wheel.setTitle("请设置最大节数");
				final String array[]=terms;
				wheel.setPositiveButton("确定", new OnClickListener() {

					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						Editor editor=courseSettings.edit();
						editor.putString("maxCourseNum",array[wheel.getItemID(0)]);
						editor.commit();
						maxNum.setText(array[wheel.getItemID(0)]);
						wheel.dismiss();
					}
				});
			}
		});

        //注销账号
        logoutacount.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {

                final ConfirmDialog dlg=new ConfirmDialog(SettingActivity.this,R.style.MyDialog,"确认要注销账号吗");
                dlg.show();
                dlg.setNegativeButton("取消", new OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        // TODO Auto-generated method stub
                        dlg.cancel();
                    }
                });
                dlg.setPositiveButton("确定", new OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        // TODO Auto-generated method stub

                        SharedPreferences.Editor editor=courseSettings.edit();
                        editor.putString("acountStatus","false");
                        editor.putString("organization","");
                        editor.commit();
                        refresh();

                        CourseInfoDB courseDB=new CourseInfoDB(SettingActivity.this);
                        courseDB.deleteAll();
                        courseDB.close();
                        dlg.dismiss();
                    }
                });





            }
        });



		// 监听返回按钮
		imageView.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				// Intent intent = new Intent();
				// intent.setClass(SearchCourse.this, MainActivity.class);
				// startActivity(intent);
				SettingActivity.this.finish();

			}
		});
	}
    //刷新
    public void refresh(){
        onCreate(null);
    }
}
