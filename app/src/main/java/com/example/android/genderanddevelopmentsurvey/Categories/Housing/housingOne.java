package com.example.android.genderanddevelopmentsurvey.Categories.Housing;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.android.genderanddevelopmentsurvey.R;

public class housingOne extends AppCompatActivity {

    String sHouseholdMember;
    Intent iHousing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_housing_one);

//        Get extra
        iHousing = getIntent();
        sHouseholdMember = iHousing.getExtras().getString("householdMem");

//        name the toolbar
        this.setTitle("Housing: " + sHouseholdMember);
    }
}
