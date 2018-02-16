package com.maksim.patternstests.main;

import com.maksim.patternstests.base.BaseView;
import com.maksim.patternstests.data.model.Task;

import java.util.List;

/**
 * Created by Maksim Novikov on 16-Feb-18.
 */

public interface MainView extends BaseView {
    void onTasks(List<Task> tasks);
    void onTaskAdded(Task task);
    void onTaskDeleted(Task task);
}
