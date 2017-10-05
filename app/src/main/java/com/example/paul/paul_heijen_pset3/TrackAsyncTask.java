package com.example.paul.paul_heijen_pset3;

import android.os.AsyncTask;
import android.content.Context;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by Paul on 06/03/2017.
 */

public class TrackAsyncTask extends AsyncTask<String, Integer, String> {
    Context context;
    MainActivity mainAct;

    public TrackAsyncTask(MainActivity main){
        this.mainAct = main;
        this.context = this.mainAct.getApplicationContext();

    }

    @Override
    protected void onPreExecute(){
        Toast.makeText(context, "Searching for tracks...", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected String doInBackground(String... params){
        return HttpRequestHelper.downloadFromServer(params);
    }

    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);
        ArrayList<String> results = new ArrayList<String>();

        String title = "";
        String artist = "";
        JSONObject resultlist = null;
        JSONObject resultElem = null;
        JSONObject trackmatches = null;
        JSONArray reslist = null;

        try {

            //JSONObject trackStreamObj = new JSONObject(result);
            JSONObject trackStreamObj = new JSONObject(result);
//            JSONObject resultObject = trackStreamObj.getJSONObject("Search");
//            JSONArray res1 = trackStreamObj.getJSONArray("results");

            resultlist = trackStreamObj.getJSONObject("results");
            trackmatches = resultlist.getJSONObject("trackmatches");
            reslist = trackmatches.getJSONArray("track");

            Log.d("resultlister:",reslist.toString());
            for(int i=0; i<reslist.length(); i++) {
                resultElem = reslist.getJSONObject(i);
                title = resultElem.getString("name");
                artist =  resultElem.getString("artist");
                results.add(title + " - " + artist);
            }





        } catch (JSONException e) {
            e.printStackTrace();
        }
        this.mainAct.trackStartIntent(results);

    }


}
