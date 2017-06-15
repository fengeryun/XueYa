package xueya.jiyun.com.xueya.presenter.doctor;

import android.util.Log;

import com.google.gson.Gson;

import xueya.jiyun.com.xueya.model.bean.FreeAddBean;
import xueya.jiyun.com.xueya.model.callback.NewUrlCallback;
import xueya.jiyun.com.xueya.model.modelinter.DoctorModelInter;
import xueya.jiyun.com.xueya.view.viewinter.doc.FreeAddView;

/**
 * Created by my on 2017/6/14.
 */

public class FreeAddPresenter {

    FreeAddView freeadd;
    DoctorModelInter models;

    public FreeAddPresenter(FreeAddView freeadd){
        this.freeadd = freeadd;
        models = new DoctorModelInter();
    }

    public void getFreeAddDatas(String id,String expertid){

        models.getFreeAddList(id,expertid, new NewUrlCallback() {

            private FreeAddBean bean;

            @Override
            public void success(String eryun) {

                String str = eryun.split("schedule")[1].split(",")[0].replace("\"\"", "{}");
                StringBuffer sb = new StringBuffer();
                sb.append(eryun.split("schedule")[0]).append("schedule").append(str).append(",")
                        .append(eryun.split("schedule")[1].split(",")[1]);

                Gson gson = new Gson();
                //Log.e("YYYYYYYYYYYYYYY",eryun);
                if (str.length() > 5){
                    bean = gson.fromJson(eryun,FreeAddBean.class);
                    freeadd.loadGrid(bean.getData().getSchedule());
                }else{
                    //bean = gson.fromJson(sb.toString(),FreeAddBean.class);
                    freeadd.showToest("该专家比较懒，没预约");
                }
            }

            @Override
            public void error(int code, String erge) {
                freeadd.showToest("请连网");
            }
        });
    }

}
