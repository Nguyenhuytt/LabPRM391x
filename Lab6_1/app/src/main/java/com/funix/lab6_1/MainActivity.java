package com.funix.lab6_1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
     RecyclerView recyclerView;
     MusicAdapter musicAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        List<Music>list=getListData();
       musicAdapter=new MusicAdapter(this,list);
        recyclerView=findViewById(R.id.rv_song);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
        //set giao diện cho recyclerview
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(musicAdapter);

    }

    private List<Music> getListData() {
        List<Music>list=new ArrayList<>();
        list.add(new Music(R.drawable.ic_music,"Hoa Cỏ Mùa Xuân"));
        list.add(new Music(R.drawable.ic_music,"Con Bướm Xuân"));
        list.add(new Music(R.drawable.ic_music,"Đường Về Quê"));
        list.add(new Music(R.drawable.ic_music,"Ngày Tết Quê Em"));
        list.add(new Music(R.drawable.ic_music,"Mùa Xuân ơi"));
        list.add(new Music(R.drawable.ic_music,"Khúc Nhạc Vui"));
        list.add(new Music(R.drawable.ic_music,"Xuân Đã Về"));
        list.add(new Music(R.drawable.ic_music,"Thần Tài Đến"));
        return list;
    }
}