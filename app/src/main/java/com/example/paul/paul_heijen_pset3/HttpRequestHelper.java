package com.example.paul.paul_heijen_pset3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import android.widget.Toast;
import android.util.Log;


/**
 * Created by Paul on 06/03/2017.
 */

public class HttpRequestHelper {

    protected static synchronized String downloadFromServer(String... params){
        String result = "";
        String chosenTag = params[0];

//        String stringUrl = "http://www.omdbapi.com/?s=" + chosenTag;
//        String stringUrl = "https://api.themoviedb.org/3/movie/550?api_key=655ead75054f582727060a427eea7c26&query=" + chosenTag;
        String stringUrl = "http://ws.audioscrobbler.com/2.0/?method=track.search&track="+chosenTag+"&api_key=94501f7137ae9f1b17d720cf606af076&format=json";

        URL url = null;
        try {
            url = new URL(stringUrl);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        //creeer geldige url

        //maak van url object

        HttpURLConnection connect;

        if (url != null) {
            try{
                connect = (HttpURLConnection) url.openConnection();
                connect.setRequestMethod("GET");

                Integer responseCode = connect.getResponseCode();
                Log.d("responsecode: ",responseCode.toString());
                if (responseCode >= 200 && responseCode < 300){
                    BufferedReader bReader = new BufferedReader(new InputStreamReader(connect.getInputStream()));
                    String line;
                    while((line = bReader.readLine()) != null) {
                        result += line;
                    }
                }
            } catch(IOException e) {
                e.printStackTrace();
            }


        }
        Log.d("JSONresulter:",result);
        return result;

    }


}
