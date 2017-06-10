package xueya.jiyun.com.xueya.view.fragment.blood;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import xueya.jiyun.com.xueya.R;
import xueya.jiyun.com.xueya.tools.FragmentBuilder;
import xueya.jiyun.com.xueya.view.base.BaseFragment;

/**
 * Created by Asus on 2017/6/10.
 */

public class TakenotesFragment extends BaseFragment{
    private ListView listView;
    @Override
    public void initView(View view) {
        listView = (ListView) view.findViewById(R.id.taken_listview);
    }

    @Override
    public int getLayoutId() {
        return R.layout.takenotes;
    }

    @Override
    public void initData() {

    }

    @Override
    public void loadData() {

    }

    @Override
    public void initListener() {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                FragmentBuilder.getInstance().start(R.id.xueya_fra,InformationFragment.class).isBacked(true);
            }
        });
    }
}
