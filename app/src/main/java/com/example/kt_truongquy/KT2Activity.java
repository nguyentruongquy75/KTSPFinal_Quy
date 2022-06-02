package com.example.kt_truongquy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

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
}