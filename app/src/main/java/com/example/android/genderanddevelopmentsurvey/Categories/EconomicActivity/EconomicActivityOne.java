package com.example.android.genderanddevelopmentsurvey.Categories.EconomicActivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.example.android.genderanddevelopmentsurvey.R;

public class EconomicActivityOne extends AppCompatActivity {

    String householdMember;
    Intent iEconomicActivity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_economic_one);

//        Receive household members name
        iEconomicActivity = getIntent();
        householdMember = iEconomicActivity.getExtras().getString("householdMem");

//        name the toolbar
        this.setTitle("Economic: " + householdMember);

        Spinner spn_workingHours = (Spinner) findViewById(R.id.spn_workingHours);
        Spinner spn_natureOfWork = (Spinner) findViewById(R.id.spn_natureOfWork);
        Spinner spn_industry = (Spinner) findViewById(R.id.spn_industry);
        Button btn_next = (Button) findViewById(R.id.btn_next);

//        Adapter for Spinner: average working hours
        ArrayAdapter<String> econoAdapter = new ArrayAdapter<>(EconomicActivityOne.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.workingHours));
        econoAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spn_workingHours.setAdapter(econoAdapter);

//        Adapter for Spinner: nature of employment
        econoAdapter = new ArrayAdapter<>(EconomicActivityOne.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.natureOfEmployment));
        econoAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spn_natureOfWork.setAdapter(econoAdapter);

//        Adapter for Spinner: Industry
        econoAdapter = new ArrayAdapter<>(EconomicActivityOne.this, android.R.layout.simple_list_item_1,
                getResources().getStringArray(R.array.industry));
        econoAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spn_industry.setAdapter(econoAdapter);

//        Next button
        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iEconomicActivity = new Intent(EconomicActivityOne.this, economicActivityTwo.class);
                iEconomicActivity.putExtra("householdMem", householdMember);
                startActivity(iEconomicActivity);
            }
        });
    }
}
