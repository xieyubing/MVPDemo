package com.xb.demo.view;

import com.xb.demo.base.BaseView;

public interface ILoginView extends BaseView{

    void clearEditText();

    String getUserName();

    String getpassword();

    void setUserName(String UserName);

    void setPassword(String Password);

    void setUsernameError();

    void setPasswordError();

    void loginSuccess();
}
