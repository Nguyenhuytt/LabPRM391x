package com.example.lab32;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    //khai báo biến giao diện
    ImageView iv_rabbit,iv_cat;
    TextView tv_rabbit,tv_cat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        //ánh xạ
        iv_rabbit=findViewById(R.id.iv_rabbit);
        iv_cat=findViewById(R.id.iv_cat);
        tv_rabbit=findViewById(R.id.tv_rabbit);
        tv_cat=findViewById(R.id.tv_cat);
    }
}