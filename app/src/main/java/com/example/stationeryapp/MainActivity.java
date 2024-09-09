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
        stationaryItemList.add(new StationaryItem("Pencil", R.drawable.pencil, "A high-quality pencil. A high-quality pencil.A high-quality pencil.A high-quality pencil.A high-quality pencil.A high-quality pencil.A high-quality pencil.A high-quality pencil.A high-quality pencil.A high-quality pencil.A high-quality pencil.A high-quality pencil.A high-quality pencil.A high-quality pencil.A high-quality pencil.A high-quality pencil.A high-quality pencil.A high-quality pencil.A high-quality pencil.A high-quality pencil.A high-quality pencil.A high-quality pencil.A high-quality pencil.A high-quality pencil.A high-quality pencil.A high-quality pencil.", 1.99));
        stationaryItemList.add(new StationaryItem("Pen", R.drawable.pen, "A pen is a versatile writing instrument that uses ink to produce lines on paper or other surfaces. It is an essential tool for writing, drawing, and note-taking in various settings, from classrooms and offices to creative studios and homes. Pens come in a variety of styles, including ballpoint, rollerball, fountain, and gel pens, each offering a unique writing experience.\n" +
                "\n" +
                "Ink Type: Available in different inks like ballpoint (oil-based), rollerball (water-based), gel, and fountain.\n" +
                "Design: Comes in various designs, including retractable, capped, and twist-action mechanisms.\n" +
                "Grip: Often designed with ergonomic grips for comfortable writing.\n" +
                "Refillable: Many pens are refillable, reducing waste and allowing for a continuous writing experience.\n" +
                "Uses: Ideal for everyday writing tasks, signature signing, and artistic endeavors.\n" +
                "A good pen combines smooth writing performance with durability, making it a reliable companion for all your writing needs.", 2.49));
        stationaryItemList.add(new StationaryItem("Notebook", R.drawable.book, "A notebook is a bound collection of blank or ruled pages used for writing, sketching, and organizing thoughts. It's an indispensable tool for students, professionals, and creatives alike. Notebooks come in various sizes, styles, and formats to suit different needs and preferences.\n" +
                "\n" +
                "Cover: Typically features a durable cover made of materials like cardboard, leather, or plastic, available in various designs and colors.\n" +
                "Pages: Comes with different types of pages, including lined, grid, dotted, or blank, catering to diverse writing and drawing needs.\n" +
                "Binding: Available in various binding options such as spiral, stitched, or perfect bound, ensuring pages stay secure and easy to flip through.\n" +
                "Size: Ranges from compact pocket-sized notebooks to large desk notebooks, offering flexibility for different uses.\n" +
                "Uses: Perfect for note-taking, journaling, sketching, or as a planner. Ideal for school, work, and personal use.\n" +
                "A high-quality notebook enhances your writing experience, making it easier to keep track of your ideas, projects, and daily tasks.", 3.99));
        stationaryItemList.add(new StationaryItem("Eraser", R.drawable.erasser, "An eraser is a versatile tool designed to remove pencil marks or other forms of writing from paper surfaces. It's a must-have accessory for students, artists, and anyone who uses pencils for writing or drawing.\n" +
                "\n" +
                "Material: Typically made from rubber, vinyl, or TPR (thermoplastic rubber), which provides effective removal of pencil marks without damaging the paper.\n" +
                "Shape: Available in various shapes, including rectangular, cylindrical, or pencil-shaped, to cater to different erasing needs and preferences.\n" +
                "Color: Commonly found in shades of white, pink, or blue, though colors may vary based on brand and type.\n" +
                "Features: Some erasers have added features such as being dust-free, smudge-resistant, or designed for precise erasing.\n" +
                "Uses: Ideal for correcting mistakes in writing, sketching, and drawing. Perfect for use in schools, offices, and art studios.\n" +
                "A good-quality eraser ensures clean and efficient removal of pencil marks, making it an essential tool for maintaining neatness and accuracy in your work.", 0.99));
        stationaryItemList.add(new StationaryItem("Eraser", R.drawable.erasser, "An eraser is a versatile tool designed to remove pencil marks or other forms of writing from paper surfaces. It's a must-have accessory for students, artists, and anyone who uses pencils for writing or drawing.\n" +
                "\n" +
                "Material: Typically made from rubber, vinyl, or TPR (thermoplastic rubber), which provides effective removal of pencil marks without damaging the paper.\n" +
                "Shape: Available in various shapes, including rectangular, cylindrical, or pencil-shaped, to cater to different erasing needs and preferences.\n" +
                "Color: Commonly found in shades of white, pink, or blue, though colors may vary based on brand and type.\n" +
                "Features: Some erasers have added features such as being dust-free, smudge-resistant, or designed for precise erasing.\n" +
                "Uses: Ideal for correcting mistakes in writing, sketching, and drawing. Perfect for use in schools, offices, and art studios.\n" +
                "A good-quality eraser ensures clean and efficient removal of pencil marks, making it an essential tool for maintaining neatness and accuracy in your work.", 0.99));

        stationaryItemList.add(new StationaryItem("Calculator", R.drawable.calculator, "A calculator is a practical tool used for performing mathematical calculations quickly and accurately. Whether for simple arithmetic or complex equations, a calculator is an essential device in both academic and professional settings.\n" +
                "\n" +
                "Type: Available in variou Keypads vary from simple, straightforward layouts to more complex arrangements depending on the calculator type.\n" +
                "ith some models featuring dual power sources for convenience.\n" +
                "Uses: Ideal for students, professionals, and anyone needing to perform mathematical calculations. Commonly used in educational environments, business settings, and everyday tasks.", 4.99));
        stationaryItemList.add(new StationaryItem("Pen", R.drawable.pen, "A pen is a versatile writing instrument that uses ink to produce lines on paper or other surfaces. It is an essential tool for writing, drawing, and note-taking in various settings, from classrooms and offices to creative studios and homes. Pens come in a variety of styles, including ballpoint, rollerball, fountain, and gel pens, each offering a unique writing experience.\n" +
                "\n" +
                "Ink Type: Available in different inks like ballpoint (oil-based), rollerball (water-based), gel, and fountain.\n" +
                "Design: Comes in various designs, including retractable, capped, and twist-action mechanisms.\n" +
                "Grip: Often designed with ergonomic grips for comfortable writing.\n" +
                "Refillable: Many pens are refillable, reducing waste and allowing for a continuous writing experience.\n" +
                "Uses: Ideal for everyday writing tasks, signature signing, and artistic endeavors.\n" +
                "A good pen combines smooth writing performance with durability, making it a reliable companion for all your writing needs.", 2.49));
        stationaryItemList.add(new StationaryItem("Pen", R.drawable.pen, "A pen is a versatile writing instrument that uses ink to produce lines on paper or other surfaces. It is an essential tool for writing, drawing, and note-taking in various settings, from classrooms and offices to creative studios and homes. Pens come in a variety of styles, including ballpoint, rollerball, fountain, and gel pens, each offering a unique writing experience.\n" +
                "\n" +
                "Ink Type: Available in different inks like ballpoint (oil-based), rollerball (water-based), gel, and fountain.\n" +
                "Design: Comes in various designs, including retractable, capped, and twist-action mechanisms.\n" +
                "Grip: Often designed with ergonomic grips for comfortable writing.\n" +
                "Refillable: Many pens are refillable, reducing waste and allowing for a continuous writing experience.\n" +
                "Uses: Ideal for everyday writing tasks, signature signing, and artistic endeavors.\n" +
                "A good pen combines smooth writing performance with durability, making it a reliable companion for all your writing needs.", 2.49));
        stationaryItemList.add(new StationaryItem("Eraser", R.drawable.erasser, "An eraser is a versatile tool designed to remove pencil marks or other forms of writing from paper surfaces. It's a must-have accessory for students, artists, and anyone who uses pencils for writing or drawing.\n" +
                "\n" +
                "Material: Typically made from rubber, vinyl, or TPR (thermoplastic rubber), which provides effective removal of pencil marks without damaging the paper.\n" +
                "Shape: Available in various shapes, including rectangular, cylindrical, or pencil-shaped, to cater to different erasing needs and preferences.\n" +
                "Color: Commonly found in shades of white, pink, or blue, though colors may vary based on brand and type.\n" +
                "Features: Some erasers have added features such as being dust-free, smudge-resistant, or designed for precise erasing.\n" +
                "Uses: Ideal for correcting mistakes in writing, sketching, and drawing. Perfect for use in schools, offices, and art studios.\n" +
                "A good-quality eraser ensures clean and efficient removal of pencil marks, making it an essential tool for maintaining neatness and accuracy in your work.", 0.99));
        // Initially, the filtered list will contain all the items
        filteredList = new ArrayList<>(stationaryItemList);

        // Setup adapter and RecyclerView
        adapter = new StationaryAdapter(this, filteredList);
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
