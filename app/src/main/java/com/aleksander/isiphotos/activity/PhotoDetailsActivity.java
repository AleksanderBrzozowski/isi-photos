package com.aleksander.isiphotos.activity;

import android.os.Bundle;

import com.aleksander.isiphotos.R;
import com.aleksander.isiphotos.activity.view.PhotoDetailsView;
import com.aleksander.isiphotos.dagger.ActivityInjectVisitor;
import com.aleksander.isiphotos.model.Photo;
import com.aleksander.isiphotos.presenter.PhotoDetailsPresenter;
import com.aleksander.isiphotos.view.WidthRatioImageView;
import com.squareup.picasso.Picasso;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PhotoDetailsActivity extends BaseActivity<PhotoDetailsPresenter> implements PhotoDetailsView {

    @BindView(R.id.activity_photo_details_image)
    WidthRatioImageView imageView;

    @Inject
    Picasso picasso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_details);
        ButterKnife.bind(this);
    }

    @Override
    protected void accept(ActivityInjectVisitor visitor) {
        visitor.accept(this);
    }

    @Override
    public void setPhoto(Photo photo) {
        imageView.setRatio(photo.getRatio());
        picasso.load(photo.getUrls().getRegular())
                .into(imageView);
    }
}
