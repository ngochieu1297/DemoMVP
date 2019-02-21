package com.example.demomvp.signup;


import android.content.Context;

import com.example.demomvp.R;

public class SignUpPresenter implements SignUpContract.Presenter {
    private SignUpContract.View mView;
    private Context mContext;

    public void setView(Context context, SignUpContract.View view) {
        mContext = context;
        mView = view;
    }

    @Override
    public void handleSignUp(String username, String password, String confirm) {
        if (username.isEmpty() || password.isEmpty() || confirm.isEmpty()) {
            mView.onSignUpFailure(mContext.getString(R.string.string_empty));
        }
        if (!password.equals(confirm)) {
            mView.onSignUpFailure(mContext.getString(R.string.string_incorrect));
        } else {
            mView.onSignUpSucess(mContext.getString(R.string.string_correct));
        }
    }
}
