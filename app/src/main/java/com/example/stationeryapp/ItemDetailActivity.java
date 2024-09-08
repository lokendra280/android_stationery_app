package com.example.stationeryapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ItemDetailActivity extends AppCompatActivity {

    private ImageView itemImage;
    private TextView itemName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_detail);

        ImageView itemImage = findViewById(R.id.item_detail_image);
        TextView itemName = findViewById(R.id.item_detail_name);
        TextView itemDescription = findViewById(R.id.item_detail_description);
        TextView itemPrice = findViewById(R.id.item_detail_price);
        Button addToCartButton = findViewById(R.id.add_to_cart_button);

        // Get the item details from the Intent
        String name = getIntent().getStringExtra("item_name");
        int imageResId = getIntent().getIntExtra("item_image", 0);
        String description = getIntent().getStringExtra("item_description");
        double price = getIntent().getDoubleExtra("item_price", 0.0);

        // Set the item details to the views
        itemName.setText(name);
        itemImage.setImageResource(imageResId);
        itemDescription.setText(description);
        itemPrice.setText(String.format("$%.2f", price));

        addToCartButton.setOnClickListener(v -> {
            Toast.makeText(ItemDetailActivity.this, "Added to cart", Toast.LENGTH_SHORT).show();
        });
    }

}
