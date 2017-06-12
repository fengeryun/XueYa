package xueya.jiyun.com.xueya.model.modelinter.zixun;

import java.util.HashMap;

import xueya.jiyun.com.xueya.model.callback.NewUrlCallback;
import xueya.jiyun.com.xueya.model.http.HttpFactroy;
import xueya.jiyun.com.xueya.model.modelinter.BaseModelInter;
import xueya.jiyun.com.xueya.model.urls.Urls;

/**
 * Created by Asus on 2017/6/12.
 */

public class EaasyModelInter implements BaseModelInter{
    public void goLogin(String id,String dir, NewUrlCallback callback) {  //获取文章
        HashMap<String , String> params = new HashMap<String ,String>();
        params.put("id",id);
        params.put("dir",dir);
        HttpFactroy.getUrlType(2).doGet(Urls.EAASYURL,params,callback);
    }
}
