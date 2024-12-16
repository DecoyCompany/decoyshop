package com.example.myapplication.adapters;



import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.myapplication.R;
import com.example.myapplication.entities.Kategori;
import com.example.myapplication.ui.Kategoriler_urunler_Activity;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;


public class ust_kategoriler_adapter extends RecyclerView.Adapter<ust_kategoriler_adapter.KategoriViewHolder>
{
    private Context context;
    private List<Kategori> ust_kategoriList;
    final ObjectMapper mapper = new ObjectMapper();

    // Constructor
    public ust_kategoriler_adapter(Context context, List<Kategori> kategoriList) {
        this.context = context;
        this.ust_kategoriList = kategoriList;
    }

    @NonNull
    @Override
    public KategoriViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.category_buttons, parent, false);
        return new KategoriViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull KategoriViewHolder holder, int position) {
        Kategori kategori = ust_kategoriList.get(position);

        holder.Kategori_button.setText(kategori.getKATEGORI_ISMI());

        // Handle button click
        holder.Kategori_button.setOnClickListener(v -> {
            try {
                Intent intent = new Intent(context, Kategoriler_urunler_Activity.class);
                intent.putExtra("kategori",mapper.writeValueAsString(kategori));
                intent.putExtra("kategori_parent",mapper.writeValueAsString(kategori.getUstKategori()));
                context.startActivity(intent);
            }
            catch (Exception e)
            {
                Log.e("sıkıntı",e.getMessage());
            }

        });
    }

    @Override
    public int getItemCount() {
        if(ust_kategoriList == null)
            return 0;
        return ust_kategoriList.size();
    }

    // ViewHolder Class
    static class KategoriViewHolder extends RecyclerView.ViewHolder {

        Button Kategori_button;

        public KategoriViewHolder(@NonNull View itemView) {
            super(itemView);
            Kategori_button = itemView.findViewById(R.id.Kategori_button);
        }
    }
}
