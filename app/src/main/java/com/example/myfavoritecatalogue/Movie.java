package com.example.myfavoritecatalogue;

import android.os.Parcel;
import android.os.Parcelable;

import org.json.JSONException;
import org.json.JSONObject;

public class Movie implements Parcelable {
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getBackdrop() {
        return backdrop;
    }

    public void setBackdrop(String backdrop) {
        this.backdrop = backdrop;
    }

    public String getPopularity() {
        return popularity;
    }

    public void setPopularity(String popularity) {
        this.popularity = popularity;
    }

    public String getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(String voteCount) {
        this.voteCount = voteCount;
    }

    public double getVoteAverage() {
        return voteAverage;
    }

    public void setVoteAverage(double voteAverage) {
        this.voteAverage = voteAverage;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    private String id;
    private String title;
    private String description;
    private String date;
    private String language;
    private String poster;
    private String backdrop;
    private String popularity;
    private String voteCount;
    private double voteAverage;
    private double rating;

    public Movie(String id, String title, String description, String date, String language, String poster, String backdrop, String popularity, String voteCount, double voteAverage, double rating ) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.date = date;
        this.language = language;
        this.poster = poster;
        this.backdrop = backdrop;
        this.popularity = popularity;
        this.voteCount = voteCount;
        this.voteAverage = voteAverage;
        this.rating = rating;
    }

    protected Movie(Parcel in) {
        id = in.readString();
        title = in.readString();
        date = in.readString();
        description = in.readString();
        poster = in.readString();
        language = in.readString();
        backdrop = in.readString();
        popularity = in.readString();
        voteAverage = in.readDouble();
        voteCount = in.readString();
        rating = in.readDouble();
    }

    public Movie(JSONObject object) {
        try {
            id = object.getString("id");
            title = object.getString("title");
            date = object.getString("release_date");
            description = object.getString("overview");
            poster = object.getString("poster_path");
            language = object.getString("original_language");
            backdrop = object.getString("backdrop_path");
            popularity = object.getString("popularity");
            voteCount = object.getString("vote_count");
            voteAverage = object.getDouble("vote_average");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static final Creator<Movie> CREATOR = new Creator<Movie>() {
        @Override
        public Movie createFromParcel(Parcel source) {
            return new Movie(source);
        }

        @Override
        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int flags) {
        parcel.writeString(id);
        parcel.writeString(title);
        parcel.writeString(date);
        parcel.writeString(description);
        parcel.writeString(poster);
        parcel.writeString(language);
        parcel.writeString(backdrop);
        parcel.writeString(voteCount);
        parcel.writeDouble(voteAverage);
        parcel.writeString(popularity);
        parcel.writeDouble(rating);
    }
}
