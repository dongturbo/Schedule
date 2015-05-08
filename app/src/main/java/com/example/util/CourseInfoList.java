package com.example.util;

/**
 * Created by dong on 2014/12/18.
 */


import java.io.*;
import java.util.ArrayList;

import org.simpleframework.xml.*;
import org.simpleframework.xml.core.Persister;

import com.example.data.CourseInfo;


@Root(name = "CrouseInfoList")
public class CourseInfoList {

    @ElementList(type = CourseInfo.class,name="CourseInfos")
    private ArrayList<CourseInfo> courseInfos;

    @Element(name="ThisWeek")
    private int thisWeek;
    @Element(name="Name")
    private String name;
    @Element(name="Organization")
    private String organization;


    public CourseInfoList(){
        super();
    }

    public ArrayList<CourseInfo> getCourseInfos(){
        return courseInfos;
    }

    public void setCourseInfos(ArrayList<CourseInfo> courseInfos){
        this.courseInfos=courseInfos;
    }



    public static CourseInfoList GetCourseInfoList(InputStream inputStream){
        try {
            Persister persister = new Persister();
            CourseInfoList courseInfoList = persister.read(CourseInfoList.class, inputStream);
            return courseInfoList;
        }catch (Exception e){
            return null;
        }
    }

    public static CourseInfoList GetCourseInfoList(String xmlString){
        try {

            Persister persister = new Persister();
            CourseInfoList courseInfoList = persister.read(CourseInfoList.class, xmlString);
            return courseInfoList;
        }catch (Exception e){
            return null;
        }
    }

    public static String GetXmlList(CourseInfoList courseInfos){

        try {
            Serializer serializer = new Persister();
            ByteArrayOutputStream stream=new ByteArrayOutputStream();
            serializer.write(courseInfos, stream);
            return  new String(stream.toByteArray(),"UTF-8");
        }catch (Exception e){
            e.printStackTrace();
            return "";
        }
    }

    //获取姓名
    public String getName(){return name;}
    public void setName(String name){
        this.name=name;
    }

    //获取单位
    public String getOrganization(){return organization;}
    public void setOrganization(String organization){
        this.organization=organization;
    }

    //获取当前周

    public int getThisWeek(){return thisWeek;}
    public void setThisWeek(int thisWeek){
        this.thisWeek=thisWeek;
    }

}
