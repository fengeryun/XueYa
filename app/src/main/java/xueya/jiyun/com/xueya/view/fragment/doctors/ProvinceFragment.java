package xueya.jiyun.com.xueya.view.fragment.doctors;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import xueya.jiyun.com.xueya.App;
import xueya.jiyun.com.xueya.R;
import xueya.jiyun.com.xueya.adapter.ProvinceAdapter;
import xueya.jiyun.com.xueya.model.urls.ProvinceList;
import xueya.jiyun.com.xueya.tools.FragmentBuilder;
import xueya.jiyun.com.xueya.view.base.BaseFragment;

/**
 * Created by my on 2017/6/10.
 */

public class ProvinceFragment extends BaseFragment {
    @Bind(R.id.record_back)
    ImageView recordBack;
    @Bind(R.id.record_titlle)
    TextView recordTitlle;
    @Bind(R.id.taken_listview)
    ListView takenListview;
    ProvinceAdapter adapter;

    @Override
    public void initView(View view) {
        recordTitlle.setText("省份");
    }

    @Override
    public int getLayoutId() {
        return R.layout.takenotes;
    }

    @Override
    public void initData() {
        adapter = new ProvinceAdapter(ProvinceList.getProvince().getProvinces());
        takenListview.setAdapter(adapter);
    }

    @Override
    public void loadData() {

    }

    @Override
    public void initListener() {
        takenListview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent it = new Intent();
                it.setAction("provincename");
                it.putExtra("proname",ProvinceList.getProvince().getProvinces().get(position));
                App.activity.sendBroadcast(it);
                FragmentBuilder.getInstance().start(R.id.viewpage,DoctorFragment.class).isBacked(true);
            }
        });
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

    @OnClick(R.id.record_back)
    public void onViewClicked() {
        FragmentManager message = App.activity.getSupportFragmentManager();
        message.popBackStackImmediate();
        String lastname = message.getBackStackEntryAt(message.getBackStackEntryCount()-1).getName();
        BaseFragment fragment = (BaseFragment) message.findFragmentByTag(lastname);
        FragmentBuilder.getInstance().setLastFragment(fragment);
    }
}
