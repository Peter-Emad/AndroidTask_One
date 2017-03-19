package com.peter.androidtask_one;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Peter on 16/03/2017.
 */

public class FetchingNews {
    Context context;
    ArrayList<NewsElement> ArrayOfNews = new ArrayList<>();
    ArrayList<DetailedNews> DetailedNews = new ArrayList<>();

    String url = "http://egyptinnovate.com/en/api/v01/safe/GetNews";
    JSONArray jsonArrayObj;
    JSONObject jsonObj;



    public FetchingNews(Context context)
    {
        this.context = context;
    }

    public void NewsList(final VolleyCallback callback)
    {
        final JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                try {
                    jsonArrayObj = response.getJSONArray("News");
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                for(int i = 0; i< jsonArrayObj.length(); i++)
                    {
                        NewsElement SingleElement = null;
                        try {
                            SingleElement = new NewsElement(jsonArrayObj.getJSONObject(i).getString("NewsTitle")
                                    , jsonArrayObj.getJSONObject(i).getString("Nid") , jsonArrayObj.getJSONObject(i).getString("PostDate")
                            , jsonArrayObj.getJSONObject(i).getString("ImageUrl") , jsonArrayObj.getJSONObject(i).getString("NewsType")
                            , jsonArrayObj.getJSONObject(i).getString("NumofViews") , jsonArrayObj.getJSONObject(i).getString("Likes") );
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        ArrayOfNews.add(SingleElement);

                    }
                callback.onSuccess(ArrayOfNews);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                error.printStackTrace();

            }
        });

        AppSingleton.getmInstance(context).addToRequestQueue(jsonObjReq);
      //  Volley.newRequestQueue(context).add(jsonObjReq);
    }



    public interface VolleyCallback{
        void onSuccess(ArrayList<NewsElement> result);
    }


    public void DetailedNews(final DetailsVolleyCallback callback , String Nid)
    {

        url = url.concat("Details?nid=" + Nid);
        final JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {
                try {
                    jsonObj = response.getJSONObject("newsItem");
                } catch (JSONException e) {
                    e.printStackTrace();
                }


                    DetailedNews DetailedNewsElement = null;
                    try {
                        DetailedNewsElement = new DetailedNews(jsonObj.getString("NewsTitle")
                                , jsonObj.getString("ItemDescription") , jsonObj.getString("Nid")
                                , jsonObj.getString("PostDate") , jsonObj.getString("ImageUrl")
                                , jsonObj.getString("NewsType") , jsonObj.getString("NumofViews")
                                , jsonObj.getString("Likes") , jsonObj.getString("ShareURL")
                                , jsonObj.getString("VideoURL"));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                DetailedNews.add(DetailedNewsElement);

                callback.onDetailsSuccess(DetailedNews);



            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                error.printStackTrace();

            }
        });

        AppSingleton.getmInstance(context).addToRequestQueue(jsonObjReq);
        //Volley.newRequestQueue(context).add(jsonObjReq);
    }

    public interface DetailsVolleyCallback{
        void onDetailsSuccess(ArrayList<DetailedNews> result);
    }
    
}

