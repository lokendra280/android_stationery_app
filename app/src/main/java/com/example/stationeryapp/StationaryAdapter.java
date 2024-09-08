package com.example.stationeryapp;

import android.app.Activity;
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

public class StationaryAdapter extends RecyclerView.Adapter<StationaryAdapter.ViewHolder> {

    private final List<StationaryItem> itemList;
    private final Context context;

    public StationaryAdapter(Context context, List<StationaryItem> itemList) {
        this.context = context;
        this.itemList = itemList;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_stationary, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        StationaryItem item = itemList.get(position);
        holder.itemName.setText(item.getName());
        holder.itemImage.setImageResource(item.getImageResource());
        holder.itemPrice.setText(String.format("$%.2f", item.getPrice()));

        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, ItemDetailActivity.class);
            intent.putExtra("item_name", item.getName());
            intent.putExtra("item_image", item.getImageResource());
            intent.putExtra("item_description", item.getDescription());
            intent.putExtra("item_price", item.getPrice());
            if (context instanceof Activity) {
                ((Activity) context).startActivity(intent);
            } else {
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }

        });
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView itemName;
        public ImageView itemImage;
     public TextView itemPrice;

        public ViewHolder(View view) {
            super(view);
            itemName = view.findViewById(R.id.item_name);
            itemImage = view.findViewById(R.id.item_image);
            itemPrice = itemView.findViewById(R.id.item_price);

        }
    }
}
