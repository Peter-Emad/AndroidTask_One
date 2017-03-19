package com.peter.androidtask_one;

/**
 * Created by Peter on 16/03/2017.
 */

public class NewsElement {

    private String NewsTitle , Nid , PostDate ,ImageUrl ,NewsType ,NumofViews ,Likes;

    public NewsElement(String NewsTitle , String Nid , String PostDate , String ImageUrl , String NewsType , String NumofViews , String Likes )
    {
        this.setImageUrl(ImageUrl);
        this.setNewsTitle(NewsTitle);
        this.setNid(Nid);
        this.setPostDate(PostDate);
        this.setNewsType(NewsType);
        this.setNumofViews(NumofViews);
        this.setLikes(Likes);
    }
    public String getNewsTitle() {
        return NewsTitle;
    }

    public void setNewsTitle(String newsTitle) {
        NewsTitle = newsTitle;
    }

    public String getNid() {
        return Nid;
    }

    public void setNid(String nid) {
        Nid = nid;
    }

    public String getPostDate() {
        return PostDate;
    }

    public void setPostDate(String postDate) {
        PostDate = postDate;
    }

    public String getImageUrl() {
        return ImageUrl;
    }

    public void setImageUrl(String imageUrl) {
        ImageUrl = imageUrl;
    }

    public String getNewsType() {
        return NewsType;
    }

    public void setNewsType(String newsType) {
        NewsType = newsType;
    }

    public String getNumofViews() {
        return NumofViews;
    }

    public void setNumofViews(String numofViews) {
        NumofViews = numofViews;
    }

    public String getLikes() {
        return Likes;
    }

    public void setLikes(String likes) {
        Likes = likes;
    }
}
