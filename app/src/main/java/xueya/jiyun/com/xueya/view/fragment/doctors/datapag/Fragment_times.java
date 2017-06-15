package xueya.jiyun.com.xueya.view.fragment.doctors.datapag;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import xueya.jiyun.com.xueya.R;
import xueya.jiyun.com.xueya.view.base.BaseFragment;

/**
 * Created by my on 2017/6/12.
 */

public class Fragment_times extends BaseFragment {
    @Bind(R.id.data_time)
    GridView dataTime;
    @Bind(R.id.times_cont)
    TextView timesCont;
    @Bind(R.id.times_layout)
    LinearLayout timesLayout;

    @Override
    public void initView(View view) {

    }

    @Override
    public int getLayoutId() {
        return R.layout.data_time;
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

    @OnClick(R.id.times_layout)
    public void onViewClicked() {
    }
}
