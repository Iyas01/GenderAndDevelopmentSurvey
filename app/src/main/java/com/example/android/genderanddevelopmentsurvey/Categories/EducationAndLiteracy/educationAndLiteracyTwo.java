package com.example.android.genderanddevelopmentsurvey.Categories.EducationAndLiteracy;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.android.genderanddevelopmentsurvey.Categories.Category;
import com.example.android.genderanddevelopmentsurvey.R;
import com.example.android.genderanddevelopmentsurvey.dbHelper;

public class educationAndLiteracyTwo extends AppCompatActivity {

//    This activity will only show if the person is aged 15 and above

    Intent frEducationAndLiteracyOne;
    String householdMember, sTechVoc, sTechVocName, householdMembersAge;
    RadioGroup rg_edalTwo;
    EditText et_edLitTwo;
    dbHelper dbAccess;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_education_and_literacy_two);

        final TextView tv_edLitTwo = (TextView) findViewById(R.id.tv_edLitTwo);
        et_edLitTwo = (EditText) findViewById(R.id.et_edLitTwo);
        rg_edalTwo = (RadioGroup) findViewById(R.id.rg_edalTwo);
        RadioButton rb_LitTwo1 = (RadioButton) findViewById(R.id.rb_LitTwo1);
        RadioButton rb_LitTwo2 = (RadioButton) findViewById(R.id.rb_LitTwo2);

//        Get the householdmem extra from EducationAndLiteracyOne.class
        frEducationAndLiteracyOne = getIntent();
        householdMember = frEducationAndLiteracyOne.getExtras().getString("householdMem");
        householdMembersAge = frEducationAndLiteracyOne.getExtras().getString("Age");

//        Set the household member's name as title in action toolbar
        this.setTitle("Education: " + householdMember);

//        db instance
        dbAccess = new dbHelper(this);

//        fetch user selection of radio buttons
        rg_edalTwo.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                RadioButton radioButton = (RadioButton) findViewById(checkedId);
                sTechVoc = radioButton.getText().toString();
            }
        });

        rb_LitTwo1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv_edLitTwo.setVisibility(View.VISIBLE);
                et_edLitTwo.setVisibility(View.VISIBLE);
            }
        });

        rb_LitTwo2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv_edLitTwo.setVisibility(View.GONE);
                et_edLitTwo.setVisibility(View.GONE);
            }
        });

//        btn_edLitTwo1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
////        fetch users text in the edittext provided
//                sTechVocName = et_edLitTwo.getText().toString();
//                dbAccess.updateEduTwo(householdMember, sTechVoc, sTechVocName);
//                frEducationAndLiteracyOne = new Intent(educationAndLiteracyTwo.this, Category.class);
//                frEducationAndLiteracyOne.putExtra("householdMem", householdMember);
//                frEducationAndLiteracyOne.putExtra("Age", householdMembersAge );
//                startActivity(frEducationAndLiteracyOne);
//            }
//        });
    }

    public void btn_next(View v) {
        sTechVocName = et_edLitTwo.getText().toString();
        dbAccess.updateEduTwo(householdMember, sTechVoc, sTechVocName);
        frEducationAndLiteracyOne = new Intent(educationAndLiteracyTwo.this, Category.class);
        frEducationAndLiteracyOne.putExtra("householdMem", householdMember);
        frEducationAndLiteracyOne.putExtra("Age", householdMembersAge);
        startActivity(frEducationAndLiteracyOne);
    }
}
