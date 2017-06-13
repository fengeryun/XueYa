package xueya.jiyun.com.xueya.presenter.login;

import android.util.Log;

import com.google.gson.Gson;

import java.util.List;

import xueya.jiyun.com.xueya.model.bean.SignBean;
import xueya.jiyun.com.xueya.model.callback.NewUrlCallback;
import xueya.jiyun.com.xueya.model.modelinter.MineModelInter;
import xueya.jiyun.com.xueya.tools.ThreadUtils;
import xueya.jiyun.com.xueya.view.viewinter.mine.SignView;

/**
 * Created by 123 on 2017/6/13.
 */

public class SignPresenter implements ISignPresenter {
    SignView signView;
    MineModelInter mineModelInter;
    private SignBean signBean;

    public SignPresenter(SignView signView) {
        this.signView = signView;
        mineModelInter=new MineModelInter();
    }

    @Override
    public void GetBean(String uid) {
        mineModelInter.GetSign(uid, new NewUrlCallback() {
            @Override
            public void success(final String eryun) {
                 Gson gson=new Gson();
                signBean = gson.fromJson(eryun, SignBean.class);
                if(signBean!=null){
                    signView.HideText();
                    signView.ShowList();
                    signView.GetBean(signBean);
                }

            }

            @Override
            public void error(int code, String erge) {
            }
        });
    }
}
