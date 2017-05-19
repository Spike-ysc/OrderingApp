package com.example.yan.orderingapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.lang.annotation.Retention;

public class RateActivity extends AppCompatActivity {
    private Button rateBtn;
    private int num;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rate);
        Intent intent = getIntent();
        num = intent.getIntExtra("num",-1);

        rateBtn = (Button)findViewById(R.id.rate_Btn);
        rateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(RateActivity.this, "已评价", Toast.LENGTH_SHORT).show();
                if (num != -1){
                    AllMsg.setNum(num);
                }
                finish();
            }
        });
    }
}
