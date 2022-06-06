package com.example.kt_truongquy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class KT1Activity extends AppCompatActivity {

    private EditText editCMND;
    private  EditText editPhoneNumber;
    private EditText editAddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kt1);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("KT Số 1");
        actionBar.setDisplayHomeAsUpEnabled(true);

        mappingElement();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;

            case R.id.menu1:
                Toast.makeText(KT1Activity.this, "Bạn chọn Menu 1", Toast.LENGTH_SHORT).show();
                break;

            case R.id.menu2:
                Toast.makeText(KT1Activity.this, "Bạn chọn Menu 2", Toast.LENGTH_SHORT).show();
                break;

            case R.id.menu3:
                Toast.makeText(KT1Activity.this, "Bạn chọn Menu 3", Toast.LENGTH_SHORT).show();
                break;

            default: break;
        }

        return super.onOptionsItemSelected(item);
    }

    private void mappingElement() {
        editCMND =  findViewById(R.id.CMND);
        editPhoneNumber = findViewById(R.id.phoneNumber);
        editAddress = findViewById(R.id.address);
    }

    public void updateHandler(View view) {
        Toast.makeText(KT1Activity.this , "Đã cập nhật", Toast.LENGTH_SHORT).show();
    }

    public void resetHandler(View view) {
        editCMND.setText("");
        editPhoneNumber.setText("");
        editAddress.setText("");
        editCMND.requestFocus();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mymenu, menu);
        return true;
    }
}