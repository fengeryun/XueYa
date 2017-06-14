package xueya.jiyun.com.xueya.view.fragment.doctors;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
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
import xueya.jiyun.com.xueya.model.bean.ZhuanJiaBean;
import xueya.jiyun.com.xueya.tools.FragmentBuilder;
import xueya.jiyun.com.xueya.view.base.BaseFragment;
import xueya.jiyun.com.xueya.view.fragment.doctors.datapag.Fragment_Jingyan;
import xueya.jiyun.com.xueya.view.fragment.doctors.datapag.Fragment_huifu;
import xueya.jiyun.com.xueya.view.fragment.doctors.datapag.Fragment_times;

/**
 * Created by my on 2017/6/12.
 */

public class ZhuanJiaData extends BaseFragment {

    @Bind(R.id.zhuanjiadatalayout)
    LinearLayout zhuanjiadatalayout;
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
    Bundle bun;
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
        ZhuanJiaBean.DataBean bean = bun.getParcelable("databean");
        Glide.with(App.activity).load(bean.getApp_image()).into(dataPic);
        dataNames.setText(bean.getName());
        dataName.setText(bean.getName());
        dataYiyuan.setText(bean.getHospital());
        dataZhiwei.setText(bean.getTitle());
        dataJineng.setText(bean.getDepart());
        dataXueli.setText(bean.getTeach());
        dataContent.setText(bean.getGoodat());

        dataTab.setupWithViewPager(dataPag);
        dataTab.setTabMode(TabLayout.MODE_FIXED);
        fraglist.add(new Fragment_huifu());
        fraglist.add(new Fragment_times());
        fraglist.add(new Fragment_Jingyan());
        tabadapter = new TabAdapter(getChildFragmentManager(), fraglist);
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


    @OnClick({R.id.data_backs, R.id.zhuanjiadatalayout})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.data_backs:
                onBack();
                break;
            case R.id.zhuanjiadatalayout:
                break;
        }
    }

    private void onBack() {
        FragmentManager message = App.activity.getSupportFragmentManager();
        message.popBackStackImmediate();
        String lastname = message.getBackStackEntryAt(message.getBackStackEntryCount() - 1).getName();
        BaseFragment fragment = (BaseFragment) message.findFragmentByTag(lastname);
        FragmentBuilder.getInstance().setLastFragment(fragment);
    }
}
