package xueya.jiyun.com.xueya.view.fragment.mine;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import xueya.jiyun.com.xueya.R;
import xueya.jiyun.com.xueya.model.sp.SpUtils;
import xueya.jiyun.com.xueya.tools.FragmentBuilder;
import xueya.jiyun.com.xueya.view.base.BaseFragment;

/**
 * Created by 123 on 2017/6/13.
 */

public class PhoneFragment extends BaseFragment implements View.OnClickListener {
    Button phone_bt;
    TextView phone_text;
    private String s;

    @Override
    public void initView(View view) {
        phone_bt= (Button) view.findViewById(R.id.phone_bt);
        phone_text= (TextView) view.findViewById(R.id.phone_text);
    }

    @Override
    public int getLayoutId() {
        return R.layout.phone_fragment;
    }

    @Override
    public void initData() {
        s = SpUtils.getInstance("LogIn").GetVariable("phonenum");
        phone_text.setText(s);
    }

    @Override
    public void loadData() {

    }

    @Override
    public void initListener() {
        phone_bt.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        FragmentBuilder.getInstance().start(R.id.activity_home,VerifyFragment.class);
    }
}
