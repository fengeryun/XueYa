package xueya.jiyun.com.xueya.view.fragment.mine;

import android.content.Intent;
import android.view.View;
import android.widget.Button;

import xueya.jiyun.com.xueya.App;
import xueya.jiyun.com.xueya.R;
import xueya.jiyun.com.xueya.model.sp.SpUtils;
import xueya.jiyun.com.xueya.tools.FragmentBuilder;
import xueya.jiyun.com.xueya.view.base.BaseFragment;
import xueya.jiyun.com.xueya.view.fragment.doctors.DoctorFragment;

/**
 * Created by 123 on 2017/6/12.
 */

public class AccountFragment extends BaseFragment implements View.OnClickListener {
    Button exit_bt;
    @Override
    public void initView(View view) {
        exit_bt= (Button) view.findViewById(R.id.exit_bt);
    }

    @Override
    public int getLayoutId() {
        return R.layout.account;
    }

    @Override
    public void initData() {

    }

    @Override
    public void loadData() {

    }

    @Override
    public void initListener() {
        exit_bt.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.exit_bt:
                SpUtils.getInstance("LogIn").CleanVariable();
                Intent it = new Intent();
                it.setAction("login");
                it.putExtra("shuaxin","shuaxin");
                App.activity.sendBroadcast(it);
                FragmentBuilder.getInstance().start(R.id.viewpage, DoctorFragment.class).isBacked(true);
                break;
        }
    }
}
