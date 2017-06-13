package xueya.jiyun.com.xueya.view.viewinter.mine;

/**
 * Created by 123 on 2017/6/13.
 */

public interface VerifyView {
    void ShowOkBt();
    void HideOkBt();
    void ShowNoBt();
    void HideNoBt();

    //Toast
    void ShowMsg(String msg);

    //跳转
    void GoFragment();
}
