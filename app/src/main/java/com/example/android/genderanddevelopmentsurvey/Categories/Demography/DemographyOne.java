package com.example.android.genderanddevelopmentsurvey.Categories.Demography;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.example.android.genderanddevelopmentsurvey.R;

public class DemographyOne extends AppCompatActivity {
    String householdMember;
    String getHouseholdMembersAge;
    Intent frCategoryActivityIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demography_one);

        Button BtnDem2 = (Button) findViewById(R.id.BtnDemOne);

//        Get Data, data expected from CategoryActivity: clicked household members name
        frCategoryActivityIntent = getIntent();
        householdMember = frCategoryActivityIntent.getExtras().getString("householdMem");

//        Change the name of the toolbar to the name of the household member
        this.setTitle("Demography: " + householdMember);

//        TextView tv_relation = (TextView) findViewById(R.id.tv_relation);
//        TextView tv_gender = (TextView) findViewById(R.id.tv_gender);
//        TextView tv_birth = (TextView) findViewById(R.id.tv_birth);
//        TextView tv_reg = (TextView) findViewById(R.id.tv_reg);

//        Questions pass to the TextView
//        tv_relation.setText("What's " + householdMember + "'s relationship to the head of the household?");
//        tv_gender.setText(householdMember + "'s gender?");
//        tv_birth.setText("When's " + householdMember + "'s date of birth?");
//        tv_reg.setText("Was " + householdMember + "'s birth registered with the local civil registrar?");

//        What is your ralationship to the head of the household? Spinner
        Spinner demQTwoSpinner = (Spinner) findViewById(R.id.demQOneSpinner);

        ArrayAdapter<String> demQTwoArrAdp = new ArrayAdapter<>(DemographyOne.this,
                android.R.layout.simple_list_item_1, getResources()
                .getStringArray(R.array.DemographySp1));
        demQTwoArrAdp.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        demQTwoSpinner.setAdapter(demQTwoArrAdp);

//        Send householdMembers name and open next activity
        BtnDem2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                frCategoryActivityIntent = new Intent(DemographyOne.this, DemographyTwo.class);
                frCategoryActivityIntent.putExtra("householdMem", householdMember);
                frCategoryActivityIntent.putExtra("Age", getHouseholdMembersAge);
                startActivity(frCategoryActivityIntent);
            }
        });
    }
//    TODO: Store to database: Relationship, gender, birthdate, age, birth registration YES/NO
//    TODO: Use the age stored in the database to test if it's more than 15, if it is additional questions(EducationAndLiteratureTwo) will be presented
}
