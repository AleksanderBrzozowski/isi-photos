package com.aleksander.isiphotos.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aleksander.isiphotos.R;
import com.aleksander.isiphotos.dagger.ActivityScope;
import com.aleksander.isiphotos.model.Photo;
import com.aleksander.isiphotos.presenter.MainActivityPresenter;
import com.aleksander.isiphotos.view_holder.FeedViewHolder;
import com.squareup.picasso.Picasso;

import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

/**
 * @author Aleksander
 */

@ActivityScope
public class FeedAdapter extends RecyclerView.Adapter<FeedViewHolder>{

    private final MainActivityPresenter presenter;
    private final Picasso picasso;

    private List<Photo> photoList = Collections.emptyList();

    @Inject
    public FeedAdapter(MainActivityPresenter presenter, Picasso picasso) {
        this.presenter = presenter;
        this.picasso = picasso;
    }

    @Override
    public FeedViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_feed, parent, false);
        return new FeedViewHolder(view);
    }

    @Override
    public void onBindViewHolder(FeedViewHolder holder, int position) {
        holder.bind(photoList.get(position), presenter, picasso);
    }

    @Override
    public int getItemCount() {
        return photoList.size();
    }

    public void setPhotoList(@NonNull List<Photo> photoList) {
        this.photoList = photoList;
        notifyDataSetChanged();
    }
}
