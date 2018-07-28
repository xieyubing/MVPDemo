package com.xb.demo.presenter;

import com.xb.demo.Contract.LoginContract;
import com.xb.demo.base.BasePresenter;
import com.xb.demo.view.ILoginView;

public class LoginPresenter extends BasePresenter< LoginContract.LoginView> {

    LoginContract.LoginView loginView;
    LoginContract.LoginModel loginModel;

    public LoginPresenter(LoginContract.LoginView loginView, LoginContract.LoginModel loginModel) {
        this.loginView = loginView;
        this.loginModel = loginModel;
    }

    public void doLogin() {
        loginView.showProgress("登陆中");
        loginModel.login(loginView.getUserName(), loginView.getpassword(), new LoginContract.LoginCallBack() {
            @Override
            public void onSuccess() {
                loginView.loginSuccess();
            }

            @Override
            public void onFail(String errorInfo) {
                loginView.showProgress("登陆失败");
            }
        });

    }
}
