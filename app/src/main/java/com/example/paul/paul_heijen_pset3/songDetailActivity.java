package com.example.paul.paul_heijen_pset3;

/**
 * Created by Paul on 18/09/2017.
 */

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;



public class songDetailActivity extends AppCompatActivity {
    TextView textview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_detail);

        Bundle extras = getIntent().getExtras();
        String songTitle = (String) extras.getString("songTitle");
        textview = (TextView) findViewById(R.id.movieName);
        textview.setText(songTitle);

    }


    public void keepSong(View view) {
        Intent movieIntent = new Intent(this, savedSongsActivity.class);
        movieIntent.putExtra("movie", textview.getText());
        this.startActivity(movieIntent);
    }

    public void goSongs(View view) {
        Intent movieIntent = new Intent(this, savedSongsActivity.class);
        this.startActivity(movieIntent);
    }
}