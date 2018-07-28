package com.xb.demo.Contract;

import com.xb.demo.base.BaseModel;
import com.xb.demo.view.ILoginView;

public class LoginContract {

    public interface LoginView extends ILoginView {
    }

    public interface LoginModel extends BaseModel {
        void login(String name, String password, LoginCallBack callBack);
    }

    public interface LoginCallBack {
        void onSuccess();

        void onFail(String errorInfo);
    }

}
