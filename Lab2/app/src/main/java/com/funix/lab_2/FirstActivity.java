package com.funix.lab_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class FirstActivity extends AppCompatActivity {
    //khái báo các biến giao diện
    private static final String soa="soa";
    Button bt_first;
    EditText edt_first;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        //ánh xạ
        bt_first=findViewById(R.id.button);
        edt_first=findViewById(R.id.edt_first);
        bt_first.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(FirstActivity.this,SecondActivity.class);
                Bundle bundle=new Bundle();
                String a=edt_first.getText().toString();
                bundle.putString("soa",a);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }
}