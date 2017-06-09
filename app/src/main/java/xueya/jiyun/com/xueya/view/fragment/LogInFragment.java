package xueya.jiyun.com.xueya.view.fragment;

import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import xueya.jiyun.com.xueya.R;
import xueya.jiyun.com.xueya.view.base.BaseFragment;

/**
 * 登录界面
 * Created by 123 on 2017/6/9.
 */

public class LogInFragment extends BaseFragment {
    EditText login_user,login_psw;
    TextView login_user_introduce,login_psw_introduce;
    @Override
    public void initView(View view) {
        login_user= (EditText) view.findViewById(R.id.login_user);
        login_psw= (EditText) view.findViewById(R.id.login_psw);
        login_user_introduce= (TextView) view.findViewById(R.id.login_user_introduce);
        login_psw_introduce= (TextView) view.findViewById(R.id.login_psw_introduce);
    }

    @Override
    public int getLayoutId() {
        return R.layout.login;
    }

    @Override
    public void initData() {

    }

    @Override
    public void loadData() {

    }

    @Override
    public void initListener() {

    }
}
