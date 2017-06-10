package xueya.jiyun.com.xueya.view.fragment.blood;

import android.view.View;
import android.widget.ImageView;

import xueya.jiyun.com.xueya.App;
import xueya.jiyun.com.xueya.R;
import xueya.jiyun.com.xueya.view.base.BaseFragment;

/**
 * Created by Asus on 2017/6/9.
 */

public class RecordFragment extends BaseFragment implements View.OnClickListener {
    private ImageView record_back;
    @Override
    public void initView(View view) {
        record_back = (ImageView) view.findViewById(R.id.record_back);
    }

    @Override
    public int getLayoutId() {
        return R.layout.record;
    }

    @Override
    public void initData() {

    }

    @Override
    public void loadData() {

    }

    @Override
    public void initListener() {
        record_back.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.record_back:
                App.activity.onBackPressed();
                break;
        }
    }
}
