package com.peter.androidtask_one;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class NewsDetailActivity extends AppCompatActivity {

    TextView mTVdate , mTVlikes , mTVviews , mTVitemdesc;
    ImageView mIVnewsimage , mIVlikes , mIVviews;
    public static ArrayList<DetailedNews> NewsDetails = new ArrayList<>();
    private ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_detail);
        initi();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading ...");
        progressDialog.show();
        Intent intent = getIntent();
        String value = intent.getStringExtra("Nid");

        FetchingNews FetchDetailedNews = new FetchingNews(NewsDetailActivity.this);
        FetchDetailedNews.DetailedNews(new FetchingNews.DetailsVolleyCallback() {
            @Override
            public void onDetailsSuccess(ArrayList<DetailedNews> result) {
                NewsDetails = result;
                mTVitemdesc.setText(NewsDetails.get(0).getItemDescription());
                Glide.with(NewsDetailActivity.this).load(NewsDetails.get(0).getImageUrl()).into(mIVnewsimage);
                mTVdate.setText(NewsDetails.get(0).getPostDate());
                mTVlikes.setText("Likes(" + NewsDetails.get(0).getLikes()+")");
                mTVviews.setText(NewsDetails.get(0).getNumofViews()+ " views");
                progressDialog.hide();


            }

        } , value);
mTVlikes.setOnClickListener(new View.OnClickListener()
{
    @Override
    public void onClick(View v) {
            mIVlikes.setImageResource(R.drawable.like_clicked);
            mTVlikes.setTextColor(Color.parseColor("#ffea01"));



    }
});
    }
    private void initi()
    {
        mTVdate = (TextView)findViewById(R.id.d_TVdate);
        mTVlikes = (TextView)findViewById(R.id.d_TVlikes);
        mTVviews = (TextView)findViewById(R.id.d_TVviews);
        mTVitemdesc = (TextView)findViewById(R.id.d_TVitemdesc);
        mIVnewsimage = (ImageView)findViewById(R.id.d_IVnews);
        mIVlikes = (ImageView)findViewById(R.id.d_IVlikes);
        mIVviews = (ImageView)findViewById(R.id.d_IVviews);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.share_menu, menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.action_share) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
