package xueya.jiyun.com.xueya.view.fragment.mine;

import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import xueya.jiyun.com.xueya.App;
import xueya.jiyun.com.xueya.R;
import xueya.jiyun.com.xueya.view.base.BaseFragment;

/**
 * Created by 123 on 2017/6/12.
 */

public class CleanCacheFragment extends BaseFragment implements View.OnClickListener {
    Button clean_bt;
    @Override
    public void initView(View view) {
        clean_bt= (Button) view.findViewById(R.id.clean_bt);
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
    }

    @Override
    public void onClick(View v) {
        Toast.makeText(App.activity, "清理成功", Toast.LENGTH_SHORT).show();
    }
}
