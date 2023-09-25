package com.example.lab3_9;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final int[] ID_DRAWABLES = {R.drawable.ic_mess, R.drawable.ic_flight, R.drawable.ic_hospital,
            R.drawable.ic_hotel, R.drawable.ic_restaurant, R.drawable.ic_coctail,
            R.drawable.ic_store, R.drawable.ic_at_work, R.drawable.ic_time, R.drawable.ic_education, R.drawable.ic_movie};
    private static final int[] ID_TEXTS = {R.string.txt_mess, R.string.txt_flight, R.string.txt_hospital,
            R.string.txt_hotel, R.string.txt_restaurant, R.string.txt_coctail,
            R.string.txt_store, R.string.txt_work, R.string.txt_time, R.string.txt_education, R.string.txt_movie};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }
    private void initView(){
        //khai báo và ánh xạ các biến giao diện
        LinearLayout lnMain=findViewById(R.id.ln_main);
        lnMain.removeAllViews();
        //Tạo ra cacsitem topic và add vào LinearLayout
        for(int i=0;i<ID_DRAWABLES.length;i++){
            View v=LayoutInflater.from(this).inflate(R.layout.item_topic,null);
            ImageView ivTopic=v.findViewById(R.id.iv_topic);
            TextView tvTopic=v.findViewById(R.id.tv_topic);
            ivTopic.setImageResource(ID_DRAWABLES[i]);
            tvTopic.setText(ID_TEXTS[i]);
            //quy định không gian chiếm của mỗi item view=1
            LinearLayout.LayoutParams param=new LinearLayout.LayoutParams(//LinearLayout.LayoutParams để lưu trữ các thông số layout
                 //Đặt chiều cao và chiều rộng của phần tử tương ứng
                    LinearLayout.LayoutParams.MATCH_PARENT,
                 LinearLayout.LayoutParams.MATCH_PARENT,
                 1.0f//đại diện cho trọng số (weight) của phần tử trong LinearLayout
            );
            v.setLayoutParams(param);
            lnMain.addView(v);
        }
    }

}