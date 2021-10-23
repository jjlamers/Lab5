package com.example.lab5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onLogin(View view){
        EditText Username = (EditText) findViewById(R.id.Username);
        EditText Password = (EditText) findViewById(R.id.Password);

        if (Password.getText().toString().length() > 0){
            goToActivity2(Username.getText().toString());
        }
    }

    public void goToActivity2(String Username) {
        Intent intent = new Intent(this,MainActivity2.class);
        intent.putExtra("message",String.valueOf(Username));
        startActivity(intent);
    }
}