package com.example.application.musicalapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MusicListAdapter extends RecyclerView.Adapter<MusicListAdapter.MusicViewHolder> {

    private Context context;
    private ArrayList<MusicItem> musicItems;

    MusicListAdapter(Context context, ArrayList<MusicItem> musicItems) {
        this.context = context;
        this.musicItems = musicItems;
    }


    @NonNull
    @Override
    public MusicListAdapter.MusicViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_item,parent,false);
        return new MusicViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MusicListAdapter.MusicViewHolder holder, int position) {

        final MusicItem musicItem = musicItems.get(position);

        holder.base.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("name",holder.name.getText().toString());
                intent.putExtra("artist",holder.artist.getText().toString());
                intent.putExtra("artist_id",musicItem.getArtist_id());
                intent.setClass(context,MusicPlayer.class);
                context.startActivity(intent);
            }
        });

        holder.name.setText(musicItem.getName());
        holder.artist.setText(musicItem.getArtist());
        int artist_id = musicItem.getArtist_id();

        switch (artist_id) {
            case 0:
                holder.thumbnail.setImageResource(R.drawable.believer);
                break;

            case 1:
                holder.thumbnail.setImageResource(R.drawable.alan);
                break;

            case 2:
                holder.thumbnail.setImageResource(R.drawable.thescore);
                break;

            case 3:
                holder.thumbnail.setImageResource(R.drawable.unlikely);
                break;

            case 4:
                holder.thumbnail.setImageResource(R.drawable.amau);
                break;

            default:
                break;
        }

    }

    @Override
    public int getItemCount() {
        return musicItems.size();
    }

    static class MusicViewHolder extends RecyclerView.ViewHolder{
        private TextView name;
        private TextView artist;
        private ImageView thumbnail;
        private RelativeLayout base;

        MusicViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            artist = itemView.findViewById(R.id.artist);
            thumbnail  = itemView.findViewById(R.id.thumbnail);
            base = itemView.findViewById(R.id.base);
        }
    }
}
