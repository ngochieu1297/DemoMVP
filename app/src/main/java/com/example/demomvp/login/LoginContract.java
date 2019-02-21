package com.example.demomvp.login;

public interface LoginContract {
    interface View {
        void onLoginSucess();

        void onLoginFailure();
    }

    interface Presenter {
        void handleLogin(String username, String password);
    }
}
