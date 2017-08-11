package com.example.android.genderanddevelopmentsurvey.Categories.EconomicActivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.example.android.genderanddevelopmentsurvey.Categories.Category;
import com.example.android.genderanddevelopmentsurvey.R;

public class economicActivityFour extends AppCompatActivity {

    String householdMember;
    Intent ieconoFour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_economic_four);

        ieconoFour = getIntent();
        householdMember = ieconoFour.getExtras().getString("householdMem");

//        name the toolbar
        this.setTitle("Economic: " + householdMember);

        Spinner spn_econo3 = (Spinner) findViewById(R.id.spn_econo3);
        Button btn_next = (Button) findViewById(R.id.btn_next);

//        Adapter for spn_econo3 Spinner
        ArrayAdapter<String> arrEconoThree = new ArrayAdapter<>(economicActivityFour.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.occupation));
        arrEconoThree.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spn_econo3.setAdapter(arrEconoThree);

        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ieconoFour = new Intent(economicActivityFour.this, Category.class);
                ieconoFour.putExtra("householdMem", householdMember);
                startActivity(ieconoFour);
            }
        });
    }
}
