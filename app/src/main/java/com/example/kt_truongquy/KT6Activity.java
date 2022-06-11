package com.example.kt_truongquy;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.kt_truongquy.model.Product;

import java.util.ArrayList;

public class KT6Activity extends AppCompatActivity {

    ListView listView;
    ProductAdapter productAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kt6);

        ActionBar actionBar=getSupportActionBar();
        actionBar.setTitle("Sản phẩm");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        listView = findViewById(R.id.lvProduct);


        ArrayList<Product> products = Product.getProducts();

        productAdapter = new ProductAdapter(this,products);
        listView.setAdapter(productAdapter);

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(KT6Activity.this);
                alertDialogBuilder.setMessage("Bán có muốn xóa sản phẩm này!");
                alertDialogBuilder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Product.getProducts().remove(position);
                        productAdapter.notifyDataSetChanged();

                    }
                });
                alertDialogBuilder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
                alertDialogBuilder.show();
                return true;
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(KT6Activity.this, ProductActivity.class);
                intent.putExtra("position", position);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.product_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case android.R.id.home:
                onBackPressed();
                return true;

            case R.id.btnAdd:
                openAddProduct();
                break;
            default:break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void openAddProduct() {
        final AlertDialog builder = new AlertDialog.Builder(this).create();

        final View alert = LayoutInflater.from(this).inflate(R.layout.activity_product,null);

        builder.setView(alert);

        EditText productName = alert.findViewById(R.id.editnamexml);
        EditText productImage = alert.findViewById(R.id.editImagexml);
        EditText productPrice = alert.findViewById(R.id.editpricexml);
        Button buttonOK = alert.findViewById(R.id.btnOK);
        Button buttonCancel = alert.findViewById(R.id.btnCancel);


        buttonOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Product product = new Product();
                product.setName(productName.getText().toString());
                product.setPrice(Integer.parseInt(productPrice.getText().toString()));
                product.setImage(productImage.getText().toString());

                productAdapter.add(product);
                productAdapter.notifyDataSetChanged();
                builder.dismiss();
            }
        });

        buttonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                builder.dismiss();
            }
        });

        builder.show();

    }
}