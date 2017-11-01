package net.bewusstlos.feedburner.actvities;

import android.app.ListActivity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v4.widget.SwipeRefreshLayout;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import net.bewusstlos.feedburner.FeedBurner;
import net.bewusstlos.feedburner.R;
import net.bewusstlos.feedburner.api.FeedBurnerAPI;
import net.bewusstlos.feedburner.common.FeedAdapter;
import net.bewusstlos.feedburner.models.Entry;
import net.bewusstlos.feedburner.models.Feed;

import java.util.ArrayList;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends ListActivity {
    @Inject
    public Retrofit retrofit;
    private SwipeRefreshLayout refresher;
    private FeedBurnerAPI feedCall;
    private ProgressDialog mProgressDialog;
    private FeedAdapter mFeedAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FeedBurner.getComponent().inject(this);
        feedCall = retrofit.create(FeedBurnerAPI.class);

        mProgressDialog = new ProgressDialog(this);
        mProgressDialog.setIndeterminate(false);
        mProgressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        mProgressDialog.setTitle(getString(R.string.loading));
        mProgressDialog.setMessage(getString(R.string.please_wait));

        refresher = findViewById(R.id.swiperefresh);
        refresher.setOnRefreshListener(() -> loadFeed());

        getListView().setOnItemClickListener((adapterView, view, i, l) -> {
            Intent intent = new Intent(MainActivity.this, DetailActivity.class);
            intent.putExtra("Url", mFeedAdapter.getEntry(i).getLink());
            startActivity(intent);
        });

        mProgressDialog.show();
        loadFeed();
    }

    private void loadFeed() {
        feedCall.feed().enqueue(new Callback<Feed>() {
            @Override
            public void onResponse(Call<Feed> call, Response<Feed> response) {
                Feed feed = response.body();
                mFeedAdapter = new FeedAdapter(MainActivity.this, (ArrayList<Entry>) feed.getEntry());
                getListView().setAdapter(mFeedAdapter);
                refresher.setRefreshing(false);

                if (mProgressDialog.isShowing())
                    mProgressDialog.hide();
            }

            @Override
            public void onFailure(Call<Feed> call, Throwable t) {
                Log.e("Retrofit", t.getMessage());
                Toast.makeText(MainActivity.this, "Cannot load data", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
