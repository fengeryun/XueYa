package xueya.jiyun.com.xueya.presenter.login;

import android.util.Log;

import xueya.jiyun.com.xueya.model.sp.SpUtils;
import xueya.jiyun.com.xueya.view.viewinter.mine.MineView;

/**
 * Created by 123 on 2017/6/12.
 */

public class IMainPresenter implements MinePresenter {
    MineView mineView;
    private String s;

    public IMainPresenter(MineView mineView) {
        this.mineView = mineView;
    }

    @Override
    public boolean login() {
        //清空sp文件中的所有内容
        SpUtils.getInstance("LogIn").CleanVariable();
        s = SpUtils.getInstance("LogIn").GetVariable("userid");
        if(!s.equals("")){
            Log.e("TAG",s);
         mineView.showToux();
            mineView.hideBt();
            return false;
        }else{
            mineView.hideToux();
            mineView.showBt();
        }
        return true;
    }

    @Override
    public String getName() {
        return null;
    }
}
