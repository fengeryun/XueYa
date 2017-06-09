package xueya.jiyun.com.xueya.view.fragment;

import android.view.View;
import android.widget.LinearLayout;

import xueya.jiyun.com.xueya.R;
import xueya.jiyun.com.xueya.view.base.BaseFragment;

/**
 * Created by Asus on 2017/6/9.
 */

public class CoreFragment extends BaseFragment{
    //                登录        加号        收藏        资料     消息  设置
    LinearLayout mine_nologin,mine_sign,mine_collect,mine_data,mine_msg,mine_set;
    @Override
    public void initView(View view) {
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

    }
}
