package com.example.stationeryapp;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private StationaryAdapter adapter;
    private List<StationaryItem> stationaryItemList;
    private List<StationaryItem> filteredList;
    private EditText searchBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        searchBar = findViewById(R.id.search_bar);
        recyclerView = findViewById(R.id.recycler_view);

        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));

        // Initialize the list of stationery items
        stationaryItemList = new ArrayList<>();
        stationaryItemList.add(new StationaryItem("Pencil", R.drawable.pen, "A high-quality pencil.", 1.99));
        stationaryItemList.add(new StationaryItem("Pen", R.drawable.pen, "A smooth writing pen.", 2.49));
        stationaryItemList.add(new StationaryItem("Notebook", R.drawable.nootbook, "A lined notebook for notes.", 3.99));
        stationaryItemList.add(new StationaryItem("Eraser", R.drawable.calculator, "An eraser for pencils.", 0.99));
        stationaryItemList.add(new StationaryItem("Calculator", R.drawable.calculator, "A basic calculator.", 4.99));
        stationaryItemList.add(new StationaryItem("Pencil", R.drawable.pen, "A high-quality pencil.", 1.99));
        stationaryItemList.add(new StationaryItem("Pen", R.drawable.pen, "A smooth writing pen.", 2.49));
        stationaryItemList.add(new StationaryItem("Notebook", R.drawable.nootbook, "A lined notebook for notes.", 3.99));
        stationaryItemList.add(new StationaryItem("Eraser", R.drawable.calculator, "An eraser for pencils.", 0.99));
        stationaryItemList.add(new StationaryItem("Calculator", R.drawable.calculator, "A basic calculator.", 4.99));

        // Initially, the filtered list will contain all the items
        filteredList = new ArrayList<>(stationaryItemList);

        // Setup adapter and RecyclerView
        adapter = new StationaryAdapter(filteredList);
        recyclerView.setAdapter(adapter);

        searchBar.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                filter(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }

    private void filter(String text) {
        filteredList.clear();
        if (text.isEmpty()) {
            filteredList.addAll(stationaryItemList);
        } else {
            for (StationaryItem item : stationaryItemList) {
                if (item.getName().toLowerCase().contains(text.toLowerCase())) {
                    filteredList.add(item);
                }
            }
        }
        // Notify the adapter about the changes
        adapter.notifyDataSetChanged();
    }
}
