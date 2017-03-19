package com.peter.androidtask_one;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by Peter on 17/03/2017.
 */

public class AppSingleton {
    private static AppSingleton mInstance;
    private RequestQueue requestQueue;
    private static Context mContext;

    private AppSingleton(Context context)
    {
        mContext = context;
        requestQueue = getRequestQueue();
    }


    public RequestQueue getRequestQueue(){
        if(requestQueue == null)
        {
            requestQueue = Volley.newRequestQueue(mContext.getApplicationContext());
        }

        return requestQueue;
    }
    public static synchronized AppSingleton getmInstance(Context context)
    {
        if(mInstance == null)
        {
            mInstance = new AppSingleton(context);
        }
        return mInstance;
    }

    public <T> void addToRequestQueue(Request<T> request)
    {
        requestQueue.add(request);
    }
}
