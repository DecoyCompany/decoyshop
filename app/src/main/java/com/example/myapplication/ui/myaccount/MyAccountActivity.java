package com.example.myapplication.ui.myaccount;
import com.example.myapplication.http_stuff.http_request_builder;

import android.os.Build;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


import com.example.myapplication.R;

public class MyAccountActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_my_account);
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(ContextCompat.getColor(this, R.color.gray_600));
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        TextView email_text = findViewById(R.id.email_text);
        TextView name_text = findViewById(R.id.name_text);
        TextView password_text = findViewById(R.id.password_text);
        TextView error_text = findViewById(R.id.error_text);

        findViewById(R.id.kayit_ol_kayit_ol_button).setOnClickListener(a -> {
            String response = http_request_builder.Register(name_text.getText().toString(),
                    email_text.getText().toString(),
                    password_text.getText().toString());

            if (response == null || response.isEmpty())
            {
                response = "response come null ??";
            }

            error_text.setText(response);
        });
    }
}