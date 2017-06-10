package xueya.jiyun.com.xueya.model.modelinter;

import java.util.HashMap;

import xueya.jiyun.com.xueya.model.callback.NewUrlCallback;
import xueya.jiyun.com.xueya.model.http.HttpFactroy;

/**
 * Created by my on 2017/6/10.
 * 个人中心网络请求
 *
 */

public class MineModelInter implements BaseModelInter{

    public void goLogin(String phonenum,String password , NewUrlCallback callback) {  //获取综合资讯，
        HashMap<String , String> params = new HashMap<String ,String>();
        params.put("phonenum", phonenum);
        params.put("password", password);

        //HttpFactroy.getUrlType(2).doPost(Urls.NEWS_LIST_URL,params,callback);
    }


}
