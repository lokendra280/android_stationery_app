package com.example.stationeryapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ItemDetailActivity extends AppCompatActivity {

    private static final String TAG = "ItemDetailActivity";
    private ImageView itemImage;
    private TextView itemName;
    private TextView itemDescription;
    private TextView itemPrice;
    private Button addToCartButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_detail);

        itemImage = findViewById(R.id.item_detail_image);
        itemName = findViewById(R.id.item_detail_name);
        itemDescription = findViewById(R.id.item_detail_description);
        itemPrice = findViewById(R.id.item_detail_price);
        addToCartButton = findViewById(R.id.add_to_cart_button);

        // Get the item details from the Intent
        Intent intent = getIntent();
        String name = intent.getStringExtra("item_name");
        int imageResId = intent.getIntExtra("item_image", -1); // Default value -1 to check if not set
        String description = intent.getStringExtra("item_description");
        double price = intent.getDoubleExtra("item_price", 0.0);

        // Log the values to debug
        Log.d(TAG, "Item Name: " + name);
        Log.d(TAG, "Item Image ID: " + imageResId);
        Log.d(TAG, "Item Description: " + description);
        Log.d(TAG, "Item Price: " + price);

        // Validate data and set to views
        if (name != null && imageResId != -1 && description != null) {
            itemName.setText(name);
            itemImage.setImageResource(imageResId);
            itemDescription.setText(description);
            itemPrice.setText(String.format("$%.2f", price));
        } else {
            // Handle missing data
            Toast.makeText(this, "Error: Missing item details", Toast.LENGTH_SHORT).show();
            finish(); // Close activity
        }

        addToCartButton.setOnClickListener(v -> {
            Toast.makeText(ItemDetailActivity.this, "Added to cart", Toast.LENGTH_SHORT).show();
        });
    }
}
