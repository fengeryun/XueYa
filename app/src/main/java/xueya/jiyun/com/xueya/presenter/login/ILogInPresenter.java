package xueya.jiyun.com.xueya.presenter.login;

/**
 * Created by 123 on 2017/6/9.
 */

public interface ILogInPresenter {
    void login(String username,String psw);


    //判断名字是否正在输入
    void yetimportname(String username);

    //判断密码是否正在输入
    void yetimportpsw(String psw);
}
