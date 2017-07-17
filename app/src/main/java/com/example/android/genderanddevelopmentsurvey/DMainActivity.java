package com.example.android.genderanddevelopmentsurvey;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class DMainActivity extends AppCompatActivity {

    EditText fromUserInput;
    ArrayList<String> arrHouseholdMems = new ArrayList<>();
    ListView showMems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dmain);

//        TODO: Create a listview that will list items based on user input, and the users can delete items on the list with a swipe

        fromUserInput = (EditText) findViewById(R.id.et_dmain);
        Button button = (Button) findViewById(R.id.btn_dmain);
        showMems = (ListView) findViewById(R.id.lv_dmain);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userInput = fromUserInput.getText().toString();

                if (arrHouseholdMems.contains(userInput)) {
                    Toast.makeText(getBaseContext(), "The household member is already added to the list, please check", Toast.LENGTH_SHORT).show();
                } else if (userInput == null | userInput.trim().equals("")) {
                    Toast.makeText(getBaseContext(), "Please provide a valid household member name", Toast.LENGTH_SHORT).show();
                } else {
                    arrHouseholdMems.add(userInput);
                    ArrayAdapter adapter = new ArrayAdapter(DMainActivity.this, android.R.layout.simple_list_item_1, arrHouseholdMems);
                    showMems.setAdapter(adapter);
                    fromUserInput.setText(userInput);
                    fromUserInput.setText("");

                }
            }
        });


    }
}
