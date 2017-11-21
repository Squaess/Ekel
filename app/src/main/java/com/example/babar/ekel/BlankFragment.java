package com.example.babar.ekel;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.babar.ekel.MyListView.CustomAdapter;
import com.example.babar.ekel.MyListView.DataModel;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment extends Fragment {

    private ListView listView;
    ArrayList<DataModel> dataModels;
    private static CustomAdapter adapter;

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
        dataModels.add(new DataModel("Spaghetti","12"));
        dataModels.add(new DataModel("aaaaaaaaa","12"));
        dataModels.add(new DataModel("sssssssss","12"));
        dataModels.add(new DataModel("ddddddddd","12"));
        dataModels.add(new DataModel("Spaghetti","12"));
        dataModels.add(new DataModel("fffffffff","12"));
        dataModels.add(new DataModel("Spaghetti","12"));
        dataModels.add(new DataModel("ggggggggg","12"));
        dataModels.add(new DataModel("Spaghetti","12"));
        dataModels.add(new DataModel("Spaghetti","12"));
        dataModels.add(new DataModel("Spaghetti","22"));
        dataModels.add(new DataModel("Spaghetti","33.8"));
        dataModels.add(new DataModel("Spaghetti","12"));
        dataModels.add(new DataModel("Spaghetti","1234"));
        dataModels.add(new DataModel("Spaghetti","234"));
        dataModels.add(new DataModel("Spaghetti","12"));
        dataModels.add(new DataModel("Spaghetti","3456"));
        dataModels.add(new DataModel("Spaghetti","12"));
        dataModels.add(new DataModel("Spaghetti","12"));
        dataModels.add(new DataModel("Spaghetti","12"));
        dataModels.add(new DataModel("Spaghetti","12"));
        dataModels.add(new DataModel("Spaghetti","12"));
        dataModels.add(new DataModel("Spaghetti","12"));
        dataModels.add(new DataModel("Spaghetti","12"));
        dataModels.add(new DataModel("Spaghetti","12"));
        dataModels.add(new DataModel("Spaghetti","12"));
        dataModels.add(new DataModel("Spaghetti","12"));
        dataModels.add(new DataModel("Spaghetti","12"));
        dataModels.add(new DataModel("Spaghetti","12"));
        dataModels.add(new DataModel("Spaghetti","12"));
        dataModels.add(new DataModel("Spaghetti","12"));
        dataModels.add(new DataModel("Spaghetti","12"));
        dataModels.add(new DataModel("Spaghetti","12"));
        dataModels.add(new DataModel("Spaghetti","12"));
        dataModels.add(new DataModel("Spaghetti","12"));
        dataModels.add(new DataModel("Spaghetti","12"));
        dataModels.add(new DataModel("Spaghetti","12"));
        dataModels.add(new DataModel("Spaghetti","12"));
        dataModels.add(new DataModel("Spaghetti","12"));
        dataModels.add(new DataModel("Spaghetti","12"));
        dataModels.add(new DataModel("Spaghetti","12"));

        adapter = new CustomAdapter(dataModels, getContext().getApplicationContext());
        listView.setAdapter(adapter);


    }


}