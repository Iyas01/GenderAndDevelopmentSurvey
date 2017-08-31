package com.example.android.genderanddevelopmentsurvey.Categories.EducationAndLiteracy;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.android.genderanddevelopmentsurvey.Person;
import com.example.android.genderanddevelopmentsurvey.R;

public class EducationAndLiteracyOne extends AppCompatActivity {

    private static final String TAG = "EducationAndLiteracy";

    String householdMember;
    Intent frAnotherActivity;
    TextView tv_edLitFour;
    ArrayAdapter<String> edLitSpnAdapter;
    TextView tv_fifteenPlus;
    int intHouseholdMembersAge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_education_and_literacy_one);

//        Get the household name from either DMainActivity/DemographyTwo
        frAnotherActivity = getIntent();
        householdMember = frAnotherActivity.getExtras().getString("householdMem");
//        Get the Age to determine if household member is age 15 or above. Age 15 and above gets additional questions
//        householdMembersAge = frAnotherActivity.getExtras().getString("Age");

//        Display the name of the household member to the action bar
        this.setTitle("Education: " + householdMember);

//        get household members age
        Person person = new Person();
        intHouseholdMembersAge = person.get_age();
//        intHouseholdMembersAge = Integer.parseInt(householdMembersAge);

        tv_edLitFour = (TextView) findViewById(R.id.tv_edLitFour);
        tv_fifteenPlus = (TextView) findViewById(R.id.tv_fifteenPlus);

        //            Btn_edLit.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    frAnotherActivity = new Intent(EducationAndLiteracyOne.this, educationAndLiteracyTwo.class);
//                    frAnotherActivity.putExtra("householdMem", householdMember);
//                    startActivity(frAnotherActivity);
//                }
//            });
        //            Btn_edLit2.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    frAnotherActivity = new Intent(EducationAndLiteracyOne.this, Category.class);
//                    frAnotherActivity.putExtra("householdMem", householdMember);
//                    frAnotherActivity.putExtra("Age", householdMembersAge);
//                }
//            });
//        if (intHouseholdMembersAge >= mAge) Btn_edLit.setVisibility(View.GONE);
//        else Btn_edLit2.setVisibility(View.GONE);

        Spinner edLitSpn = (Spinner) findViewById(R.id.edLitSpn);

        edLitSpnAdapter = new ArrayAdapter<>(EducationAndLiteracyOne.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.education));
        edLitSpnAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        edLitSpn.setAdapter(edLitSpnAdapter);

//      The magic radiogroup
        final RadioGroup rg_school = (RadioGroup) findViewById(R.id.rg_school);
//      The magic spinner
        final Spinner Spn_noSchool = (Spinner) findViewById(R.id.Spn_noSchool);
        edLitSpnAdapter = new ArrayAdapter<>(EducationAndLiteracyOne.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.notAttendingSchool));
        edLitSpnAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spn_noSchool.setAdapter(edLitSpnAdapter);

//        When this radio button is clicked, RadioGroup rg_school will be visible
        RadioButton schoolYes = (RadioButton) findViewById(R.id.schoolYes);
        schoolYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv_edLitFour.setVisibility(View.VISIBLE);
                tv_edLitFour.setText(R.string.publicPrivateQ);
                Spn_noSchool.setVisibility(View.GONE);
                rg_school.setVisibility(View.VISIBLE);
            }
        });

//        When this radio button is clicked, RadioGroup rg_school will be gone and Spinner Spn_noSchool will be set to visible
        RadioButton schoolNo = (RadioButton) findViewById(R.id.schoolNo);
        schoolNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv_edLitFour.setText("Why is " + householdMember + " not attending school?");
                rg_school.setVisibility(View.GONE);
                Spn_noSchool.setVisibility(View.VISIBLE);
            }
        });
    }

    public void evaluate(View view) {
//        Test the age of the household member
        Log.d(TAG, "evaluate: " + intHouseholdMembersAge);
//        if (intHouseholdMembersAge >= 15) {
//            frAnotherActivity = new Intent(EducationAndLiteracyOne.this, educationAndLiteracyTwo.class);
//            frAnotherActivity.putExtra("householdMem", householdMember);
//            startActivity(frAnotherActivity);
//        } else {
//            frAnotherActivity = new Intent(EducationAndLiteracyOne.this, Category.class);
//            frAnotherActivity.putExtra("householdMem", householdMember);
//            startActivity(frAnotherActivity);
//        }
    }
}
