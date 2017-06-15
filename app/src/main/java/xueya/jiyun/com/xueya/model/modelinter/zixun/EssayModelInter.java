package xueya.jiyun.com.xueya.model.modelinter.zixun;

import android.util.Log;

import java.util.HashMap;

import xueya.jiyun.com.xueya.model.callback.NewUrlCallback;
import xueya.jiyun.com.xueya.model.http.HttpFactroy;
import xueya.jiyun.com.xueya.model.modelinter.BaseModelInter;
import xueya.jiyun.com.xueya.model.urls.Urls;

/**
 * Created by Asus on 2017/6/14.
 */

public class EssayModelInter implements BaseModelInter{

    public void goLogin(String xywy_userid,String title,String categoryid,String meta,NewUrlCallback callback) {
        HashMap<String , String> params = new HashMap<String ,String>();
        params.put("sign","2e0d0887581be1c35794ee4c13b00cae");
        params.put("category","1");
        params.put("title",title);
        params.put("categoryid",categoryid);
        params.put("xywy_userid",xywy_userid);
        params.put("tag","zj");
        params.put("app_id","2");
        params.put("meta",meta);
        HttpFactroy.getUrlType(2).doPost(Urls.SHOUCANG,params,callback);
        Log.e("AAA","-=-=="+Urls.SHOUCANG+params);
    }
}
