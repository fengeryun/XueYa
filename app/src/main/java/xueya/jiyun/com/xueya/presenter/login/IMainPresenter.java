package xueya.jiyun.com.xueya.presenter.login;

import xueya.jiyun.com.xueya.view.viewinter.mine.MineView;

/**
 * Created by 123 on 2017/6/12.
 */

public class IMainPresenter implements MinePresenter {
    MineView mineView;

    public IMainPresenter(MineView mineView) {
        this.mineView = mineView;
    }

    @Override
    public boolean login() {

        return false;
    }
}
