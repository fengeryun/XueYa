package xueya.jiyun.com.xueya.view.fragment.blood;

import android.view.View;
import android.widget.TextView;

import xueya.jiyun.com.xueya.R;
import xueya.jiyun.com.xueya.view.base.BaseFragment;

/**
 * Created by Asus on 2017/6/9.
 */

public class DayFragment extends BaseFragment implements View.OnClickListener {
    private TextView day_records;
    @Override
    public void initView(View view) {
        day_records = (TextView) view.findViewById(R.id.day_records);
    }

    @Override
    public int getLayoutId() {
        return R.layout.day;
    }

    @Override
    public void initData() {

    }

    @Override
    public void loadData() {

    }

    @Override
    public void initListener() {
        day_records.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

    }
}
