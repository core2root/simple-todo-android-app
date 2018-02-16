package com.maksim.patternstests.main;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.maksim.patternstests.R;
import com.maksim.patternstests.base.BaseActivity;
import com.maksim.patternstests.data.model.Task;

import java.util.List;

public class MainActivity extends BaseActivity implements MainView, View.OnClickListener {

    private MainPresenter mPresenter;
    private RecyclerView mRecyclerView;
    private TasksAdapter mAdapter;
    private TextView noTasksTv;
    private ImageView addTaskIv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPresenter = new MainPresenter();
        mPresenter.attachView(this);
        mRecyclerView = findViewById(R.id.recycler_view);
        noTasksTv = findViewById(R.id.no_tasks_tv);
        addTaskIv = findViewById(R.id.add_task_iv);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
        addTaskIv.setOnClickListener(this);

        mPresenter.fetchAllTasks();

    }

    @Override
    public void onTasks(List<Task> tasks) {
        if (tasks.size() == 0)
            noTasksTv.setVisibility(View.VISIBLE);
        else{
            noTasksTv.setVisibility(View.GONE);
        }
        mAdapter = new TasksAdapter(tasks);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void onTaskAdded(Task task) {
        mAdapter.addTask(task);
    }

    @Override
    public void onTaskDeleted(Task task) {
        mAdapter.removeTask(task);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.add_task_iv:
                mPresenter.addTask();
                break;
        }
    }
}
