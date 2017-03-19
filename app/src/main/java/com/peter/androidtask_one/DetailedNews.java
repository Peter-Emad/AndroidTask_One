package com.peter.androidtask_one;

/**
 * Created by Peter on 19/03/2017.
 */

public class DetailedNews {


    private String NewsTitle;
    private String ItemDescription;

    public String getItemDescription() {
        return ItemDescription;
    }

    public void setItemDescription(String itemDescription) {
        ItemDescription = itemDescription;
    }

    public String getShareURL() {
        return ShareURL;
    }

    public void setShareURL(String shareURL) {
        ShareURL = shareURL;
    }

    private String ShareURL;
    private String Nid;
    private String PostDate;
    private String ImageUrl;
    private String NewsType;
    private String NumofViews;
    private String Likes;

    public String getVideoURL() {
        return VideoURL;
    }

    public void setVideoURL(String videoURL) {
        VideoURL = videoURL;
    }

    private String VideoURL;


    public DetailedNews (String NewsTitle , String ItemDescription , String Nid , String PostDate ,
                         String ImageUrl , String NewsType , String NumofViews , String Likes , String ShareURL , String VideoURL)
    {
        this.setImageUrl(ImageUrl);
        this.setNewsTitle(NewsTitle);
        this.setNid(Nid);
        this.setPostDate(PostDate);
        this.setNewsType(NewsType);
        this.setNumofViews(NumofViews);
        this.setLikes(Likes);
        this.setItemDescription(ItemDescription);
        this.setShareURL(ShareURL);
        this.setVideoURL(VideoURL);


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
