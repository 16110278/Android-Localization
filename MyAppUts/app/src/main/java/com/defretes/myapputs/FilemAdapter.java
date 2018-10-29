package com.defretes.myapputs;


import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.GsonBuilder;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import java.util.List;

public class FilemAdapter extends RecyclerView.Adapter<FilemAdapter.FilemHolder> {
    List<Result> results;

    public FilemAdapter(List<Result> results) {
        this.results = results;
    }

    @NonNull
    @Override
    public FilemHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.daftar_filem, viewGroup, false);
        return new FilemHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final FilemHolder holder, final int i) {
        Picasso.with(holder.itemView.getContext())
                .load("http://image.tmdb.org/t/p/w185/"+results.get(i).getPosterPath())
                .into(holder.Poster);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Result data = results.get(i);
                Intent j = new Intent(holder.itemView.getContext(), Detail_filem.class);
                j.putExtra("movie", new GsonBuilder().create().toJson(data));
                holder.itemView.getContext().startActivity(j);
            }
        });
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }

    @Override
    public int getItemCount() {
        return results.size();
    }

    class FilemHolder extends RecyclerView.ViewHolder{
        ImageView Poster;
        public FilemHolder(@NonNull View itemView) {
            super(itemView);
            Poster = (ImageView)itemView.findViewById(R.id.imgPoster);
        }
    }

}
