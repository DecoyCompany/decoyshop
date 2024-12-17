package com.example.myapplication.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import com.example.myapplication.R;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.myapplication.entities.Yorum;

import java.util.List;

public class yorumlar_adapter extends RecyclerView.Adapter<yorumlar_adapter.yorumlar_adapterViewHolder> {

    private final Context context;
    private final List<Yorum>  yorumList;

    // Constructor
    public yorumlar_adapter(Context context, List<Yorum> yorumList) {
        this.context = context;
        this.yorumList = yorumList;
    }

    @NonNull
    @Override
    public yorumlar_adapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate the item layout
        View view = LayoutInflater.from(context).inflate(R.layout.yorum_layout, parent, false);
        return new yorumlar_adapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull yorumlar_adapterViewHolder holder, int position) {
        // Get the current user review
        Yorum yorum = yorumList.get(position);

        // Bind data to the views
        holder.userName.setText(yorum.getYorumcuAdi());
        holder.comment.setText(yorum.getYazi());
        holder.ratingBar.setRating(yorum.getPuan());
        holder.date.setText(yorum.getTarih().toString());

        Glide.with(context).load(R.drawable.baseline_person_24).into(holder.avatar);
    }

    @Override
    public int getItemCount() {
        return yorumList.size();
    }

    // ViewHolder class
    public static class yorumlar_adapterViewHolder extends RecyclerView.ViewHolder {

        ImageView avatar;
        TextView userName, comment, date;
        RatingBar ratingBar;

        public yorumlar_adapterViewHolder(@NonNull View itemView) {
            super(itemView);

            // Find views by ID
            avatar = itemView.findViewById(R.id.user_avatar);
            userName = itemView.findViewById(R.id.user_name);
            comment = itemView.findViewById(R.id.yorum_text);
            ratingBar = itemView.findViewById(R.id.yorum_puan);
            date = itemView.findViewById(R.id.textView3);
        }
    }
}
