package xueya.jiyun.com.xueya.model.http;

import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

import xueya.jiyun.com.xueya.App;
import xueya.jiyun.com.xueya.model.callback.NewUrlCallback;

/**
 * Created by my on 2017/5/14.
 */

public class VolleyUtils implements Ihttp{
    private static VolleyUtils instance;
    RequestQueue queue;
    private VolleyUtils(){ queue = Volley.newRequestQueue(App.activity);}
    public static VolleyUtils getInstance(){
        if(instance == null){
            synchronized (VolleyUtils.class){
                if(instance == null){
                    instance = new VolleyUtils();
                }
            }
        }
        return instance;
    }

    @Override
    public void doGet(String url, HashMap<String, String> params, final NewUrlCallback callback) {
        String urls = getParams(url,params);
        StringRequest strrequest = new StringRequest(Request.Method.GET, urls, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                callback.success(s);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                callback.error(404,volleyError.getMessage());
            }
        });
        queue.add(strrequest);
    }

    @Override
    public void doPost(String url, final HashMap<String, String> params, final NewUrlCallback callback) {
        StringRequest str = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                callback.success(s);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                callback.error(404,volleyError.getMessage());
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                return params;
            }
        };
        queue.add(str);
    }

    public String getParams(String url,HashMap<String , String> params){
        StringBuffer buff = new StringBuffer();
        buff.append(url);
        buff.append("?");
        for(Object keys : params.keySet()){
            buff.append(keys+"="+params.get(keys));
            buff.append("&");
        }
        buff.deleteCharAt(buff.length()-1);
        Log.e("VolleyUtils----参数拼接完成",buff.toString());
        return buff.toString();
    }



}
