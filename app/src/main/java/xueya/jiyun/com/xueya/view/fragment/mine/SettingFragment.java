package xueya.jiyun.com.xueya.view.fragment.mine;

import android.support.v4.app.FragmentManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import xueya.jiyun.com.xueya.App;
import xueya.jiyun.com.xueya.R;
import xueya.jiyun.com.xueya.tools.FragmentBuilder;
import xueya.jiyun.com.xueya.view.base.BaseFragment;

/**
 * Created by 123 on 2017/6/12.
 */

public class SettingFragment extends BaseFragment implements View.OnClickListener {
    RelativeLayout set_acc,clean_rll,set_about;
    ImageView set_back;
    @Override
    public void initView(View view) {
        set_acc= (RelativeLayout) view.findViewById(R.id.set_acc);
        clean_rll= (RelativeLayout) view.findViewById(R.id.clean_rll);
        set_about= (RelativeLayout) view.findViewById(R.id.set_about);
        set_back= (ImageView) view.findViewById(R.id.set_back);
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
        set_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager message = App.activity.getSupportFragmentManager();
                message.popBackStackImmediate();
                String lastname = message.getBackStackEntryAt(message.getBackStackEntryCount()-1).getName();
                BaseFragment fragment = (BaseFragment) message.findFragmentByTag(lastname);
                FragmentBuilder.getInstance().setLastFragment(fragment);
            }
        });
        set_acc.setOnClickListener(this);
        clean_rll.setOnClickListener(this);
        set_about.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.set_acc:
                FragmentBuilder.getInstance().start(R.id.activity_home,AccountFragment.class).isBacked(true);
                break;
            case R.id.clean_rll:
                FragmentBuilder.getInstance().start(R.id.activity_home,CleanCacheFragment.class).isBacked(true);
                break;
            case R.id.set_about:
                FragmentBuilder.getInstance().start(R.id.activity_home,AboutFragment.class).isBacked(true);
                break;
        }
    }
}
