package com.defretes.myapputs;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.GsonBuilder;
import com.squareup.picasso.Picasso;

public class Detail_filem extends AppCompatActivity {

    ImageView Poster;
    TextView Judul, Rating, Tgl, Overview;

    Result result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_filem);

        Poster = (ImageView)findViewById(R.id.imgPoster);
        Judul = (TextView)findViewById(R.id.tv_judul);
        Rating = (TextView)findViewById(R.id.tv_rating);
        Tgl = (TextView)findViewById(R.id.tv_tgl);
        Overview = (TextView)findViewById(R.id.tv_overview);

        result = new GsonBuilder()
                .create()
                .fromJson(getIntent().getStringExtra("movie"), Result.class);

        Picasso.with(Detail_filem.this)
                .load("http://image.tmdb.org/t/p/w185/"+result.getPosterPath())
                .into(Poster);

        Judul.setText(result.getTitle());
        Rating.setText("Rating : "+Double.toString(result.getVoteAverage()));
        Tgl.setText("Tgl Rilis : "+result.getReleaseDate());
        Overview.setText(result.getOverview());
    }
}
