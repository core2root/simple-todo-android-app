package com.maksim.patternstests.main;

import com.maksim.patternstests.base.BasePresenter;
import com.maksim.patternstests.data.model.Task;
import com.maksim.patternstests.data.model.TaskBuilder;
import com.maksim.patternstests.data.repository.TaskRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Maksim Novikov on 16-Feb-18.
 */

public class MainPresenter extends BasePresenter<MainView> {

    private TaskRepository mTasksRepo;

    @Override
    public void attachView(MainView view) {
        super.attachView(view);
        mTasksRepo = TaskRepository.getInstance(view.getContext());
    }

    public void fetchAllTasks(){
        List<Task> l = mTasksRepo.getAllTasks();
        getView().onTasks(l);

    }

    public void addTask(){
        Task t = new TaskBuilder().setTitle("Some title").setBody("Fucking shit").setUrgency(Task.URGENCY_NORMAL).build();
        mTasksRepo.addTask(t);
        getView().onTaskAdded(t);

    }

    public void deleteTask(Task t){
        mTasksRepo.deleteTask(t);
        getView().onTaskDeleted(t);
    }

}
