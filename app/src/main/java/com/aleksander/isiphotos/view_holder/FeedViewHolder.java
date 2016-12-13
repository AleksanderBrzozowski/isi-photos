package com.aleksander.isiphotos.view_holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.aleksander.isiphotos.R;
import com.aleksander.isiphotos.model.Photo;
import com.aleksander.isiphotos.presenter.OnItemClickListener;
import com.makeramen.roundedimageview.RoundedTransformationBuilder;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author Aleksander
 */

public class FeedViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.item_feed_image)
    ImageView imageView;
    @BindView(R.id.item_feed_profile_image)
    ImageView profileImageView;
    @BindView(R.id.item_feed_username)
    TextView usernameTextView;


    public FeedViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void bind(Photo photo, OnItemClickListener<Photo> onItemClickListener, Picasso picasso) {
        picasso.load(photo.getUrls().getSmall())
                .into(imageView);

        picasso.load(photo.getUser().getProfileImage().getMedium())
                .transform(
                        new RoundedTransformationBuilder()
                                .oval(true)
                                .build()
                )
                .fit()
                .into(profileImageView);

        usernameTextView.setText(photo.getUser().getUsername());
    }

}
