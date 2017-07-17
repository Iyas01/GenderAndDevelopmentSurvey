package com.example.android.genderanddevelopmentsurvey;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.android.genderanddevelopmentsurvey.Categories.Category;

import java.util.ArrayList;

public class DMainActivity extends AppCompatActivity implements GestureDetector.OnGestureListener {

    EditText fromUserInput;
    ArrayList<String> arrHouseholdMems = new ArrayList<>();
    ListView showMems;
    String userInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dmain);


//      Create arrayList from user inputs
        fromUserInput = (EditText) findViewById(R.id.et_dmain);
        Button button = (Button) findViewById(R.id.btn_dmain);
        showMems = (ListView) findViewById(R.id.lv_dmain);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userInput = fromUserInput.getText().toString();

                if (arrHouseholdMems.contains(userInput)) {
                    Toast.makeText(getBaseContext(), "The household member is already added to the list, please check",
                            Toast.LENGTH_SHORT).show();
                } else if (userInput == null | userInput.trim().equals("")) {
                    Toast.makeText(getBaseContext(), "Please provide a valid household member name",
                            Toast.LENGTH_SHORT).show();
                } else {
                    arrHouseholdMems.add(userInput);
                    ArrayAdapter adapter = new ArrayAdapter(DMainActivity.this, android.R.layout.simple_list_item_1,
                            arrHouseholdMems);
                    showMems.setAdapter(adapter);
                    fromUserInput.setText(userInput);
                    fromUserInput.setText("");

                }
            }
        });

//      TODO:  setOnItemClickListener on each item on the ArrayList
        showMems.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(DMainActivity.this, Category.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onDown(MotionEvent e) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {

    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
//        code to remove selected item on the arraylist

        return false;
    }
}
