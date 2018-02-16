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

    public static final int URGENCY_LOW = 1;
    public static final int URGENCY_NORMAL = 2;
    public static final int URGENCY_HIGH = 3;

    @PrimaryKey(autoGenerate = true)
    private int uid;

    private String title;
    private long createdAt;
    private String body;
    private int urgency;


    public Task(String title, String body, int urgency){
        this.title = title;
        this.body = body;
        if(urgency > 3 || urgency < 1)
            this.urgency = URGENCY_LOW;
        else
            this.urgency = urgency;
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

    public void setUrgency(int urgency) {
        this.urgency = urgency;
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

    public int getUrgency() {
        return urgency;
    }

    public String getCreatedAtText(){
        return TimeUtils.getFormattedTime(createdAt,TimeUtils.FULL_TIME_FORMAT);
    }

    public int getBackgroundColor(){
        switch (urgency){
            case URGENCY_LOW:
                return R.color.urgency_low;
            case URGENCY_NORMAL:
                return  R.color.urgency_normal;
            case URGENCY_HIGH:
                return R.color.urgency_high;
            default: return R.color.urgency_low;
        }
    }
}
