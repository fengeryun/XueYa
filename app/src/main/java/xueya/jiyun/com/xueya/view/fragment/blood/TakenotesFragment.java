package xueya.jiyun.com.xueya.view.fragment.blood;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import xueya.jiyun.com.xueya.App;
import xueya.jiyun.com.xueya.R;
import xueya.jiyun.com.xueya.adapter.TakenAdapter;
import xueya.jiyun.com.xueya.model.bean.Ha;
import xueya.jiyun.com.xueya.model.bean.Hei;
import xueya.jiyun.com.xueya.model.db.Takes;
import xueya.jiyun.com.xueya.presenter.bloods.TakenotesPersenter;
import xueya.jiyun.com.xueya.tools.FragmentBuilder;
import xueya.jiyun.com.xueya.view.base.BaseFragment;
import xueya.jiyun.com.xueya.view.viewinter.blooder.TakenotesView;

/**
 * Created by Asus on 2017/6/10.
 */

public class TakenotesFragment extends BaseFragment implements TakenotesView{
    @Bind(R.id.record_back)
    ImageView recordBack;
    @Bind(R.id.taken_listview)
    ListView takenListview;
    private TakenotesPersenter persenter;
    TakenAdapter adapter;
    @Override
    public void initView(View view) {
    }

    @Override
    public int getLayoutId() {
        return R.layout.takenotes;
    }

    @Override
    public void initData() {
        persenter = new TakenotesPersenter(this);

    }

    @Override
    public void loadData() {
        persenter.getListview();
    }

    @Override
    public void initListener() {
        takenListview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                FragmentBuilder.getInstance().start(R.id.xueya_fra, InformationFragment.class).isBacked(true);
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
        EventBus.getDefault().postSticky(new Ha("freshen"));
        FragmentManager message = App.activity.getSupportFragmentManager();
        message.popBackStackImmediate();
        String lastname = message.getBackStackEntryAt(message.getBackStackEntryCount()-1).getName();
        BaseFragment fragment = (BaseFragment) message.findFragmentByTag(lastname);
        FragmentBuilder.getInstance().setLastFragment(fragment);
    }

    @Override
    public void showListview(List<Takes> list) {
        adapter = new TakenAdapter(list);
        takenListview.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        takenListview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                FragmentBuilder.getInstance().start(R.id.activity_home,InformationFragment.class).isBacked(true);
            }
        });
        onLong();
    }
    @Subscribe(threadMode = ThreadMode.POSTING,sticky = true)
    public void Wocao(Hei hei){
        if (hei!=null){
            persenter.getListview();
            adapter.notifyDataSetChanged();
        }
    }

    public void onLong(){
        takenListview.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {
                Dialog dialog = new AlertDialog.Builder(App.activity)
                        .setMessage("确认删除吗？")

                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                persenter.deletData(position);

                                persenter.getListview();
                                adapter.notifyDataSetChanged();
                            }
                        })
                        .setNegativeButton("取消",null)
                        .create();
                dialog.show();

                adapter.notifyDataSetChanged();
                return false;
            }
        });
    }
}
