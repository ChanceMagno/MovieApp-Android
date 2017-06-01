package com.example.guest.movieapp.services;

import android.app.DownloadManager;
import android.util.Log;

import com.example.guest.movieapp.Constants;
import com.example.guest.movieapp.models.Movie;

import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Guest on 6/1/17.
 */

public class MovieService {

    public static void searchTitles(String title, Callback callback) {
        OkHttpClient client = new OkHttpClient.Builder().build();

        HttpUrl.Builder urlBuilder = HttpUrl.parse(Constants.BASE_URL).newBuilder();
        urlBuilder.addQueryParameter(Constants.APP_ID, Constants.API_KEY);
        urlBuilder.addQueryParameter(Constants.QUERY_PARAMETER, title);

        String url = urlBuilder.build().toString();

        Request request = new Request.Builder().url(url).build();

        Call call = client.newCall(request);
        call.enqueue(callback);
    }

    public ArrayList<Movie> processResults(Response response) {
        ArrayList<Movie> movies = new ArrayList<>();

        try{
            String jsonData = response.body().string();
        }
    }

}
