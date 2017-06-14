package xueya.jiyun.com.xueya.view.fragment.doctors;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import xueya.jiyun.com.xueya.App;
import xueya.jiyun.com.xueya.R;
import xueya.jiyun.com.xueya.adapter.TabAdapter;
import xueya.jiyun.com.xueya.tools.FragmentBuilder;
import xueya.jiyun.com.xueya.tools.ThreadUtils;
import xueya.jiyun.com.xueya.view.base.BaseFragment;
import xueya.jiyun.com.xueya.view.fragment.doctors.datapag.Fragment_huifu;
import xueya.jiyun.com.xueya.view.fragment.doctors.datapag.Fragment_times;
import xueya.jiyun.com.xueya.view.viewinter.Dialogs;

/**
 * Created by my on 2017/6/12.
 */

public class ZhuanJiaData extends BaseFragment {

    Bundle bun;
    @Bind(R.id.data_backs)
    ImageView dataBacks;
    @Bind(R.id.data_names)
    TextView dataNames;
    @Bind(R.id.data_pic)
    ImageView dataPic;
    @Bind(R.id.data_name)
    TextView dataName;
    @Bind(R.id.data_yiyuan)
    TextView dataYiyuan;
    @Bind(R.id.data_zhiwei)
    TextView dataZhiwei;
    @Bind(R.id.data_jineng)
    TextView dataJineng;
    @Bind(R.id.data_xueli)
    TextView dataXueli;
    @Bind(R.id.data_content)
    TextView dataContent;
    @Bind(R.id.data_tab)
    TabLayout dataTab;
    @Bind(R.id.data_pag)
    ViewPager dataPag;
    List<BaseFragment> fraglist = new ArrayList<>();
    TabAdapter tabadapter;

    @Override
    public void initView(View view) {

    }

    @Override
    public int getLayoutId() {
        return R.layout.zhuanjiadata;
    }

    @Override
    public void initData() {
        bun = getParams();
        Glide.with(App.activity).load(bun.getString("img")).into(dataPic);
        dataNames.setText(bun.getString("name"));
        dataName.setText(bun.getString("name"));
        dataYiyuan.setText(bun.getString("yiyuan"));
        dataZhiwei.setText(bun.getString("job"));
        dataJineng.setText(bun.getString("jineng"));
        dataXueli.setText(bun.getString("xueli"));
        dataContent.setText(bun.getString("content"));

        dataTab.setupWithViewPager(dataPag);
        dataTab.setTabMode(TabLayout.MODE_FIXED);
        fraglist.add(new Fragment_huifu());
        fraglist.add(new Fragment_times());
        fraglist.add(new Fragment_times());
        tabadapter = new TabAdapter(getChildFragmentManager(),fraglist);
        dataPag.setAdapter(tabadapter);
    }

    @Override
    public void onResume() {
        super.onResume();
        tabadapter.notifyDataSetChanged();
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

    @OnClick(R.id.data_backs)
    public void onViewClicked() {
        onBack();
    }

    private void onBack() {
        FragmentManager message = App.activity.getSupportFragmentManager();
        message.popBackStackImmediate();
        String lastname = message.getBackStackEntryAt(message.getBackStackEntryCount() - 1).getName();
        BaseFragment fragment = (BaseFragment) message.findFragmentByTag(lastname);
        FragmentBuilder.getInstance().setLastFragment(fragment);
    }

}