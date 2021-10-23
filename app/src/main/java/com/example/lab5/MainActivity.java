package com.example.lab5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SharedPreferences sharedPreferences = getSharedPreferences("com.example.lab5", Context.MODE_PRIVATE);
        String username = sharedPreferences.getString("username", "");

        if (!username.equals("")) {
            Intent intent = new Intent(this,MainActivity2.class);
            intent.putExtra("message",String.valueOf(username));
            startActivity(intent);
        } else {
            setContentView(R.layout.activity_main);
        }
    }

    public void onLogin(View view){
        EditText Username = (EditText) findViewById(R.id.Username);
        EditText Password = (EditText) findViewById(R.id.Password);

        if (Password.getText().toString().length() > 0){
            SharedPreferences sharedPreferences = getSharedPreferences("com.example.lab5", Context.MODE_PRIVATE);
            sharedPreferences.edit().putString("username", Username.getText().toString()).apply();
            goToActivity2(Username.getText().toString());
        }
    }

    public void goToActivity2(String Username) {
        Intent intent = new Intent(this,MainActivity2.class);
        intent.putExtra("message",String.valueOf(Username));
        startActivity(intent);
    }
}