package com.example.myfavoritecatalogue;

import android.database.Cursor;

import java.util.ArrayList;

import static com.example.myfavoritecatalogue.DatabaseContract.FavoriteColumns.BACKDROP;
import static com.example.myfavoritecatalogue.DatabaseContract.FavoriteColumns.DATE;
import static com.example.myfavoritecatalogue.DatabaseContract.FavoriteColumns.LANGUAGE;
import static com.example.myfavoritecatalogue.DatabaseContract.FavoriteColumns.OVERVIEW;
import static com.example.myfavoritecatalogue.DatabaseContract.FavoriteColumns.POPULARITY;
import static com.example.myfavoritecatalogue.DatabaseContract.FavoriteColumns.POSTER_PATH;
import static com.example.myfavoritecatalogue.DatabaseContract.FavoriteColumns.RATING;
import static com.example.myfavoritecatalogue.DatabaseContract.FavoriteColumns.TITLE;
import static com.example.myfavoritecatalogue.DatabaseContract.FavoriteColumns.VOTE_AVERAGE;
import static com.example.myfavoritecatalogue.DatabaseContract.FavoriteColumns.VOTE_COUNT;
import static com.example.myfavoritecatalogue.DatabaseContract.FavoriteColumns._ID;


public class MappingHelper {
    public static ArrayList<Movie> mapCursorToArrayList(Cursor notesCursor) {
        ArrayList<Movie> movieArrayList = new ArrayList<>();

        while (notesCursor.moveToNext()) {
            String id = notesCursor.getString(notesCursor.getColumnIndexOrThrow(_ID));
            String title = notesCursor.getString(notesCursor.getColumnIndexOrThrow(TITLE));
            String date = notesCursor.getString(notesCursor.getColumnIndexOrThrow(DATE));
            String overview = notesCursor.getString(notesCursor.getColumnIndexOrThrow(OVERVIEW));
            String poster = notesCursor.getString(notesCursor.getColumnIndexOrThrow(POSTER_PATH));
            String popularity = notesCursor.getString(notesCursor.getColumnIndexOrThrow(POPULARITY));
            String language = notesCursor.getString(notesCursor.getColumnIndexOrThrow(LANGUAGE));
            String backdrop = notesCursor.getString(notesCursor.getColumnIndexOrThrow(BACKDROP));
            String voteCount = notesCursor.getString(notesCursor.getColumnIndexOrThrow(VOTE_COUNT));
            double voteAverage = notesCursor.getDouble(notesCursor.getColumnIndexOrThrow(VOTE_AVERAGE));
            double rating = notesCursor.getDouble(notesCursor.getColumnIndexOrThrow(RATING));
            movieArrayList.add(new Movie(id, title, date, overview, poster, popularity, language, backdrop, voteCount, voteAverage, rating));

        }
        return movieArrayList;
    }
}
