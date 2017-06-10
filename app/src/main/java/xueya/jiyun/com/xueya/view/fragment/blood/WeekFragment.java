package xueya.jiyun.com.xueya.view.fragment.blood;

import android.view.View;
import android.widget.TextView;

import xueya.jiyun.com.xueya.R;
import xueya.jiyun.com.xueya.tools.FragmentBuilder;
import xueya.jiyun.com.xueya.view.base.BaseFragment;

/**
 * Created by Asus on 2017/6/9.
 */

public class WeekFragment extends BaseFragment implements View.OnClickListener {
    private TextView week_record;

    @Override
    public void initView(View view) {
        week_record = (TextView) view.findViewById(R.id.week_record);
    }

    @Override
    public int getLayoutId() {
        return R.layout.week;
    }

    @Override
    public void initData() {

    }

    @Override
    public void loadData() {

    }

    @Override
    public void initListener() {
        week_record.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        FragmentBuilder.getInstance().start(R.id.activity_home,TakenotesFragment.class).isBacked(true);
    }
}
