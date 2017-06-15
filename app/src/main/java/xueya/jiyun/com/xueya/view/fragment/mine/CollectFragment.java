package xueya.jiyun.com.xueya.view.fragment.mine;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import xueya.jiyun.com.xueya.App;
import xueya.jiyun.com.xueya.R;
import xueya.jiyun.com.xueya.adapter.CollAdapter;
import xueya.jiyun.com.xueya.adapter.CollectAdapter;
import xueya.jiyun.com.xueya.model.bean.Collect;
import xueya.jiyun.com.xueya.model.bean.SignBean;
import xueya.jiyun.com.xueya.model.sp.SpUtils;
import xueya.jiyun.com.xueya.presenter.login.CollectPresenter;
import xueya.jiyun.com.xueya.tools.FragmentBuilder;
import xueya.jiyun.com.xueya.view.base.BaseFragment;
import xueya.jiyun.com.xueya.view.fragment.blood.information.EaasyFragment;
import xueya.jiyun.com.xueya.view.viewinter.Dialogs;
import xueya.jiyun.com.xueya.view.viewinter.mine.CollectView;

/**
 * Created by 123 on 2017/6/12.
 */

public class CollectFragment extends BaseFragment implements CollectView{
    ListView collect_list;
    CollectPresenter collectPresenter;
    CollAdapter adapter;
    Collect coll;
    private String s;
    private Bundle b;

    @Override
    public void initView(View view) {
        collect_list= (ListView) view.findViewById(R.id.collect_list);
        collectPresenter=new CollectPresenter(this);
        Dialogs.Show2Dialog();
    }

    @Override
    public int getLayoutId() {
        return R.layout.mine_collect;
    }

    @Override
    public void initData() {
        collectPresenter.GetBean(SpUtils.getInstance("LogIn").GetVariable("userid"));
    }

    @Override
    public void loadData() {

    }
    @Override
    public void initListener() {
        collect_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                /*Bundle bundle=new Bundle();
                bundle.putString("type","2");
                FragmentBuilde\r.getInstance().start(R.id.activity_home, EaasyFragment.class).setParams(bundle).isBacked(true);*/
                s = coll.getData().get(position).getMeta().split(",")[0];
                Log.e("SSS",s);
                b = new Bundle();
                b.putString("type",s);
                b.putString("id",coll.getData().get(position).getCategoryid());
                FragmentBuilder.getInstance().start(R.id.activity_home,EaasyFragment.class).setParams(b).isBacked(true);
            }
        });
    }

    public void ShouItem() {

    }
    public void GetCollect(Collect collect) {
        coll=collect;
    adapter=new CollAdapter(collect);
        collect_list.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

}
