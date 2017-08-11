package com.example.android.genderanddevelopmentsurvey.Categories.EducationAndLiteracy;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.android.genderanddevelopmentsurvey.Categories.Category;
import com.example.android.genderanddevelopmentsurvey.R;

public class educationAndLiteracyTwo extends AppCompatActivity {

//    This activity will only show if the person is aged 15 and above

    Intent frEducationAndLiteracyOne;
    String householdMember;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_education_and_literacy_two);

        final TextView tv_edLitTwo = (TextView) findViewById(R.id.tv_edLitTwo);
        final EditText et_edLitTwo = (EditText) findViewById(R.id.et_edLitTwo);
        RadioButton rb_LitTwo1 = (RadioButton) findViewById(R.id.rb_LitTwo1);
        RadioButton rb_LitTwo2 = (RadioButton) findViewById(R.id.rb_LitTwo2);
        Button btn_edLitTwo1 = (Button) findViewById(R.id.btn_edLitTwo1);

//        Get the householdmem extra from EducationAndLiteracyOne.class
        frEducationAndLiteracyOne = getIntent();
        householdMember = frEducationAndLiteracyOne.getExtras().getString("householdMem");
//        householdMemberAge = frEducationAndLiteracyOne.getExtras().getString("Age");

//        Set the household member's name as title in action toolbar
        this.setTitle("Education: " + householdMember);

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

        btn_edLitTwo1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                frEducationAndLiteracyOne = new Intent(educationAndLiteracyTwo.this, Category.class);
                frEducationAndLiteracyOne.putExtra("householdMem", householdMember);
                startActivity(frEducationAndLiteracyOne);
            }
        });
    }
}
