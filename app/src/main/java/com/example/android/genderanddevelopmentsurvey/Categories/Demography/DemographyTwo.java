package com.example.android.genderanddevelopmentsurvey.Categories.Demography;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.android.genderanddevelopmentsurvey.Categories.Category;
import com.example.android.genderanddevelopmentsurvey.R;
import com.example.android.genderanddevelopmentsurvey.dbHelper;

public class DemographyTwo extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Intent demographyTwoIntent;
    String sCivilStatus;
    String sReligiousAff;
    String sIndigenous;
    String householdMember, householdMembersAge;
    dbHelper dbAccess;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demography_two);

//        Get data from DemographyOne: household members name
        demographyTwoIntent = getIntent();
        householdMember = demographyTwoIntent.getExtras().getString("householdMem");
        householdMembersAge = demographyTwoIntent.getExtras().getString("Age");

//        Set the toolbar to display the household members name
        this.setTitle("Demography: " + householdMember);

        Button BtnDemTwo = (Button) findViewById(R.id.BtnDemTwo);
        RadioGroup rg_indigenous = (RadioGroup) findViewById(R.id.rg_indigenous);

//        What is your marital/civil status? Spinner
        Spinner demQTwoSpinner = (Spinner) findViewById(R.id.demQTwoSpinner);
        ArrayAdapter<String> demQTwoArrAdp = new ArrayAdapter<>(DemographyTwo.this,
                android.R.layout.simple_list_item_1, getResources()
                .getStringArray(R.array.DemographySp2));
        demQTwoArrAdp.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        demQTwoSpinner.setAdapter(demQTwoArrAdp);
        demQTwoSpinner.setOnItemSelectedListener(this);

//        What is your religious affiliation? Spinner
        Spinner DemQTwoSpinner2 = (Spinner) findViewById(R.id.DemQTwoSpinner2);
        demQTwoArrAdp = new ArrayAdapter<>(DemographyTwo.this,
                android.R.layout.simple_list_item_1, getResources()
                .getStringArray(R.array.DemographySp3));
        demQTwoArrAdp.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        DemQTwoSpinner2.setAdapter(demQTwoArrAdp);
        DemQTwoSpinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                TextView religiousAff = (TextView) view;
                sReligiousAff = religiousAff.getText().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

//        database instance
        dbAccess = new dbHelper(this);

//        listener for the radiogoup rg_indigenous
        rg_indigenous.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                RadioButton radioButton = (RadioButton) findViewById(checkedId);
                sIndigenous = radioButton.getText().toString();
            }
        });

        BtnDemTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbAccess.updateDemTwo(householdMember, sCivilStatus, sReligiousAff, sIndigenous);
                demographyTwoIntent = new Intent(DemographyTwo.this, Category.class);
                demographyTwoIntent.putExtra("householdMem", householdMember);
                demographyTwoIntent.putExtra("Age", householdMembersAge);
                startActivity(demographyTwoIntent);
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        TextView civilStatus = (TextView) view;
        sCivilStatus = civilStatus.getText().toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
