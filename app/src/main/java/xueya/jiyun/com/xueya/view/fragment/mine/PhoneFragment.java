package xueya.jiyun.com.xueya.view.fragment.mine;

import android.support.v4.app.FragmentManager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import xueya.jiyun.com.xueya.App;
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
    ImageView phone_back;
    @Override
    public void initView(View view) {
        phone_bt= (Button) view.findViewById(R.id.phone_bt);
        phone_text= (TextView) view.findViewById(R.id.phone_text);
        phone_back= (ImageView) view.findViewById(R.id.phone_back);
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
        phone_back.setOnClickListener(new View.OnClickListener() {
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
        FragmentBuilder.getInstance().start(R.id.activity_home,VerifyFragment.class).isBacked(true);
    }
}
