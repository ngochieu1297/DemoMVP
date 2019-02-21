package com.example.demomvp.signup;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.demomvp.R;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener,
        SignUpContract.View {
    private EditText mTextUserName;
    private EditText mTextPassword;
    private EditText mTextConfirm;
    private Button mButtonSignUp;
    private SignUpPresenter mPresenterSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        initView();
    }

    private void initView() {
        mTextUserName = findViewById(R.id.edit_text_new_user);
        mTextPassword = findViewById(R.id.edit_text_new_password);
        mTextConfirm = findViewById(R.id.edit_text_confirm_password);
        mButtonSignUp = findViewById(R.id.button_sign_up);
        mButtonSignUp.setOnClickListener(this);
        mPresenterSignUp = new SignUpPresenter();
        mPresenterSignUp.setView(this, this);
    }

    @Override
    public void onClick(View v) {
        String username = mTextUserName.getText().toString();
        String password = mTextPassword.getText().toString();
        String confirm = mTextConfirm.getText().toString();
        mPresenterSignUp.handleSignUp(username, password, confirm);
    }

    @Override
    public void onSignUpSucess(String sucess) {
        Toast.makeText(this, sucess, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onSignUpFailure(String error) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
    }
}
