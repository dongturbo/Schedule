
package com.example.main;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

//import com.example.adatper.MessageAdapter;
import com.example.data.Message;
import com.example.schedule.R;

import java.util.ArrayList;
import java.util.List;

//import com.example.util.GetCourseInfo;

public class SearchCourse extends Activity {

    ListView listView;
    EditText editText;
    ImageView imageView;
    RelativeLayout titleRight;
    //TextView SearchCourse;
    //List<CourseInfo> courseInfos = new ArrayList<CourseInfo>();
    boolean clearCheck=true;
    List<Message> messages = new ArrayList<Message>();
    Message massage;
    TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_course);
        listView = (ListView) findViewById(R.id.course_Info);
        //editText = (EditText) findViewById(R.id.select_course_edtx_course_name);
        imageView = (ImageView) findViewById(R.id.title_imgv_left_icon);
        title = (TextView) findViewById(R.id.title_txv_title);
        title.setText("消息通知");
        imageView.setVisibility(View.INVISIBLE);
        Intent intent = getIntent();
        String temp = intent.getStringExtra("key");
//		if(temp==null){
//			titleRight = (RelativeLayout) findViewById(R.id.title_rlyt_right);
//			titleRight.setVisibility(View.VISIBLE);
//			SearchCourse = (TextView) findViewById(R.id.title_txv_right_text);
//			SearchCourse.setText("查询");
//
//			SearchCourse.setOnClickListener(new OnClickListener() {
//
//				@Override
//				public void onClick(View v) {
//					// TODO Auto-generated method stub
//
//					if (editText.getText().length() == 0) {
//						Toast toast = Toast.makeText(SearchCourse.this, "请输入搜索关键字",
//								Toast.LENGTH_SHORT);
//						toast.show();
//						return;
//					}
////					getInfo(editText.getText().toString(),null);
//
//				}
//			});
//		}else{
////			getInfo(temp,temp);
//
//			char a=temp.charAt(0);
//			String b=temp.subSequence(1,temp.length()).toString();
//			switch(a){
//			case'1':
//				temp="周一";
//				break;
//			case'2':
//				temp="周二";
//				break;
//			case'3':
//				temp="周三";
//				break;
//			case'4':
//				temp="周四";
//				break;
//			case'5':
//				temp="周五";
//				break;
//			case'6':
//				temp="周六";
//				break;
//			case'7':
//				temp="周日";
//				break;
//			}
//			temp=temp+"第"+b+"节";
//			editText.setText(temp);
//			editText.setFocusable(false);
//			editText.setClickable(false);
//			editText.setInputType(InputType.TYPE_NULL);
//		}


        // 监听返回按钮



        getMessage(clearCheck,SearchCourse.this);

        imageView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                //Intent intent = new Intent();
                //intent.setClass(SearchCourse.this, MainActivity.class);
                //startActivity(intent);
                SearchCourse.this.finish();

            }
        });





    }
    public void getMessage(boolean check,Context context){

        if(check){
            massage = new Message("欢迎", "欢迎您使用课程表应用，我们会竭诚为您服务！非常感谢");
            messages.add(massage);
        }
        //填充数据

        MessageAdapter adapter = new MessageAdapter(context, messages, R.layout.message_item,
                new int[]{R.id.message_title, R.id.message_content,R.id.message_item,R.id.clear_message});

        listView.setAdapter(adapter);
    }

//    public static void setClear(){
//        clearCheck=false;
//        messages.clear();
//    }

    //判断当前是否有WiFi连接


    // temp传输搜索的关键字
//	public void getInfo(String temp,String temp1) {
//
//		// 服务器地址
//		try {
//
//			if (CheckedWifi.CheckNetworkState(SearchCourse.this)) {
//				courseInfos = GetCourseInfo.getCourseInfo(new GetStream()
//						.getStream(temp,temp1));
//				ListViewAdapter adapter = new ListViewAdapter(
//						SearchCourse.this, courseInfos, R.layout.item_course,
//						new int[] { R.id.select_course_txv_course_name,
//								R.id.select_course_txv_teacherName,
//								R.id.select_course_txv_classroom,
//								R.id.select_course_txv_section,
//								R.id.select_course_txv_week,
//								R.id.select_course_btn_control });
//				listView.setAdapter(adapter);
//			} else {
//				Toast toast = Toast.makeText(SearchCourse.this, "当前无WIFI连接",
//						Toast.LENGTH_SHORT);
//				toast.show();
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

    //刷新
    public void refresh(){
        onCreate(null);
    }


    public class MessageAdapter extends BaseAdapter {
        private LayoutInflater inflater;
        private List<Message> list;
        private int layoutID;
        private int ItemIDs[];
        private Context context;

        public MessageAdapter(Context context, List<Message> list,
                              int layoutID,  int ItemIDs[]) {
            this.inflater = LayoutInflater.from(context);
            this.list = list;
            this.layoutID = layoutID;
            this.ItemIDs = ItemIDs;
            this.context=context;
        }

        @Override
        public int getCount() {
            // TODO Auto-generated method stub
            return list.size();
        }

        @Override
        public Object getItem(int arg0) {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public long getItemId(int arg0) {
            // TODO Auto-generated method stub
            return 0;
        }

        @Override
        public View getView(int position, View convertView,ViewGroup parent){
            final int p=position;
            convertView = inflater.inflate(layoutID, null);

            TextView tx1=(TextView)convertView.findViewById(ItemIDs[0]);
            TextView tx2=(TextView)convertView.findViewById(ItemIDs[1]);
            RelativeLayout message_item=(RelativeLayout)convertView.findViewById(ItemIDs[2]);
            final ImageButton clear=(ImageButton)convertView.findViewById(ItemIDs[3]);
//        TextView tx3=(TextView)convertView.findViewById(ItemIDs[2]);
//        TextView tx4=(TextView)convertView.findViewById(ItemIDs[3]);
//        TextView tx5=(TextView)convertView.findViewById(ItemIDs[4]);

            tx1.setText(list.get(position).getMessage_title());
            tx2.setText(list.get(position).getMessage_content());
//        tx3.setText(list.get(position).getCoursePlace());
//        tx4.setText(list.get(position).getWeekString()+list.get(position).getCourseTime());
//        tx5.setText(list.get(position).getWeekNumString());
            //Button addCourse=(Button)convertView.findViewById(ItemIDs[5]);
            message_item.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    // TODO Auto-generated method stub

//                CourseInfoDB courseDB=new CourseInfoDB(context);
//
//                if(courseDB.insertCourse(list.get(p))){
//                    Toast toast=Toast.makeText(context, "添加成功",Toast.LENGTH_SHORT);
//                    toast.show();
//                }
//                courseDB.close();

                }
            });
            clear.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast toast=Toast.makeText(context, "删除成功",Toast.LENGTH_SHORT);
                    toast.show();

                    //SearchCourse.setClear();
                    clearCheck=false;
//                    MessageAdapter adapter = new MessageAdapter(context, messages, R.layout.message_item,
//                            new int[]{R.id.message_title, R.id.message_content,R.id.message_item,R.id.clear_message});

                    listView.setAdapter(null);
                    //refresh();

                }
            });


            return convertView;
        }


    }
}

