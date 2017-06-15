package xueya.jiyun.com.xueya.presenter.doctor;

import com.google.gson.Gson;

import xueya.jiyun.com.xueya.model.bean.HuiFuBean;
import xueya.jiyun.com.xueya.model.callback.NewUrlCallback;
import xueya.jiyun.com.xueya.model.modelinter.DoctorModelInter;
import xueya.jiyun.com.xueya.view.viewinter.doc.HuiFuView;

/**
 * Created by my on 2017/6/13.
 */

public class HuiFuPresenter {

    HuiFuView huifu;
    DoctorModelInter models;

    public HuiFuPresenter(HuiFuView huifu){
        this.huifu = huifu;
        models = new DoctorModelInter();
    }


    public void getHuiFuDataList(int numb){
        models.getHuiFuData(numb, new NewUrlCallback() {
            @Override
            public void success(String eryun) {
                Gson gson = new Gson();
                HuiFuBean bean = gson.fromJson(eryun,HuiFuBean.class);

                if(bean.getData().size()>=1){
                    huifu.loadList(bean.getData());
                }else {
                    huifu.showToast("该专家无回复");
                }

            }

            @Override
            public void error(int code, String erge) {
                huifu.showToast("请连网");
            }
        });
    }

}
