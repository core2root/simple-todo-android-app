package com.maksim.patternstests.base;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

/**
 * Created by Maksim Novikov on 16-Feb-18.
 */

public abstract class BaseActivity extends AppCompatActivity implements BaseView{
    @Override
    public void showMessage(String message) {
        if(message != null){
            Toast.makeText(this, message,Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Oops! something went wrong.",Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void showMessage(int resId) {
        showMessage(getString(resId));
    }

    @Override
    public Context getContext() {
        return this;
    }
}
