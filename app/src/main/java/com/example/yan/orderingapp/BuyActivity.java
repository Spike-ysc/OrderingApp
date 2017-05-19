package com.example.yan.orderingapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class BuyActivity extends AppCompatActivity {
    private String food_name, food_message, money;
    private int imageId;
    private TextView nameText, moneyText,buyMsg,dialogText,rateText;
    private ImageView mImageView;
    private String[] datas = {"辣","微辣","不辣"};
    private Button mButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);
        final Intent intent = getIntent();
        food_name = intent.getStringExtra("food_Name");
        food_message = intent.getStringExtra("food_message");
        money = intent.getStringExtra("money");
        imageId = intent.getIntExtra("imageId",-1);
        nameText =(TextView) findViewById(R.id.buy_name_text);
        moneyText = (TextView) findViewById(R.id.buy_money);
        mImageView = (ImageView) findViewById(R.id.buy_image);
        buyMsg = (TextView)findViewById(R.id.buy_msg);
        nameText.setText(food_name);
        moneyText.setText(money);
        mImageView.setImageResource(imageId);
        buyMsg.setText("你选择了"+food_name+"一份,价格为："+money);

        dialogText = (TextView)findViewById(R.id.buy_dialog_Text);
        dialogText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog();
            }
        });
        mButton = (Button)findViewById(R.id.buy_sure);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = getSharedPreferences(""+AllMsg.getAllTime(),MODE_PRIVATE).edit();
                editor.putString("name",food_name);
                editor.putString("message", food_message);
                editor.putString("money",money);
                editor.putInt("image", imageId);
                editor.commit();

                Toast.makeText(BuyActivity.this, "订餐成功" , Toast.LENGTH_SHORT).show();
                AllMsg.setAllTime(AllMsg.getAllTime()+1);
                finish();

            }
        });
        rateText = (TextView) findViewById(R.id.rate_Text);
        rateText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(BuyActivity.this, RateActivity.class);
                startActivity(intent1);
            }
        });

    }
    private void showDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("规格");
        builder.setSingleChoiceItems(datas, 0, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String str = datas[which];
                buyMsg.setText("你选择了"+food_name+"一份,价格为："+money+","+str);
                dialog.dismiss();
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }



























}
