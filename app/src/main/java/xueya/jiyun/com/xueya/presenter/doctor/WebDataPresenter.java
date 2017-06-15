package xueya.jiyun.com.xueya.presenter.doctor;

import android.util.Log;

import com.google.gson.Gson;

import xueya.jiyun.com.xueya.model.bean.WebDataBean;
import xueya.jiyun.com.xueya.model.callback.NewUrlCallback;
import xueya.jiyun.com.xueya.model.modelinter.DoctorModelInter;
import xueya.jiyun.com.xueya.view.viewinter.doc.WebDataView;

/**
 * Created by my on 2017/6/14.
 */

public class WebDataPresenter {
    WebDataView webdata;
    DoctorModelInter modelinter;

    public WebDataPresenter(WebDataView webdata){
        this.webdata = webdata;
        modelinter = new DoctorModelInter();
    }

    public void getWebDatas(String id,String cateid){
        modelinter.getWebData(id,cateid,new NewUrlCallback() {
            @Override
            public void success(String eryun) {
                Gson gson = new Gson();
                WebDataBean bean = gson.fromJson(eryun,WebDataBean.class);

                webdata.loadGrid(bean.getData());
            }

            @Override
            public void error(int code, String erge) {
                webdata.showToest("请连网..");
                //Log.e("SSSSSSSSSSSSSSSS",erge);
            }
        });

    }
}
