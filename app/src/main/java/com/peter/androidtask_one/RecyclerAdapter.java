package com.peter.androidtask_one;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by Peter on 16/03/2017.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {

    Context mCtx;
    ArrayList<NewsElement> ArrayOfNews = new ArrayList<>();

    public RecyclerAdapter(ArrayList<NewsElement> ArrayOfNews , Context mCtx)
    {
        this.ArrayOfNews = ArrayOfNews;
        this.mCtx = mCtx;
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item,parent,false);
       MyViewHolder myViewHolder = new MyViewHolder(view);

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {

        if(ArrayOfNews.get(position).getNewsTitle().length() > 120)
        {
            holder.mNewsTitle.setTextSize(13);
            holder.mNewsTitle.setText(ArrayOfNews.get(position).getNewsTitle());

        }
        else
        {
            holder.mNewsTitle.setTextSize(14);
            holder.mNewsTitle.setText(ArrayOfNews.get(position).getNewsTitle());
        }
        holder.mLikes.setText("Likes(" + ArrayOfNews.get(position).getLikes()+")");
        holder.mNumOfViews.setText(ArrayOfNews.get(position).getNumofViews()+ " views");
        holder.mPostDate.setText(ArrayOfNews.get(position).getPostDate());
        if(Integer.valueOf(ArrayOfNews.get(position).getNewsType()) == 84)
        {
            Glide.with(mCtx).load(R.drawable.article_label).into(holder.mType);
        }
        else             Glide.with(mCtx).load(R.drawable.video_label).into(holder.mType);


   //    Glide.with(mCtx).load(ArrayOfNews.get(position).getImageUrl()).into(holder.mNewsImage);

        Glide.with(mCtx).load(ArrayOfNews.get(position).getImageUrl()).asBitmap().centerCrop().into(new BitmapImageViewTarget(holder.mNewsImage) {
            @Override
            protected void setResource(Bitmap resource) {
                RoundedBitmapDrawable circularBitmapDrawable =
                        RoundedBitmapDrawableFactory.create(mCtx.getResources(), resource);
                circularBitmapDrawable.setCircular(true);

                holder.mNewsImage.setImageDrawable(circularBitmapDrawable);
            }
        });
    }

    @Override
    public int getItemCount() {
        return ArrayOfNews.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder
    {
     TextView mNewsTitle , mPostDate , mNumOfViews , mLikes;
        ImageView mNewsImage , mType;

        public MyViewHolder(View itemView) {
            super(itemView);
            mNewsTitle = (TextView)itemView.findViewById(R.id.TVtitle);
            mPostDate = (TextView)itemView.findViewById(R.id.TVdate);
            mNumOfViews = (TextView)itemView.findViewById(R.id.TVviews);
            mLikes = (TextView)itemView.findViewById(R.id.TVlikes);
            mNewsImage = (ImageView)itemView.findViewById(R.id.IVnews);
            mType = (ImageView)itemView.findViewById(R.id.IVtype);
        }
    }



    }

