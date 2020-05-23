package com.example.application.musicalapp;

public class MusicItem {
    private String name;
    private String artist;
    private int artist_id;
    MusicItem(String name, String artist, int artist_id)
    {
        this.name=name;
        this.artist=artist;
        this.artist_id=artist_id;
        this.artist=artist;

    }
    int getArtist_id(){
        return this.artist_id;
    }
    public String getName(){
        return this.name;
    }
    String getArtist(){
        return this.artist;
    }

}
