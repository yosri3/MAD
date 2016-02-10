package com.example.whyinc.shoppinglistadvanced;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

public class NewItemActivity extends AppCompatActivity {
    private EditText titleText;
    private EditText descText;
    private Spinner iconSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_item);

        titleText = (EditText)findViewById(R.id.editTitle);
        descText = (EditText)findViewById(R.id.editDescription);
        iconSpinner = (Spinner)findViewById(R.id.spinner);

        //Create the spinner items
        String[] spinnerItems = {"Apple", "Banana", "Pear"};

        //Create the spinner adapter
        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, spinnerItems);

        //Set the adapter for the spinner
        iconSpinner.setAdapter(spinnerAdapter);
    }
}
