package xueya.jiyun.com.xueya.presenter.doctor;

import com.google.gson.Gson;

import xueya.jiyun.com.xueya.model.bean.JingYanBean;
import xueya.jiyun.com.xueya.model.callback.NewUrlCallback;
import xueya.jiyun.com.xueya.model.modelinter.DoctorModelInter;
import xueya.jiyun.com.xueya.view.viewinter.doc.JingYanView;

/**
 * Created by my on 2017/6/13.
 */

public class JingYanPresenter {

    JingYanView jingyan;
    DoctorModelInter docmodel;

    public JingYanPresenter(JingYanView jingyan){
        this.jingyan = jingyan;
        docmodel = new DoctorModelInter();
    }

    public void getJingYan(int num){
        docmodel.getJingYanData(num, new NewUrlCallback() {
            @Override
            public void success(String eryun) {
                Gson gson = new Gson();
                JingYanBean bean = gson.fromJson(eryun,JingYanBean.class);

                jingyan.loadGrid(bean.getData());
            }

            @Override
            public void error(int code, String erge) {
                jingyan.showToest("请连网");
            }
        });
    }

}
