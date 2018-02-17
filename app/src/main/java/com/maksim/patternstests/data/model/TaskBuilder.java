package com.maksim.patternstests.data.model;

/**
 * Created by Maksim Novikov on 16-Feb-18.
 */
/**
 * Builder for Task calss
 */
public class TaskBuilder{
    private String title;
    private long createdAt;
    private String body;
    private int priority;

    public TaskBuilder setTitle(String title) {
        this.title = title;
        return this;
    }

    public TaskBuilder setBody(String body) {
        this.body = body;
        return this;
    }

    public TaskBuilder setPriority(int priority) {
        this.priority = priority;
        return this;
    }

    public Task build(){
        return new Task(title,body,priority);
    }
}
