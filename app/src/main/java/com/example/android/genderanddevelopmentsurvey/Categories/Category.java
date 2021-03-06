package com.example.android.genderanddevelopmentsurvey.Categories;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.android.genderanddevelopmentsurvey.Categories.Demography.DemographyOne;
import com.example.android.genderanddevelopmentsurvey.Categories.EconomicActivity.EconomicActivityOne;
import com.example.android.genderanddevelopmentsurvey.Categories.EducationAndLiteracy.EducationAndLiteracyOne;
import com.example.android.genderanddevelopmentsurvey.Categories.Health.HealthOne;
import com.example.android.genderanddevelopmentsurvey.Categories.Housing.housingOne;
import com.example.android.genderanddevelopmentsurvey.Categories.Participation.ParticipationOne;
import com.example.android.genderanddevelopmentsurvey.Categories.assetsInfo.assetsInfoOne;
import com.example.android.genderanddevelopmentsurvey.DMainActivity;
import com.example.android.genderanddevelopmentsurvey.R;

public class Category extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "Category";

    String sHouseholdMember;
    Intent nextActivity;
    String householdMembersAge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

//        Receive data from DMainActivity: Data to send: clicked household members name
        nextActivity = getIntent();
        sHouseholdMember = nextActivity.getExtras().getString("householdMem");
        householdMembersAge = nextActivity.getExtras().getString("Age");

//        name the toolbar
        this.setTitle("Category: " + sHouseholdMember);

        Button demographyBtn = (Button) findViewById(R.id.demographyBtn);
        Button edalBtn = (Button) findViewById(R.id.edalBtn);
        Button partiBtn = (Button) findViewById(R.id.partiBtn);
        Button econoBtn = (Button) findViewById(R.id.econoBtn);
        Button healthBtn = (Button) findViewById(R.id.healthBtn);
        Button hocBtn = (Button) findViewById(R.id.hocBtn);
        Button interBtn = (Button) findViewById(R.id.assetsInfo);
        Button Btn_householdList = (Button) findViewById(R.id.Btn_householdList);

        demographyBtn.setOnClickListener(this);
        edalBtn.setOnClickListener(this);
        partiBtn.setOnClickListener(this);
        econoBtn.setOnClickListener(this);
        healthBtn.setOnClickListener(this);
        hocBtn.setOnClickListener(this);
        interBtn.setOnClickListener(this);
        Btn_householdList.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.demographyBtn:
                nextActivity = new Intent(Category.this, DemographyOne.class);
//        Pass variable-String frDMainActivity to CategoryActivity Sub-Category(ex. DemographyActivity, etc.)
                nextActivity.putExtra("householdMem", sHouseholdMember);
                nextActivity.putExtra("Age", householdMembersAge);
                startActivity(nextActivity);
                break;
            case R.id.edalBtn:
                nextActivity = new Intent(Category.this, EducationAndLiteracyOne.class);
//        Pass variable-String frDMainActivity to CategoryActivity Sub-Category(ex. DemographyActivity, etc.)
                Log.d(TAG, "Name: " + sHouseholdMember + " Age: " + householdMembersAge);
                nextActivity.putExtra("householdMem", sHouseholdMember);
                nextActivity.putExtra("Age", householdMembersAge);
                startActivity(nextActivity);
                break;
            case R.id.partiBtn:
                nextActivity = new Intent(Category.this, ParticipationOne.class);
//        Pass variable-String frDMainActivity to CategoryActivity Sub-Category(ex. DemographyActivity, etc.)
                nextActivity.putExtra("householdMem", sHouseholdMember);
                nextActivity.putExtra("Age", householdMembersAge);
                startActivity(nextActivity);
                break;
            case R.id.econoBtn:
                nextActivity = new Intent(Category.this, EconomicActivityOne.class);
//        Pass variable-String frDMainActivity to CategoryActivity Sub-Category(ex. DemographyActivity, etc.)
                nextActivity.putExtra("householdMem", sHouseholdMember);
                startActivity(nextActivity);
                break;
            case R.id.healthBtn:
                nextActivity = new Intent(Category.this, HealthOne.class);
//        Pass variable-String frDMainActivity to CategoryActivity Sub-Category(ex. DemographyActivity, etc.)
                nextActivity.putExtra("householdMem", sHouseholdMember);
                startActivity(nextActivity);
                break;
            case R.id.hocBtn:
                nextActivity = new Intent(Category.this, housingOne.class);
//        Pass variable-String frDMainActivity to CategoryActivity Sub-Category(ex. DemographyActivity, etc.)
                nextActivity.putExtra("householdMem", sHouseholdMember);
                startActivity(nextActivity);
                break;
            case R.id.assetsInfo:
                nextActivity = new Intent(Category.this, assetsInfoOne.class);
//        Pass variable-String frDMainActivity to CategoryActivity Sub-Category(ex. DemographyActivity, etc.)
                nextActivity.putExtra("householdMem", sHouseholdMember);
                startActivity(nextActivity);
                break;
//            case R.id.interBtn:
//                nextActivity = new Intent(Category.this, ForthActivityInterviewStatus.class);
//        Pass variable-String frDMainActivity to CategoryActivity Sub-Category(ex. DemographyActivity, etc.)
//                nextActivity.putExtra("householdMem", frDMainActivity);
//                startActivity(nextActivity);
//                break;
            case R.id.Btn_householdList:
//                Code to return to household list
                nextActivity = new Intent(Category.this, DMainActivity.class);
                startActivity(nextActivity);
//                finish();
                break;
        }
    }
}
