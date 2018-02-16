package com.maksim.patternstests.data.repository;

import android.content.Context;

import com.maksim.patternstests.data.model.Task;
import com.maksim.patternstests.root.AppDatabase;

import java.util.List;

/**
 * Created by Maksim Novikov on 16-Feb-18.
 */

public class TaskRepository implements TaskRepositoryHelper{

    private TaskRepository(Context context){
        mDatabase = AppDatabase.getInstance(context);
    }
    private static TaskRepository instance;

    private AppDatabase mDatabase;
    public static TaskRepository getInstance(Context context){
        if(instance == null){
            instance = new TaskRepository(context);
        }
        return instance;
    }

    @Override
    public void addTask(Task task) {
        mDatabase.taskDao().addTask(task);
    }

    @Override
    public void deleteTask(Task task) {
        mDatabase.taskDao().deleteTask(task);
    }

    @Override
    public List<Task> getAllTasks() {
        return mDatabase.taskDao().getAllTasks();
    }
}
