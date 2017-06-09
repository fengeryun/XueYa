package xueya.jiyun.com.xueya.model.http;

import android.util.Log;

import com.franmontiel.persistentcookiejar.ClearableCookieJar;

import java.io.IOException;
import java.util.HashMap;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import xueya.jiyun.com.xueya.App;
import xueya.jiyun.com.xueya.model.callback.NewUrlCallback;

/**
 * Created by my on 2017/5/23.
 */

public class OKhttpUtils implements Ihttp{
    private static OKhttpUtils instance;
    OkHttpClient.Builder okbuilder;
    private OKhttpUtils(){
        okbuilder = new OkHttpClient.Builder();
        ClearableCookieJar clearableCookieJar = new OkhttpBean();
        okbuilder.cookieJar(clearableCookieJar);
    }
    public static OKhttpUtils getInstance(){
        if(instance == null){
            synchronized (OKhttpUtils.class){
                if(instance == null){
                    instance = new OKhttpUtils();
                }
            }
        }
        return instance;
    }

    @Override
    public void doGet(String url, HashMap<String, String> params, final NewUrlCallback callback) {
        String urls = getParams(url,params);
        Request request = new Request.Builder().url(urls).build();
            Callback back = new Callback() {
                @Override
                public void onFailure(Call call, final IOException e) {
                    App.activity.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            callback.error(404,e.getMessage());
                        }
                    });

                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    final String str = response.body().string();
                    App.activity.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            callback.success(str);
                        }
                    });

                }
            };
        okbuilder.build().newCall(request).enqueue(back);
    }

    @Override
    public void doPost(String url, HashMap<String, String> params, final NewUrlCallback callback) {

        FormBody.Builder builder = new FormBody.Builder();
        for(Object keys : params.keySet()){
            builder.add(String.valueOf(keys),params.get(keys));
        }
        FormBody body = builder.build();
        Request request = new Request.Builder().url(url).post(body).build();
        Callback back = new Callback() {
            @Override
            public void onFailure(Call call, final IOException e) {
                App.activity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        callback.error(404,e.getMessage());
                    }
                });
            }
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String str = response.body().string();
                App.activity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        callback.success(str);
                    }
                });
            }
        };
        okbuilder.build().newCall(request).enqueue(back);
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
