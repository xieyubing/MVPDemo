package com.xb.demo.model;

import android.os.Handler;
import android.os.Looper;

import com.xb.demo.Contract.LoginContract;

public class UserModel implements LoginContract.LoginModel {

    private Handler handler=new Handler(Looper.getMainLooper());


    @Override
    public void login(final String username, final String password, final LoginContract.LoginCallBack callBack) {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if(username.equals("123")&&password.equals("123"))
                    callBack.onSuccess();
                else
                    callBack.onFail("帐号或者密码错误");
            }
        },2000);
    }
}
