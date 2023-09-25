package com.example.lab3_5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //khai báo các biến giao diện
    TextView tvTopLeft,tvBelow,tvBelowRL;
    Button btnTopRight;
    RelativeLayout rlTopContainer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_part_1);
        //ánh xạ
        tvTopLeft =findViewById(R.id.tvTopLeft);
        tvBelow=findViewById(R.id.tvBelow);
        tvBelowRL=findViewById(R.id.tvBelowRL);
        btnTopRight=findViewById(R.id.btnTopRight);
        rlTopContainer=findViewById(R.id.rlTopContainer);
        //xử lý click
        btnTopRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,MainActivity2.class);
                startActivity(intent);
            }
        });
    }
}