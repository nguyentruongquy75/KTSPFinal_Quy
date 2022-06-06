package com.example.kt_truongquy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class Listview2Activity extends AppCompatActivity {
    ListView listView;
    ArrayAdapter<String> arrayAdapter;
    String []provinces;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview2);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("List View 2");
        actionBar.setDisplayHomeAsUpEnabled(true);

        listView = findViewById(R.id.listview2Data);
        provinces = getResources().getStringArray(R.array.provinces);
        arrayAdapter = new ArrayAdapter<String>(Listview2Activity.this, android.R.layout.simple_list_item_1, provinces);

        listView.setAdapter(arrayAdapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(Listview2Activity.this, "Bạn chọn "+provinces[position], Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mymenu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;

            case R.id.menu1:
                Toast.makeText(Listview2Activity.this, "Bạn chọn Menu 1", Toast.LENGTH_SHORT).show();
                break;

            case R.id.menu2:
                Toast.makeText(Listview2Activity.this, "Bạn chọn Menu 2", Toast.LENGTH_SHORT).show();
                break;

            case R.id.menu3:
                Toast.makeText(Listview2Activity.this, "Bạn chọn Menu 3", Toast.LENGTH_SHORT).show();
                break;

            default: break;
        }

        return super.onOptionsItemSelected(item);
    }
}