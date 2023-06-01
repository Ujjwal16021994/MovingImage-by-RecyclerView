package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class display extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        TextView name,mob,email;
        name = findViewById(R.id.textView1);
        mob = findViewById(R.id.textView2);
        email = findViewById(R.id.textView3);
        Intent intent = getIntent();
        name.setText(intent.getStringExtra("name1"));
        mob.setText(intent.getStringExtra("mob1"));
        email.setText(intent.getStringExtra("email1"));
    }
}