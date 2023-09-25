package com.funix.lab6_1;

public class Music {
    private int img;
    private String musicName;

    public Music(int img,String musicName) {
        this.img = img;
        this.musicName=musicName;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getMusicName() {
        return musicName;
    }

    public void setMusicName(String musicName) {
        this.musicName = musicName;
    }
}
