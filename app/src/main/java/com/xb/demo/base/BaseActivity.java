package com.xb.demo.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;

public abstract class BaseActivity <V extends BaseView,P extends BasePresenter<V>> extends AppCompatActivity {

    protected P presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = createPresenter();
        if (presenter == null) {
            throw new NullPointerException("Presenter is null! Do you return null in createPresenter()?");
        }
        presenter.attachView((V)this);
        setContentView(getLayoutResId());
        initdate();
    }

    protected abstract void initdate();


    protected abstract P  createPresenter();

    protected abstract int getLayoutResId();

    //页面跳转
    public void startActivity(Class<?> clz) {
        startActivity(clz, null);
    }

    //携带数据跳转
    public void startActivity(Class<?> clz, Bundle bundle) {
        Intent intent = new Intent();
        intent.setClass(this, clz);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivity(intent);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detachView();
    }
}
