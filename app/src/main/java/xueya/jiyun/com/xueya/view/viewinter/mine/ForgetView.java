package xueya.jiyun.com.xueya.view.viewinter.mine;

/**
 * Created by 123 on 2017/6/10.
 */

public interface ForgetView {
    //提示消息
    void ShouMessage(String msg);
    //可以进行登录按钮的显示
    void ShowOkButton();
    //不可以进行登录按钮的显示
    void ShowNoButton();
    //可以进行登录按钮的隐藏
    void HideOkButton();
    //不可以进行登录按钮的隐藏
    void HideNoButton();
    //输入正确控件的显示
    void ShowEtOk();
    //输入正确控件的隐藏
    void HideEtOk();
    //输入时控件的显示
    void ShowTextOk();
    //输入时控件的隐藏
    void HideTextOk();
}
