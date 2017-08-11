package com.example.android.genderanddevelopmentsurvey.Categories.EconomicActivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.android.genderanddevelopmentsurvey.R;

public class economicActivityThree extends AppCompatActivity {

    String householdMember;
    Intent ieconoThree;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_economic_three);

//        Receive extra
        ieconoThree = getIntent();
        householdMember = ieconoThree.getExtras().getString("householdMem");

//        Set toolbar name
        this.setTitle("Membership: " + householdMember);

        Button btn_next = (Button) findViewById(R.id.btn_next);

//        Next button
        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ieconoThree = new Intent(economicActivityThree.this, economicActivityFour.class);
                ieconoThree.putExtra("householdMem", householdMember);
                startActivity(ieconoThree);
            }
        });

    }
}
