package com.maksim.patternstests.activity.newtask;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.maksim.patternstests.R;
import com.maksim.patternstests.base.BaseActivity;
import com.maksim.patternstests.data.model.Task;
import com.maksim.patternstests.widgets.CircleImageView;

/**
 * Created by Maksim Novikov on 17-Feb-18.
 */

public class NewTaskActivity extends BaseActivity implements NewTaskView, View.OnClickListener {

    private NewTaskPresenter mPresenter;
    private CircleImageView lowPriorityIv,normalPriorityIv, highPriorityIv;
    private ImageView saveIv;
    private EditText titleInput, bodyInput;
    /**
     * the priority for current task, by default have Task.PRIORITY_DEFAULT
     * if user choose other priority will be overridden
     */
    private  int mPriority = Task.PRIORITY_DEFAULT;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_task);

        lowPriorityIv = findViewById(R.id.low_priority_iv);
        normalPriorityIv = findViewById(R.id.normal_priority_iv);
        highPriorityIv = findViewById(R.id.high_priority_iv);
        saveIv = findViewById(R.id.save_iv);
        titleInput = findViewById(R.id.title_input);
        bodyInput = findViewById(R.id.body_input);

        saveIv.setOnClickListener(this);
        lowPriorityIv.setOnClickListener(this);
        normalPriorityIv.setOnClickListener(this);
        highPriorityIv.setOnClickListener(this);


        mPresenter = new NewTaskPresenter();
        mPresenter.attachView(this);
    }


    @Override
    public void onTaskAdded(Task task) {
        onBackPressed();
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.low_priority_iv:
                if(mPriority != Task.PRIORITY_LOW){
                    mPriority = Task.PRIORITY_LOW;
                    lowPriorityIv.setBorderColor(getResources().getColor(R.color.colorPrimaryDark));

                    highPriorityIv.setBorderColor(getResources().getColor(android.R.color.transparent));
                    normalPriorityIv.setBorderColor(getResources().getColor(android.R.color.transparent));
                }else{
                    mPriority = Task.PRIORITY_DEFAULT;
                    lowPriorityIv.setBorderColor(getResources().getColor(android.R.color.transparent));
                }
                break;
            case R.id.normal_priority_iv:
                if(mPriority != Task.PRIORITY_NORMAL){
                    mPriority = Task.PRIORITY_NORMAL;
                    normalPriorityIv.setBorderColor(getResources().getColor(R.color.colorPrimaryDark));

                    highPriorityIv.setBorderColor(getResources().getColor(android.R.color.transparent));
                    lowPriorityIv.setBorderColor(getResources().getColor(android.R.color.transparent));
                }else{
                    mPriority = Task.PRIORITY_DEFAULT;
                    normalPriorityIv.setBorderColor(getResources().getColor(android.R.color.transparent));
                }
                break;
            case R.id.high_priority_iv:
                //if chosen
                if(mPriority != Task.PRIORITY_HIGH) {
                    mPriority = Task.PRIORITY_HIGH;
                    highPriorityIv.setBorderColor(getResources().getColor(R.color.colorPrimaryDark));

                    normalPriorityIv.setBorderColor(getResources().getColor(android.R.color.transparent));
                    lowPriorityIv.setBorderColor(getResources().getColor(android.R.color.transparent));
                }
                //if user click again when it already chosen nee to set priority to DEFAULT and un chose the circle
                else{
                    mPriority = Task.PRIORITY_DEFAULT;
                    highPriorityIv.setBorderColor(getResources().getColor(android.R.color.transparent));
                }
                break;
            case R.id.save_iv:

                String title = titleInput.getText().toString();
                String body = bodyInput.getText().toString();
                if(title == null || TextUtils.isEmpty(title.trim())){
                    showMessage(R.string.empty_title_message);
                    return;
                }
                mPresenter.saveTask(title, body, mPriority);
                break;
        }
    }
}
