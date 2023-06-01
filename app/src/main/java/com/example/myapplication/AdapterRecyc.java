package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;

public class AdapterRecyc extends RecyclerView.Adapter<AdapterRecyc.ViewHolder> {
    Context context;
    ArrayList<Integer> list;
    AdapterRecyc(Context context, ArrayList<Integer> list){
        this.context = context;
        this.list = list;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.image,parent,false);
        ViewHolder itsView = new AdapterRecyc.ViewHolder(v);
        return itsView;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.immage.setImageResource(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView immage;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            immage = itemView.findViewById(R.id.imageView);
        }
    }
}
