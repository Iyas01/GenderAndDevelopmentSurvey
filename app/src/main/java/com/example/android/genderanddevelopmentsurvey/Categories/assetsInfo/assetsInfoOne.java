package com.example.android.genderanddevelopmentsurvey.Categories.assetsInfo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.android.genderanddevelopmentsurvey.R;

public class assetsInfoOne extends AppCompatActivity {

    String sHouseholdMember;
    Intent iAssetsInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assets_info_one);

//        receive extra
        iAssetsInfo = getIntent();
        sHouseholdMember = iAssetsInfo.getExtras().getString("householdMem");

//        set title
        this.setTitle("Asset Info: " + sHouseholdMember);

        Button btn_next = (Button) findViewById(R.id.btn_next);

        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iAssetsInfo = new Intent(assetsInfoOne.this, assetsInfoTwo.class);
                iAssetsInfo.putExtra("householdMem", sHouseholdMember);
                startActivity(iAssetsInfo);
            }
        });


    }
}
