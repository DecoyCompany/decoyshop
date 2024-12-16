package com.example.myapplication.http_stuff;


import static javax.crypto.Cipher.SECRET_KEY;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.Context;
import android.util.Log;

import com.example.myapplication.entities.Kategori;
import com.example.myapplication.entities.Kullanici;
import com.example.myapplication.entities.Urun;
import com.example.myapplication.ui.login.LoginActivity;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
                        .header("Content-Type", "application/json")
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

    public static List<Urun> getUrunlerPopular(int limit, Context context)
    {
        SharedPreferences preferences = context.getSharedPreferences("user_data", Context.MODE_PRIVATE);
        String token = preferences.getString("token", null);
        FutureTask<List<Urun>> futureTask = new FutureTask<>(() -> {
            try
            {
                if (token == null)
                {
                    Log.e("Auth", "Token is missing, redirecting to login");
                    return null;
                }

                Request request = new Request.Builder()
                        .url(base_url + "/CRUD/read/Urun/"+limit +"/0")
                        .get()
                        .header("Authorization","Bearer " + token)
                        .build();

                Log.e("Auth",request.toString());

                try (Response response = client.newCall(request).execute())
                {
                    if (response.body() != null && response.isSuccessful())
                    {
                        String value = response.body().string();
                        Log.e("output",value);
                        return mapper.readValue(value,
                                mapper.getTypeFactory().constructCollectionType(List.class, Urun.class));
                    }
                    else
                    {
                        Log.e("API", "Failed to get products or received empty response. " + response.toString());
                        return null;
                    }
                }
            }
            catch (Exception e)
            {
                Log.e("API", "Error during request execution", e);
                return null;
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
            Log.e("API", "Error in getting products", e);
            return null;
        }
    }

    public static List<Kategori> getKategoriler(Context context) {
        SharedPreferences preferences = context.getSharedPreferences("user_data", Context.MODE_PRIVATE);
        String token = preferences.getString("token", null);
        FutureTask<List<Kategori>> futureTask = new FutureTask<>(() -> {
            try {
                if (token == null) {
                    Log.e("Auth", "Token is missing, redirecting to login");
                    return null;
                }

                Request request = new Request.Builder()
                        .url(base_url + "/CRUD/read/Kategoriler/all")
                        .get()
                        .header("Authorization", "Bearer " + token)
                        .build();

                Log.e("Auth", request.toString());

                try (Response response = client.newCall(request).execute()) {
                    if (response.body() != null && response.isSuccessful()) {
                        String value = response.body().string();
                        Log.e("output",value);
                        return mapper.readValue(value,
                                mapper.getTypeFactory().constructCollectionType(List.class, Kategori.class));
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                Log.e("RequestError", "Error while fetching categories: " + e.getMessage());
            }
            return null;
        });

        Thread thread = new Thread(futureTask);
        thread.start();

        try {
            return futureTask.get();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }



}
