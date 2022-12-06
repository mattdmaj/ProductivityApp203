package com.example.productivityapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

class PointsViewHolder extends RecyclerView.ViewHolder {
    private final TextView pointsItemView;

    private PointsViewHolder(View itemView){
        super(itemView);
        pointsItemView = itemView.findViewById(R.id.tvPoints);
    }

    public void bind(int text){
        pointsItemView.setText(text);
    }

    static PointsViewHolder create(ViewGroup parent){
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.points_item, parent, false);
        return new PointsViewHolder(view);
    }
}
