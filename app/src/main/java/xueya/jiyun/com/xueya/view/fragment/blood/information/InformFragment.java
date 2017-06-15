package xueya.jiyun.com.xueya.view.fragment.blood.information;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import xueya.jiyun.com.xueya.App;
import xueya.jiyun.com.xueya.R;
import xueya.jiyun.com.xueya.tools.FragmentBuilder;
import xueya.jiyun.com.xueya.view.base.BaseFragment;

/**
 * Created by Asus on 2017/6/10.
 */

public class InformFragment extends BaseFragment {
    @Bind(R.id.nous)
    LinearLayout nous;
    @Bind(R.id.cookbook)
    LinearLayout cookbook;
    @Bind(R.id.prevent)
    LinearLayout prevent;
    @Bind(R.id.treat)
    LinearLayout treat;
    @Bind(R.id.inspect)
    LinearLayout inspect;
    @Bind(R.id.record_titlle)
    TextView recordTitlle;
    @Bind(R.id.inform_layout)
    LinearLayout informLayout;
    @Bind(R.id.inform_back)
    ImageView informBack;

    @Override
    public void initView(View view) {

    }

    @Override
    public int getLayoutId() {
        return R.layout.inform;
    }

    @Override
    public void initData() {

    }

    @Override
    public void loadData() {

    }

    @Override
    public void initListener() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @OnClick({R.id.nous, R.id.cookbook, R.id.prevent, R.id.treat, R.id.inspect,R.id.inform_back,R.id.inform_layout})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.nous:

                Bundle bundle1 = new Bundle();
                bundle1.putString("type","zhuanti_nk");
                bundle1.putString("typeid","18031");
                FragmentBuilder.getInstance().start(R.id.activity_home, NousFragment.class).isBacked(true).setParams(bundle1);

                break;
            case R.id.cookbook:
                Bundle bundle2 = new Bundle();
                bundle2.putString("type","zhuzhan_ys");
                bundle2.putString("typeid","7938");
                FragmentBuilder.getInstance().start(R.id.activity_home, NousFragment.class).isBacked(true).setParams(bundle2);
                break;
            case R.id.prevent:
                Bundle bundle3 = new Bundle();
                bundle3.putString("type","zhuanti_nk");
                bundle3.putString("typeid","18033");
                FragmentBuilder.getInstance().start(R.id.activity_home, NousFragment.class).isBacked(true).setParams(bundle3);
                break;
            case R.id.treat:
                Bundle bundle4 = new Bundle();
                bundle4.putString("type","zhuanti_nk");
                bundle4.putString("typeid","18035");
                FragmentBuilder.getInstance().start(R.id.activity_home, NousFragment.class).isBacked(true).setParams(bundle4);
                break;
            case R.id.inspect:
                Bundle bundle5 = new Bundle();
                bundle5.putString("type","zhuanti_nk");
                bundle5.putString("typeid","18032");
                FragmentBuilder.getInstance().start(R.id.activity_home, NousFragment.class).isBacked(true).setParams(bundle5);
                break;
            case R.id.inform_back:
                FragmentManager message = App.activity.getSupportFragmentManager();
                message.popBackStackImmediate();
                String lastname = message.getBackStackEntryAt(message.getBackStackEntryCount() - 1).getName();
                BaseFragment fragment = (BaseFragment) message.findFragmentByTag(lastname);
                FragmentBuilder.getInstance().setLastFragment(fragment);
                break;
            case R.id.inform_layout:
                break;
        }
    }
}
