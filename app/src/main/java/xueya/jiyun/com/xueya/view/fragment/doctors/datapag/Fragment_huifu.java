package xueya.jiyun.com.xueya.view.fragment.doctors.datapag;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import in.srain.cube.views.ptr.PtrFrameLayout;
import xueya.jiyun.com.xueya.App;
import xueya.jiyun.com.xueya.R;
import xueya.jiyun.com.xueya.adapter.HuiFuAdapter;
import xueya.jiyun.com.xueya.model.bean.HuiFuBean;
import xueya.jiyun.com.xueya.presenter.doctor.HuiFuPresenter;
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
    public void loadList(List<HuiFuBean.DataBean> lists) {
        Dialogs.disDialog();
        adapters = new HuiFuAdapter(lists);
        hiufuListview.setAdapter(adapters);
    }
}
