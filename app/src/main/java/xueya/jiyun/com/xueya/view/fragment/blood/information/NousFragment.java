package xueya.jiyun.com.xueya.view.fragment.blood.information;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.List;

import xueya.jiyun.com.xueya.App;
import xueya.jiyun.com.xueya.R;
import xueya.jiyun.com.xueya.adapter.NousAdapter;
import xueya.jiyun.com.xueya.model.bean.Nous;
import xueya.jiyun.com.xueya.presenter.bloods.NousPresenter;
import xueya.jiyun.com.xueya.tools.FragmentBuilder;
import xueya.jiyun.com.xueya.view.base.BaseFragment;
import xueya.jiyun.com.xueya.view.viewinter.Dialogs;
import xueya.jiyun.com.xueya.view.viewinter.blooder.NousView;

/**
 * Created by Asus on 2017/6/10.
 */

public class NousFragment extends BaseFragment implements NousView, View.OnClickListener {
    NousPresenter nousPresenter;
    private ListView listVieww;
    private String type;
    private NousAdapter adapter;
    private String typeid;
    private ImageView nous_back;

    @Override
    public void initView(View view) {
        listVieww = (ListView) view.findViewById(R.id.nous_listview);
        Dialogs.Show2Dialog();
        nous_back = (ImageView) view.findViewById(R.id.nous_back);
    }

    @Override
    public int getLayoutId() {
        return R.layout.nous;
    }

    @Override
    public void initData() {
        nousPresenter = new NousPresenter(type,this,typeid);
    }

    @Override
    public void loadData() {
        nousPresenter.click(typeid);
    }

    @Override
    public void initListener() {
        nous_back.setOnClickListener(this);
    }

    @Override
    public void setParams(Bundle bundle) {
        super.setParams(bundle);
        type = bundle.getString("type");
        typeid = bundle.getString("typeid");
        Log.e("AAA","---"+typeid);

    }


    @Override
    public void ListData(final List<Nous.DataBean> listdata) {
        adapter = new NousAdapter(listdata);
        listVieww.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        listVieww.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Bundle bundle = new Bundle();
                bundle.putString("type",type);
                bundle.putString("id",listdata.get(position).getId());
                bundle.putString("typeid",typeid);
                FragmentBuilder.getInstance().start(R.id.activity_home, EaasyFragment.class).isBacked(true).setParams(bundle);
            }
        });
    }

    @Override
    public void onClick(View v) {
        FragmentManager message = App.activity.getSupportFragmentManager();
        message.popBackStackImmediate();
        String lastname = message.getBackStackEntryAt(message.getBackStackEntryCount()-1).getName();
        BaseFragment fragment = (BaseFragment) message.findFragmentByTag(lastname);
        FragmentBuilder.getInstance().setLastFragment(fragment);
    }
}
