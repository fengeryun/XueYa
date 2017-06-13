package xueya.jiyun.com.xueya.presenter.login;

import android.util.Log;

import xueya.jiyun.com.xueya.model.callback.NewUrlCallback;
import xueya.jiyun.com.xueya.model.modelinter.MineModelInter;
import xueya.jiyun.com.xueya.view.viewinter.mine.VerifyView;

/**
 * Created by 123 on 2017/6/13.
 */

public class VerifyPresenter implements IVerifyPresenter{
    VerifyView verifyView;
    MineModelInter mineModelInter;
    public VerifyPresenter(VerifyView verifyView) {
        this.verifyView = verifyView;
        mineModelInter=new MineModelInter();
    }

    @Override
    public void GetPhone(String phone) {
        if(phone.length()==11){
            verifyView.ShowOkBt();
            verifyView.HideNoBt();
        }else {
            verifyView.HideOkBt();
            verifyView.ShowNoBt();
        }

    }

    @Override
    public void JundePhone(String phone) {
        mineModelInter.ChangePhone(phone, new NewUrlCallback() {
            @Override
            public void success(String eryun) {
               if(eryun.contains("id")){
                   verifyView.GoFragment();
               }else{
                   verifyView.ShowMsg("手机号已绑定,无法重复绑定");
               }
            }

            @Override
            public void error(int code, String erge) {
                verifyView.ShowMsg("网络连接失败,请检查网络");
            }
        });

    }
}
