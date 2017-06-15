package xueya.jiyun.com.xueya.presenter.bloods;

import android.util.Log;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import xueya.jiyun.com.xueya.model.callback.NewUrlCallback;
import xueya.jiyun.com.xueya.model.modelinter.zixun.EssayModelInter;
import xueya.jiyun.com.xueya.model.sp.SpUtils;
import xueya.jiyun.com.xueya.view.viewinter.blooder.EssayView;

/**
 * Created by Asus on 2017/6/15.
 */

public class EssayPersenter {
    private EssayView essayView;
    private String s;

    public EssayPersenter(EssayView essayView) {
        this.essayView = essayView;
    }

    public void getAsk(String tittle, String id, String meta){
        try {
            s = URLEncoder.encode(tittle, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String userid = SpUtils.getInstance("LogIn").GetVariable("userid");
        EssayModelInter essayModelInter = new EssayModelInter();
       essayModelInter.goLogin(userid, s, id, meta, new NewUrlCallback() {
           @Override
           public void success(String eryun) {
               Log.e("AAA","---"+eryun.toString());
           }

           @Override
           public void error(int code, String erge) {

           }
       });
    }
}
