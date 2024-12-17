package com.example.myapplication.ui.productpage;

import android.os.Bundle;
import android.content.Intent;
import android.util.Log;
import com.example.myapplication.adapters.yorumlar_adapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.example.myapplication.MainActivity;
import com.example.myapplication.R;
import com.example.myapplication.entities.Urun;
import com.example.myapplication.entities.Yorum;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;

public class ProductPageActivity extends AppCompatActivity {

    int i = 0;

    private static final String base_url = "http://10.0.2.2:1025";

    private void change_resim(int max_i, ImageView resim, List<String> resimler, boolean direction)
    {
        if(direction)
        {
            i = i == max_i ? 0 : i + 1;
        }
        else
        {
            i = i == 0 ? max_i : i - 1;
        }
        Glide.with(this).load(base_url + resimler.get(i)).into(resim);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_product_page);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Intent intent = getIntent();
        if(intent == null)
        {
            intent = new Intent(ProductPageActivity.this, MainActivity.class);
            startActivity(intent);
        }

        final Urun the_urun;
        Urun temp;
        try
        {
            final ObjectMapper mapper = new ObjectMapper();
            temp = mapper.readValue(getIntent().getStringExtra("urun"),
                    mapper.getTypeFactory().constructType(Urun.class));
        }
        catch (Exception e)
        {
            Log.e("mapper",e.getMessage());
            temp = null;
        }

        the_urun = temp;
        if(the_urun == null)
        {
            Log.e("the_urun", "the_urun is emtpty !!!");
            intent = new Intent(ProductPageActivity.this, MainActivity.class);
            startActivity(intent);
        }

        int resim_sayisi = the_urun.getResimler().size();


        ImageView resim = findViewById(R.id.imageView4);
        ImageButton left_arrow = findViewById(R.id.left_arrow);
        ImageButton right_arrow = findViewById(R.id.right_arrow);

        if(resim_sayisi >= 1)
        {
            Glide.with(this).load(base_url + the_urun.getResimler().get(i)).into(resim);

            left_arrow.setOnClickListener(v ->
            {
                change_resim(resim_sayisi - 1, resim, the_urun.getResimler(), false);
            });

            right_arrow.setOnClickListener(v ->
            {
                change_resim(resim_sayisi - 1, resim, the_urun.getResimler(), true);
            });
        }
        else
        {
            Glide.with(this).load(R.drawable.baseline_person_24).into(resim);
        }

        RatingBar ratingBar = findViewById(R.id.ratingBar2);
        ratingBar.setRating(the_urun.getUrunPuani());

        TextView product_title = findViewById(R.id.product_title);
        product_title.setText(the_urun.getURUN_AD());

        TextView product_description = findViewById(R.id.product_description);
        product_description.setText(the_urun.getStoklar().get(0).getAciklama());

        TextView product_price = findViewById(R.id.product_price);
        product_price.setText(the_urun.getStoklar().get(0).getFiyat() + " TL");

        List<Yorum> yorumlar = the_urun.getYorumlar();
        yorumlar.sort((a, b) -> b.getTarih().compareTo(a.getTarih()));

        yorumlar_adapter yorumlar_adapter = new yorumlar_adapter(this, yorumlar);
        RecyclerView yorumlar_list = findViewById(R.id.reviews_list);
        yorumlar_list.setLayoutManager(new LinearLayoutManager(this));
        yorumlar_list.setAdapter(yorumlar_adapter);
    }
}