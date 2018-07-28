package com.xb.demo.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.xb.demo.Contract.LoginContract;
import com.xb.demo.R;
import com.xb.demo.base.BaseActivity;
import com.xb.demo.model.UserModel;
import com.xb.demo.presenter.LoginPresenter;

public class LoginActivity extends BaseActivity<LoginContract.LoginView, LoginPresenter> implements LoginContract.LoginView {


    EditText username;
    EditText password;
    Button button;

    @Override
    protected void initdate() {
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.doLogin();
            }
        });
    }

    @Override
    protected LoginPresenter createPresenter() {
        return new LoginPresenter(this, new UserModel());
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_login;
    }

    @Override
    public void clearEditText() {

    }

    @Override
    public String getUserName() {
        return username.getText().toString().trim();
    }

    @Override
    public String getpassword() {
        return password.getText().toString().trim();
    }

    @Override
    public void setUserName(String UserName) {

    }

    @Override
    public void setPassword(String Password) {

    }

    @Override
    public void setUsernameError() {

    }

    @Override
    public void setPasswordError() {

    }

    @Override
    public void loginSuccess() {
        Toast.makeText(this, "登陆成功！", Toast.LENGTH_LONG).show();
    }

    @Override
    public void showProgress(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }

    @Override
    public void hideProgress() {

    }

}
