package com.example.android.genderanddevelopmentsurvey.Categories.Health;

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

import com.example.android.genderanddevelopmentsurvey.Categories.Category;
import com.example.android.genderanddevelopmentsurvey.Categories.Housing.housingOne;
import com.example.android.genderanddevelopmentsurvey.R;

public class healthTwo extends AppCompatActivity implements View.OnClickListener {

//    This will only activate if the household member is female and age 10 and above

    String sHouseholdMember;
    Intent iHealthTwo;
    TextView tv_famPlan, tv_immuni, tv_soloP;
    Spinner spn_healthTwo, spn_healthTwo2;
    RadioGroup rg_soloP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_two);

//      Receive extra
        iHealthTwo = getIntent();
        sHouseholdMember = iHealthTwo.getExtras().getString("householdMem");

//        name the toolbar
        this.setTitle("Health: " + sHouseholdMember);

//        the textviews
        tv_famPlan = (TextView) findViewById(R.id.tv_famPlan);
        tv_immuni = (TextView) findViewById(R.id.tv_immuni);
        tv_soloP = (TextView) findViewById(R.id.tv_soloP);

//        the radio buttons
        RadioButton rb_healthTwo1 = (RadioButton) findViewById(R.id.rb_healthTwo1);
        RadioButton rb_healthTwo2 = (RadioButton) findViewById(R.id.rb_healthTwo2);
        RadioButton rb_healthTwo3 = (RadioButton) findViewById(R.id.rb_healthTwo3);
        RadioButton rb_healthTwo4 = (RadioButton) findViewById(R.id.rb_healthTwo4);

//        radiogroup
        rg_soloP = (RadioGroup) findViewById(R.id.rg_soloP);

        rb_healthTwo1.setOnClickListener(this);
        rb_healthTwo2.setOnClickListener(this);
        rb_healthTwo3.setOnClickListener(this);
        rb_healthTwo4.setOnClickListener(this);

//        Spinner for immunization
        spn_healthTwo = (Spinner) findViewById(R.id.spn_healthTwo);
        ArrayAdapter<String> arrHealthTwo = new ArrayAdapter<>(healthTwo.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.immunization));
        arrHealthTwo.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spn_healthTwo.setAdapter(arrHealthTwo);

//        Spinner for family planning
        spn_healthTwo2 = (Spinner) findViewById(R.id.spn_healthTwo2);
        arrHealthTwo = new ArrayAdapter<>(healthTwo.this, android.R.layout.simple_list_item_1,
                getResources().getStringArray(R.array.familyPlanning));
        arrHealthTwo.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spn_healthTwo2.setAdapter(arrHealthTwo);

//        next button
        Button btn_next = (Button) findViewById(R.id.btn_next);
        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iHealthTwo = new Intent(healthTwo.this, Category.class);
                iHealthTwo.putExtra("householdMem", sHouseholdMember);
                startActivity(iHealthTwo);
            }
        });
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.rb_healthTwo1:
                tv_immuni.setVisibility(View.VISIBLE);
                tv_famPlan.setVisibility(View.GONE);
                spn_healthTwo.setVisibility(View.VISIBLE);
                spn_healthTwo2.setVisibility(View.GONE);
                tv_soloP.setVisibility(View.VISIBLE);
                rg_soloP.setVisibility(View.VISIBLE);
                break;

            case R.id.rb_healthTwo2:
                tv_immuni.setVisibility(View.VISIBLE);
                tv_famPlan.setVisibility(View.GONE);
                spn_healthTwo.setVisibility(View.VISIBLE);
                spn_healthTwo2.setVisibility(View.GONE);
                tv_soloP.setVisibility(View.VISIBLE);
                rg_soloP.setVisibility(View.VISIBLE);
                break;

            case R.id.rb_healthTwo3:
                tv_immuni.setVisibility(View.GONE);
                spn_healthTwo.setVisibility(View.GONE);
                tv_famPlan.setVisibility(View.VISIBLE);
                spn_healthTwo2.setVisibility(View.VISIBLE);
                tv_soloP.setVisibility(View.VISIBLE);
                rg_soloP.setVisibility(View.VISIBLE);
                break;

            case R.id.rb_healthTwo4:
                iHealthTwo = new Intent(healthTwo.this, housingOne.class);
                iHealthTwo.putExtra("householdMem", sHouseholdMember);
                startActivity(iHealthTwo);

        }

    }
}
