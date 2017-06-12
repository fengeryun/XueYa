package xueya.jiyun.com.xueya.presenter.bloods;

import com.google.gson.Gson;

import xueya.jiyun.com.xueya.model.bean.Eaasys;
import xueya.jiyun.com.xueya.model.callback.NewUrlCallback;
import xueya.jiyun.com.xueya.model.modelinter.zixun.EaasyModelInter;
import xueya.jiyun.com.xueya.view.viewinter.Dialogs;
import xueya.jiyun.com.xueya.view.viewinter.blooder.EaasyView;

/**
 * Created by Asus on 2017/6/12.
 */

public class EaasyPresenter implements INousPresenter {

    private String type,id;
    private EaasyView eaasyView;
    private Eaasys nous;

    public EaasyPresenter(EaasyView eaasyView,String type,String id) {

        this.eaasyView=eaasyView;
        this.type=type;
        this.id=id;
    }

    @Override
    public void click() {

      switch (type){
          case "1":
              shuju2();
              break;
          case "2":
              shuju();
              break;
          case "3":
              shuju2();
              break;
          case "4":
              shuju2();
              break;
          case "5":
              shuju2();
              break;
      }
    }

    public void shuju(){
        EaasyModelInter eaasyModelInterr = new EaasyModelInter();
        eaasyModelInterr.goLogin(id,"zhuzhan_ys",new NewUrlCallback() {
            @Override
            public void success(String eryun) {
                Gson gson = new Gson();
                nous = gson.fromJson(eryun, Eaasys.class);
                eaasyView.EaasyData(nous);
                Dialogs.DissDialog("");
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
                Dialogs.DissDialog("");
            }

            @Override
            public void error(int code, String erge) {

            }
        });
    }
}
