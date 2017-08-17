package com.example.android.genderanddevelopmentsurvey.Categories.Housing;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import com.example.android.genderanddevelopmentsurvey.R;

public class housingFour extends AppCompatActivity {

    String sHouseholdMember;
    Intent iHousing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_housing_four);

//        Receive extra
        iHousing = getIntent();
        sHouseholdMember = iHousing.getExtras().getString("householdMem");

//        Set title bar
        this.setTitle("Housing: " + sHouseholdMember);

        RadioButton rb_commercial = (RadioButton) findViewById(R.id.rb_commercial);
        RadioButton rb_res = (RadioButton) findViewById(R.id.rb_res);
        RadioButton rb_comb = (RadioButton) findViewById(R.id.rb_comb);
        final EditText et_spec = (EditText) findViewById(R.id.et_spec);
        Button btn_next = (Button) findViewById(R.id.btn_next);


        rb_commercial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et_spec.setVisibility(View.VISIBLE);
            }
        });

        rb_res.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et_spec.setVisibility(View.GONE);
            }
        });

        rb_comb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et_spec.setVisibility(View.GONE);
            }
        });

        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iHousing = new Intent(housingFour.this, housingFive.class);
                iHousing.putExtra("householdMem", sHouseholdMember);
                startActivity(iHousing);
            }
        });
    }
}
