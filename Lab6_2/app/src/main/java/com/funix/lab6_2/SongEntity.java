package com.funix.lab6_2;

public class SongEntity {
    private String name, path, album;
    private int rawResourceId;

    public SongEntity(String name, String path, String album,int rawResourceId) {
        this.name = name;
        this.path = path;
        this.album = album;
        this.rawResourceId=rawResourceId;
    }

    public int getRawResourceId() {
        return rawResourceId;
    }

    public String getName() {
        return name;
    }

    public String getPath() {
        return path;
    }

    public String getAlbum() {
        return album;
    }

}
