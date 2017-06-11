package xueya.jiyun.com.xueya.view.fragment.mine;

import android.view.View;
import android.widget.LinearLayout;

import xueya.jiyun.com.xueya.R;
import xueya.jiyun.com.xueya.view.base.BaseFragment;

/**
 * Created by 123 on 2017/6/11.
 */

public class FreeFragment extends BaseFragment implements View.OnClickListener {
    LinearLayout free_lin;
    @Override
    public void initView(View view) {
        free_lin= (LinearLayout) view.findViewById(R.id.free_lin);
    }

    @Override
    public int getLayoutId() {
        return R.layout.freequiz;
    }

    @Override
    public void initData() {

    }

    @Override
    public void loadData() {

    }

    @Override
    public void initListener() {
        free_lin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

    }
}
