package com.example.kt_truongquy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button exitBtn;
    Intent i;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        exitBtn = findViewById(R.id.exitBtn);
    }

    public void exitHandler(View view) {
        finish();
    }

    public void clickItemHandler(View view) {

        switch (view.getId()) {
            case R.id.kt1:
                i = new Intent(MainActivity.this, KT1Activity.class);
                break;

            case R.id.kt2:
                i = new Intent(MainActivity.this, KT2Activity.class);

                break;

            case R.id.kt3:
                i.putExtra("data", "Khách hàng");
                break;

            case R.id.kt4:
                i.putExtra("data", "Danh sách tuyến");
                break;

            case R.id.kt5:
                i.putExtra("data", "Tra cứu sản phẩm");
                break;
        }

        startActivity(i);
    }
}