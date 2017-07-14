package com.example.android.genderanddevelopmentsurvey;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;

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

    }
}
