package com.example.paul.paul_heijen_pset3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    EditText searchfield;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        searchfield = (EditText) findViewById(R.id.searchfield);
        Log.d("logchecker:", "aap");
        assert searchfield != null;
        searchfield.setHint("Search for a song");
    }

    public void trackSearch(View view){
        String trackSearch = searchfield.getText().toString();

        TrackAsyncTask asynctask = new TrackAsyncTask(this);
        asynctask.execute(trackSearch);

        searchfield.getText().clear();

    }

    public void trackStartIntent(ArrayList<String> trackData){
        Intent dataIntent = new Intent(this, DataActivity.class);
        dataIntent.putExtra("data",trackData);
        this.startActivity(dataIntent);


    }

    public void goSongs(View view) {
        Intent gaIntent = new Intent(this, savedSongsActivity.class);
        this.startActivity(gaIntent);
    }






}

