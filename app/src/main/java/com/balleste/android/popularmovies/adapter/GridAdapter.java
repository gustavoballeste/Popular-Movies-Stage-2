package com.balleste.android.popularmovies.adapter;

import android.content.Context;
import android.database.Cursor;
import android.support.v4.widget.CursorAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.balleste.android.popularmovies.MoviesFragment;
import com.balleste.android.popularmovies.R;
import com.squareup.picasso.Picasso;

public class GridAdapter extends CursorAdapter {

    public GridAdapter(Context context, Cursor c, int flags) {
        super(context, c, flags);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {

        View view = LayoutInflater.from(context).inflate(R.layout.list_item_movie, parent, false);
        return view;
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {

        String url = cursor.getString(MoviesFragment.COL_IMAGE);
        ImageView imageView = (ImageView) view.findViewById(R.id.list_item_movie_imageview);
        Picasso.with(context).load(url).placeholder(R.mipmap.grid_placeholder).into(imageView);
    }

}
