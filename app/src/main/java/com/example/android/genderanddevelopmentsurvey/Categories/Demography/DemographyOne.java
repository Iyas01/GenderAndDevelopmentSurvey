package com.example.android.genderanddevelopmentsurvey.Categories.Demography;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.android.genderanddevelopmentsurvey.R;

public class DemographyOne extends AppCompatActivity {
    String householdMember;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demography_one);

//        Data expected from CategoryActivity: clicked household members name
        Intent frCategoryActivityIntent = getIntent();
        householdMember = frCategoryActivityIntent.getExtras().getString("householdMem");

        TextView tv_rel = (TextView) findViewById(R.id.tv_rel);
        TextView tv_gender = (TextView) findViewById(R.id.tv_gender);
        TextView tv_birth = (TextView) findViewById(R.id.tv_birth);
        TextView tv_civ = (TextView) findViewById(R.id.tv_civ);

        tv_rel.append(householdMember + "relationship to the head of the household?");
        tv_gender.append(householdMember + "gender?");
        tv_birth.append(householdMember + "date of birth?");
        tv_civ.append(householdMember + "birth registered with the local civil registrar?");

    }
}
