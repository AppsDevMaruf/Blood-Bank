package com.marufalam.bloodbank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        TextView textView = findViewById(R.id.tv);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String number =intent.getStringExtra("number");
        String gender =intent.getStringExtra("gender");
        String  blood = intent.getStringExtra("bloodGroup");
        String ckbox = intent.getStringExtra("ckBox");
        textView.setText(name+"\n"+number+"\n"+gender+"\n"+blood+"\n"+ckbox);
    }
}