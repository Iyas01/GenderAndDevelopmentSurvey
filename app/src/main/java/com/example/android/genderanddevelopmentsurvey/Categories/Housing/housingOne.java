package com.example.android.genderanddevelopmentsurvey.Categories.Housing;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import com.example.android.genderanddevelopmentsurvey.R;

public class housingOne extends AppCompatActivity {

    String sHouseholdMember;
    Intent iHousing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_housing_one);

//        Get extra
        iHousing = getIntent();
        sHouseholdMember = iHousing.getExtras().getString("householdMem");

//        name the toolbar
        this.setTitle("Housing: " + sHouseholdMember);

        RadioButton rb_absentee = (RadioButton) findViewById(R.id.rb_absentee);
        RadioButton rb_strOwner = (RadioButton) findViewById(R.id.rb_strOwner);
        RadioButton rb_houseRenter = (RadioButton) findViewById(R.id.rb_houseRenter);
        RadioButton rb_roomRenter = (RadioButton) findViewById(R.id.rb_roomRenter);
        RadioButton rb_rentFree = (RadioButton) findViewById(R.id.rb_rentFree);
        RadioButton rb_extended = (RadioButton) findViewById(R.id.rb_extended);

        final EditText et_name = (EditText) findViewById(R.id.et_name);
        final EditText et_address = (EditText) findViewById(R.id.et_address);

        rb_absentee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et_name.setVisibility(View.VISIBLE);
                et_address.setVisibility(View.VISIBLE);
            }
        });

        rb_strOwner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et_name.setVisibility(View.GONE);
                et_address.setVisibility(View.GONE);
            }
        });

        rb_houseRenter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et_name.setVisibility(View.GONE);
                et_address.setVisibility(View.GONE);
                iHousing = new Intent(housingOne.this, housingThree.class);
                iHousing.putExtra("householdMem", sHouseholdMember);
                startActivity(iHousing);
            }
        });

        rb_roomRenter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et_name.setVisibility(View.GONE);
                et_address.setVisibility(View.GONE);
                iHousing = new Intent(housingOne.this, housingThree.class);
                iHousing.putExtra("householdMem", sHouseholdMember);
                startActivity(iHousing);
            }
        });

        rb_rentFree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et_name.setVisibility(View.GONE);
                et_address.setVisibility(View.GONE);
                iHousing = new Intent(housingOne.this, housingThree.class);
                iHousing.putExtra("householdMem", sHouseholdMember);
                startActivity(iHousing);
            }
        });

        rb_extended.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et_name.setVisibility(View.GONE);
                et_address.setVisibility(View.GONE);
                iHousing = new Intent(housingOne.this, housingThree.class);
                iHousing.putExtra("householdMem", sHouseholdMember);
                startActivity(iHousing);
            }
        });

        Button btn_next = (Button) findViewById(R.id.btn_next);
        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iHousing = new Intent(housingOne.this, housingTwo.class);
                iHousing.putExtra("householdMem", sHouseholdMember);
                startActivity(iHousing);
            }
        });
    }
}
