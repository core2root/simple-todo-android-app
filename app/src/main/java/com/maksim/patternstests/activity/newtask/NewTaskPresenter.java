package com.maksim.patternstests.activity.newtask;

import com.maksim.patternstests.base.BasePresenter;
import com.maksim.patternstests.data.model.Task;
import com.maksim.patternstests.data.model.TaskBuilder;
import com.maksim.patternstests.data.repository.TaskRepository;

/**
 * Created by Maksim Novikov on 17-Feb-18.
 */

public class NewTaskPresenter extends BasePresenter<NewTaskView> {

    private TaskRepository mTasksRepo;

    @Override
    public void attachView(NewTaskView view) {
        super.attachView(view);
        mTasksRepo = TaskRepository.getInstance(view.getContext());
    }

    public void saveTask(String title, String body, int priority){
        Task task = new TaskBuilder().setTitle(title).setBody(body).setPriority(priority).build();
        mTasksRepo.addTask(task);
        getView().onTaskAdded(task);
    }
}
