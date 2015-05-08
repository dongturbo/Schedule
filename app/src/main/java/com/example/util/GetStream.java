package com.example.util;

import android.util.Log;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class GetStream {
	private String  urlStr="http://course.chinacloudsites.cn/api/course";
	public  InputStream getStream(String name,String pwd){
		StringBuilder str=new StringBuilder(urlStr);
        Log.i("zifu",urlStr);
        try{
			//设置发送的数据，即利用GET方式发送数据到服务器端
			//temp1="11";
			str.append("?username=");
			str.append(URLEncoder.encode(name, "UTF-8"));
			if(pwd!=null){
				str.append("&password=");
				str.append(URLEncoder.encode(pwd, "UTF-8"));
			}
            Log.i("zifu",str.toString());
			URL url=new URL(str.toString());
			HttpURLConnection conn=(HttpURLConnection)url.openConnection();
			conn.setConnectTimeout(10000);
			conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept","application/xml");
			InputStream in=conn.getInputStream();
			return in;
		}catch (Exception e) {  
            e.printStackTrace();             
        } 
		return null;
	}
}
