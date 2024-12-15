package com.example.myapplication.http_stuff;


import android.content.SharedPreferences;
import android.content.Context;

import com.example.myapplication.entities.Kullanici;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.concurrent.FutureTask;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;


public class http_request_builder
{
    private static final String base_url = "http://10.0.2.2:1025";
    private static final OkHttpClient client = new OkHttpClient();
    private static final ObjectMapper mapper = new ObjectMapper();

    public static String Register(String userName, String email, String password)
    {
        FutureTask<String> futureTask = new FutureTask<>(() -> {
            try {
                Kullanici kayit = new Kullanici();
                kayit.setKullanici_adi(userName);
                kayit.setEmail(email);
                kayit.setSifre(password);

                RequestBody body = RequestBody.create(mapper.writeValueAsString(kayit),
                        MediaType.get("application/json"));

                Request request = new Request.Builder()
                        .url(base_url + "/register/user")
                        .post(body)
                        .build();

                try (Response response = client.newCall(request).execute())
                {
                    if (response.body() != null) {
                        return response.body().string(); // Response from the server
                    }
                    else
                    {
                        return "Failed to create user: " + response.code();
                    }
                }
            }
            catch (Exception e)
            {
                e.printStackTrace();
                return e.getMessage();
            }
        });
        Thread new_thread = new Thread(futureTask);
        new_thread.start();

        try
        {
            return futureTask.get();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return e.getMessage();
        }
    }

    public static String Login(String email, String password, Context context)
    {
        FutureTask<String> futureTask = new FutureTask<>(() -> {
            try
            {
                RequestBody body = RequestBody.create(password.getBytes());

                Request request = new Request.Builder()
                        .url(base_url + "/auth/login/" + email)
                        .post(body)
                        .build();

                try (Response response = client.newCall(request).execute())
                {
                    if (response.body() != null)
                    {
                        if(!response.isSuccessful())
                        {
                            return response.body().string();
                        }
                        else
                        {
                            SharedPreferences preferences = context.getSharedPreferences("user_data", Context.MODE_PRIVATE);
                            SharedPreferences.Editor editor = preferences.edit();

                            editor.putString("token", response.body().string());
                            editor.putString("user_mail", email);
                            editor.putString("user_password", password);
                            editor.apply();

                            return "Login successful";
                        }
                    }
                    else
                    {
                        return "Failed to login: " + response.code();
                    }
                }
            }
            catch (Exception e)
            {
                e.printStackTrace();
                return e.getMessage();
            }
        });
        Thread new_thread = new Thread(futureTask);
        new_thread.start();

        try
        {
            return futureTask.get();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return e.getMessage();
        }
    }
}
