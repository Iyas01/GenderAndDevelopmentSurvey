package com.example.android.genderanddevelopmentsurvey.Categories.Demography;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.android.genderanddevelopmentsurvey.Categories.Category;
import com.example.android.genderanddevelopmentsurvey.R;

public class DemographyTwo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demography_two);

//        Get data from DemographyOne: household members name
        final Intent getHouseholdNameAndAge = getIntent();
        final String householdMember = getHouseholdNameAndAge.getExtras().getString("householdMem");
        final String householdMembersAge = getHouseholdNameAndAge.getExtras().getString("Age");

        TextView tv_cs = (TextView) findViewById(R.id.tv_cs);
        TextView tv_religion = (TextView) findViewById(R.id.tv_religion);
        TextView tv_tribe = (TextView) findViewById(R.id.tv_tribe);
        Button BtnDemTwo = (Button) findViewById(R.id.BtnDemTwo);

//        Set TextViews with the ff questions
        tv_cs.setText("What's " + householdMember + "'s marital/civil status?");
        tv_religion.setText("What's " + householdMember + "'s religious affiliation?");
        tv_tribe.setText("Does " + householdMember + " belong to any indigenous tribe");

//        What is your marital/civil status? Spinner
        Spinner demQTwoSpinner = (Spinner) findViewById(R.id.demQTwoSpinner);
        ArrayAdapter<String> demQTwoArrAdp = new ArrayAdapter<>(DemographyTwo.this,
                android.R.layout.simple_list_item_1, getResources()
                .getStringArray(R.array.DemographySp2));
        demQTwoArrAdp.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        demQTwoSpinner.setAdapter(demQTwoArrAdp);

//        What is your religious affiliation? Spinner
        Spinner DemQTwoSpinner2 = (Spinner) findViewById(R.id.DemQTwoSpinner2);
        demQTwoArrAdp = new ArrayAdapter<>(DemographyTwo.this,
                android.R.layout.simple_list_item_1, getResources()
                .getStringArray(R.array.DemographySp3));
        demQTwoArrAdp.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        DemQTwoSpinner2.setAdapter(demQTwoArrAdp);

        BtnDemTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentDem = new Intent(DemographyTwo.this, Category.class);
                intentDem.putExtra("householdMem", householdMember);
                if (householdMembersAge != null)
                    intentDem.putExtra("Age", householdMembersAge);
                startActivity(intentDem);
            }
        });
    }
}
