package com.example.myfavoritecatalogue;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import static com.example.myfavoritecatalogue.DatabaseContract.FavoriteColumns.CONTENT_URI;
import static com.example.myfavoritecatalogue.MappingHelper.mapCursorToArrayList;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements RecyclerViewClickListener  {

    private RecyclerView recyclerViewList;
    private ProgressBar progressBar;
    private ArrayList<Movie> movieArrayList;
    private ListMovieAdapter listMovieAdapter;
    private static String LIST = "list";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerViewList = findViewById(R.id.rv_main);
        progressBar = findViewById(R.id.pb_main);

        movieArrayList = new ArrayList<>();
        listMovieAdapter = new ListMovieAdapter(this);

        recyclerViewList.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewList.setAdapter(listMovieAdapter);
        listMovieAdapter.setListMovie(movieArrayList);
        listMovieAdapter.setRecyclerViewClickListener(this);

        if (savedInstanceState == null) {
            loadData();
        } else {
            movieArrayList = savedInstanceState.getParcelableArrayList(LIST);
            if (movieArrayList != null) {
                listMovieAdapter.setListMovie(movieArrayList);
            }

        }

    }

    @Override
    public void onItemClicked(int position) {

    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelableArrayList(LIST, listMovieAdapter.getListMovie());
    }

    private void loadData() {
        new MovieAsyncTask().execute();
    }

    private class MovieAsyncTask extends AsyncTask<Void, Void, Cursor> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            recyclerViewList.setVisibility(View.GONE);
            progressBar.setVisibility(View.VISIBLE);
        }

        @Override
        protected Cursor doInBackground(Void... voids) {
            return getContentResolver().query(CONTENT_URI, null, null, null, null);
        }
        @Override
        protected void onPostExecute(Cursor cursor) {
            super.onPostExecute(cursor);
            recyclerViewList.setVisibility(View.VISIBLE);
            progressBar.setVisibility(View.GONE);

            movieArrayList = mapCursorToArrayList(cursor);
            listMovieAdapter.setListMovie(movieArrayList);
        }

    }
}
