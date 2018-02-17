package com.maksim.patternstests.data.repository;

import android.content.Context;

import com.maksim.patternstests.data.model.Task;
import com.maksim.patternstests.root.AppDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Maksim Novikov on 16-Feb-18.
 */

public class TaskRepository implements TaskRepositoryHelper{

    private ArrayList<TaskRepoObserver> mObservers;

    private TaskRepository(Context context){
        mDatabase = AppDatabase.getInstance(context);
        mObservers = new ArrayList<>();
    }
    private static TaskRepository instance;

    private AppDatabase mDatabase;
    public static TaskRepository getInstance(Context context){
        if(instance == null){
            instance = new TaskRepository(context);
        }
        return instance;
    }

    public void addObserver(TaskRepoObserver observer){
        mObservers.add(observer);
    }

    public void removeObserver(TaskRepoObserver observer){
        if(mObservers.contains(observer))
            mObservers.remove(observer);
    }

    public void notifyAddTaskObservers(Task task){
        for(TaskRepoObserver observer : mObservers){
            observer.onTaskAdded(task);
        }
    }

    public void notifyDeletedTaskObservers(Task task){
        for(TaskRepoObserver observer : mObservers){
            observer.onTaskDeleted(task);
        }
    }

    @Override
    public void addTask(Task task) {
        mDatabase.taskDao().addTask(task);
        notifyAddTaskObservers(task);
    }

    @Override
    public void deleteTask(Task task) {
        mDatabase.taskDao().deleteTask(task);
        notifyDeletedTaskObservers(task);
    }

    @Override
    public List<Task> getAllTasks() {
        return mDatabase.taskDao().getAllTasks();
    }

    public interface TaskRepoObserver{
        void onTaskAdded(Task task);
        void onTaskDeleted(Task task);
    }
}
