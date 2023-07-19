package com.mastercoding.luckynumgenapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class LuckyNumberActivity extends AppCompatActivity {
    TextView welcomeTxt, luckyNumberTxt;
    Button share_btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lucky_number);

        welcomeTxt = findViewById(R.id.textView2);
        luckyNumberTxt = findViewById(R.id.lucky_number_txt);
        share_btn = findViewById(R.id.share_number_btn);

        // user name
        Intent i = getIntent();
        String username = i.getStringExtra("name");

        // random number
        int random_num = GetRandomNum();

        luckyNumberTxt.setText("" + random_num);

        Toast.makeText(this,"Username: "+ username, Toast.LENGTH_SHORT).show();
    }

    // method to generate random number using the built in random class
    public int GetRandomNum(){

        Random random = new Random();
        int upper_limit = 1000;
        return random.nextInt(upper_limit);
    }
}