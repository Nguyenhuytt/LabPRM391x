package com.example.lab3_4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.view.animation.AnimationUtils;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    //khai báo biến gaio diện
    private ImageView ivAnimal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       initViews();
    }
    private void initViews(){
        ivAnimal=findViewById(R.id.iv_animal);
        findViewById(R.id.bt_alpha).setOnClickListener(this);
        findViewById(R.id.bt_rotate).setOnClickListener(this);
        findViewById(R.id.bt_scale).setOnClickListener(this);
        findViewById(R.id.bt_trans).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
    if(v.getId()==R.id.bt_alpha){
       ivAnimal.startAnimation(AnimationUtils.loadAnimation(this,R.anim.alpha));
    }else if (v.getId() == R.id.bt_rotate) {
        ivAnimal.startAnimation(AnimationUtils.loadAnimation(this, R.anim.rotate));
    } else if (v.getId() == R.id.bt_scale) {
        ivAnimal.startAnimation(AnimationUtils.loadAnimation(this, R.anim.scale));
    } else if (v.getId() == R.id.bt_trans) {
        ivAnimal.startAnimation(AnimationUtils.loadAnimation(this, R.anim.translate));
    }
    }
}