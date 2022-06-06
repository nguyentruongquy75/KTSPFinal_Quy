package com.example.kt_truongquy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class KT2Activity extends AppCompatActivity {

    EditText yearInput;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kt2);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("KT Số 2");
        actionBar.setDisplayHomeAsUpEnabled(true);

        yearInput = findViewById(R.id.yearInput);
        result = findViewById(R.id.result);
    }



    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;

            case R.id.menu1:
                Toast.makeText(KT2Activity.this, "Bạn chọn Menu 1", Toast.LENGTH_SHORT).show();
                break;

            case R.id.menu2:
                Toast.makeText(KT2Activity.this, "Bạn chọn Menu 2", Toast.LENGTH_SHORT).show();
                break;

            case R.id.menu3:
                Toast.makeText(KT2Activity.this, "Bạn chọn Menu 3", Toast.LENGTH_SHORT).show();
                break;

            default: break;
        }

        return super.onOptionsItemSelected(item);
    }

    public void xuLyDuongSangAm(View view) {
        String []arrCan={"Canh","Tân","Nhâm","Quý","Giáp","Ất","Bính","Đinh","Mậu","Kỷ"};
        String []arrChi={"Thân","Dậu","Tuất","Hợi","Tý","Sửu","Dần","Mẹo","Thìn","Tỵ","Ngọ","Mùi"};
        int namDuong=Integer.parseInt(yearInput.getText().toString());
        String can=arrCan[namDuong%10];
        String chi=arrChi[namDuong%12];

        result.setText(can +" " + chi);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mymenu, menu);
        return true;
    }
}