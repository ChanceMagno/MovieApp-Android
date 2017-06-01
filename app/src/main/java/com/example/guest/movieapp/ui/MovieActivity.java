package com.example.guest.movieapp.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.guest.movieapp.R;
import com.example.guest.movieapp.models.Movie;
import com.example.guest.movieapp.services.MovieService;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class MovieActivity extends AppCompatActivity {
public ArrayList<Movie> mMovieList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);

        Intent intent = getIntent();
        String title = intent.getStringExtra("title");

        getMovieList(title);
    }

    private void getMovieList(String title) {

        final MovieService movieService = new MovieService();

        movieService.searchTitles(title, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
               mMovieList =  movieService.processResults(response);

                MovieActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Log.i("movies", mMovieList.get(0).getTitle());
                    }
                });
            }
        });
    }
}
