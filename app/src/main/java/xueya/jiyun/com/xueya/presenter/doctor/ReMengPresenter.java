package xueya.jiyun.com.xueya.presenter.doctor;

import android.util.Log;

import com.google.gson.Gson;

import xueya.jiyun.com.xueya.model.bean.ReMengBean;
import xueya.jiyun.com.xueya.model.callback.NewUrlCallback;
import xueya.jiyun.com.xueya.model.modelinter.DoctorModelInter;
import xueya.jiyun.com.xueya.view.viewinter.doc.ReMengDoctor;

/**
 * Created by my on 2017/6/12.
 */

public class ReMengPresenter {

    ReMengDoctor remeng;
    DoctorModelInter modelinter;

    public ReMengPresenter(ReMengDoctor remeng){
        this.remeng = remeng;
        modelinter = new DoctorModelInter();
    }

    public void getReMengData(int num){
        modelinter.getReMengDatas(num,new NewUrlCallback() {
            @Override
            public void success(String eryun) {
                Gson gson = new Gson();
                ReMengBean bean = gson.fromJson(eryun,ReMengBean.class);

                remeng.loadGrid(bean.getData());
                //remeng.showToest(bean.getData().get(0).getName());
                //remeng.showToest("请求成功");
                //Log.e("SSSSSSSSSSSSSSSS",eryun);
            }

            @Override
            public void error(int code, String erge) {
                remeng.showToest("请连网..");
                Log.e("SSSSSSSSSSSSSSSS",erge);
            }
        });

    }


}
