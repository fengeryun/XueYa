package xueya.jiyun.com.xueya.model.http;

import android.util.Log;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import xueya.jiyun.com.xueya.model.callback.NewUrlCallback;

/**
 * Created by 123 on 2017/6/14.
 */

public class OKhttpUtils implements Ihttp {
    private static OKhttpUtils httpUtils;
    private OkHttpClient client;
    private static final MediaType MEDIA_TYPE_PNG = MediaType.parse("image/png");

    private OKhttpUtils(){
        client = new OkHttpClient();
    }

    public static OKhttpUtils getInstance(){
        synchronized (OKhttpUtils.class){
            if(httpUtils == null){
                synchronized (OKhttpUtils.class){
                    httpUtils = new OKhttpUtils();
                }
            }
        }
        return httpUtils;
    }
    @Override
    public void doGet(String url, HashMap<String, String> params, final NewUrlCallback callback) {
        StringBuffer apiurl = new StringBuffer(url);
        if(params != null){
            apiurl.append("?");
            int index = 0;
            for (String s : params.keySet()){
                index++;
                apiurl.append(s+"="+params.get(s));
                if (index < params.size()) {
                    apiurl.append("&");
                }
            }
        }
        String string = apiurl.toString();

        Log.e("Url", string);

        Request request = new Request.Builder().url(string).get().build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                try {
                    callback.success(e.getMessage().toString());
                }catch (NullPointerException e1){
                    e1.printStackTrace();
                    Log.e("OkHttpUtils", "空指针"+e1);
                }

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                callback.success(response.body().string());
            }
        });
    }

    @Override
    public void doPost(String url, HashMap<String, String> params, final NewUrlCallback callback) {
        FormBody.Builder builder = new FormBody.Builder();

        for (String key : params.keySet()) {
            builder.add(key, params.get(key));
        }

        final Request request = new Request.Builder().url(url).post(builder.build()).build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e("onFailure ",e.getMessage().toString());
                callback.success(e.getMessage().toString());
            }

            @Override
            public void onResponse(Call call, final Response response)throws  IOException {

            }
        });

    }
}
