package com.example.android.genderanddevelopmentsurvey.Categories.Participation;

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

import com.example.android.genderanddevelopmentsurvey.R;

public class ParticipationOne extends AppCompatActivity {

    String householdMember;
    Intent participationOneIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_participation_one);

//        Recieve the extra data sent from Category.class
        participationOneIntent = getIntent();
        householdMember = participationOneIntent.getExtras().getString("householdMem");

//        Display household members name in the toolbar
        this.setTitle("Participation: " + householdMember);

//        TextView tv_partOne1 = (TextView) findViewById(R.id.tv_partOne1);
        final TextView tv_partOne2 = (TextView) findViewById(R.id.tv_partOne2);
        final TextView tv_partOne3 = (TextView) findViewById(R.id.tv_partOne3);
//        final  TextView tv_partOne4 = (TextView) findViewById(R.id.tv_partOne4);
//        final TextView tv_partOne5 = (TextView) findViewById(R.id.tv_partOne5);

//        tv_partOne1.setText("Is " + householdMember + " a registered voter?");

        final RadioGroup rg_partOne1 = (RadioGroup) findViewById(R.id.rg_partOne1);
        final RadioGroup rg_partOne2 = (RadioGroup) findViewById(R.id.rg_partOne2);
        final RadioGroup rg_partOne3 = (RadioGroup) findViewById(R.id.rg_partOne3);

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
//                participationOneIntent = new Intent(ParticipationOne.this, Category.class);
//                participationOneIntent.putExtra("householdMem", householdMember);
//                startActivity(participationOneIntent);
                finish();
            }
        });
    }
}
