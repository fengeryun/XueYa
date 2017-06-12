package xueya.jiyun.com.xueya.presenter.login;

import android.util.Log;

import org.greenrobot.eventbus.EventBus;

import xueya.jiyun.com.xueya.model.bean.Event;
import xueya.jiyun.com.xueya.view.viewinter.mine.OpinionView;

/**
 * Created by 123 on 2017/6/12.
 */

public class OpinionPresenter implements IOpinionPresenter {
    OpinionView opinionView;

    public OpinionPresenter(OpinionView opinionView) {
        this.opinionView = opinionView;
    }

    @Override
    public void GetMsgNum(String num) {
       if(num.length()!=1){
           EventBus.getDefault().postSticky(new Event(num.length()+""));
       }else{
           EventBus.getDefault().postSticky(new Event("1"));
       }
    }
}
