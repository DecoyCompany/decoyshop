package com.example.myapplication.adapters;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.entities.Urun;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import com.bumptech.glide.Glide;

import java.util.Comparator;
import java.util.List;


public class urunler_table_adapter extends RecyclerView.Adapter<urunler_table_adapter.UrunViewHolder>
{
    private Context context;
    private List<Urun> urunList;

    // Constructor
    public urunler_table_adapter(Context context, List<Urun> urunList) {
        this.context = context;
        this.urunList = urunList;
    }

    @NonNull
    @Override
    public UrunViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.urun_card, parent, false);
        return new UrunViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UrunViewHolder holder, int position) {
        Urun urun = urunList.get(position);

        urun.getStoklar().sort(Comparator.comparingDouble( stock -> stock.getFiyat() * stock.getIndirim_orani()));

        // Set data to the views
        holder.urunIsmi.setText(urun.getURUN_AD());
        holder.urunFiyat.setText(urun.getStoklar().get(0).getFiyat() + " TL");
        holder.ratingBar.setRating(urun.getUrunPuani());

        // Load the image using Glide
        if(urun.getResimler().isEmpty())
            Glide.with(context).load(R.drawable.baseline_person_24).into(holder.productImage);
        else
            Glide.with(context).load(urun.getResimler().get(0)).into(holder.productImage);

        // Handle button click
        holder.uruneGitButton.setOnClickListener(v -> {
            //TODO
            // Define what happens when the button is clicked
            // For example, navigate to a product details page
        });
    }

    @Override
    public int getItemCount() {
        return urunList.size();
    }

    // ViewHolder Class
    static class UrunViewHolder extends RecyclerView.ViewHolder {

        ImageView productImage;
        TextView urunIsmi, urunFiyat;
        RatingBar ratingBar;
        Button uruneGitButton;

        public UrunViewHolder(@NonNull View itemView) {
            super(itemView);
            productImage = itemView.findViewById(R.id.productImage);
            urunIsmi = itemView.findViewById(R.id.urun_ismi);
            urunFiyat = itemView.findViewById(R.id.urun_fiyat);
            ratingBar = itemView.findViewById(R.id.ratingBar);
            uruneGitButton = itemView.findViewById(R.id.urune_git);
        }
    }
}
