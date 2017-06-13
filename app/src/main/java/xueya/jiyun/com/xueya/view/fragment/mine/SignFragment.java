package xueya.jiyun.com.xueya.view.fragment.mine;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

import xueya.jiyun.com.xueya.R;
import xueya.jiyun.com.xueya.adapter.CollectAdapter;
import xueya.jiyun.com.xueya.model.bean.SignBean;
import xueya.jiyun.com.xueya.model.sp.SpUtils;
import xueya.jiyun.com.xueya.presenter.login.SignPresenter;
import xueya.jiyun.com.xueya.tools.FragmentBuilder;
import xueya.jiyun.com.xueya.view.base.BaseFragment;
import xueya.jiyun.com.xueya.view.viewinter.mine.SignView;

/**
 * Created by 123 on 2017/6/12.
 */

public class SignFragment extends BaseFragment implements SignView {
    TextView sign_tishi;
    ListView sign_list;
    SignPresenter signPresenter;
    private String s;
    CollectAdapter adapter;
    SignBean signBean;
    @Override
    public void initView(View view) {
        sign_list= (ListView) view.findViewById(R.id.sign_list);
        sign_tishi= (TextView) view.findViewById(R.id.sign_tishi);
        signPresenter=new SignPresenter(this);
    }

    @Override
    public int getLayoutId() {
        return R.layout.mine_sign;
    }

    @Override
    public void initData() {
           s = SpUtils.getInstance("LogIn").GetVariable("userid");
            signPresenter.GetBean(s);

    }

    @Override
    public void loadData() {

    }

    @Override
    public void initListener() {
        sign_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                SignBean.DataBeanX.DataBean dataBean = signBean.getData().getData().get(position);
                Bundle bundle=new Bundle();
                bundle.putString("depart",dataBean.getDepart());
                bundle.putString("expert",dataBean.getExpert());
                bundle.putString("todate",dataBean.getTodate());
                bundle.putString("hopital",dataBean.getHopital());
                FragmentBuilder.getInstance().start(R.id.activity_home,DetailsFragment.class).setParams(bundle);
            }
        });
    }

    @Override
    public void ShowList() {
        sign_list.setVisibility(View.VISIBLE);
    }

    @Override
    public void HideList() {
        sign_list.setVisibility(View.GONE);
    }

    @Override
    public void ShowText() {
   sign_tishi.setVisibility(View.VISIBLE);
    }

    @Override
    public void HideText() {
    sign_tishi.setVisibility(View.GONE);
    }

    @Override
    public void GetBean(SignBean signBean1) {
        signBean=signBean1;
        adapter=new CollectAdapter(signBean);
        sign_list.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
}
