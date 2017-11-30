package com.example.lab1_a156620;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // Declare button and edit text
    Button btn_login, btn_sign_up;
    EditText et_username, et_password;
    ImageButton btn_email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // link or initialised the button and the edit text
        // because btn_login is Button type thus have to cast it to Button Type
        // you can have shortcut key Ctrl+l

        btn_login = (Button) findViewById(R.id.main_btn_login);
        btn_sign_up = (Button) findViewById(R.id.main_btn_sign_up);
        et_username = (EditText) findViewById(R.id.main_et_user_name);
        et_password = (EditText) findViewById(R.id.main_et_password);
        btn_email = (ImageButton) findViewById(R.id.image_btn_email);

        // Create button's click event listener
        btn_login.setOnClickListener(new View.OnClickListener() {

            @Override
            public  void onClick(View v){
                // Create toast message
                Toast.makeText(getApplicationContext(), "Login clicked", Toast.LENGTH_LONG).show();

            }
        });

        btn_sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Create toast message
                // Get the edit text field's text
                Toast.makeText(getApplicationContext(), "Password: " + et_password.getText(), Toast.LENGTH_LONG).show();
            }
        });

        btn_email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Start email activity using explicit intent
                // New intent (from where, to where);
                Intent myIntent = new Intent(MainActivity.this, EmailActivity.class);
                startActivity(myIntent);
            }
        });
    }
}
