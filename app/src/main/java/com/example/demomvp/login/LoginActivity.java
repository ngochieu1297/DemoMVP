package com.example.demomvp.login;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.demomvp.R;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener,
        LoginContract.View {
    private EditText mTextUserName;
    private EditText mTextPassword;
    private Button mButtonLogin;
    private LoginPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
        initPresenter();
    }

    public void initPresenter() {
        mPresenter = new LoginPresenter();
        mPresenter.setView(this);
    }

    public void initView() {
        mTextUserName = findViewById(R.id.edit_user_name);
        mTextPassword = findViewById(R.id.edit_password);
        mButtonLogin = findViewById(R.id.button_login);
        mButtonLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String username = mTextUserName.getText().toString();
        String password = mTextPassword.getText().toString();
        mPresenter.handleLogin(username, password);
    }


    @Override
    public void onLoginSucess() {
        Toast.makeText(this, getString(R.string.string_login_success), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLoginFailure() {
        Toast.makeText(this, getString(R.string.string_login_error), Toast.LENGTH_SHORT).show();
    }
}
