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

import com.example.android.genderanddevelopmentsurvey.R;
import com.example.android.genderanddevelopmentsurvey.dbHelper;

public class DemographyOne extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    String householdMember;
    String getHouseholdMembersAge;
    Intent frCategoryActivityIntent;
    dbHelper dbAccess;
    String rg_result;
    String selectedRel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demography_one);

        Button BtnDem2 = (Button) findViewById(R.id.BtnDemOne);
        RadioGroup rg_relation = (RadioGroup) findViewById(R.id.rg_relation);
//        RadioButton rb_yes = (RadioButton) findViewById(R.id.rb_yes);
//        RadioButton rb_no = (RadioButton) findViewById(R.id.rb_no);


//        Get Data, data expected from CategoryActivity: clicked household members name
        frCategoryActivityIntent = getIntent();
        householdMember = frCategoryActivityIntent.getExtras().getString("householdMem");

//        Change the name of the toolbar to the name of the household member
        this.setTitle("Demography: " + householdMember);

//        What is your ralationship to the head of the household? Spinner
        Spinner demQTwoSpinner = (Spinner) findViewById(R.id.demQOneSpinner);

        ArrayAdapter<String> demQTwoArrAdp = new ArrayAdapter<>(DemographyOne.this,
                android.R.layout.simple_list_item_1, getResources()
                .getStringArray(R.array.DemographySp1));
        demQTwoArrAdp.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        demQTwoSpinner.setAdapter(demQTwoArrAdp);
        demQTwoSpinner.setOnItemSelectedListener(this);

        int checkedRbId = rg_relation.getCheckedRadioButtonId();
        rg_relation.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                RadioButton radioButton = (RadioButton) findViewById(checkedId);
                rg_result = radioButton.getText().toString();
            }
        });

//        database instance
        dbAccess = new dbHelper(this);

//        Send householdMembers name and open next activity
        BtnDem2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbAccess.updateOne(householdMember, selectedRel, rg_result);
                frCategoryActivityIntent = new Intent(DemographyOne.this, DemographyTwo.class);
                frCategoryActivityIntent.putExtra("householdMem", householdMember);
                frCategoryActivityIntent.putExtra("Age", getHouseholdMembersAge);
                startActivity(frCategoryActivityIntent);
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        TextView selected = (TextView) view;
        selectedRel = selected.getText().toString(); // convert to string, the picked relation to head spinner
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

//    TODO: Use the age stored in the database to test if it's more than 15, if it is additional questions(EducationAndLiteratureTwo) will be presented
}
