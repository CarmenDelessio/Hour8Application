package com.bffmedia.hour8application;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


public class ArrayAdapterActivity extends Activity {
    ListView pieListView;
    String[] pies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Resources resources = getResources();
        pies = resources.getStringArray(R.array.pie_array);
        pieListView = (ListView) findViewById(R.id.listView);
        pieListView.setAdapter(new ArrayAdapter<String>(this,
                R.layout.text_view_item, pies));
        pieListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),
                        pies[position], Toast.LENGTH_SHORT).show();
            }
        });
    }


}
