package com.example.android.genderanddevelopmentsurvey;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CMainActivity extends AppCompatActivity {
    //    private static final String TAG = "CMainActivity"; // for logging purposes
    String frBMainActivity, housing, building, totalHousehold, enumerator, respondent, address, timeStarted;
    EditText editHousingNo, editBuldingNo, editTotalHousehold, editEnumerator,
            editRespondent, editAddress, editTimeStarted;
    //    int housingNo, buildingNo, totalHouseholdNo;
    dbHelper dbAccess;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cmain);

        dbAccess = new dbHelper(this, null, null, 4);

        //        Get the data sent by BMainActivity
        Intent frBMainActivityIntent = getIntent();
        frBMainActivity = frBMainActivityIntent.getExtras().getString("barangayName");
        TextView textView = (TextView) findViewById(R.id.chosen_barangay);
        textView.append(" " + frBMainActivity);

        editHousingNo = (EditText) findViewById(R.id.housingUnitNo);
        editBuldingNo = (EditText) findViewById(R.id.buildingNo);
        editTotalHousehold = (EditText) findViewById(R.id.totalHouseholdNo);
        editEnumerator = (EditText) findViewById(R.id.enumerator);
        editRespondent = (EditText) findViewById(R.id.respondent);
        editAddress = (EditText) findViewById(R.id.address);
        editTimeStarted = (EditText) findViewById(R.id.timeStarted);

        Button button = (Button) findViewById(R.id.btn_cmain);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 /*Strings for edit texts*/
                housing = editHousingNo.getText().toString();
                building = editBuldingNo.getText().toString();
                totalHousehold = editTotalHousehold.getText().toString();
                enumerator = editEnumerator.getText().toString();
                respondent = editRespondent.getText().toString();
                address = editAddress.getText().toString();
                timeStarted = editTimeStarted.getText().toString();
                Intent intent = new Intent(CMainActivity.this, DMainActivity.class);
//                send this strings to next activity to be inserted in database
                intent.putExtra("barangayName", frBMainActivity);
                intent.putExtra("housing", housing);
                intent.putExtra("building", building);
                intent.putExtra("totalHousehold", totalHousehold);
                intent.putExtra("enumerator", enumerator);
                intent.putExtra("respondent", respondent);
                intent.putExtra("address", address);
                intent.putExtra("timeStarted", timeStarted);
                startActivity(intent);
//                Log.d(TAG, "onClick: " + housing + " " + building + " " + totalHousehold + " " + enumerator + " " + respondent + " " + address + " " + timeStarted + " end." );
//                Log.d(TAG, "onClick: " + barangay);
            }
        });
    }
}
