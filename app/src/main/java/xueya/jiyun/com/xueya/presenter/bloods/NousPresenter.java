package xueya.jiyun.com.xueya.presenter.bloods;

import com.google.gson.Gson;

import xueya.jiyun.com.xueya.model.bean.Nous;
import xueya.jiyun.com.xueya.model.callback.NewUrlCallback;
import xueya.jiyun.com.xueya.model.modelinter.zixun.CookModelInter;
import xueya.jiyun.com.xueya.model.modelinter.zixun.InspectModelInter;
import xueya.jiyun.com.xueya.model.modelinter.zixun.NousModelInter;
import xueya.jiyun.com.xueya.model.modelinter.zixun.PreventModelInter;
import xueya.jiyun.com.xueya.model.modelinter.zixun.TreatModelInter;
import xueya.jiyun.com.xueya.view.viewinter.Dialogs;
import xueya.jiyun.com.xueya.view.viewinter.blooder.NousView;

/**
 * Created by Asus on 2017/6/12.
 */

public class NousPresenter implements INousPresenter{


    private String type;
    private Nous nous;
    private NousView nousView;

    public NousPresenter(String type,NousView nousView) {
        this.type=type;
        this.nousView = nousView;
    }

    @Override
    public void click() {

        switch (type){
            case "1":
                NousModelInter nousModelInter = new NousModelInter();
                nousModelInter.goLogin(new NewUrlCallback() {
                    @Override
                    public void success(String eryun) {
                        Gson gson = new Gson();
                        nous = gson.fromJson(eryun, Nous.class);
                        nousView.ListData(nous.getData());
                        Dialogs.DissDialog("");
                    }
                    @Override
                    public void error(int code, String erge) {

                    }
                });
                break;
            case "2":
                CookModelInter cookModelInter = new CookModelInter();
                cookModelInter.goLogin(new NewUrlCallback() {
                    @Override
                    public void success(String eryun) {
                        Gson gson = new Gson();
                        nous = gson.fromJson(eryun, Nous.class);
                        nousView.ListData(nous.getData());


                        Dialogs.DissDialog("");
                    }
                    @Override
                    public void error(int code, String erge) {
                    }
                });
                break;
            case "3":
                PreventModelInter preventModelInter = new PreventModelInter();
                preventModelInter.goLogin(new NewUrlCallback() {
                    @Override
                    public void success(String eryun) {
                        Gson gson = new Gson();
                        nous = gson.fromJson(eryun, Nous.class);
                        nousView.ListData(nous.getData());
                        Dialogs.DissDialog("");

                    }
                    @Override
                    public void error(int code, String erge) {

                    }
                });
                break;
            case "4":
                TreatModelInter treatModelInter = new TreatModelInter();
                treatModelInter.goLogin(new NewUrlCallback() {
                    @Override
                    public void success(String eryun) {
                        Gson gson = new Gson();
                        nous = gson.fromJson(eryun, Nous.class);
                        nousView.ListData(nous.getData());
                        Dialogs.DissDialog("");
                    }
                    @Override
                    public void error(int code, String erge) {
                    }
                });
                break;
            case "5":
                InspectModelInter inspectModelInter = new InspectModelInter();
                inspectModelInter.goLogin(new NewUrlCallback() {
                    @Override
                    public void success(String eryun) {
                        Gson gson = new Gson();
                        nous = gson.fromJson(eryun, Nous.class);
                        nousView.ListData(nous.getData());
                        Dialogs.DissDialog("");
                    }
                    @Override
                    public void error(int code, String erge) {
                    }
                });
                break;
        }

    }
}
