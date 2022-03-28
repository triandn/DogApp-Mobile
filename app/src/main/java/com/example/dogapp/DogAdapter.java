package com.example.dogapp;

import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dogapp.model.DogBreed;
import com.example.dogapp.viewmodel.DogsApiService;
import com.squareup.picasso.Picasso;


import java.util.ArrayList;
import java.util.List;

public  class DogAdapter extends RecyclerView.Adapter<DogAdapter.DogHolder>{
    private List<DogBreed> dogs;
    private final  String url_img = "https://raw.githubusercontent.com/DevTides/DogsApi/master/";


    public DogAdapter(List<DogBreed> dogs) {
        this.dogs = dogs;
    }
    @NonNull
    @Override
    public DogHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_item, parent, false);
        return new DogHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull DogHolder holder, int position) {
        holder.textView.setText(dogs.get(position).getName());
        Picasso.get().
                load(dogs.get(position).getUrl()).
                into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return dogs.size();
    }
    static class DogHolder extends RecyclerView.ViewHolder {
        private TextView textView;
        private ImageView imageView;
        public DogHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.tv_name);
            imageView = itemView.findViewById(R.id.iv_photo);
        }
    }
}