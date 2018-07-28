package com.xb.demo.base;

import java.lang.ref.WeakReference;

public class BasePresenter <V extends BaseView> {

    protected WeakReference<V> mReference;

    public void attachView(V view){
        mReference=new WeakReference<V>(view);
    }

    public void detachView(){
        if (mReference!=null) {
            mReference.clear();
        }
    }

    protected V getView(){
        if (isAttach())
            return mReference.get();
        else
            throw new NullPointerException("have you ever called attachView() in BasePresenter");

    }

    protected boolean isAttach() {
        return mReference != null && mReference.get() != null;
    }

}
