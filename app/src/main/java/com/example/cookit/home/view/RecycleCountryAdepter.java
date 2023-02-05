package com.example.cookit.home.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.cookit.R;
import com.example.cookit.model.Category;

import java.util.List;

public class RecycleCountryAdepter extends RecyclerView.Adapter<RecycleCountryAdepter.ViewHolder> {

    private final Context context;
    private List<Category> list;
    public static final String TAG = "RECYCLER";

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public ImageView imageView;
        public TextView name;
        public CardView cardItem;
        public View view;

        public ViewHolder(View v){
            super(v);
            view = v;
            imageView = v.findViewById(R.id.imageCategory);
            name = v.findViewById(R.id.categoryName);
            cardItem = v.findViewById(R.id.cardCategory);

        }
    }

    public RecycleCountryAdepter(Context context, List<Category> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.categoryitem,parent,false);
        ViewHolder viewHolder = new RecycleCountryAdepter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.imageView.setImageResource(R.drawable.egypt);
        holder.name.setText(list.get(position).getStrCategory());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}


