package com.example.lab1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;

public class SecondActivity extends AppCompatActivity {


    private final int max_size = 100000;
    Converter[] list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        ListView listView = (ListView) findViewById(R.id.listView);
        list = new Converter[max_size];
        fillArray();
        ListAdapter adapter = new MyArrayAdapter(this, R.layout.items, list);
        listView.setAdapter(adapter);
    }
    public void fillArray()
    {
        for(int i = 1; i <= max_size; i++)
        {
            Converter item = new Converter(i);
            list[i - 1] = item;
        }
    }
}
