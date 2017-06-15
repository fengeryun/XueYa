package xueya.jiyun.com.xueya.presenter.bloods;

import android.util.Log;

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
    private String typeid;

    public NousPresenter(String type, NousView nousView, String typeid) {
        this.type = type;
        this.nousView = nousView;
        this.typeid = typeid;
        Log.e("AAA","----"+typeid);
    }

    @Override
    public void click(String type) {
        switch (typeid){
            case "18031":
                NousModelInter nousModelInter = new NousModelInter();
                nousModelInter.goLogin(new NewUrlCallback() {
                    @Override
                    public void success(String eryun) {
                        Gson gson = new Gson();
                        nous = gson.fromJson(eryun, Nous.class);
                        nousView.ListData(nous.getData());
                        Dialogs.disDialog();
                    }
                    @Override
                    public void error(int code, String erge) {

                    }
                });
                break;
            case "7938":
                CookModelInter cookModelInter = new CookModelInter();
                cookModelInter.goLogin(new NewUrlCallback() {
                    @Override
                    public void success(String eryun) {
                        Gson gson = new Gson();
                        nous = gson.fromJson(eryun, Nous.class);
                        nousView.ListData(nous.getData());
                        Dialogs.disDialog();
                    }
                    @Override
                    public void error(int code, String erge) {
                    }
                });
                break;
            case "18033":
                PreventModelInter preventModelInter = new PreventModelInter();
                preventModelInter.goLogin(new NewUrlCallback() {
                    @Override
                    public void success(String eryun) {
                        Gson gson = new Gson();
                        nous = gson.fromJson(eryun, Nous.class);
                        nousView.ListData(nous.getData());
                        Dialogs.disDialog();
                    }
                    @Override
                    public void error(int code, String erge) {
                    }
                });
                break;
            case "18035":
                TreatModelInter treatModelInter = new TreatModelInter();
                treatModelInter.goLogin(new NewUrlCallback() {
                    @Override
                    public void success(String eryun) {
                        Gson gson = new Gson();
                        nous = gson.fromJson(eryun, Nous.class);
                        nousView.ListData(nous.getData());
                        Dialogs.disDialog();
                    }
                    @Override
                    public void error(int code, String erge) {
                    }
                });
                break;
            case "18032":
                InspectModelInter inspectModelInter = new InspectModelInter();
                inspectModelInter.goLogin(new NewUrlCallback() {
                    @Override
                    public void success(String eryun) {
                        Gson gson = new Gson();
                        nous = gson.fromJson(eryun, Nous.class);
                        nousView.ListData(nous.getData());
                        Dialogs.disDialog();
                    }
                    @Override
                    public void error(int code, String erge) {
                    }
                });
                break;

        }

    }
}
