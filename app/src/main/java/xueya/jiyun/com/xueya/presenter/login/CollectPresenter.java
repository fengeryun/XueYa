package xueya.jiyun.com.xueya.presenter.login;

import android.util.Log;

import com.google.gson.Gson;

import java.util.HashMap;
import java.util.List;
import java.util.logging.LogRecord;

import xueya.jiyun.com.xueya.model.bean.Collect;
import xueya.jiyun.com.xueya.model.bean.CollectBean;
import xueya.jiyun.com.xueya.model.callback.NewUrlCallback;
import xueya.jiyun.com.xueya.model.http.OKhttpUtils;
import xueya.jiyun.com.xueya.model.modelinter.MineModelInter;
import xueya.jiyun.com.xueya.model.urls.Urls;
import xueya.jiyun.com.xueya.view.viewinter.Dialogs;
import xueya.jiyun.com.xueya.view.viewinter.mine.CollectView;

/**
 * Created by 123 on 2017/6/13.
 */

public class CollectPresenter implements ICollectPresenter {
   CollectView collectView;
   MineModelInter mineModelInter;
    public CollectPresenter(CollectView collectView) {
        this.collectView = collectView;
        mineModelInter=new MineModelInter();
    }

    @Override
    public void GetBean(String uid) {
        HashMap<String , String> params = new HashMap<String ,String>();
        params.put("xywy_userid",uid);
        params.put("app_id","2");
        params.put("tag","zj");
        params.put("sign","2e0d0887581be1c35794ee4c13b00cae");
        mineModelInter.SHOUCANG(params, new NewUrlCallback() {
            @Override
            public void success(String eryun) {
                Gson gson=new Gson();
                Collect collect = gson.fromJson(eryun, Collect.class);
                if(collect!=null){
                    collectView.GetCollect(collect);
                    Dialogs.disDialog();
                }
            }

            @Override
            public void error(int code, String erge) {

            }
        });
    }
}
