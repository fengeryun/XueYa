package xueya.jiyun.com.xueya.presenter.login;

import org.greenrobot.eventbus.EventBus;

import xueya.jiyun.com.xueya.model.bean.Event;
import xueya.jiyun.com.xueya.view.viewinter.mine.ChangeNameView;

/**
 * Created by 123 on 2017/6/13.
 */

public class ChangeNamePresenter implements IChangeNamePresenter {
    ChangeNameView changeNameView;

    public ChangeNamePresenter(ChangeNameView changeNameView) {
        this.changeNameView = changeNameView;
    }

    @Override
    public void GetMsg(String msg) {
        if (msg.length()==0){
            changeNameView.ShowMeg("内容不能为空");
        }else {
            EventBus.getDefault().postSticky(new Event(msg));
            changeNameView.ShowMeg("更改成功");
        }
    }
}
