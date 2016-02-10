package com.example.whyinc.shoppinglistadvanced;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class NewItemActivity extends AppCompatActivity {
    private EditText titleText;
    private EditText descText;
    private Spinner iconSpinner;
    private Button addButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_item);

        titleText = (EditText)findViewById(R.id.editTitle);
        descText = (EditText)findViewById(R.id.editDescription);
        iconSpinner = (Spinner)findViewById(R.id.spinner);
        addButton = (Button)findViewById(R.id.addItemButton);

        //Create the spinner items
        String[] spinnerItems = {"Apple", "Banana", "Pear"};

        //Create the spinner adapter
        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, spinnerItems);

        //Set the adapter for the spinner
        iconSpinner.setAdapter(spinnerAdapter);

        //Handle the button click
        addButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //Check if the title and descriptions have text
                if (!TextUtils.isEmpty(titleText.getText()) && !TextUtils.isEmpty(descText.getText())) {

                    //Get the resource value for the selected icon from the spinner
                    int imageResource = 0;
                    switch (iconSpinner.getSelectedItemPosition()) {
                        case 0:
                            imageResource = R.mipmap.ic_launcher;
                            break;
                        case 1:
                            imageResource = R.mipmap.ic_launcher;
                            break;
                        case 2:
                            imageResource = R.mipmap.ic_launcher;
                            break;
                        default:
                            imageResource = R.mipmap.ic_launcher;
                            break;
                    }

                    //Create a new intent with the entered data
                    Intent data = new Intent();
                    data.putExtra("title", titleText.getText().toString());
                    data.putExtra("description", descText.getText().toString());
                    data.putExtra("image-resource", imageResource);

                    //Send the result back to the activity
                    setResult(Activity.RESULT_OK, data);

                    //Finish this activity
                    finish();
                } else {
                    //Show a message to the user
                    Toast.makeText(NewItemActivity.this, "Please enter some text in the title and description fields", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
