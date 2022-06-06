package com.example.kt_truongquy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button exitBtn;
    Intent i;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        exitBtn = findViewById(R.id.exitBtn);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mymenu, menu);
        return true;
    }

    public void exitHandler(View view) {
        XuLyThoat();
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
                i = new Intent(MainActivity.this, KT3Activity.class);
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

    private void XuLyThoat() {
        //Tạo đối tượng
        AlertDialog.Builder b = new AlertDialog.Builder(this);
        //Thiết lập tiêu đề
        b.setTitle("Xác nhận");
        b.setMessage("Bạn có đồng ý thoát chương trình không?");
        // Nút Ok
        b.setPositiveButton("Đồng ý", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                finish();
            }
        });
        //Nút Cancel
        b.setNegativeButton("Không đồng ý", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.cancel();
            }
        });
        //Tạo dialog
        AlertDialog al = b.create();
        //Hiển thị
        al.show();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu1:
                Toast.makeText(MainActivity.this, "Bạn chọn Menu 1", Toast.LENGTH_SHORT).show();
                break;

            case R.id.menu2:
                Toast.makeText(MainActivity.this, "Bạn chọn Menu 2", Toast.LENGTH_SHORT).show();
                break;

            case R.id.menu3:
                Toast.makeText(MainActivity.this, "Bạn chọn Menu 3", Toast.LENGTH_SHORT).show();
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}