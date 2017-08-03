package com.example.android.genderanddevelopmentsurvey.Categories.Participation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.android.genderanddevelopmentsurvey.R;

public class ParticipationOne extends AppCompatActivity {

    String householdMember;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_participation_one);

        TextView tv_partOne1 = (TextView) findViewById(R.id.tv_partOne1);
        final TextView tv_partOne2 = (TextView) findViewById(R.id.tv_partOne2);
        final TextView tv_partOne3 = (TextView) findViewById(R.id.tv_partOne3);

        tv_partOne1.setText("Is " + householdMember + " a registered voter?");

        final RadioGroup rg_partOne1 = (RadioGroup) findViewById(R.id.rg_partOne1);
        final RadioGroup rg_partOne2 = (RadioGroup) findViewById(R.id.rg_partOne2);
        final RadioGroup rg_partOne3 = (RadioGroup) findViewById(R.id.rg_partOne3);

        RadioButton rb_partOne1 = (RadioButton) findViewById(R.id.rb_partOne1);
        RadioButton rb_partOne2 = (RadioButton) findViewById(R.id.rb_partOne2);
        RadioButton rb_partOne3 = (RadioButton) findViewById(R.id.rb_partOne3);
        RadioButton rb_partOne4 = (RadioButton) findViewById(R.id.rb_partOne4);

//      YES radiobutton, on registered voter question
        rb_partOne1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv_partOne2.setText("Is " + householdMember + " an OFW?");
                rg_partOne1.clearCheck();
                rg_partOne1.setVisibility(View.VISIBLE);
                rg_partOne3.setVisibility(View.GONE);
            }
        });

//      NO radiobutton, on registered voter question
        rb_partOne2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv_partOne2.setText("Did " + householdMember + " do any job during the last 6 months?");
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
                tv_partOne3.setText("Did " + householdMember + " participate in absentee voting?");
                tv_partOne3.setVisibility(View.VISIBLE);
                rg_partOne2.setVisibility(View.VISIBLE);
                rg_partOne2.clearCheck();
            }
        });

//        NO radiobutton, on OFW question
        rb_partOne4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv_partOne3.setText("Did " + householdMember + " vote in the last election?");
            }
        });

//        Did householdmember do any job during the last 6 months?



    }
}
