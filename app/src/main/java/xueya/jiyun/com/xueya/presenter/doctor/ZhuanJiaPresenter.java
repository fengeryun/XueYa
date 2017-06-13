package xueya.jiyun.com.xueya.presenter.doctor;

import android.util.Log;

import com.google.gson.Gson;

import xueya.jiyun.com.xueya.model.bean.ZhuanJiaBean;
import xueya.jiyun.com.xueya.model.callback.NewUrlCallback;
import xueya.jiyun.com.xueya.model.modelinter.BaseModelInter;
import xueya.jiyun.com.xueya.model.modelinter.DoctorModelInter;
import xueya.jiyun.com.xueya.presenter.BasePresenter;
import xueya.jiyun.com.xueya.view.viewinter.doc.ZhuanJiaView;

/**
 * Created by my on 2017/6/9.
 */

public class ZhuanJiaPresenter {

    ZhuanJiaView zhuanjia;
    DoctorModelInter model;

    public ZhuanJiaPresenter(ZhuanJiaView zhuanJiaView){
        this.zhuanjia = zhuanJiaView;
        model = new DoctorModelInter();
    }


    public void getZhuanJiaData(int num){
        model.getData(num,new NewUrlCallback() {
            @Override
            public void success(String eryun) {
                Gson gson = new Gson();
                ZhuanJiaBean bean = gson.fromJson(eryun,ZhuanJiaBean.class);

                zhuanjia.loadList(bean.getData());
            }

            @Override
            public void error(int code, String erge) {
                zhuanjia.showToast("请连网..");
                //Log.e("SSSSSSSSSSSSSSSS",erge);
            }
        });
    }

}
