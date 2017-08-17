package com.example.android.genderanddevelopmentsurvey.Categories.Housing;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.android.genderanddevelopmentsurvey.Categories.Category;
import com.example.android.genderanddevelopmentsurvey.R;

public class housingSix extends AppCompatActivity {

    String sHouseholdMember;
    Intent iHousing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_housing_six);

//        receive extra
        iHousing = getIntent();
        sHouseholdMember = iHousing.getExtras().getString("householdMem");

//        set title
        this.setTitle("Housing: " + sHouseholdMember);

        Button btn_next = (Button) findViewById(R.id.btn_next);
        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iHousing = new Intent(housingSix.this, Category.class);
                iHousing.putExtra("householdMem", sHouseholdMember);
                startActivity(iHousing);
            }
        });
    }
}
