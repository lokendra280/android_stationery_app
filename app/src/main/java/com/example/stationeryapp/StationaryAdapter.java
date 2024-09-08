package com.example.stationeryapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class StationaryAdapter extends RecyclerView.Adapter<StationaryAdapter.StationaryViewHolder> {

    private List<StationaryItem> stationaryItemList;
    private Context context;

    public StationaryAdapter(List<StationaryItem> stationaryItemList) {
        this.context = context;
        this.stationaryItemList = stationaryItemList;
    }

    @NonNull
    @Override
    public StationaryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_stationary, parent, false);
        return new StationaryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StationaryViewHolder holder, int position) {
        StationaryItem item = stationaryItemList.get(position);
        holder.itemName.setText(item.getName());
        holder.itemImage.setImageResource(item.getImageResource());

        // Handle item click
        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, ItemDetailActivity.class);
            intent.putExtra("item_name", item.getName());
            intent.putExtra("item_image", item.getImageResource());
            intent.putExtra("item_description", item.getDescription());
            intent.putExtra("item_price", item.getPrice());
            context.startActivity(intent);
        });


    }

    @Override
    public int getItemCount() {
        return stationaryItemList.size();
    }

    public static class StationaryViewHolder extends RecyclerView.ViewHolder {

        ImageView itemImage;
        TextView itemName;

        public StationaryViewHolder(@NonNull View itemView) {
            super(itemView);
            itemImage = itemView.findViewById(R.id.item_image);
            itemName = itemView.findViewById(R.id.item_name);
        }
    }
}
