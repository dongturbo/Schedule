package com.example.data;

import java.io.Serializable;

/**
 * Created by ²© on 2015/8/5.
 */
public class Message implements Serializable {
    private String message_title;
    private String message_content;

    public Message(String message_title,String message_content){
        this.message_title=message_title;
        this.message_content=message_content;
    }

    public String getMessage_title() {
        return message_title;
    }

    public void setMessage_title(String message_title) {
        this.message_title = message_title;
    }

    public String getMessage_content() {
        return message_content;
    }

    public void setMessage_content(String message_content) {
        this.message_content = message_content;
    }
}
