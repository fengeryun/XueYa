package xueya.jiyun.com.xueya.view.fragment.doctors;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import in.srain.cube.views.ptr.PtrClassicDefaultFooter;
import in.srain.cube.views.ptr.PtrClassicDefaultHeader;
import in.srain.cube.views.ptr.PtrDefaultHandler2;
import in.srain.cube.views.ptr.PtrFrameLayout;
import xueya.jiyun.com.xueya.App;
import xueya.jiyun.com.xueya.R;
import xueya.jiyun.com.xueya.adapter.ZhuanJiaAdapter;
import xueya.jiyun.com.xueya.model.bean.ZhuanJiaBean;
import xueya.jiyun.com.xueya.presenter.doctor.ZhuanJiaPresenter;
import xueya.jiyun.com.xueya.tools.FragmentBuilder;
import xueya.jiyun.com.xueya.tools.ThreadUtils;
import xueya.jiyun.com.xueya.view.base.BaseFragment;
import xueya.jiyun.com.xueya.view.viewinter.Dialogs;
import xueya.jiyun.com.xueya.view.viewinter.doc.ZhuanJiaView;

/**
 * Created by my on 2017/6/12.
 */

public class ZhuanjiaFragment extends BaseFragment implements ZhuanJiaView {
    @Bind(R.id.zhuanjia_back)
    ImageView zhuanjiaBack;
    @Bind(R.id.zhuanjia_titlle)
    TextView zhuanjiaTitlle;
    @Bind(R.id.zhuanjia_listview)
    ListView zhuanjiaListview;
    @Bind(R.id.zhuanjia_ptr)
    PtrFrameLayout zhuanjiaPtr;
    ZhuanJiaPresenter persenter;
    ZhuanJiaAdapter adapter;
    ProgressDialog dialog;
    Bundle bun;
    String province;
    int num = 1;

    @Override
    public void initView(View view) {

    }

    @Override
    public int getLayoutId() {
        return R.layout.zhuanjialist;
    }

    @Override
    public void initData() {
    }

    @Override
    public void loadData() {
        bun = getParams();
        province = bun.getString("proname");
        dialog = new ProgressDialog(App.activity);
        dialog.setMessage("loading");
        dialog.show();
        persenter = new ZhuanJiaPresenter(this);
        persenter.getZhuanJiaData(province,num);
    }

    @Override
    public void initListener() {
        PtrClassicDefaultHeader head = new PtrClassicDefaultHeader(getActivity());
        PtrClassicDefaultFooter foot = new PtrClassicDefaultFooter(getActivity());
        zhuanjiaPtr.setHeaderView(head);
        zhuanjiaPtr.setFooterView(foot);
        zhuanjiaPtr.addPtrUIHandler(head);
        zhuanjiaPtr.addPtrUIHandler(foot);     //下拉刷新

        zhuanjiaPtr.setPtrHandler(new PtrDefaultHandler2() {  //下拉刷新监听
            @Override
            public void onLoadMoreBegin(PtrFrameLayout frame) {
                ThreadUtils.runOnSubThread(new Runnable(){
                    @Override
                    public void run() {
                        num++;
                        persenter.getZhuanJiaData(province,num);
                        ThreadUtils.runOnMain(new Runnable() {
                            @Override
                            public void run() {
                                adapter.notifyDataSetChanged();
                                zhuanjiaPtr.refreshComplete();
                            }
                        });
                    }
                });
            }
            @Override
            public void onRefreshBegin(PtrFrameLayout frame) {
                persenter.getZhuanJiaData(province,1);
                ThreadUtils.runOnMain(new Runnable() {
                    @Override
                    public void run() {
                        adapter.notifyDataSetChanged();
                        zhuanjiaPtr.refreshComplete();
                    }
                });
            }
        });
    }

    @Override
    public void showToast(String cont) {
        Toast.makeText(App.activity, cont, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void goListItem() {

    }

    @Override
    public void loadList(String docnum,final List<ZhuanJiaBean.DataBean> list) {
        dialog.dismiss();
        zhuanjiaTitlle.setText(docnum);
        adapter = new ZhuanJiaAdapter(list);
        zhuanjiaListview.setAdapter(adapter);

        zhuanjiaListview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Bundle bun = new Bundle();
                bun.putParcelable("databean",list.get(position));
                FragmentBuilder.getInstance().start(R.id.activity_home,ZhuanJiaData.class).isBacked(true).setParams(bun);
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

    @OnClick(R.id.zhuanjia_back)
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
