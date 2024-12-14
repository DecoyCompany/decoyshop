package com.example.myapplication.http_stuff;

import android.os.Looper;

import com.example.myapplication.entities.Kullanici;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.logging.Handler;

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

                System.out.println("sended a request");

                try (Response response = client.newCall(request).execute())
                {
                    if (response.body() != null) {
                        System.out.println("recived a response with body");
                        String temp = response.body().string();
                        System.out.println(temp);
                        return temp; // Response from the server
                    } else {
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
}
