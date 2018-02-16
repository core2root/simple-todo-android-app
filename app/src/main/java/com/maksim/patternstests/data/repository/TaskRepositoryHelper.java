package com.maksim.patternstests.data.repository;

import com.maksim.patternstests.data.model.Task;

import java.util.List;

/**
 * Created by Maksim Novikov on 16-Feb-18.
 */

public interface TaskRepositoryHelper {

    void addTask(Task task);
    void deleteTask(Task task);
    List<Task> getAllTasks();
}
