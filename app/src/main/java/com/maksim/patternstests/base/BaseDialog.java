package com.maksim.patternstests.base;

import android.content.Context;
import android.support.v4.app.DialogFragment;

/**
 * Created by Maksim Novikov on 26-Jan-18.
 */

public class BaseDialog extends DialogFragment implements BaseDialogView{

    private BaseActivity mActivity;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof BaseActivity){
            mActivity = (BaseActivity) context;
        }
    }

    @Override
    public void dismissDialog() {
        dismiss();
    }


    @Override
    public void showMessage(String message) {
        mActivity.showMessage(message);
    }

    @Override
    public void showMessage(int resId) {
        mActivity.showMessage(resId);
    }

}
