package xueya.jiyun.com.xueya.view.fragment.doctors.datapag;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import in.srain.cube.views.ptr.PtrClassicDefaultFooter;
import in.srain.cube.views.ptr.PtrClassicDefaultHeader;
import in.srain.cube.views.ptr.PtrDefaultHandler2;
import in.srain.cube.views.ptr.PtrFrameLayout;
import xueya.jiyun.com.xueya.App;
import xueya.jiyun.com.xueya.R;
import xueya.jiyun.com.xueya.adapter.HuiFuAdapter;
import xueya.jiyun.com.xueya.model.bean.HuiFuBean;
import xueya.jiyun.com.xueya.presenter.doctor.HuiFuPresenter;
import xueya.jiyun.com.xueya.tools.FragmentBuilder;
import xueya.jiyun.com.xueya.tools.ThreadUtils;
import xueya.jiyun.com.xueya.view.base.BaseFragment;
import xueya.jiyun.com.xueya.view.viewinter.Dialogs;
import xueya.jiyun.com.xueya.view.viewinter.doc.HuiFuView;

/**
 * Created by my on 2017/6/12.
 */

public class Fragment_huifu extends BaseFragment implements HuiFuView{
    @Bind(R.id.hiufuListview)
    ListView hiufuListview;
    @Bind(R.id.huifuPtr)
    PtrFrameLayout huifuPtr;
    HuiFuPresenter persenter;
    int numb = 1;
    HuiFuAdapter adapters;

    @Override
    public void initView(View view) {

    }

    @Override
    public int getLayoutId() {
        return R.layout.huifu_list;
    }

    @Override
    public void initData() {
    }

    @Override
    public void onResume() {
        super.onResume();
        persenter = new HuiFuPresenter(this);
        persenter.getHuiFuDataList(numb);
        Dialogs.ShowDialog();
        //adapters.notifyDataSetChanged();
    }

    @Override
    public void loadData() {

    }

    @Override
    public void initListener() {
        PtrClassicDefaultHeader head = new PtrClassicDefaultHeader(getActivity());
        PtrClassicDefaultFooter foot = new PtrClassicDefaultFooter(getActivity());
        huifuPtr.setHeaderView(head);
        huifuPtr.setFooterView(foot);
        huifuPtr.addPtrUIHandler(head);
        huifuPtr.addPtrUIHandler(foot);     //下拉刷新

        huifuPtr.setPtrHandler(new PtrDefaultHandler2() {  //下拉刷新监听
            @Override
            public void onLoadMoreBegin(PtrFrameLayout frame) {
                ThreadUtils.runOnSubThread(new Runnable(){
                    @Override
                    public void run() {
                        numb++;
                        persenter.getHuiFuDataList(numb);
                        ThreadUtils.runOnMain(new Runnable() {
                            @Override
                            public void run() {
                                adapters.notifyDataSetChanged();
                                huifuPtr.refreshComplete();
                            }
                        });
                    }
                });
            }
            @Override
            public void onRefreshBegin(PtrFrameLayout frame) {
                persenter.getHuiFuDataList(1);
                ThreadUtils.runOnMain(new Runnable() {
                    @Override
                    public void run() {
                        adapters.notifyDataSetChanged();
                        huifuPtr.refreshComplete();
                    }
                });
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

    @Override
    public void showToast(final String cont) {
        ThreadUtils.runOnMain(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(App.activity, cont, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void loadList(final List<HuiFuBean.DataBean> lists) {
        Dialogs.disDialog();
        adapters = new HuiFuAdapter(lists);
        hiufuListview.setAdapter(adapters);

        hiufuListview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Bundle bun = new Bundle();
                bun.putString("title","问题详情");
                bun.putString("id",lists.get(position).getClub_id());
                bun.putString("cateid","1");
                FragmentBuilder.getInstance().start(R.id.activity_home,Fragment_Web.class).isBacked(true).setParams(bun);
                ThreadUtils.runOnMain(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(App.activity, "问题id不能为空", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}
