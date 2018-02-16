package com.maksim.patternstests.base;

/**
 * Created by Maksim Novikov on 16-Feb-18.
 */

public interface PresenterHelper<V extends  BaseView> {
    void attachView(V view);
    void detachView();
    V getView();
}
