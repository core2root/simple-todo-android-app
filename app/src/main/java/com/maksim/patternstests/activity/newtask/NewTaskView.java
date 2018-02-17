package com.maksim.patternstests.activity.newtask;

import com.maksim.patternstests.base.BaseView;
import com.maksim.patternstests.data.model.Task;

/**
 * Created by Maksim Novikov on 17-Feb-18.
 */

public interface NewTaskView extends BaseView {
    void onTaskAdded(Task task);
}
