package com.nabin.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText username, password;
    CheckBox remember_me;
    Button login, register;
    String adminName, adminPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        adminName = "admin";
        adminPassword = "admin";

        username = findViewById(R.id.user);
        password = findViewById(R.id.pass);
        remember_me = findViewById(R.id.remember_me);
        login = findViewById(R.id.login_btn);
        register = findViewById(R.id.register_btn);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (adminName.equals(username.getText().toString().trim())
                        && adminPassword.equals(password.getText().toString().trim())) {
                    startActivity(new Intent(LoginActivity.this, QueriesActivity.class));
                }
                else if (username.getText().toString().equals("admin1") && password.getText().toString().equals("admin")) {
                    Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                    startActivity(intent);

                } else if (username.getText().toString().equals("") && password.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(), "Enter username and password", Toast.LENGTH_LONG).show();

                    } else {
                        Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG).show();
                    }
                }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this,RegisterActivity.class));
            }
        });

    }
}
