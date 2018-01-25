package com.example.android.genderanddevelopmentsurvey.Categories.Participation;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.android.genderanddevelopmentsurvey.Categories.Category;
import com.example.android.genderanddevelopmentsurvey.R;
import com.example.android.genderanddevelopmentsurvey.dbHelper;

public class ParticipationOne extends AppCompatActivity {

    String householdMember, householdMembersAge, registeredVoter, ofw, absenteeVoting, voted, job;
    Intent participationOneIntent;
    dbHelper dbAccess;
    RadioGroup rg_partOne1, rg_partOne2, rg_partOne3, rg_partOne4;

// TODO: 1 of the questions share a radio group, separate them so that you can fetch data separately

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_participation_one);

//        Recieve the extra data sent from Category.class
        participationOneIntent = getIntent();
        householdMember = participationOneIntent.getExtras().getString("householdMem");
        householdMembersAge = participationOneIntent.getExtras().getString("Age");

//        Display household members name in the toolbar
        this.setTitle("Participation: " + householdMember);

//        database instance
        dbAccess = new dbHelper(this);

//        TextView tv_partOne1 = (TextView) findViewById(R.id.tv_partOne1);
        final TextView tv_partOne2 = (TextView) findViewById(R.id.tv_partOne2);
        final TextView tv_partOne3 = (TextView) findViewById(R.id.tv_partOne3);
//        final  TextView tv_partOne4 = (TextView) findViewById(R.id.tv_partOne4);
//        final TextView tv_partOne5 = (TextView) findViewById(R.id.tv_partOne5);

//        tv_partOne1.setText("Is " + householdMember + " a registered voter?");

        rg_partOne1 = (RadioGroup) findViewById(R.id.rg_partOne1);
        rg_partOne2 = (RadioGroup) findViewById(R.id.rg_partOne2);
        rg_partOne3 = (RadioGroup) findViewById(R.id.rg_partOne3);
        rg_partOne4 = (RadioGroup) findViewById(R.id.rg_partOne4);

//        radio groups setOnClickListeners
//        registered voter
        rg_partOne1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                RadioButton radioButton = (RadioButton) findViewById(checkedId);
                registeredVoter = radioButton.getText().toString();
            }
        });
//        job in the last 6 months
        rg_partOne2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                RadioButton radioButton = (RadioButton) findViewById(checkedId);
                job = radioButton.getText().toString();
            }
        });
//        absentee voting
        rg_partOne3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                RadioButton radioButton = (RadioButton) findViewById(checkedId);
                absenteeVoting = radioButton.getText().toString();
            }
        });

        Button btn_next = (Button) findViewById(R.id.btn_next);

        RadioButton rb_partOne1 = (RadioButton) findViewById(R.id.rb_partOne1);
        RadioButton rb_partOne2 = (RadioButton) findViewById(R.id.rb_partOne2);
        RadioButton rb_partOne3 = (RadioButton) findViewById(R.id.rb_partOne3);
        RadioButton rb_partOne4 = (RadioButton) findViewById(R.id.rb_partOne4);

//      The occupation spinner
        Spinner spn_occupation = (Spinner) findViewById(R.id.spn_occupation);
        ArrayAdapter<String> ArrOccupation = new ArrayAdapter<>(ParticipationOne.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.occupation));
        ArrOccupation.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spn_occupation.setAdapter(ArrOccupation);

//      YES radiobutton, on registered voter question
        rb_partOne1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv_partOne2.setVisibility(View.VISIBLE);
                tv_partOne2.setText("Is he/she an OFW?");
                rg_partOne1.clearCheck();
                rg_partOne1.setVisibility(View.VISIBLE);
                rg_partOne3.setVisibility(View.GONE);
            }
        });

//      NO radiobutton, on registered voter question
        rb_partOne2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv_partOne2.setText("Did he/she do any job in the last 6 months?");
                tv_partOne2.setVisibility(View.VISIBLE);
                rg_partOne3.clearCheck();
                rg_partOne3.setVisibility(View.VISIBLE);
                rg_partOne1.setVisibility(View.GONE);
                tv_partOne3.setVisibility(View.GONE);
                rg_partOne2.setVisibility(View.GONE);
            }
        });

//      YES radiobutton, on OFW question
        rb_partOne3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv_partOne3.setText("Did he/she participate in absentee voting?");
                tv_partOne3.setVisibility(View.VISIBLE);
                rg_partOne2.setVisibility(View.VISIBLE);
                rg_partOne2.clearCheck();
            }
        });

//        NO radiobutton, on OFW question
        rb_partOne4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv_partOne3.setText("Did he/she vote in the last election?");
                tv_partOne3.setVisibility(View.VISIBLE);
                rg_partOne2.setVisibility(View.VISIBLE);
                rg_partOne2.clearCheck();
            }
        });

        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                dbAccess.updatePartOne(householdMember, ); // TODO: 10/23/2017
                participationOneIntent = new Intent(ParticipationOne.this, Category.class);
                participationOneIntent.putExtra("householdMem", householdMember);
                participationOneIntent.putExtra("Age", householdMembersAge);
                startActivity(participationOneIntent);
//                finish();
            }
        });
    }
}