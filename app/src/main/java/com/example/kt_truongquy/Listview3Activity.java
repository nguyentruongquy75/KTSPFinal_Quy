package com.example.kt_truongquy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.kt_truongquy.model.Contact;

public class Listview3Activity extends AppCompatActivity {
    ArrayAdapter<Contact> arrayAdapter;
    ListView listView;
    Button saveBtn;
    EditText idInput, nameInput, phoneInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview3);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("List View 3");
        actionBar.setDisplayHomeAsUpEnabled(true);


        mapping();

        addEvent();

    }

    private void mapping() {
        listView = findViewById(R.id.listview3);
        saveBtn = findViewById(R.id.saveBtn);
        idInput = findViewById(R.id.listView3IdInput);
        nameInput = findViewById(R.id.listView3NameInput);
        phoneInput = findViewById(R.id.listView3PhoneInput);

        arrayAdapter = new ArrayAdapter<>(Listview3Activity.this, android.R.layout.simple_list_item_1);
        listView.setAdapter(arrayAdapter);
    }

    private void addEvent() {
        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Contact contact = new Contact();

                contact.setId(Integer.parseInt(idInput.getText().toString()));
                contact.setName(nameInput.getText().toString());
                contact.setPhone(phoneInput.getText().toString());

                arrayAdapter.add(contact);

            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Contact contact = arrayAdapter.getItem(position);

                idInput.setText(contact.getId() + "");
                nameInput.setText(contact.getName());
                phoneInput.setText(contact.getPhone());
            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                //Tạo đối tượng
                AlertDialog.Builder b = new AlertDialog.Builder(Listview3Activity.this);
                //Thiết lập tiêu đề
                b.setTitle("Xác nhận");
                b.setMessage("Bạn có muốn xoá không?");
                // Nút Ok
                b.setPositiveButton("Đồng ý", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Contact contact = arrayAdapter.getItem(position);

                        arrayAdapter.remove(contact);

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

                return false;
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
                Intent intent = new Intent(Listview3Activity.this, ProfileActivity.class);
                startActivity(intent);
                break;

            case R.id.menu2:
                Toast.makeText(Listview3Activity.this, "Bạn chọn Menu 2", Toast.LENGTH_SHORT).show();
                break;

            case R.id.menu3:
                Toast.makeText(Listview3Activity.this, "Bạn chọn Menu 3", Toast.LENGTH_SHORT).show();
                break;

            default: break;
        }

        return super.onOptionsItemSelected(item);
    }


}