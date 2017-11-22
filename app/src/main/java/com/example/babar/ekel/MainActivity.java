package com.example.babar.ekel;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends FragmentActivity {

    TextView textView;
    private ArrayList<String> mealNames;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mealNames = new ArrayList<>();

        textView = findViewById(R.id.testTextView);
        fetchData();
    }

    private void fetchData() {
        String urlString = "http://10.0.2.2:8080/get/meal/all";
        Ion.with(this).load(urlString).asString().setCallback(new FutureCallback<String>() {
            @Override
            public void onCompleted(Exception e, String result) {
                try {
                    JSONObject json = new JSONObject(result);
                    processData(json);
                } catch (JSONException e1) {
                    e1.printStackTrace();
                }
            }
        });
    }

    private void processData(JSONObject json) {
        try {
            JSONArray array = json.getJSONArray("content");

            for (int i = 0; i<array.length(); i++){
                JSONObject o = array.getJSONObject(i);
                 mealNames.add(o.getString("mealName"));
            }
            final StringBuilder last = new StringBuilder();
            for (String s: mealNames){
                last.append(s).append(" ");
            }
            Log.i("LOL","Joke is");
            textView.post(new Runnable() {
                @Override
                public void run() {
                    textView.setText(last);
                }
            });
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

}
