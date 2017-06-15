package xueya.jiyun.com.xueya.presenter.login;

import android.widget.Toast;

import xueya.jiyun.com.xueya.App;
import xueya.jiyun.com.xueya.view.viewinter.mine.ChangePswView;

/**
 * Created by 123 on 2017/6/14.
 */

public class ChangePswPresenter implements IChangePswPresenter {
    ChangePswView changePswView;

    public ChangePswPresenter(ChangePswView changePswView) {
        this.changePswView = changePswView;
    }

    @Override
    public boolean LoginPsw(String psw, String tpsw) {
        if(psw.equals(tpsw)){
            return true;
        }else{
            changePswView.ShowMsg("密码错误");
        }
        return false;
    }

    @Override
    public void PanDuan(String psw, String tpsw) {

    }

    @Override
    public void DPanDuan(String psw, String tpsw) {

    }
}
