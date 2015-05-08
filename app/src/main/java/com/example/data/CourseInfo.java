/*
package com.example.data;

import java.io.Serializable;

@SuppressWarnings("serial")
public class CourseInfo implements Serializable{
	private String courseName;  //课程名称
	private int courseId;   	//课程ID 
	private String courseNum;		//课程序号
	private String teacherName;	//教师姓名
	private String courseTime; 		//哪几节上课
	private int week;		//周几上课
	private String  weekNum;  	//哪几周有课，上到多少周
	private String  coursePlace;	//上课地点
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public String getCourseNum() {
		return courseNum;
	}
	public void setCourseNum(String courseNum) {
		this.courseNum = courseNum;
	}
	public String getTeacherName() {
		return teacherName;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	public String getCourseTime() {
		return courseTime;
	}
	public void setCourseTime(String courseTime) {
		this.courseTime = courseTime;
	}
	public int getWeek() {	
		return week;
	}
	public String getWeekString(){
		//String temp=null;
		switch(week){
		case 1:
			return "周一";
		case 2:
			return "周二";
		case 3:
			return "周三";
		case 4:
			return "周四";
		case 5:
			return "周五";
		case 6:
			return "周六";
		case 7:
			return "周日";
			default:
				return null;
		}
	}
	public void setWeek(int week) {
		this.week = week;
	}
	public String getWeekNum() {
		return weekNum;
	}
	public void setWeekNum(String weekNum) {
		this.weekNum = weekNum;
	}
	public String getCoursePlace() {
		return coursePlace;
	}
	public void setCoursePlace(String coursePlace) {
		this.coursePlace = coursePlace;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		super.toString();
		return "课程名称:"+courseName+",教师姓名"+teacherName+",上课地点"+coursePlace;
	}
	
}
*/

package com.example.data;

import java.util.ArrayList;
import java.io.Serializable;
import java.util.ArrayList;


import org.simpleframework.xml.*;
import org.simpleframework.xml.core.Persister;

/**
 * Created by jasine on 14/12/17.
 */
@Root
@SuppressWarnings("serial")
public class CourseInfo implements Serializable{




    @Element(name = "Name")
    private String courseName;  //课程名称

    @Element(name = "Id")
    private int courseId;   	//课程ID

    @Element(name = "Num")
    private String courseNum;		//课程序号

    @Element(name = "Teacher",required = false)
    private String teacherName;	//教师姓名

    @Element(name = "Time")
    private String courseTime; 		//哪几节上课

    @Element(name = "Week")
    private int week;		//周几上课

    @Element(name = "WeekNum")
    private   String weekNum;  	//哪几周有课，上到多少周

    @Element(name = "Place")
    private String  coursePlace;	//上课地点

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }
    public String getCourseNum() {
        return courseNum;
    }


    public void setCourseNum(String courseNum) {
        this.courseNum = courseNum;
    }
    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }
    public String getCourseTime() {
        return courseTime;
    }

    public void setCourseTime(String courseTime) {
        this.courseTime = courseTime;
    }
    public int getWeek() {
        return week;
    }
    public  String getWeekString(){
        switch(week){
            case 1:
                return "周一";
            case 2:
                return "周二";
            case 3:
                return "周三";
            case 4:
                return "周四";
            case 5:
                return "周五";
            case 6:
                return "周六";
            case 7:
                return "周日";
            default:
                return null;
        }
    }

    public static  int getWeekIndex(String week){
        if(week.equals("星期一"))
            return 1;
        else if(week.equals("星期二"))
            return 2;
        else if(week.equals("星期三"))
            return 3;
        else if(week.equals("星期四"))
            return 4;
        else if(week.equals("星期五"))
            return 5;
        else if(week.equals("星期六"))
            return 6;
        else if(week.equals("星期日")||week.equals("星期天"))
            return 7;
        else
            return 0;
    }

    public void setWeek(int week) {
        this.week = week;
    }

    public ArrayList<Integer> getWeekNumArray() {
        ArrayList<Integer> weekNum1=new ArrayList<Integer>();
        String[] tem=weekNum.split("、");
        for(int i=0;i<tem.length;i++){
            weekNum1.add(Integer.parseInt(tem[i]));
        }


        return weekNum1;
    }
    public String getWeekNumString(){

        return weekNum;
    }

    //不能直接赋值
    public void setWeekNumString(String weekNum){


        this.weekNum=weekNum;
    }
    public void setWeekNum(String weekNum) {
        this.weekNum=weekNum;
    }

    public String getWeekNum(){
        return weekNum;
    }
    public String getCoursePlace() {
        return coursePlace;
    }

    public void setCoursePlace(String coursePlace) {
        this.coursePlace = coursePlace;
    }
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        super.toString();
        return "课程名称:"+courseName+",教师姓名:"+teacherName+",上课地点:"+coursePlace;
    }

    public CourseInfo(){
        super();
    }

}
