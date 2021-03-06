package com.aleksander.isiphotos.view_holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.aleksander.isiphotos.R;
import com.aleksander.isiphotos.model.Photo;
import com.aleksander.isiphotos.presenter.OnItemClickListener;
import com.aleksander.isiphotos.utils.ColorUtils;
import com.aleksander.isiphotos.view.WidthRatioImageView;
import com.makeramen.roundedimageview.RoundedTransformationBuilder;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author Aleksander
 */

public class FeedViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.item_feed_image)
    WidthRatioImageView imageView;
    @BindView(R.id.item_feed_profile_image)
    ImageView profileImageView;
    @BindView(R.id.item_feed_username)
    TextView usernameTextView;
    @BindView(R.id.item_feed_likes)
    TextView likesTextView;


    public FeedViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void bind(Photo photo, OnItemClickListener<Photo> onItemClickListener, Picasso picasso) {
        likesTextView.setText(String.valueOf(photo.getLikes()));

        imageView.setRatio((float)photo.getHeight() / photo.getWidth());
        picasso.load(photo.getUrls().getRegular())
                .into(imageView);
        imageView.setOnClickListener(view -> onItemClickListener.onItemClicked(photo));

        picasso.load(photo.getUser().getProfileImage().getMedium())
                .transform(
                        new RoundedTransformationBuilder()
                                .oval(true)
                                .borderWidthDp(0.5f)
                                .borderColor(ColorUtils.getThemeAccentColor(itemView.getContext()))
                                .build()
                ).into(profileImageView);

        usernameTextView.setText(photo.getUser().getUsername());
    }

}
