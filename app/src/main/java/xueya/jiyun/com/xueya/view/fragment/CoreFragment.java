package xueya.jiyun.com.xueya.view.fragment;

import android.view.View;
import android.widget.LinearLayout;

import xueya.jiyun.com.xueya.R;
import xueya.jiyun.com.xueya.tools.FragmentBuilder;
import xueya.jiyun.com.xueya.view.base.BaseFragment;

/**
 * 个人中心
 * Created by Asus on 2017/6/9.
 */

public class CoreFragment extends BaseFragment implements View.OnClickListener {
    //          顶层LinearLayout  登录   加号        收藏        资料     消息  设置
    LinearLayout login_lin,mine_nologin,mine_sign,mine_collect,mine_data,mine_msg,mine_set;
    @Override
    public void initView(View view) {
        login_lin= (LinearLayout) view.findViewById(R.id.login_lin);
        mine_nologin= (LinearLayout) view.findViewById(R.id.mine_nologin);
        mine_sign= (LinearLayout) view.findViewById(R.id.mine_sign);
        mine_collect= (LinearLayout) view.findViewById(R.id.mine_collect);
        mine_data= (LinearLayout) view.findViewById(R.id.mine_data);
        mine_msg= (LinearLayout) view.findViewById(R.id.mine_msg);
        mine_set= (LinearLayout) view.findViewById(R.id.mine_set);
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
        login_lin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        FragmentBuilder.getInstance().start(R.id.activity_home,LogInFragment.class).isBacked(true);
    }
}
