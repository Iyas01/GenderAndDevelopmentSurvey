package com.example.android.genderanddevelopmentsurvey;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;
import java.util.Arrays;

public class BMainActivity extends AppCompatActivity {

    private ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmain);

//        Setting up the ListView and OnItemClickListener
        ArrayList<String> arrayBarangay = new ArrayList<>();
        arrayBarangay.addAll(Arrays.asList(getResources().getStringArray(R.array.array_barangay)));

        adapter = new ArrayAdapter<>(
                BMainActivity.this,
                android.R.layout.simple_list_item_1,
                arrayBarangay
        );

        final ListView listView = (ListView) findViewById(R.id.lv_barangay);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//          Get the clicked item on the ListView then display it on the next Activity
                Intent intent = new Intent(BMainActivity.this, CMainActivity.class);
                intent.putExtra("barangayName", listView.getItemAtPosition(position).toString());
                startActivity(intent);
            }
        });
        listView.setAdapter(adapter);

//        Setting up the SearchView Filter
        SearchView searchView = (SearchView) findViewById(R.id.sv_barangay);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return false;
            }
        });

    }
}
