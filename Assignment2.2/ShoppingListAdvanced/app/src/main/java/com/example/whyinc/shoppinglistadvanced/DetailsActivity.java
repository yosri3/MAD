package com.example.whyinc.shoppinglistadvanced;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {
    private TextView titleText;
    private TextView descText;
    private ImageView icon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        titleText = (TextView) findViewById(R.id.activity_details_title);
        descText = (TextView) findViewById(R.id.activity_details_description);
        icon = (ImageView) findViewById(R.id.activity_details_icon);

        //Get the values from the intent
        int imageResource = getIntent().getIntExtra("image-resource", 0);
        String titleString = getIntent().getStringExtra("title");
        String descriptionString = getIntent().getStringExtra("description");

        //Set the values from the intent to the views
        icon.setImageResource(imageResource);
        titleText.setText(titleString);
        descText.setText(descriptionString);

    }
}
