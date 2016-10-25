package com.balleste.android.popularmovies.queries;

import android.content.Context;
import android.database.Cursor;
import android.os.AsyncTask;

import com.balleste.android.popularmovies.MoviesFragment;
import com.balleste.android.popularmovies.data.MovieContract;
import com.balleste.android.popularmovies.model.Movie;

import java.util.ArrayList;
import java.util.List;

public class FetchFavoriteMoviesTask extends AsyncTask<Void, Void, List<Movie>> {

    private Context mContext;
    private MoviesFragment mFragment;

    public FetchFavoriteMoviesTask(Context context, MoviesFragment fragment) {
        mContext = context;
        mFragment = fragment;
    }

    @Override
    protected List<Movie> doInBackground(Void... params) {
        Cursor cursor = mContext.getContentResolver().query(
                MovieContract.MovieEntry.CONTENT_URI,
                MoviesFragment.MOVIE_COLUMNS,
                null,
                null,
                null
        );

        List<Movie> results = new ArrayList<>();
        if (cursor != null && cursor.moveToFirst()) {
            do {
                Movie movie = new Movie(cursor);
                results.add(movie);
            } while (cursor.moveToNext());
            cursor.close();
        }
        return results;
    }

}
