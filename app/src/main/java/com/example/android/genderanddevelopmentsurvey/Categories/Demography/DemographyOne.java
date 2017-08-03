package com.example.android.genderanddevelopmentsurvey.Categories.Demography;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.android.genderanddevelopmentsurvey.R;

import java.util.Calendar;

public class DemographyOne extends AppCompatActivity {
    String householdMember;
    Intent frCategoryActivityIntent;
    int age;
    private DatePickerDialog.OnDateSetListener mDateSetListener;
    private Calendar calendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demography_one);

        Button BtnDem2 = (Button) findViewById(R.id.BtnDemOne);

//        Get Data, data expected from CategoryActivity: clicked household members name
        frCategoryActivityIntent = getIntent();
        householdMember = frCategoryActivityIntent.getExtras().getString("householdMem");

        TextView tv_relation = (TextView) findViewById(R.id.tv_relation);
        TextView tv_gender = (TextView) findViewById(R.id.tv_gender);
        TextView tv_birth = (TextView) findViewById(R.id.tv_birth);
        TextView tv_reg = (TextView) findViewById(R.id.tv_reg);

//        Questions pass to the TextView
        tv_relation.setText("What's " + householdMember + "'s relationship to the head of the household?");
        tv_gender.setText("What's " + householdMember + "'s gender?");
        tv_birth.setText("When's " + householdMember + "'s date of birth?");
        tv_reg.setText("Was " + householdMember + "'s birth registered with the local civil registrar?");

//        What is your ralationship to the head of the household? Spinner
        Spinner demQTwoSpinner = (Spinner) findViewById(R.id.demQOneSpinner);

        ArrayAdapter<String> demQTwoArrAdp = new ArrayAdapter<>(DemographyOne.this,
                android.R.layout.simple_list_item_1, getResources()
                .getStringArray(R.array.DemographySp1));
        demQTwoArrAdp.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        demQTwoSpinner.setAdapter(demQTwoArrAdp);

//        Date of Birth and Age Computation
        final TextView datePickerTextView = (TextView) findViewById(R.id.datePickerTextView);
        datePickerTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calendar = Calendar.getInstance();
                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH);
                int day = calendar.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(DemographyOne.this,
                        android.R.style.Theme_Holo_Dialog_MinWidth, mDateSetListener, year, month, day);
                datePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                datePickerDialog.show();
            }
        });
        final TextView tvAge = (TextView) findViewById(R.id.age);
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
                else
                    tvAge.setText(getString(R.string.actualAge, age));
            }
        };

//        Send householdMembers name and open next activity
        BtnDem2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                if age is greater dhan or equal to 15, additional questions will be added.
                if (age >= 15) {
                    frCategoryActivityIntent.putExtra("Age", age);
                }
                frCategoryActivityIntent = new Intent(DemographyOne.this, DemographyTwo.class);
                frCategoryActivityIntent.putExtra("householdMem", householdMember);
                startActivity(frCategoryActivityIntent);
            }
        });
    }
//    TODO: Store to database: Relationship, gender, birthdate, age, birth registration YES/NO
//    TODO: Use the age stored in the database to test if it's more than 15, if it is additional questions(EducationAndLiteratureTwo) will be presented
}
