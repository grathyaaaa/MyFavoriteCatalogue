package com.example.myfavoritecatalogue.Api;

import android.net.Uri;

import com.example.myfavoritecatalogue.BuildConfig;

import java.net.MalformedURLException;
import java.net.URL;

public class Api {
    public static final String API_KEY = BuildConfig.API_KEY;
    private static final String BASE_URL = BuildConfig.BASE_URL;
    private static final String BASE_URL_POSTER = "https://image.tmdb.org/t/p/";
    private static final String KEY = "api_key";
    private static final String SIZE_POSTER = "w185";
    private static final String SIZE_BACKDROP = "original";
    private static final String DISCOVER = "discover";
    private static final String SEARCH = "search";
    public static final String MOVIE = "movie";
    private static final String TV = "tv";
    private static final String UPCOMING = "upcoming";
    private static final String LANGUAGE = "language";
    private static final String EN = "en-US";


    public static URL getPoster(String path) {
        //  https://image.tmdb.org/t/p/w185/zfE0R94v1E8cuKAerbskfD3VfUt.jpg
        path = path.startsWith("/") ? path.substring(1) : path;
        Uri uri = Uri.parse(BASE_URL_POSTER).buildUpon()
                .appendPath(SIZE_POSTER)
                .appendPath(path)
                .build();
        URL url = null;
        try {
            url = new URL(uri.toString());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return url;
    }

}
