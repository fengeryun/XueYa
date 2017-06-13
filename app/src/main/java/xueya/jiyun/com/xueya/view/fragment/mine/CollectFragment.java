package xueya.jiyun.com.xueya.view.fragment.mine;

import android.view.View;
import android.widget.ListView;

import xueya.jiyun.com.xueya.R;
import xueya.jiyun.com.xueya.adapter.CollectAdapter;
import xueya.jiyun.com.xueya.presenter.login.CollectPresenter;
import xueya.jiyun.com.xueya.view.base.BaseFragment;
import xueya.jiyun.com.xueya.view.viewinter.mine.CollectView;

/**
 * Created by 123 on 2017/6/12.
 */

public class CollectFragment extends BaseFragment implements CollectView{
    ListView collect_list;
    CollectAdapter adapter;
    CollectPresenter collectPresenter;
    @Override
    public void initView(View view) {
        collect_list= (ListView) view.findViewById(R.id.collect_list);
        collectPresenter=new CollectPresenter(this);
    }

    @Override
    public int getLayoutId() {
        return R.layout.mine_collect;
    }

    @Override
    public void initData() {
        collectPresenter.GetBean();
    }

    @Override
    public void loadData() {

    }

    @Override
    public void initListener() {

    }

    @Override
    public void ShouItem() {

    }
}
