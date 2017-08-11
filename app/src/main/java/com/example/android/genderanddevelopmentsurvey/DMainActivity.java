package com.example.android.genderanddevelopmentsurvey;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.baoyz.swipemenulistview.SwipeMenu;
import com.baoyz.swipemenulistview.SwipeMenuCreator;
import com.baoyz.swipemenulistview.SwipeMenuItem;
import com.baoyz.swipemenulistview.SwipeMenuListView;
import com.example.android.genderanddevelopmentsurvey.Categories.Category;

import java.util.ArrayList;

//SwipeMenuListView is deprecated in favor of the new "RecyclerView"
public class DMainActivity extends AppCompatActivity {
    //    private static final String TAG = "DMainActivity"; - for logging purposes
    EditText fromUserInput;
    ArrayList<String> arrHouseholdMems = new ArrayList<>();
    SwipeMenuListView showMems;
    String userInput;
    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dmain);

//        name the toolbar
        this.setTitle("Add Household Members");

//      Create arrayList from user inputs
        fromUserInput = (EditText) findViewById(R.id.et_dmain);
        Button button = (Button) findViewById(R.id.btn_dmain); //add button
        showMems = (SwipeMenuListView) findViewById(R.id.lv_dmain);

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
                    adapter = new ArrayAdapter<>(DMainActivity.this, android.R.layout.simple_list_item_1,
                            arrHouseholdMems);
                    showMems.setAdapter(adapter);
                    fromUserInput.setText(userInput);
                    fromUserInput.setText("");
                }
            }
        });

        showMems.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(DMainActivity.this, Category.class);
//            Place the clicked household members name and send it to the next activity
                intent.putExtra("householdMem", showMems.getItemAtPosition(position).toString());
                startActivity(intent);
            }
        });

        SwipeMenuCreator creator = new SwipeMenuCreator() {

            @Override
            public void create(SwipeMenu menu) {
//                // create "open" item
//                SwipeMenuItem openItem = new SwipeMenuItem(
//                        getApplicationContext());
//                // set item background
//                openItem.setBackground(new ColorDrawable(Color.rgb(0xFF, 0x00,
//                        0x00)));
//                // set item width
//                openItem.setWidth(170);
//                // set item title
//                openItem.setTitle("Open");
//                // set item title fontsize
//                openItem.setTitleSize(18);
//                // set item title font color
//                openItem.setTitleColor(Color.WHITE);
//                // add to menu
//                menu.addMenuItem(openItem);

                // create "delete" item
                SwipeMenuItem deleteItem = new SwipeMenuItem(
                        getApplicationContext());
                // set item background
                deleteItem.setBackground(new ColorDrawable(Color.rgb(0xFF,
                        0x00, 0x00)));
                // set item width
                deleteItem.setWidth(85);
                // set a icon
                deleteItem.setIcon(R.drawable.ic_delete);
                // add to menu
                menu.addMenuItem(deleteItem);
            }
        };

        showMems.setMenuCreator(creator);

        showMems.setOnMenuItemClickListener(new SwipeMenuListView.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(int position, SwipeMenu menu, int index) {
                switch (index) {
                    case 0:
                        // delete
                        arrHouseholdMems.remove(position);
                        adapter.notifyDataSetChanged();
                        break;
//                    case 1:
//                        // open
//                        break;
                }
                // false : not close the menu; true : close the menu
                return true;
            }
        });
    }
}
