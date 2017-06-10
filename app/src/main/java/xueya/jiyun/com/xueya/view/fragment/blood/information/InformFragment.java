package xueya.jiyun.com.xueya.view.fragment.blood.information;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
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

    @OnClick({R.id.nous, R.id.cookbook, R.id.prevent, R.id.treat, R.id.inspect})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.nous:
                FragmentBuilder.getInstance().start(R.id.activity_home,NousFragment.class).isBacked(true);
                break;
            case R.id.cookbook:
                FragmentBuilder.getInstance().start(R.id.activity_home,NousFragment.class).isBacked(true);
                break;
            case R.id.prevent:
                FragmentBuilder.getInstance().start(R.id.activity_home,NousFragment.class).isBacked(true);
                break;
            case R.id.treat:
                FragmentBuilder.getInstance().start(R.id.activity_home,NousFragment.class).isBacked(true);
                break;
            case R.id.inspect:
                FragmentBuilder.getInstance().start(R.id.activity_home,NousFragment.class).isBacked(true);
                break;
        }
    }
}
