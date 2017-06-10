package xueya.jiyun.com.xueya.view.fragment.blood;

import android.view.View;
import android.widget.TextView;

import xueya.jiyun.com.xueya.R;
import xueya.jiyun.com.xueya.tools.FragmentBuilder;
import xueya.jiyun.com.xueya.view.base.BaseFragment;

/**
 * Created by Asus on 2017/6/9.
 */

public class MoonFragment extends BaseFragment implements View.OnClickListener {
    private TextView moon_record;
    @Override
    public void initView(View view) {
     moon_record = (TextView) view.findViewById(R.id.moon_records);
    }

    @Override
    public int getLayoutId() {
        return R.layout.moon;
    }

    @Override
    public void initData() {

    }

    @Override
    public void loadData() {

    }

    @Override
    public void initListener() {
        moon_record.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        FragmentBuilder.getInstance().start(R.id.activity_home,TakenotesFragment.class).isBacked(true);
    }
}
