package xueya.jiyun.com.xueya.presenter.login;

import android.text.TextUtils;

import java.util.HashMap;

import xueya.jiyun.com.xueya.model.callback.NewUrlCallback;
import xueya.jiyun.com.xueya.model.http.VolleyUtils;

/**
 * Created by 123 on 2017/6/9.
 */

public class LogInPresenter implements ILogInPresenter {
    private LogInView logInView;

    public LogInPresenter(LogInView logInView) {
        this.logInView = logInView;
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
        VolleyUtils.getInstance().doPost("", new HashMap<String, String>(), new NewUrlCallback() {
            @Override
            public void success(String eryun) {
                logInView.startActivity();
            }

            @Override
            public void error(int code, String erge) {
                logInView.shouMessage("登录失败,请检查用户名和密码");
            }
        });
    }
}
