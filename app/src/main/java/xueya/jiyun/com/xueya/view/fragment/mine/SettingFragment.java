package xueya.jiyun.com.xueya.view.fragment.mine;

import android.view.View;
import android.widget.RelativeLayout;

import xueya.jiyun.com.xueya.R;
import xueya.jiyun.com.xueya.tools.FragmentBuilder;
import xueya.jiyun.com.xueya.view.base.BaseFragment;

/**
 * Created by 123 on 2017/6/12.
 */

public class SettingFragment extends BaseFragment implements View.OnClickListener {
    RelativeLayout set_acc,clean_rll,set_about;
    @Override
    public void initView(View view) {
        set_acc= (RelativeLayout) view.findViewById(R.id.set_acc);
        clean_rll= (RelativeLayout) view.findViewById(R.id.clean_rll);
        set_about= (RelativeLayout) view.findViewById(R.id.set_about);
    }

    @Override
    public int getLayoutId() {
        return R.layout.set_setting;
    }

    @Override
    public void initData() {

    }

    @Override
    public void loadData() {

    }

    @Override
    public void initListener() {
        set_acc.setOnClickListener(this);
        clean_rll.setOnClickListener(this);
        set_about.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.set_acc:
                FragmentBuilder.getInstance().start(R.id.activity_home,AccountFragment.class);
                break;
            case R.id.clean_rll:
                FragmentBuilder.getInstance().start(R.id.activity_home,CleanCacheFragment.class);
                break;
            case R.id.set_about:
                FragmentBuilder.getInstance().start(R.id.activity_home,AboutFragment.class);
                break;
        }
    }
}
