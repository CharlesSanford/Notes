package com.example.charles.notes;

import java.util.Date;

import io.realm.RealmObject;

/**
 * Created by Charles on 1/27/2017.
 */

public class Note extends RealmObject{

    private String title;
    private String content;
    private Date date;

    public String getTitle() {
        return title;
    }
    public String getContent() {
        return content;
    }
    public Date getDate() {
        return date;
    }
    public void setTitle(String newTitle) {
        title = newTitle;
    }
    public void setContent(String newContent) {
        content = newContent;
    }
    public void setDate(Date newDate) {
        date = newDate;
    }
}

