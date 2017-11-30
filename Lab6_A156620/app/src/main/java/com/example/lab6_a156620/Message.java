package com.example.lab6_a156620;

import android.content.Context;
import android.widget.Toast;

public class Message {
    public static void message (Context c, String message){
        Toast.makeText(c, message, Toast.LENGTH_LONG).show();
    }
}
