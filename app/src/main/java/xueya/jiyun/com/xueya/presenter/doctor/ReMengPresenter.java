package xueya.jiyun.com.xueya.presenter.doctor;

import com.google.gson.Gson;

import xueya.jiyun.com.xueya.model.bean.ZhuanJiaBean;
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
                ZhuanJiaBean bean = gson.fromJson(eryun,ZhuanJiaBean.class);
                if(bean.getData().size()>0){
                    remeng.loadGrid(bean.getData());
                }else {
                    remeng.showToest("请检查网络连接..");
                }
            }

            @Override
            public void error(int code, String erge) {
                remeng.showToest("请连网..");
                //Log.e("SSSSSSSSSSSSSSSS",erge);
            }
        });

    }


}
