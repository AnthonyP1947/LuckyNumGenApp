package com.mastercoding.luckynumgenapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Notification;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
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
        int random_num = getRandomNum();

        luckyNumberTxt.setText("" + random_num);

      share_btn.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              shareData(username, random_num);
          }
      });
    }

    // method to generate random number using the built in random class
    public int getRandomNum(){

        Random random = new Random();
        int upper_limit = 1000;
        return random.nextInt(upper_limit);
    }

    public void shareData(String username, int random_num){
        // Implicit Intents
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("text/plain");

        // convert the int to string type
        String num = String.valueOf(random_num);

        i.putExtra(Intent.EXTRA_SUBJECT, "Check out the lucky number of:  " + username );
        i.putExtra(Intent.EXTRA_TEXT, "Their lucky number is: " + random_num);

        startActivity(Intent.createChooser(i,"Choose a platform"));

    }
}