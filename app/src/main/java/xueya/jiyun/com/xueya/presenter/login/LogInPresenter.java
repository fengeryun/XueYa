package xueya.jiyun.com.xueya.presenter.login;

import android.content.SharedPreferences;
import android.text.TextUtils;

import com.google.gson.Gson;

import xueya.jiyun.com.xueya.App;
import xueya.jiyun.com.xueya.model.bean.LogInOk;
import xueya.jiyun.com.xueya.model.callback.NewUrlCallback;
import xueya.jiyun.com.xueya.model.modelinter.MineModelInter;
import xueya.jiyun.com.xueya.view.viewinter.Dialogs;
import xueya.jiyun.com.xueya.view.viewinter.mine.LogInView;

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
    public void login(String username, final String psw) {
        if (TextUtils.isEmpty(username)) {
            logInView.shouMessage("用户名不能为空");
            return;
        }
        if (TextUtils.isEmpty(psw)) {
            logInView.shouMessage("密码不能为空");
            return;
        }
        mine.goLogin(username, psw, new NewUrlCallback() {
          //  {"state":200,"userid":"116924091","isregister":1,"phonenum":"15533604305","height":158,"sex":"\u5973","birthday":"1939-09-11"}
            @Override
            public void success(String eryun) {
                Dialogs.Show2Dialog();
                if(eryun.contains("userid")){
                    Gson gson=new Gson();
                    LogInOk logInOk = gson.fromJson(eryun, LogInOk.class);

                    //网络请求获取的用户信息存入SP文件
                    SharedPreferences sp = App.activity.getSharedPreferences("LogIn", App.activity.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sp.edit();
                    editor.putBoolean("isLogin",true);
                    editor.putString("userid", logInOk.getUserid());
                    editor.putString("phonenum", logInOk.getPhonenum());
                    editor.putString("height", logInOk.getHeight()+"");
                    editor.putString("sex", logInOk.getSex());
                    editor.putString("birthday", logInOk.getBirthday());
                    editor.putString("isregister", logInOk.getIsregister()+"");
                    editor.putString("psw", psw);
                    editor.commit();
                    Dialogs.disDialog();
                    logInView.shouMessage("登陆成功");
                    logInView.startActivity();
                }else {
                    logInView.shouMessage("登录失败,检查账号密码");
                }

            }
            @Override
            public void error(int code, String erge) {
                logInView.shouMessage("登录失败,请检查网络连接");
            }
        });

    }

    @Override
    public void yetimportname(String username) {
        if(username.length()!=0){
            logInView.hideHame();
            if(username.length()>10){
                logInView.showUOkIm();
            }else {
                logInView.hideUOkIm();
            }
        }else{
            logInView.showName();
        }
    }

    @Override
    public void yetimportpsw(String psw) {
        if(psw.length()!=0){
            logInView.hidePsw();
            if(psw.length()>5){
                logInView.showPOkIm();
            }else {
                logInView.hidePOkIm();
            }
        }else{
            logInView.showPsw();
        }
    }
}
