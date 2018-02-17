package com.maksim.patternstests.data.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.maksim.patternstests.R;
import com.maksim.patternstests.utils.TimeUtils;

import java.util.Date;

/**
 * Created by Maksim Novikov on 16-Feb-18.
 */
 @Entity(tableName = "task")
public class Task {

    public static final int PRIORITY_DEFAULT = 0;
    public static final int PRIORITY_LOW = 1;
    public static final int PRIORITY_NORMAL = 2;
    public static final int PRIORITY_HIGH = 3;

    @PrimaryKey(autoGenerate = true)
    private int uid;

    private String title;
    private long createdAt;
    private String body;
    private int priority;


    public Task(String title, String body, int priority){
        this.title = title;
        this.body = body;
        if(priority > 3 || priority < 1)
            this.priority = PRIORITY_DEFAULT;
        else
            this.priority = priority;
        this.createdAt = new Date().getTime();
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getTitle() {
        return title;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public String getBody() {
        return body;
    }

    public int getPriority() {
        return priority;
    }

    public String getCreatedAtText(){
        return TimeUtils.getFormattedTime(createdAt,TimeUtils.FULL_TIME_FORMAT);
    }

    public int getBackgroundColor(){
        switch (priority){
            case PRIORITY_LOW:
                return R.color.priority_low;
            case PRIORITY_NORMAL:
                return  R.color.priority_normal;
            case PRIORITY_HIGH:
                return R.color.priority_high;
            default:
                return R.color.priority_default;
        }
    }
}
