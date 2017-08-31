package com.example.android.genderanddevelopmentsurvey;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.android.genderanddevelopmentsurvey.Categories.Category;

import java.util.Calendar;

import static android.R.attr.name;

public class EGenderAge extends AppCompatActivity {

    private static final String TAG = "EGenderAge";

    String sHouseholdMember;
    String getHouseholdMembersAge;
    int age, rbId;
    Intent iEgenderAge;
    TextView datePickerTextView;
    Calendar calendar;
    DatePickerDialog.OnDateSetListener mDateSetListener;
    TextView tvAge;
    String gender;
    Person person;
    dbHelper dbAccess;
    RadioGroup rg_genderSel;
    RadioButton rb_sel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_egender_age);

//        receive extra
        iEgenderAge = getIntent();
        sHouseholdMember = iEgenderAge.getExtras().getString("householdMem");

//        set title
        this.setTitle(sHouseholdMember + "'s Gender and Age");

        Button Btn_next = (Button) findViewById(R.id.Btn_next);

//        Fetch household members gender from user input
        rg_genderSel = (RadioGroup) findViewById(R.id.rg_genderSel);
        rg_genderSel.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                rbId = rg_genderSel.getCheckedRadioButtonId();
                rb_sel = (RadioButton) findViewById(rbId);
                gender = (String) rb_sel.getText();
            }
        });

//        Date of Birth and Age Computation
        datePickerTextView = (TextView) findViewById(R.id.datePickerTextView);
        datePickerTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calendar = Calendar.getInstance();
                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH);
                int day = calendar.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(EGenderAge.this,
                        android.R.style.Theme_Holo_Dialog_MinWidth, mDateSetListener, year, month, day);
                datePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                datePickerDialog.show();
            }
        });

        tvAge = (TextView) findViewById(R.id.age);
        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int day) {
                month = month + 1;
                String date = month + "/" + day + "/" + year;
                datePickerTextView.setText(date);

//                Compute Age
                int currentYear = calendar.get(Calendar.YEAR);
                age = currentYear - year;

                if (age < 0)
                    tvAge.setText(R.string.defaultAge);

                else {
                    tvAge.setText(getString(R.string.actualAge, age));
                }

            }
        };

//        Send householdMembers name and open next activity
        Btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iEgenderAge = new Intent(EGenderAge.this, Category.class);
                iEgenderAge.putExtra("householdMem", sHouseholdMember);
//                person.set_age(age); //set persons age in db
//                person.set_gender(gender); //set persons gender in db
                dbAccess.insertAgeGender(sHouseholdMember, age, gender);
                Log.d(TAG, "onClick: " + name + " " + age + " " + gender);
//                iEgenderAge.putExtra("Age", getHouseholdMembersAge);
                startActivity(iEgenderAge);
            }
        });
    }
}
