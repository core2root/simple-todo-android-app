package com.maksim.patternstests.data.model;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

/**
 * Created by Maksim Novikov on 16-Feb-18.
 */

@Dao
public interface TaskDao  {

    @Query("SELECT * FROM task")
    List<Task> getAllTasks();

    @Query("SELECT * FROM task WHERE uid = :uid")
    Task getTask(String uid);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void addTask(Task... tasks);

    @Delete
    void deleteTask(Task task);

}
