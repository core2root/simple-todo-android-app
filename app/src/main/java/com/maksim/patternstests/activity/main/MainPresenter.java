package com.maksim.patternstests.activity.main;

import com.maksim.patternstests.base.BasePresenter;
import com.maksim.patternstests.data.model.Task;
import com.maksim.patternstests.data.repository.TaskRepository;

import java.util.List;

/**
 * Created by Maksim Novikov on 16-Feb-18.
 */

public class MainPresenter extends BasePresenter<MainView> implements TaskRepository.TaskRepoObserver {

    private TaskRepository mTasksRepo;

    @Override
    public void attachView(MainView view) {
        super.attachView(view);
        mTasksRepo = TaskRepository.getInstance(view.getContext());
        mTasksRepo.addObserver(this);
    }

    @Override
    public void detachView() {
        super.detachView();
        mTasksRepo.removeObserver(this);
    }

    public void fetchAllTasks(){
        List<Task> l = mTasksRepo.getAllTasks();
        getView().onTasks(l);

    }

    public void deleteTask(Task t){
        mTasksRepo.deleteTask(t);
    }

    /**
     * get notified from TaskRepoObserver
     * @param task
     */
    @Override
    public void onTaskAdded(Task task) {
        getView().onTaskAdded(task);
    }

    /**
     * get notified from TaskRepoObserver
     * @param task
     */
    @Override
    public void onTaskDeleted(Task task) {
        getView().onTaskDeleted(task);
    }
}
