package com.example.android.genderanddevelopmentsurvey.Categories.EducationAndLiterature;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.android.genderanddevelopmentsurvey.R;

public class EducationAndLiteratureOne extends AppCompatActivity {
    String householdMember, householdMembersAge;
    Intent frAnotherActivity;
    TextView tv_edLitFour;
    ArrayAdapter<String> edLitSpnAdapter;
    TextView tv_fifteenPlus;
    Button Btn_edLit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_education_and_literature_one);

//        Get the household name from either DMainActivity/DemographyTwo
        frAnotherActivity = getIntent();
        householdMember = frAnotherActivity.getExtras().getString("householdMem");
//        Get the Age to determine if household member is age 15 or above. Age 15 and above gets additional questions
        householdMembersAge = frAnotherActivity.getExtras().getString("Age");

        Btn_edLit = (Button) findViewById(R.id.Btn_edLit);
        TextView tv_edLitOne = (TextView) findViewById(R.id.tv_edLitOne);
        TextView tv_edLitTwo = (TextView) findViewById(R.id.tv_edLitTwo);
        TextView tv_edLitThree = (TextView) findViewById(R.id.tv_edLitThree);
        tv_edLitFour = (TextView) findViewById(R.id.tv_edLitFour);
        tv_fifteenPlus = (TextView) findViewById(R.id.tv_fifteenPlus);

        tv_edLitOne.setText("Can " + householdMember + " read and write simple messages in any dialect/language?");
        tv_edLitTwo.setText("What is " + householdMember + "'s highest educational attainment?");
        tv_edLitThree.setText("Is " + householdMember + " attending school?");

        Spinner edLitSpn = (Spinner) findViewById(R.id.edLitSpn);

        edLitSpnAdapter = new ArrayAdapter<>(EducationAndLiteratureOne.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.education));
        edLitSpnAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        edLitSpn.setAdapter(edLitSpnAdapter);

//      The magic radiogroup
        final RadioGroup rg_school = (RadioGroup) findViewById(R.id.rg_school);
//      The magic spinner
        final Spinner Spn_noSchool = (Spinner) findViewById(R.id.Spn_noSchool);
        edLitSpnAdapter = new ArrayAdapter<>(EducationAndLiteratureOne.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.notAttendingSchool));
        edLitSpnAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spn_noSchool.setAdapter(edLitSpnAdapter);

//        When this radio button is clicked, RadioGroup rg_school will be visible
        RadioButton schoolYes = (RadioButton) findViewById(R.id.schoolYes);
        schoolYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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

        Btn_edLit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                frAnotherActivity = new Intent(EducationAndLiteratureOne.this, educationAndLiteratureTwo.class);
                startActivity(frAnotherActivity);
            }
        });

//        This button will forward to next activity depends on the age of the household member
//        Btn_edLit = (Button) findViewById(R.id.Btn_edLit);
//        if (householdMembersAge != null){
//            Btn_addQuestion.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    frAnotherActivity = new Intent(EducationAndLiteratureOne.this, educationAndLiteratureTwo.class);
//                    startActivity(frAnotherActivity);
//                }
//            });
//        }
//        else {
//            Btn_addQuestion.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    frAnotherActivity = new Intent(EducationAndLiteratureOne.this, Category.class);
//                    TODO: pass householdMember to Category.class
//                    startActivity(frAnotherActivity);
//                }
//            });
//        }
    }
}
