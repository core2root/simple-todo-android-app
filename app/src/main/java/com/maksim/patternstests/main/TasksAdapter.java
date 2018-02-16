package com.maksim.patternstests.main;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.maksim.patternstests.R;
import com.maksim.patternstests.data.model.Task;

import java.util.List;

/**
 * Created by Maksim Novikov on 16-Feb-18.
 */

public class TasksAdapter extends RecyclerView.Adapter<TasksAdapter.TaskViewHolder> {

    private List<Task> mList;

    public TasksAdapter(List<Task> tasks){
        this.mList = tasks;
    }

    public void addTask(Task task){
        mList.add(task);
        notifyDataSetChanged();
    }

    public void removeTask(Task task){
        if(mList.contains(task)) {
            mList.remove(task);
            notifyDataSetChanged();
        }
    }

    @Override
    public TaskViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View item = LayoutInflater.from(parent.getContext()).inflate(R.layout.task_layout,parent, false);
        return new TaskViewHolder(item);
    }

    @Override
    public void onBindViewHolder(TaskViewHolder holder, int position) {
        Task task = mList.get(position);
        holder.titleTv.setText(task.getTitle());
        holder.bodyTv.setText(task.getBody());
        holder.timeTv.setText(task.getCreatedAtText());
        holder.wrapper.setBackgroundResource(task.getBackgroundColor());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class TaskViewHolder extends RecyclerView.ViewHolder{
        public TextView titleTv, timeTv, bodyTv;
        public RelativeLayout wrapper;
        public TaskViewHolder(View itemView) {
            super(itemView);
            titleTv = itemView.findViewById(R.id.title_tv);
            timeTv = itemView.findViewById(R.id.time_tv);
            bodyTv = itemView.findViewById(R.id.body_tv);
            wrapper = itemView.findViewById(R.id.wrapper);
        }
    }
}
