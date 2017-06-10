package xueya.jiyun.com.xueya.view.fragment.blood;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
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

public class InformationFragment extends BaseFragment {
    @Bind(R.id.reco_back)
    ImageView recoBack;
    @Bind(R.id.record_titlle)
    TextView recordTitlle;
    @Bind(R.id.information_data)
    ImageView informationData;

    @Override
    public void initView(View view) {

    }

    @Override
    public int getLayoutId() {
        return R.layout.information;
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

    @OnClick(R.id.reco_back)
    public void onViewClicked() {
        FragmentManager message = App.activity.getSupportFragmentManager();
        message.popBackStackImmediate();
        String lastname = message.getBackStackEntryAt(message.getBackStackEntryCount()-1).getName();
        BaseFragment fragment = (BaseFragment) message.findFragmentByTag(lastname);
        FragmentBuilder.getInstance().setLastFragment(fragment);
    }
}
