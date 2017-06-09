package xueya.jiyun.com.xueya.view.fragment.blood;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import xueya.jiyun.com.xueya.R;
import xueya.jiyun.com.xueya.adapter.ZongAdapter;
import xueya.jiyun.com.xueya.view.base.BaseFragment;

/**
 * Created by 123 on 2017/6/9.
 */

public class BloodFragment extends BaseFragment {
    @Bind(R.id.radioButton2)
    RadioButton radioButton2;
    @Bind(R.id.radioButton)
    RadioButton radioButton;
    @Bind(R.id.radioButton4)
    RadioButton radioButton4;
    @Bind(R.id.radioButton3)
    RadioButton radioButton3;
    @Bind(R.id.xueya_fra)
    ViewPager xueyaFra;
    private ArrayList<Fragment> list;
    private ZongAdapter adapter;

    @Override
    public int getLayoutId() {
        return R.layout.bloodfragment;
    }

    @Override
    public void initView(View view) {

    }

    @Override
    public void initData() {
        list = new ArrayList<>();
        list.add(new DayFragment());
        list.add(new WeekFragment());
        list.add(new MoonFragment());
        list.add(new YearFragment());
        adapter = new ZongAdapter(getChildFragmentManager(),list);
        xueyaFra.setAdapter(adapter);
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

    @OnClick({R.id.radioButton2, R.id.radioButton, R.id.radioButton4, R.id.radioButton3})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.radioButton2:
                xueyaFra.setCurrentItem(0);
                break;
            case R.id.radioButton:
                xueyaFra.setCurrentItem(1);
                break;
            case R.id.radioButton4:
                xueyaFra.setCurrentItem(2);
                break;
            case R.id.radioButton3:
                xueyaFra.setCurrentItem(3);
                break;
        }
    }
}
