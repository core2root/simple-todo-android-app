package com.maksim.patternstests.activity.main;

import com.maksim.patternstests.base.BaseView;
import com.maksim.patternstests.data.model.Task;

import java.util.List;

/**
 * Created by Maksim Novikov on 16-Feb-18.
 */

public interface MainView extends BaseView {
    void onTasks(List<Task> tasks);
    void onTaskDeleted(Task task);
    void onTaskAdded(Task task);
}
