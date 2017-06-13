package xueya.jiyun.com.xueya.model.modelinter;

import java.util.HashMap;

import xueya.jiyun.com.xueya.model.callback.NewUrlCallback;
import xueya.jiyun.com.xueya.model.http.HttpFactroy;
import xueya.jiyun.com.xueya.model.urls.Urls;

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

        HttpFactroy.getUrlType(2).doPost(Urls.LogIn_url,params,callback);
    }
    public void getName(String uid, NewUrlCallback callback) {  //获取登录内容，
        String str = "&sign=ee3dd4651821d3a45f4329a86d459cb7";
        HttpFactroy.getUrlType(2).doPost(Urls.GETMSG + uid + str, new HashMap<String, String>(), callback);
    }


    public void getName(String phonenum,String password , NewUrlCallback callback) {  //获取综合资讯，
        HashMap<String , String> params = new HashMap<String ,String>();
        params.put("phonenum", phonenum);
        params.put("password", password);

        HttpFactroy.getUrlType(2).doPost(Urls.LogIn_url,params,callback);
    }
    public void ChangePhone(String uid, NewUrlCallback callback) {  //更换手机号，
        String str="&tag=BloodAndroid&sign=2c19b2821ebc5306c3ac37bac5b4288b&type=3";
        HttpFactroy.getUrlType(2).doPost(Urls.CHANGE_PHONE+uid+str,new HashMap<String, String>(),callback);
    }
    public void GetSign(String uid, NewUrlCallback callback) {  //获取加号，
        String str="&state=0&pagesize=10&PageNum=1";
        HttpFactroy.getUrlType(2).doPost(Urls.GETSIGN+uid+str,new HashMap<String, String>(),callback);
    }


}
