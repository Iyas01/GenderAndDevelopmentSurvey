package com.example.android.genderanddevelopmentsurvey;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.android.genderanddevelopmentsurvey.Categories.Category;

import java.util.Calendar;

public class EGenderAge extends AppCompatActivity {

    private static final String TAG = "EGenderAge";

    String sHouseholdMember, enumerator, respondent, address;
    String sHousing, sBuilding, sTotalHousehold, timeStarted;
    int age, rbId, housing, building, totalHousehold;
    Intent iEgenderAge;
    TextView datePickerTextView;
    Calendar calendar;
    DatePickerDialog.OnDateSetListener mDateSetListener;
    TextView tvAge;
    String gender, barangay;
    dbHelper dbAccess;
    RadioGroup rg_genderSel;
    RadioButton rb_sel;
    Person person;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_egender_age);

//        receive extra
//        iEgenderAge = getIntent();
//        sHouseholdMember = iEgenderAge.getExtras().getString("householdMem");
//        barangay = iEgenderAge.getExtras().getString("barangayName");
//        enumerator = iEgenderAge.getExtras().getString("enumerator");
//        respondent = iEgenderAge.getExtras().getString("respondent");
//        address = iEgenderAge.getExtras().getString("address");
//        sHousing = iEgenderAge.getExtras().getString("housing");
//        sBuilding = iEgenderAge.getExtras().getString("building");
//        sTotalHousehold = iEgenderAge.getExtras().getString("totalHousehold");
//        timeStarted = iEgenderAge.getExtras().getString("timeStarted");

//        parse int from Strings sHousing, sBuilding, sTotalHousehold, sTimeStarted
//        housing = Integer.parseInt(sHousing);
//        building = Integer.parseInt(sBuilding);
//        totalHousehold = Integer.parseInt(sTotalHousehold);

//        set title
        this.setTitle(sHouseholdMember + "'s Gender and Age");

//        create a new instance of database connection
        dbAccess = new dbHelper(this, null, null, 4);

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

//        set the persons gender
        person.set_gender(gender);

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

//        set Person's age
        person.set_age(age);

//        Send householdMembers name and open next activity
        Btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                dbAccess.otherDetails(person.get_name(), person.get_age(), person.get_gender(), person.get_barangay(), person.get_housing(), person.get_bldg(),
//                        person.get_total_household(), person.get_name_of_enumerator(), person.get_name_of_respondent(), person.get_address(), person.get_time_started()); // insert other details of the person to the database
                iEgenderAge = new Intent(EGenderAge.this, Category.class); // call the next activity
//                iEgenderAge.putExtra("householdMem", sHouseholdMember);
                startActivity(iEgenderAge);
//              logging to console
//                Log.d(TAG, "onClick: " + sHouseholdMember + " " + age + " " + gender);
//                iEgenderAge.putExtra("Age", getHouseholdMembersAge);
            }
        });
    }
}