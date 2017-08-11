package com.example.android.genderanddevelopmentsurvey.Categories.EconomicActivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.example.android.genderanddevelopmentsurvey.R;

public class economicActivityTwo extends AppCompatActivity {

    String householdMember;
    Intent ieconoTwo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_economic_two);

//        Receive extra
        ieconoTwo = getIntent();
        householdMember = ieconoTwo.getExtras().getString("householdMem");

//        Set toolbar name
        this.setTitle("Economic: " + householdMember);

        Spinner spn_econo1 = (Spinner) findViewById(R.id.spn_econo1);
        Spinner spn_econo2 = (Spinner) findViewById(R.id.spn_econo2);
        Button btn_next = (Button) findViewById(R.id.btn_next);

//        Set adapter for Spinner1
        ArrayAdapter<String> arrSaln = new ArrayAdapter<>(economicActivityTwo.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.saln));
        arrSaln.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spn_econo1.setAdapter(arrSaln);

        //        Set adapter for Spinner2
        arrSaln = new ArrayAdapter<String>(economicActivityTwo.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.saln));
        arrSaln.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spn_econo2.setAdapter(arrSaln);

        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ieconoTwo = new Intent(economicActivityTwo.this, economicActivityThree.class);
                ieconoTwo.putExtra("householdMem", householdMember);
                startActivity(ieconoTwo);
            }
        });
    }
}
