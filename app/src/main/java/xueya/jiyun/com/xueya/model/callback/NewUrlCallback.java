package xueya.jiyun.com.xueya.model.callback;

/**
 * Created by my on 2017/5/14.
 */

public interface NewUrlCallback {
    void success(String eryun);
    void error(int code, String erge);
}
