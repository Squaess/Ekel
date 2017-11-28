package com.example.babar.ekel;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.babar.ekel.MyListView.CustomAdapter;
import com.example.babar.ekel.MyListView.DataModel;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment extends Fragment {

    private ListView listView;
    private ArrayList<DataModel> dataModels;
    private static CustomAdapter adapter;

    public static final String BASE_URL = "localhost:8080/";

    public BlankFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_blank, container, false);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        listView = getActivity().findViewById(R.id.fragment_listView);
        dataModels = new ArrayList<>();
        fetchData();

        adapter = new CustomAdapter(dataModels, getContext().getApplicationContext());
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                DataModel dataModel = dataModels.get(i);

                Toast.makeText(getContext(), dataModel.getMealId()+" "+
                        dataModel.getName(), Toast.LENGTH_SHORT).show();
            }
        });

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

            for (int i = 0; i<array.length(); i++) {
                JSONObject o = array.getJSONObject(i);
                DataModel dataModel = new DataModel(o.getBoolean("available"), o.getInt("mealId"),
                        o.getString("mealName"), o.getString("price"));
                dataModels.add(dataModel);
            }
            Log.i("LOL","Joke is"+" "+ dataModels.get(0).getPrice());
            adapter.notifyDataSetChanged();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

}