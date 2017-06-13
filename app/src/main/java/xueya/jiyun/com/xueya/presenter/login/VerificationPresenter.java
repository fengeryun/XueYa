package xueya.jiyun.com.xueya.presenter.login;

import xueya.jiyun.com.xueya.view.viewinter.mine.VerifyView;

/**
 * Created by 123 on 2017/6/13.
 */

public class VerificationPresenter implements IVerificationPresenter {
    VerifyView verifyView;

    public VerificationPresenter(VerifyView verifyView) {
        this.verifyView = verifyView;
    }

    @Override
    public void GetMsg(String msg) {
         if(msg.length()==6){
             verifyView.ShowOkBt();
             verifyView.HideNoBt();
         }else {
             verifyView.HideOkBt();
             verifyView.ShowNoBt();
         }
    }
}
