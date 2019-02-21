package com.example.demomvp.login;

import com.example.demomvp.model.User;

public class LoginPresenter implements LoginContract.Presenter {
    private LoginContract.View mView;
    private static final String USERNAME = "ngochieu1297";
    private static final String PASSWORD = "hieu1997";
    private User mUser = new User(USERNAME, PASSWORD);

    public void setView(LoginContract.View view) {
        this.mView = view;
    }

    @Override
    public void handleLogin(String username, String password) {
        if (username.equals(mUser.getUsername()) && password.equals(mUser.getPassword())) {
            mView.onLoginSucess();
            return;
        } else {
            mView.onLoginFailure();
        }
    }
}
