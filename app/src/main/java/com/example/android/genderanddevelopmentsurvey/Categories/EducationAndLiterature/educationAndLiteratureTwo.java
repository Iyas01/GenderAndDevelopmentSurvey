package com.example.android.genderanddevelopmentsurvey.Categories.EducationAndLiterature;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.android.genderanddevelopmentsurvey.R;

public class educationAndLiteratureTwo extends AppCompatActivity {

//    This activity will only show if the person is aged 15 and above

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_education_and_literature_two);

        final TextView tv_edLitTwo = (TextView) findViewById(R.id.tv_edLitTwo);
        final EditText et_edLitTwo = (EditText) findViewById(R.id.et_edLitTwo);
        RadioButton rb_LitTwo1 = (RadioButton) findViewById(R.id.rb_LitTwo1);
        RadioButton rb_LitTwo2 = (RadioButton) findViewById(R.id.rb_LitTwo2);

        rb_LitTwo1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv_edLitTwo.setVisibility(View.VISIBLE);
                et_edLitTwo.setVisibility(View.VISIBLE);
            }
        });

        rb_LitTwo2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv_edLitTwo.setVisibility(View.GONE);
                et_edLitTwo.setVisibility(View.GONE);
            }
        });
    }
}
