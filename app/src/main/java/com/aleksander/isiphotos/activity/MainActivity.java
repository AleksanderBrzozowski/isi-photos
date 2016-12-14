package com.aleksander.isiphotos.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.aleksander.isiphotos.R;
import com.aleksander.isiphotos.activity.view.MainActivityView;
import com.aleksander.isiphotos.adapter.FeedAdapter;
import com.aleksander.isiphotos.dagger.ActivityInjectVisitor;
import com.aleksander.isiphotos.model.Photo;
import com.aleksander.isiphotos.presenter.MainActivityPresenter;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;

public class MainActivity extends BaseActivity<MainActivityPresenter> implements MainActivityView {

    @Inject
    FeedAdapter adapter;

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupRecyclerView();
    }

    private void setupRecyclerView() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemViewCacheSize(20);
        recyclerView.setDrawingCacheEnabled(true);
    }

    @Override
    protected void accept(ActivityInjectVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public void showPhotos(List<Photo> photoList) {
        adapter.setPhotoList(photoList);
    }
}
