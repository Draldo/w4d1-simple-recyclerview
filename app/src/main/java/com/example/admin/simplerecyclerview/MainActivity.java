package com.example.admin.simplerecyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerview;

    private ArrayList<String> mArrayStr;
    private simpleAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mArrayStr = new ArrayList<>();
        mArrayStr.add("Aldo");
        mArrayStr.add("Libu");
        mArrayStr.add("Chris");
        mArrayStr.add("Mike");
        mArrayStr.add("Karles");

        mAdapter = new simpleAdapter(getApplicationContext(),mArrayStr);

        mRecyclerview = (RecyclerView) findViewById(R.id.a_main_recycler);
        mRecyclerview.setAdapter(mAdapter);
        mRecyclerview.setLayoutManager(new LinearLayoutManager(this));
    }
}
