package xueya.jiyun.com.xueya.view.fragment.doctors.datapag;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import in.srain.cube.views.ptr.PtrFrameLayout;
import xueya.jiyun.com.xueya.App;
import xueya.jiyun.com.xueya.R;
import xueya.jiyun.com.xueya.adapter.ProvinceAdapter;
import xueya.jiyun.com.xueya.model.bean.JingYanBean;
import xueya.jiyun.com.xueya.presenter.doctor.JingYanPresenter;
import xueya.jiyun.com.xueya.tools.FragmentBuilder;
import xueya.jiyun.com.xueya.tools.ThreadUtils;
import xueya.jiyun.com.xueya.view.base.BaseFragment;
import xueya.jiyun.com.xueya.view.viewinter.doc.JingYanView;

/**
 * Created by my on 2017/6/13.
 */

public class Fragment_Jingyan extends BaseFragment implements JingYanView{
    @Bind(R.id.hiufuListview)
    ListView hiufuListview;
    @Bind(R.id.huifuPtr)
    PtrFrameLayout huifuPtr;
    JingYanPresenter persenter;
    int num = 1;
    List<String> jingyanlist = new ArrayList<>();
    ProvinceAdapter adapter;

    @Override
    public void initView(View view) {

    }

    @Override
    public int getLayoutId() {
        return R.layout.huifu_list;
    }

    @Override
    public void initData() {
        persenter = new JingYanPresenter(this);
        persenter.getJingYan(num);
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

    @Override
    public void showToest(final String cont) {
        ThreadUtils.runOnMain(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(App.activity, cont, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void loadGrid(final List<JingYanBean.DataBean> list) {
        for(int i=0; i<list.size(); i++){
            jingyanlist.add(list.get(i).getTitle());
        }
        if(jingyanlist.size()>=1){
            adapter = new ProvinceAdapter(jingyanlist);
            hiufuListview.setAdapter(adapter);
        }else {
            Toast.makeText(App.activity, "网速太慢，差点崩了", Toast.LENGTH_SHORT).show();
        }

        hiufuListview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Bundle bun = new Bundle();
                bun.putString("title","文章详情");
                bun.putString("id",list.get(position).getId());
                bun.putString("cateid",list.get(position).getCategoryid());
                FragmentBuilder.getInstance().start(R.id.activity_home,Fragment_Web.class).isBacked(true).setParams(bun);
            }
        });
    }
}
