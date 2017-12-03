package com.example.lab1_a156620;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EmailActivity extends AppCompatActivity {

    Button btn_send;
    EditText et_email_address, et_subject, et_message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email);

        btn_send = (Button) findViewById(R.id.email_btn_send);

        et_email_address = (EditText) findViewById(R.id.email_et_recipent);
        et_subject = (EditText) findViewById(R.id.email_et_subject);
        et_message = (EditText) findViewById(R.id.email_et_message);

        btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                // Send an email using implicit intent
                Intent emailIntent = new Intent(Intent.ACTION_SEND);
                emailIntent.setData(Uri.parse("mailto:"));
                emailIntent.setType("text/plain");
                emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]
                        {et_email_address.getText().toString()});
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, et_subject.getText().toString());
                emailIntent.putExtra(Intent.EXTRA_TEXT, "Hi, Good Evening. "
                        + et_message.getText().toString());

                startActivity(emailIntent);
            }
        });
    }
}
