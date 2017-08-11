package com.example.android.genderanddevelopmentsurvey.Categories.Health;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.example.android.genderanddevelopmentsurvey.R;

public class HealthOne extends AppCompatActivity {

    Intent iHealth;
    String sHouseholdMember;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_one);

//        Receive the extra sent
        iHealth = getIntent();
        sHouseholdMember = iHealth.getExtras().getString("householdMem");

//        name the toolbar
        this.setTitle("Health: " + sHouseholdMember);

        Spinner spn_disability = (Spinner) findViewById(R.id.spn_disability);

//        Adapter for spn_disability
        ArrayAdapter<String> arrDisability = new ArrayAdapter<>(HealthOne.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.disability));
        arrDisability.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spn_disability.setAdapter(arrDisability);

//        next button
        Button btn_next = (Button) findViewById(R.id.btn_next);
        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iHealth = new Intent(HealthOne.this, healthTwo.class);
                iHealth.putExtra("householdMem", sHouseholdMember);
                startActivity(iHealth);
            }
        });

    }
}
