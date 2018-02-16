package com.maksim.patternstests.base;

/**
 * Created by Maksim Novikov on 16-Feb-18.
 */

public class BasePresenter<V extends BaseView> implements PresenterHelper<V>{

    private V mView;

    @Override
    public void attachView(V view) {
        mView = view;
    }

    @Override
    public void detachView() {
        mView = null;
    }

    @Override
    public V getView() {
        return mView;
    }
}
