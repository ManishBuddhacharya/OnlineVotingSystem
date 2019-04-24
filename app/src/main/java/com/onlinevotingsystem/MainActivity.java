package com.onlinevotingsystem;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import fragments.SignupFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnLogin;
    private TextView tvSignup;
    private EditText etUsername, etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLogin = findViewById(R.id.btnLogin);
        tvSignup = findViewById(R.id.tvSignup);
        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);

        btnLogin.setOnClickListener(this);
        tvSignup.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        switch (v.getId()) {
            case R.id.btnLogin:
                 Intent intent = new Intent(MainActivity.this, DashboardActivity.class);
                 startActivity(intent);
                break;

            case R.id.tvSignup:
                SignupFragment signupFragment = new SignupFragment();
                fragmentTransaction.replace(R.id.layoutMain, signupFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
                break;

        }

    }
}
