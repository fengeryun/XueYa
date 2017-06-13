package xueya.jiyun.com.xueya.presenter.login;

/**
 * Created by 123 on 2017/6/10.
 */

public interface IVerifyPresenter {
    //获取正在输入的手机号
    void GetPhone(String phone);

    //进行手机号码确认
    void JundePhone(String phone);
}
