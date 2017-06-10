package xueya.jiyun.com.xueya.presenter.login;

import android.text.TextUtils;

import xueya.jiyun.com.xueya.model.callback.NewUrlCallback;
import xueya.jiyun.com.xueya.model.modelinter.MineModelInter;
import xueya.jiyun.com.xueya.view.viewinter.LogInView;

/**
 * Created by 123 on 2017/6/9.
 */

public class LogInPresenter implements ILogInPresenter {
    private LogInView logInView;
    MineModelInter mine;

    public LogInPresenter(LogInView logInView) {
        this.logInView = logInView;
        mine = new MineModelInter();
    }

    @Override
    public void login(String username, String psw) {
        if (TextUtils.isEmpty(username)) {
            logInView.shouMessage("用户名不能为空");
            return;
        }

        if (TextUtils.isEmpty(psw)) {
            logInView.shouMessage("密码不能为空");
            return;
        }

        mine.goLogin(username, psw, new NewUrlCallback() {
            @Override
            public void success(String eryun) {
                logInView.shouMessage("登录成功");
                logInView.startActivity();
            }
            @Override
            public void error(int code, String erge) {
                logInView.shouMessage("登录失败,请检查用户名和密码");
            }
        });

    }
}
