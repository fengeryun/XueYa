package xueya.jiyun.com.xueya.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import xueya.jiyun.com.xueya.view.base.BaseFragment;

/**
 * Created by my on 2017/6/12.
 */

public class TabAdapter extends FragmentPagerAdapter{

    List<BaseFragment> list;
    List<String> titlelist = new ArrayList<>();

    public TabAdapter(FragmentManager fm, List<BaseFragment> list) {
        super(fm);
        this.list = list;
        titlelist.add("专家回复");
        titlelist.add("出诊时间表");
        titlelist.add("专家经验分享");

    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titlelist.get(position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
     //  super.destroyItem(container, position, object);
    }
}
