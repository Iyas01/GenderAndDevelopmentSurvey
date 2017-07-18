package com.example.android.genderanddevelopmentsurvey.Categories;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.android.genderanddevelopmentsurvey.Categories.Demography.DemographyOne;
import com.example.android.genderanddevelopmentsurvey.Categories.EconomicActivity.EconomicActivityOne;
import com.example.android.genderanddevelopmentsurvey.Categories.EducationAndLiterature.EducationAndLiteratureOne;
import com.example.android.genderanddevelopmentsurvey.Categories.Health.HealthOne;
import com.example.android.genderanddevelopmentsurvey.Categories.Participation.ParticipationOne;
import com.example.android.genderanddevelopmentsurvey.R;

public class Category extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        Button demographyBtn = (Button) findViewById(R.id.demographyBtn);
        Button edalBtn = (Button) findViewById(R.id.edalBtn);
        Button partiBtn = (Button) findViewById(R.id.partiBtn);
        Button econoBtn = (Button) findViewById(R.id.econoBtn);
        Button healthBtn = (Button) findViewById(R.id.healthBtn);
        Button hocBtn = (Button) findViewById(R.id.hocBtn);
        Button interBtn = (Button) findViewById(R.id.interBtn);

        demographyBtn.setOnClickListener(this);
        edalBtn.setOnClickListener(this);
        partiBtn.setOnClickListener(this);
        econoBtn.setOnClickListener(this);
        healthBtn.setOnClickListener(this);
        hocBtn.setOnClickListener(this);
        interBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.demographyBtn:
                Intent intent1 = new Intent(Category.this, DemographyOne.class);
                startActivity(intent1);
                break;
            case R.id.edalBtn:
                Intent intent2 = new Intent(Category.this, EconomicActivityOne.class);
                startActivity(intent2);
                break;
            case R.id.partiBtn:
                Intent intent3 = new Intent(Category.this, EducationAndLiteratureOne.class);
                startActivity(intent3);
                break;
            case R.id.econoBtn:
                Intent intent4 = new Intent(Category.this, HealthOne.class);
                startActivity(intent4);
                break;
            case R.id.healthBtn:
                Intent intent5 = new Intent(Category.this, ParticipationOne.class);
                startActivity(intent5);
                break;
//            case R.id.hocBtn:
//                Intent intent6 = new Intent(Category.this, ForthActivityHousingCharacteristic.class);
//                startActivity(intent6);
//                break;
//            case R.id.infoBtn:
//                Intent intent7 = new Intent(Category.this, ForthActivityHousingCharacteristic.class);
//                startActivity(intent7);
//                break;
//            case R.id.interBtn:
//                Intent intent8 = new Intent(Category.this, ForthActivityInterviewStatus.class);
//                startActivity(intent8);
//                break;
        }
    }
}
