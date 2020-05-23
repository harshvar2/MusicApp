package com.example.application.musicalapp;


import android.os.Bundle;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {
    private ArrayList<MusicItem> musicItems = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = findViewById(R.id.all_songs_list);

        musicItems.add(new MusicItem("Say Something", " Justin Timberlake feat. Chris", 0));
        musicItems.add(new MusicItem("Lottery", "Jade Bird", 2));
        musicItems.add(new MusicItem("Pristine ", "Snail Mail", 4));
        musicItems.add(new MusicItem("Call out my Name", "The Weeknd", 1));
        musicItems.add(new MusicItem("love lies", "Khalid & Normani", 2));
        musicItems.add(new MusicItem("Bad bad news", "Leon Bridges",  0));
        musicItems.add(new MusicItem("Friends", "Marshmello & Anne-Marie",  3));
        musicItems.add(new MusicItem("Fake-love", " BTS", 1));
        musicItems.add(new MusicItem("Done for me", "Charlie Puth feat. Kehlani",  2));
        musicItems.add(new MusicItem("Stri fry", "Migos",  0));
        MusicListAdapter musicListAdapter = new MusicListAdapter(this, musicItems);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(musicListAdapter);



    }
}
