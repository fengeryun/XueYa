package xueya.jiyun.com.xueya.view.fragment.blood.tixing;

import android.view.View;
import android.widget.ImageView;

import xueya.jiyun.com.xueya.R;
import xueya.jiyun.com.xueya.tools.FragmentBuilder;
import xueya.jiyun.com.xueya.view.base.BaseFragment;

/**
 * Created by Asus on 2017/6/10.
 */

public class RemindFragment extends BaseFragment implements View.OnClickListener {
    private ImageView remind_jia;
    @Override
    public void initView(View view) {
        remind_jia = (ImageView) view.findViewById(R.id.remind_jia);

    }

    @Override
    public int getLayoutId() {
        return R.layout.remind;
    }

    @Override
    public void initData() {

    }

    @Override
    public void loadData() {

    }

    @Override
    public void initListener() {
        remind_jia.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.remind_jia:
                FragmentBuilder.getInstance().start(R.id.activity_home,AddRemindFragment.class).isBacked(true);
                break;
        }
    }
}
