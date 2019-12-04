package com.bawei.chenshuaishuai20191204.network;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bawei.chenshuaishuai20191204.app.App;

import java.util.Map;

public class VolleyUtils {
    private RequestQueue requestQueue;
    private static VolleyUtils instance;
    private VolleyUtils(){
        requestQueue= Volley.newRequestQueue(App.getContext());
    }
    //双重上锁
    public static VolleyUtils getInstance(){
        if (instance==null){
            synchronized (VolleyUtils.class){
                if (instance==null){
                    instance=new VolleyUtils();
                }
            }
        }
        return instance;
    }
    public void doGet(final Map<String,String> params,String url,final VolleyCallback volleyCallback){
        String endUrl=url+"?";
        if (params!=null&&params.size()>0){
            for (Map.Entry<String,String> stringStringEntry : params.entrySet()){
                endUrl+=stringStringEntry.getKey()+"="+stringStringEntry.getValue()+"&";
            }
        }
        System.out.println("endurl==="+endUrl);
        //第二步
        StringRequest stringRequest=new StringRequest(StringRequest.Method.GET, endUrl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (volleyCallback != null) {
                    volleyCallback.success(response);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                if (volleyCallback!=null){
                    volleyCallback.failure(error);
                }
            }
        });
        requestQueue.add(stringRequest);
    }

    public void doPost(final  Map<String,String> params,String url,final VolleyCallback volleyCallback){
        StringRequest stringRequest=new StringRequest(StringRequest.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (volleyCallback != null) {
                    volleyCallback.success(response);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                if (volleyCallback!=null){
                    volleyCallback.failure(error);
                }
            }
        }){
            protected Map<String,String> getParams() throws AuthFailureError{
                return params;
            }
        };
        requestQueue.add(stringRequest);
    }

    public interface VolleyCallback{
        void success(String response);
        void failure(Throwable error);
    }
}
