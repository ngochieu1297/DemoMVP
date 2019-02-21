package com.example.demomvp.signup;

public interface SignUpContract {
    interface View {
        void onSignUpSucess(String sucess);

        void onSignUpFailure(String error);
    }

    interface Presenter {
        void handleSignUp(String username, String password, String comfirm);
    }
}
