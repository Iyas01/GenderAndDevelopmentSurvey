package com.example.android.genderanddevelopmentsurvey;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class AMainActivity extends AppCompatActivity {

    dbHelper dbAccess;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_amain);

        Button AMBtn = (Button) findViewById(R.id.button);
        AMBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AMainActivity.this, BMainActivity.class);
                startActivity(intent);
            }
        });
    }
}
