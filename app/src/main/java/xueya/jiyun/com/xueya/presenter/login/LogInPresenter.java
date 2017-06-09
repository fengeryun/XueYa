package xueya.jiyun.com.xueya.presenter.login;

import android.text.TextUtils;

/**
 * Created by 123 on 2017/6/9.
 */

public class LogInPresenter implements ILogInPresenter {

    @Override
    public void login(String username, String psw) {
        if (TextUtils.isEmpty(username)) {

            return;
        }

        if (TextUtils.isEmpty(psw)) {

            return;
        }
    }
}
