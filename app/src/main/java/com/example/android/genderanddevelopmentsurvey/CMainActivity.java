package com.example.android.genderanddevelopmentsurvey;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CMainActivity extends AppCompatActivity {

    String frBMainActivity;
    EditText editHousingNo, editBuldingNo, totalHousehold, editEnumerator,
            editRespondent, editAddress, editTimeStarted;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cmain);

        //        Get the data sent by StartSurveyActivity
        Intent frBMainActivityIntent = getIntent();
        frBMainActivity = frBMainActivityIntent.getExtras().getString("barangayName");
        TextView textView = (TextView) findViewById(R.id.chosen_barangay);
        if (frBMainActivity != null) {
            textView.append(" " + frBMainActivity);
        }

        editHousingNo = (EditText) findViewById(R.id.housingUnitNo);
        editBuldingNo = (EditText) findViewById(R.id.buildingNo);
        totalHousehold = (EditText) findViewById(R.id.totalHouseholdNo);
        editEnumerator = (EditText) findViewById(R.id.enumerator);
        editRespondent = (EditText) findViewById(R.id.respondent);
        editAddress = (EditText) findViewById(R.id.address);
        editTimeStarted = (EditText) findViewById(R.id.timeStarted);

        Button button = (Button) findViewById(R.id.btn_cmain);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CMainActivity.this, DMainActivity.class);
                startActivity(intent);
            }
        });
    }
}
