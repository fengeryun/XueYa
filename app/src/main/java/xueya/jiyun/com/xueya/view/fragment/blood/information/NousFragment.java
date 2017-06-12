package xueya.jiyun.com.xueya.view.fragment.blood.information;

import android.view.View;
import android.widget.ListView;

import xueya.jiyun.com.xueya.R;
import xueya.jiyun.com.xueya.presenter.bloods.NousPresenter;
import xueya.jiyun.com.xueya.view.base.BaseFragment;
import xueya.jiyun.com.xueya.view.viewinter.Dialogs;

/**
 * Created by Asus on 2017/6/10.
 */

public class NousFragment extends BaseFragment{
    NousPresenter nousPresenter;
    private ListView listView;
    @Override
    public void initView(View view) {
        Dialogs.getInstent().ShowDialog();
        listView = (ListView) view.findViewById(R.id.nous_listview);
    }

    @Override
    public int getLayoutId() {
        return R.layout.nous;
    }

    @Override
    public void initData() {
        nousPresenter = new NousPresenter(listView);
    }

    @Override
    public void loadData() {
       nousPresenter.click();

    }

    @Override
    public void initListener() {

    }
}
