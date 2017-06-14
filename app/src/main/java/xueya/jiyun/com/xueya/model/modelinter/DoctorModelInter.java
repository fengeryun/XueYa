package xueya.jiyun.com.xueya.model.modelinter;

import java.util.HashMap;

import xueya.jiyun.com.xueya.model.callback.NewUrlCallback;
import xueya.jiyun.com.xueya.model.http.HttpFactroy;
import xueya.jiyun.com.xueya.model.urls.Urls;

/**
 * Created by my on 2017/6/9.
 * 医生在线网络接口
 *
 */

public class DoctorModelInter implements BaseModelInter{
    public void getData(int pageNum,NewUrlCallback callback) {  //砖家列表，
        HashMap<String , String> params = new HashMap<String ,String>();

        HttpFactroy.getUrlType(2).doGet(Urls.ZhuanJiaList(pageNum),params,callback);
    }

    public void getReMengDatas(int pageNum,NewUrlCallback callback) {  //热门砖家，
        HashMap<String , String> params = new HashMap<String ,String>();

        HttpFactroy.getUrlType(2).doGet(Urls.ReMengList(pageNum),params,callback);
    }

    public void getHuiFuData(int pageNum,NewUrlCallback callback) {  //砖家回复，
        HashMap<String , String> params = new HashMap<String ,String>();

        HttpFactroy.getUrlType(2).doGet(Urls.HuiFuList(pageNum),params,callback);
    }

    public void getJingYanData(int pageNum,NewUrlCallback callback) {  //砖家回复，
        HashMap<String , String> params = new HashMap<String ,String>();

        HttpFactroy.getUrlType(2).doGet(Urls.JingYanList(pageNum),params,callback);
    }
}
