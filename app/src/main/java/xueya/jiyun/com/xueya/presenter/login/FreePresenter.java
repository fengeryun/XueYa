package xueya.jiyun.com.xueya.presenter.login;

import xueya.jiyun.com.xueya.view.viewinter.mine.FreeView;

/**
 * Created by 123 on 2017/6/12.
 */

public class FreePresenter implements IFreePresenter {
    FreeView freeView;

    public FreePresenter(FreeView freeView) {
        this.freeView = freeView;
    }

    @Override
    public void GetMsgNum(String num) {
        if(num.length()!=0){
            freeView.ChangeTv(num.length());
        }else {
            freeView.ChangeTv(1);
        }
    }
}
