package com.example.adatper;

import android.content.ClipData;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.data.CourseInfo;
import com.example.data.Message;
import com.example.db.CourseInfoDB;
import com.example.main.SearchCourse;

import java.util.List;

/**
 * Created by 博 on 2015/8/5.
 */
//public class MessageAdapter extends BaseAdapter {
//    private LayoutInflater inflater;
//    private List<Message> list;
//    private int layoutID;
//    private int ItemIDs[];
//    private Context context;
//
//    public MessageAdapter(Context context, List<Message> list,
//                           int layoutID,  int ItemIDs[]) {
//        this.inflater = LayoutInflater.from(context);
//        this.list = list;
//        this.layoutID = layoutID;
//        this.ItemIDs = ItemIDs;
//        this.context=context;
//    }
//
//    @Override
//    public int getCount() {
//        // TODO Auto-generated method stub
//        return list.size();
//    }
//
//    @Override
//    public Object getItem(int arg0) {
//        // TODO Auto-generated method stub
//        return null;
//    }
//
//    @Override
//    public long getItemId(int arg0) {
//        // TODO Auto-generated method stub
//        return 0;
//    }
//
//    @Override
//    public View getView(int position, View convertView,ViewGroup parent){
//        final int p=position;
//        convertView = inflater.inflate(layoutID, null);
//
//        TextView tx1=(TextView)convertView.findViewById(ItemIDs[0]);
//        TextView tx2=(TextView)convertView.findViewById(ItemIDs[1]);
//        RelativeLayout message_item=(RelativeLayout)convertView.findViewById(ItemIDs[2]);
//        ImageButton clear=(ImageButton)convertView.findViewById(ItemIDs[3]);
////        TextView tx3=(TextView)convertView.findViewById(ItemIDs[2]);
////        TextView tx4=(TextView)convertView.findViewById(ItemIDs[3]);
////        TextView tx5=(TextView)convertView.findViewById(ItemIDs[4]);
//
//        tx1.setText(list.get(position).getMessage_title());
//        tx2.setText(list.get(position).getMessage_content());
////        tx3.setText(list.get(position).getCoursePlace());
////        tx4.setText(list.get(position).getWeekString()+list.get(position).getCourseTime());
////        tx5.setText(list.get(position).getWeekNumString());
//        //Button addCourse=(Button)convertView.findViewById(ItemIDs[5]);
//        message_item.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//                // TODO Auto-generated method stub
//
////                CourseInfoDB courseDB=new CourseInfoDB(context);
////
////                if(courseDB.insertCourse(list.get(p))){
////                    Toast toast=Toast.makeText(context, "添加成功",Toast.LENGTH_SHORT);
////                    toast.show();
////                }
////                courseDB.close();
//
//            }
//        });
//        clear.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast toast=Toast.makeText(context, "删除成功",Toast.LENGTH_SHORT);
//                toast.show();
//
//                //SearchCourse.setClear();
//                getMessage();
//
//            }
//        });
//
//
//        return convertView;
//    }
//
//
//}
