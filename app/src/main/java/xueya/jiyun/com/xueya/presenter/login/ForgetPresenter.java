package xueya.jiyun.com.xueya.presenter.login;

import xueya.jiyun.com.xueya.view.viewinter.ForgetView;

/**
 * Created by 123 on 2017/6/10.
 */

public class ForgetPresenter implements IForgetPresenter {
    private ForgetView forgetView;

    public ForgetPresenter(ForgetView forgetView) {
        this.forgetView = forgetView;
    }

    @Override
    public void GetPhone(String phone) {
        if(phone.length()!=0){
         forgetView.HideEtOk();
            if(phone.length()>10){
                forgetView.ShowTextOk();
                forgetView.ShowOkButton();
            }else{
                forgetView.HideTextOk();
                forgetView.HideOkButton();
            }
        }else{
            forgetView.ShowEtOk();
        }
    }

}
