package xueya.jiyun.com.xueya.model.http;

import com.franmontiel.persistentcookiejar.ClearableCookieJar;
import com.franmontiel.persistentcookiejar.PersistentCookieJar;
import com.franmontiel.persistentcookiejar.cache.SetCookieCache;
import com.franmontiel.persistentcookiejar.persistence.SharedPrefsCookiePersistor;

import java.util.List;

import okhttp3.Cookie;
import okhttp3.HttpUrl;
import xueya.jiyun.com.xueya.App;

/**
 * Created by my on 2017/5/23.
 */

public class OkhttpBean implements ClearableCookieJar {

    private PersistentCookieJar per = new PersistentCookieJar(new SetCookieCache(), new SharedPrefsCookiePersistor(App.activity));

    @Override
    public void clearSession() {
        per.clearSession();
    }

    @Override
    public void clear() {
        per.clear();
    }

    @Override
    public void saveFromResponse(HttpUrl httpUrl, List<Cookie> list) {
        per.saveFromResponse(httpUrl, list);
    }

    @Override
    public List<Cookie> loadForRequest(HttpUrl httpUrl) {
        List<Cookie> cookies = per.loadForRequest(httpUrl);
        return cookies;
    }
}
