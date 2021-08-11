package com.omug.androidfinalexam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    Button login;
    TextView username, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login = findViewById(R.id.btnLogin);
        username = findViewById(R.id.txtUsername);
        password = findViewById(R.id.txtPassword);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (username.getText().toString().isEmpty() || password.getText().toString().isEmpty()){
                    Toast.makeText(getBaseContext(),"Empty username or password",Toast.LENGTH_LONG).show();
                }else{
                    String user = username.getText().toString();
                    String pass = password.getText().toString();
                    //if(validLogin(user,pass)){
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);
                    //}else{
                    //    Toast.makeText(getBaseContext(),"Invalid username or password",Toast.LENGTH_LONG).show();
                    //}
                }
            }
        });
    }

    private boolean validLogin(String user, String pass) {
        if(user=="omairys" && pass =="123456"){
            return true;
        }
        return false;
    }
}