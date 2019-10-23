package com.example.myfavoritecatalogue;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.myfavoritecatalogue.Api.Api;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ListMovieAdapter extends RecyclerView.Adapter<ListMovieAdapter.ViewHolder> {
    private Context context;
    private ArrayList<Movie> movieArrayList;

    public void setRecyclerViewClickListener(RecyclerViewClickListener recyclerViewClickListener) {
        this.recyclerViewClickListener = recyclerViewClickListener;
    }

    private RecyclerViewClickListener recyclerViewClickListener;

    public ListMovieAdapter(Context context) {
        this.context = context;
    }

    private Context getContext() {
        return context;
    }

    public ArrayList<Movie> getListMovie() {
        return movieArrayList;
    }

    public void setListMovie(ArrayList<Movie> movieArrayList) {
        this.movieArrayList = movieArrayList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_list, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ListMovieAdapter.ViewHolder viewHolder, final int position) {

        viewHolder.txtTitle.setText(getListMovie().get(position).getTitle());
        viewHolder.txtDescription.setText(getListMovie().get(position).getDescription());
        viewHolder.txtDate.setText(getListMovie().get(position).getDate());
        String posterPath = getListMovie().get(position).getPoster();
        Glide.with(context).load(Api.getPoster(posterPath))
                .apply(new RequestOptions().override(70, 100))
                .into(viewHolder.imgPoster);

        viewHolder.itemView.setOnClickListener(v -> {
            int itemPosition = viewHolder.getAdapterPosition();
            Log.e("Position", String.valueOf(itemPosition));
            recyclerViewClickListener.onItemClicked(itemPosition);
        });
    }

    @Override
    public int getItemCount() {
        return getListMovie().size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtTitle;
        TextView txtDescription;
        TextView txtDate;
        ImageView imgPoster;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtTitle = itemView.findViewById(R.id.txt_title);
            txtDescription = itemView.findViewById(R.id.txt_description);
            txtDate = itemView.findViewById(R.id.txt_date);
            imgPoster = itemView.findViewById(R.id.img_poster);
        }
    }
}
