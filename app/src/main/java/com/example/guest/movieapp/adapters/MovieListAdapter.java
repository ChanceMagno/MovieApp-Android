package com.example.guest.movieapp.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.guest.movieapp.R;
import com.example.guest.movieapp.models.Movie;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

import static java.lang.Float.parseFloat;

/**
 * Created by Guest on 6/1/17.
 */

public class MovieListAdapter extends RecyclerView.Adapter<MovieListAdapter.MovieViewHolder> {
    private ArrayList<Movie> mMovies = new ArrayList<>();
    private Context mContext;
    private static final int MAX_WIDTH = 150;
    private static final int MAX_HEIGHT = 200;

    public MovieListAdapter(Context context, ArrayList<Movie> movies) {
        mContext = context;
        mMovies = movies;
    }

    @Override
    public MovieListAdapter.MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_list_item, parent, false);
        MovieViewHolder viewHolder = new MovieViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MovieListAdapter.MovieViewHolder holder, int position) {
        holder.bindMovie(mMovies.get(position));
    }

    @Override
    public int getItemCount() {
        return mMovies.size();
    }


    public class MovieViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.titleTextView) TextView mTitleTextView;
        @Bind(R.id.movieImageView) ImageView mMovieImageView;
        @Bind(R.id.movieOverviewView) TextView mMovieOverviewView;
        @Bind(R.id.ratingBar) RatingBar mRatingBar;
        @Bind(R.id.releaseDateTextView) TextView mReleaseDateTextView;

        public MovieViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();
        }

        public void bindMovie(Movie movie) {
            mTitleTextView.setText(movie.getTitle());
            Picasso.with(itemView.getContext()).load(movie.getPhoto()).resize(MAX_WIDTH, MAX_HEIGHT).centerCrop().into(mMovieImageView);
            mMovieOverviewView.setText(movie.getOverview());
            mReleaseDateTextView.setText(movie.getReleaseDate());
            Log.i("rating", movie.getRating());
            mRatingBar.setRating(parseFloat(movie.getRating()) / 2);
        }
    }
}
