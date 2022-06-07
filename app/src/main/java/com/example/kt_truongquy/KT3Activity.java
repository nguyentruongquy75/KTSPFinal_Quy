package com.example.kt_truongquy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class KT3Activity extends AppCompatActivity {

    Button listView1Btn, listView2Btn, listView3Btn;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kt3);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("KT Số 3");
        actionBar.setDisplayHomeAsUpEnabled(true);

        listView1Btn = findViewById(R.id.listView1Btn);
        listView2Btn = findViewById(R.id.listView2Btn);
        listView3Btn = findViewById(R.id.listView3Btn);


        listView1Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(KT3Activity.this, Listview1Activity.class);
                startActivity(intent);
            }
        });

        listView2Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(KT3Activity.this, Listview2Activity.class);
                startActivity(intent);
            }
        });

        listView3Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(KT3Activity.this, Listview3Activity.class);
                startActivity(intent);
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
                Intent intent = new Intent(KT3Activity.this, ProfileActivity.class);
                startActivity(intent);
                break;

            case R.id.menu2:
                Toast.makeText(KT3Activity.this, "Bạn chọn Menu 2", Toast.LENGTH_SHORT).show();
                break;

            case R.id.menu3:
                Toast.makeText(KT3Activity.this, "Bạn chọn Menu 3", Toast.LENGTH_SHORT).show();
                break;

            default: break;
        }

        return super.onOptionsItemSelected(item);
    }


}