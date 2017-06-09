package xueya.jiyun.com.xueya.model.http;

import java.util.HashMap;

import xueya.jiyun.com.xueya.model.callback.NewUrlCallback;

/**
 * Created by my on 2017/5/14.
 */

public interface Ihttp {
    void doGet(String url, HashMap<String, String> params, NewUrlCallback callback);
    void doPost(String url, HashMap<String, String> params, NewUrlCallback callback);
}
