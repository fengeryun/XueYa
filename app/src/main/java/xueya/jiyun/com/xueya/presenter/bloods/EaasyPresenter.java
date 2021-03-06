package xueya.jiyun.com.xueya.presenter.bloods;

import com.google.gson.Gson;

import xueya.jiyun.com.xueya.model.bean.Eaasys;
import xueya.jiyun.com.xueya.model.callback.NewUrlCallback;
import xueya.jiyun.com.xueya.model.modelinter.zixun.EaasyModelInter;
import xueya.jiyun.com.xueya.view.viewinter.Dialogs;
import xueya.jiyun.com.xueya.view.viewinter.blooder.EaasyView;
import xueya.jiyun.com.xueya.view.viewinter.blooder.EssayView;

/**
 * Created by Asus on 2017/6/12.
 */

public class EaasyPresenter  {

    private String type,id;
    private EaasyView eaasyView;
    private Eaasys nous;
    private EssayView essayView;
    public EaasyPresenter(EaasyView eaasyView,String type,String id,EssayView essayView) {
        this.eaasyView=eaasyView;
        this.type=type;
        this.id=id;
        this.essayView=essayView;
    }

    public void click() {
shuju();
    }

    public void shuju(){
        EaasyModelInter eaasyModelInterr = new EaasyModelInter();
        eaasyModelInterr.goLogin(id,type,new NewUrlCallback() {
            @Override
            public void success(String eryun) {
                Gson gson = new Gson();
                nous = gson.fromJson(eryun, Eaasys.class);
                if(nous!=null){
                    eaasyView.EaasyData(nous);
                    essayView.getStatus(nous);
                    Dialogs.disDialog();
                }
            }

            @Override
            public void error(int code, String erge) {

            }
        });
    }

    public void shuju2(){
        EaasyModelInter eaasyModelInter = new EaasyModelInter();
        eaasyModelInter.goLogin(id, "zhuanti_nk", new NewUrlCallback() {
            @Override
            public void success(String eryun) {
                Gson gson = new Gson();
                nous = gson.fromJson(eryun, Eaasys.class);
                eaasyView.EaasyData(nous);
                Dialogs.disDialog();

            }

            @Override
            public void error(int code, String erge) {

            }
        });

    }

}
