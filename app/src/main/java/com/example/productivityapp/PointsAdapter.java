package com.example.productivityapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PointsAdapter extends ListAdapter<Points, PointsViewHolder> {
    public PointsAdapter(@NonNull DiffUtil.ItemCallback<Points> diffCallback) {
        super(diffCallback);
    }

    @NonNull
    @Override
    public PointsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return PointsViewHolder.create(parent);
    }

    @Override
    public void onBindViewHolder(@NonNull PointsViewHolder holder, int position) {
        Points current = getItem(position);
        holder.bind(current.getPoints());
    }

    static class PointsDiff extends DiffUtil.ItemCallback<Points> {
        @Override
        public boolean areItemsTheSame(@NonNull Points oldItem, @NonNull Points newItem) {
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull Points oldItem, @NonNull Points newItem) {
            return false;
        }
    }
}
