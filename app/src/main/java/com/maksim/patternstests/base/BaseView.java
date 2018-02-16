package com.maksim.patternstests.base;

import android.content.Context;

/**
 * Created by Maksim Novikov on 16-Feb-18.
 */

public interface BaseView {
    void showMessage(String message);
    void showMessage(int resId);
    Context getContext();
}
