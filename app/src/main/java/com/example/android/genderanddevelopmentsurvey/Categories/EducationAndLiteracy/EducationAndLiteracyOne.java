package com.example.android.genderanddevelopmentsurvey.Categories.EducationAndLiteracy;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.android.genderanddevelopmentsurvey.Categories.Category;
import com.example.android.genderanddevelopmentsurvey.R;
import com.example.android.genderanddevelopmentsurvey.dbHelper;

public class EducationAndLiteracyOne extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

//    private static final String TAG = "EducationAndLiteracy";

    String householdMember, sEducation, sLiteracy, sAttendingSchool, sPrivatePublic, sNoSchool, sFifteenPlus, householdMembersAge;
    Intent frAnotherActivity;
    TextView tv_edLitFour;
    ArrayAdapter<String> edLitSpnAdapter;
    TextView tv_fifteenPlus;
    int intHouseholdMembersAge;
    RadioGroup rg_school, rg_edal1, rg_edal2, rg_fifteenPlus;
    Spinner Spn_noSchool;
    dbHelper dbAccess;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_education_and_literacy_one);

//        Get the household name from either DMainActivity/DemographyTwo
        frAnotherActivity = getIntent();
        householdMember = frAnotherActivity.getExtras().getString("householdMem");
        householdMembersAge = frAnotherActivity.getExtras().getString("Age");

//        fetch household members age
        intHouseholdMembersAge = Integer.parseInt(householdMembersAge);
//        determine if household member is age 15 or above. Age 15 and above gets additional questions
//        if (intHouseholdMembersAge >= 15) {
//            toEdalTwo();
//        } else {
//            toCategory();
//        }

//        Display the name of the household member to the action bar
        this.setTitle("Education: " + householdMember);

        tv_edLitFour = (TextView) findViewById(R.id.tv_edLitFour);
        tv_fifteenPlus = (TextView) findViewById(R.id.tv_fifteenPlus);

//        database instance
        dbAccess = new dbHelper(this);

        Spinner edLitSpn = (Spinner) findViewById(R.id.edLitSpn);

        edLitSpnAdapter = new ArrayAdapter<>(EducationAndLiteracyOne.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.education));
        edLitSpnAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        edLitSpn.setAdapter(edLitSpnAdapter);
        edLitSpn.setOnItemSelectedListener(this);

//        radiogroups
        rg_edal1 = (RadioGroup) findViewById(R.id.rg_edal1);
        rg_edal1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                RadioButton radioButton = (RadioButton) findViewById(checkedId);
                sLiteracy = radioButton.getText().toString();
            }
        });
        rg_edal2 = (RadioGroup) findViewById(R.id.rg_edal2);
        rg_edal2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                RadioButton radioButton = (RadioButton) findViewById(checkedId);
                sAttendingSchool = radioButton.getText().toString();
            }
        });
        rg_school = (RadioGroup) findViewById(R.id.rg_school); //      a magic radiogroup
        rg_school.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                RadioButton radioButton = (RadioButton) findViewById(checkedId);
                sPrivatePublic = radioButton.getText().toString();
            }
        });
        rg_fifteenPlus = (RadioGroup) findViewById(R.id.rg_fifteenPlus); //      a magic radiogroup
        rg_fifteenPlus.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                RadioButton radioButton = (RadioButton) findViewById(checkedId);
                sFifteenPlus = radioButton.getText().toString();
            }
        });

        Spn_noSchool = (Spinner) findViewById(R.id.Spn_noSchool); //      a magic spinner
        edLitSpnAdapter = new ArrayAdapter<>(EducationAndLiteracyOne.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.notAttendingSchool));
        edLitSpnAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spn_noSchool.setAdapter(edLitSpnAdapter);
        Spn_noSchool.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                TextView noSchool = (TextView) view;
                sNoSchool = noSchool.getText().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

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
        dbAccess.updateEduOne(householdMember, sLiteracy, sEducation, sAttendingSchool, sPrivatePublic, sNoSchool);
        if (intHouseholdMembersAge >= 15) {
            Intent i = new Intent(EducationAndLiteracyOne.this, educationAndLiteracyTwo.class);
            i.putExtra("householdMem", householdMember);
            startActivity(i);
        } else {
            Intent i = new Intent(EducationAndLiteracyOne.this, Category.class);
            i.putExtra("householdMem", householdMember);
            i.putExtra("Age", householdMembersAge);
            startActivity(i);
        }

//        Test all variables of the household member
//        Log.d(TAG, "Can he/she read and write simple messages in any dialect? " + sLiteracy +
//                " Highest educational attainment: " + sEducation +
//                " Is he/she attending school? " + sAttendingSchool +
//                " Is it public or private school? " + sPrivatePublic);
//        dbAccess.updateEduOne(householdMember, sLiteracy, sEducation, sAttendingSchool, sPrivatePublic, sNoSchool);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        TextView education = (TextView) view;
        sEducation = education.getText().toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
