package xueya.jiyun.com.xueya.view.fragment.mine;

import android.support.v4.app.FragmentManager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import xueya.jiyun.com.xueya.App;
import xueya.jiyun.com.xueya.R;
import xueya.jiyun.com.xueya.tools.FragmentBuilder;
import xueya.jiyun.com.xueya.view.base.BaseFragment;

/**
 * Created by 123 on 2017/6/12.
 */

public class CleanCacheFragment extends BaseFragment implements View.OnClickListener {
    Button clean_bt;
    ImageView clean_back;
    @Override
    public void initView(View view) {
        clean_bt= (Button) view.findViewById(R.id.clean_bt);
        clean_back= (ImageView) view.findViewById(R.id.clean_back);
    }

    @Override
    public int getLayoutId() {
        return R.layout.clean_cache;
    }

    @Override
    public void initData() {

    }

    @Override
    public void loadData() {

    }

    @Override
    public void initListener() {
        clean_bt.setOnClickListener(this);
        clean_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager message = App.activity.getSupportFragmentManager();
                message.popBackStackImmediate();
                String lastname = message.getBackStackEntryAt(message.getBackStackEntryCount()-1).getName();
                BaseFragment fragment = (BaseFragment) message.findFragmentByTag(lastname);
                FragmentBuilder.getInstance().setLastFragment(fragment);
            }
        });
    }

    @Override
    public void onClick(View v) {
        Toast.makeText(App.activity, "清理成功", Toast.LENGTH_SHORT).show();
    }
}
