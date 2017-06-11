package xueya.jiyun.com.xueya.view.fragment.mine;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import xueya.jiyun.com.xueya.App;
import xueya.jiyun.com.xueya.R;
import xueya.jiyun.com.xueya.tools.FragmentBuilder;
import xueya.jiyun.com.xueya.view.base.BaseFragment;
import xueya.jiyun.com.xueya.view.fragment.mine.LogInFragment;


/**
 * 个人中心
 * Created by Asus on 2017/6/9.
 */

public class CoreFragment extends BaseFragment implements View.OnClickListener {
    //          顶层LinearLayout  登录   加号        收藏        资料     消息  设置
    LinearLayout login_lin,mine_nologin,mine_sign,mine_collect,mine_data,mine_msg,mine_set;
    Button loginbut;

    @Override
    public void initView(View view) {
        login_lin= (LinearLayout) view.findViewById(R.id.login_lin);
        mine_nologin= (LinearLayout) view.findViewById(R.id.mine_nologin);
        mine_sign= (LinearLayout) view.findViewById(R.id.mine_sign);
        mine_collect= (LinearLayout) view.findViewById(R.id.mine_collect);
        mine_data= (LinearLayout) view.findViewById(R.id.mine_data);
        mine_msg= (LinearLayout) view.findViewById(R.id.mine_msg);
        mine_set= (LinearLayout) view.findViewById(R.id.mine_set);
        loginbut = (Button) view.findViewById(R.id.loginbut);
    }

    @Override
    public int getLayoutId() {
        return R.layout.corefragment;
    }

    @Override
    public void initData() {
    }

    @Override
    public void loadData() {
    }

    @Override
    public void initListener() {
        loginbut.setOnClickListener(this);
        mine_msg.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.loginbut:
                FragmentBuilder.getInstance().start(R.id.activity_home,LogInFragment.class).isBacked(true);
                break;
            case R.id.mine_msg:
                FragmentBuilder.getInstance().start(R.id.activity_home,MessageFragment.class).isBacked(true);
                break;
        }

    }
}
