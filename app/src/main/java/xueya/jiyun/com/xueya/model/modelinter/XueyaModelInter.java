package xueya.jiyun.com.xueya.model.modelinter;

import java.util.HashMap;

import xueya.jiyun.com.xueya.model.callback.NewUrlCallback;
import xueya.jiyun.com.xueya.model.http.HttpFactroy;
import xueya.jiyun.com.xueya.model.urls.Urls;

/**
 * Created by my on 2017/6/10.
 * 血压管理网络接口
 *
 */

public class XueyaModelInter implements BaseModelInter{
    public void goLogin(NewUrlCallback callback) {  //获取综合资讯，
        HashMap<String , String> params = new HashMap<String ,String>();

        HttpFactroy.getUrlType(2).doPost(Urls.NOUSURL,params,callback);
    }
}
