package com.cataclysm.android.cataclysm;


import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class Mysingleton {
    private static Mysingleton minstance;
    private RequestQueue requestQueue;
    private static Context ctx;

    private Mysingleton(Context context) {
        ctx = context;
        requestQueue = getrequestque();

    }

    public RequestQueue getrequestque() {
        if (requestQueue == null) {
            requestQueue = Volley.newRequestQueue(ctx.getApplicationContext());
        }
        return requestQueue;
    }

    public static synchronized Mysingleton getMinstance(Context context) {
        if (minstance == null) {
            minstance = new Mysingleton(context);
        }
        return minstance;
    }

    public <T> void addtorequestque(Request<T> request) {

        requestQueue.add(request);
    }

}

