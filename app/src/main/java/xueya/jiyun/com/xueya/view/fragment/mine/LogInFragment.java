package xueya.jiyun.com.xueya.view.fragment.mine;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import xueya.jiyun.com.xueya.App;
import xueya.jiyun.com.xueya.R;
import xueya.jiyun.com.xueya.presenter.login.LogInPresenter;
import xueya.jiyun.com.xueya.view.viewinter.LogInView;
import xueya.jiyun.com.xueya.tools.FragmentBuilder;
import xueya.jiyun.com.xueya.view.viewinter.LogInView;
import xueya.jiyun.com.xueya.view.base.BaseFragment;
import xueya.jiyun.com.xueya.view.fragment.doctors.DoctorFragment;

/**
 * 登录界面
 * Created by 123 on 2017/6/9.
 */

public class LogInFragment extends BaseFragment implements View.OnClickListener, LogInView {
    EditText login_user,login_psw;
    TextView login_user_introduce,login_psw_introduce,login_register,login_forget;
    Button login_bt;
    ImageView psw_ok,user_ok;
    LogInPresenter logInPresenter;
    @Override
    public void initView(View view) {
        login_user= (EditText) view.findViewById(R.id.login_user);
        login_psw= (EditText) view.findViewById(R.id.login_psw);
        login_user_introduce= (TextView) view.findViewById(R.id.login_user_introduce);
        login_psw_introduce= (TextView) view.findViewById(R.id.login_psw_introduce);
        login_bt= (Button) view.findViewById(R.id.login_bt);
        user_ok= (ImageView) view.findViewById(R.id.user_ok);
        psw_ok= (ImageView) view.findViewById(R.id.psw_ok);
        login_forget= (TextView) view.findViewById(R.id.login_forget);
        login_register= (TextView) view.findViewById(R.id.login_register);
    }

    @Override
    public int getLayoutId() {
        return R.layout.login;
    }

    @Override
    public void initData() {
        logInPresenter=new LogInPresenter(this);
    }

    @Override
    public void loadData() {

    }

    @Override
    public void initListener() {
        login_bt.setOnClickListener(this);
        login_forget.setOnClickListener(this);
        login_register.setOnClickListener(this);
        login_user.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
              logInPresenter.yetimportname(login_user.getText().toString().trim());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        login_psw.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
              logInPresenter.yetimportpsw(login_psw.getText().toString().trim());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            //登录
            case R.id.login_bt:
                logInPresenter.login(login_user.getText().toString().trim(),login_psw.getText().toString().trim());
                break;
            //忘记密码
            case R.id.login_forget:
                Intent intent=new Intent(App.activity,ForgetActivity.class);
                App.activity.startActivity(intent);
                break;
            //注册
            case R.id.login_register:
                break;

        }

    }

    @Override
    public void toHome() {

    }

    @Override
    public void shouMessage(String message) {
        Toast.makeText(App.activity, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void startActivity() {
        FragmentBuilder.getInstance().start(R.id.viewpage, DoctorFragment.class).isBacked(true);
    }

    @Override
    public void showName() {
        login_user_introduce.setVisibility(View.VISIBLE);
    }

    @Override
    public void showPsw() {
        login_psw_introduce.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideHame() {
        login_user_introduce.setVisibility(View.GONE);
    }

    @Override
    public void hidePsw() {
        login_psw_introduce.setVisibility(View.GONE);
    }

    @Override
    public void showUOkIm() {
        user_ok.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideUOkIm() {
      user_ok.setVisibility(View.GONE);
    }

    @Override
    public void showPOkIm() {
        psw_ok.setVisibility(View.VISIBLE);
    }

    @Override
    public void hidePOkIm() {
        psw_ok.setVisibility(View.GONE);
    }


}
