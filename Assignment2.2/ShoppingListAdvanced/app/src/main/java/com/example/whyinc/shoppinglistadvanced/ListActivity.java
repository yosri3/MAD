package com.example.whyinc.shoppinglistadvanced;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity {
    private ListView listView;
    private List<ListItem> items;
    private ItemAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        listView = (ListView) findViewById(R.id.listView);
        items = new ArrayList<ListItem>();
        adapter = new ItemAdapter(this, R.layout.row_item, items);
        listView.setAdapter(adapter);

        items.add(new ListItem("Cherry", "YUMMY", R.mipmap.ic_launcher));
        items.add(new ListItem("Mango", "Exotic", R.mipmap.ic_launcher));
        adapter.notifyDataSetChanged();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), NewItemActivity.class);
                startActivityForResult(intent, 1234);
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Create an Intent
                Intent intent = new Intent(ListActivity.this, DetailsActivity.class);
                ListItem clickedItem = (ListItem) parent.getItemAtPosition(position);

                intent.putExtra("title", clickedItem.getTitle());
                intent.putExtra("description", clickedItem.getDescription());
                intent.putExtra("image-resource", clickedItem.getImageResource());

                //Open the new screen by starting the activity
                startActivity(intent);
            }
        });

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        //Check if the result code is the right one
        if (resultCode == Activity.RESULT_OK) {
            //Check if the request code is correct
            if (requestCode == 1234) {
                //Everything's fine, get the values;
                String title = data.getStringExtra("title");
                String description = data.getStringExtra("description");
                int imageResource = data.getIntExtra("image-resource", 0);

                //Create a list item from the values
                ListItem item = new ListItem(title, description, imageResource);

                //Add the new item to the adapter;
                items.add(item);

                //Have the adapter update
                adapter.notifyDataSetChanged();
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

