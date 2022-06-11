package com.example.kt_truongquy;

import android.app.Activity;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.kt_truongquy.model.Product;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class ProductAdapter extends ArrayAdapter {
    Activity activity;

    public ProductAdapter(Activity activity, ArrayList products) {
        super(activity,0, products);
        this.activity = activity;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        if(convertView==null){
            LayoutInflater inflater = this.activity.getLayoutInflater();
            convertView = inflater.inflate(R.layout.product_item,null);

        }

        TextView productName = convertView.findViewById(R.id.productName);
        TextView productPrice = convertView.findViewById(R.id.productPrice);
        ImageView productImage = convertView.findViewById(R.id.productImage);

        ArrayList<Product> products = Product.getProducts();

        Product product = products.get(position);

        productName.setText(product.getName());
        productPrice.setText((String)(new DecimalFormat("#,###.##")).format(product.getPrice()));

        int imageId = getContext().getResources().getIdentifier(product.getImage(),"mipmap", getContext().getPackageName());

        productImage.setImageResource(imageId);



        return convertView;
    }


}
