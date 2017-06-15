package xueya.jiyun.com.xueya.view.fragment.blood.tixing;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.Calendar;
import java.util.List;

import xueya.jiyun.com.xueya.App;
import xueya.jiyun.com.xueya.R;
import xueya.jiyun.com.xueya.adapter.RemindAdapter;
import xueya.jiyun.com.xueya.model.db.Hour;
import xueya.jiyun.com.xueya.presenter.bloods.RemindPresenter;
import xueya.jiyun.com.xueya.tools.FragmentBuilder;
import xueya.jiyun.com.xueya.view.base.BaseFragment;
import xueya.jiyun.com.xueya.view.viewinter.blooder.RemindView;

/**
 * Created by Asus on 2017/6/10.
 */

public class RemindFragment extends BaseFragment implements View.OnClickListener,RemindView {
    private ImageView remind_jia,remind_back;
    private RemindPresenter remindPresenter;
    private ListView listView;
    private RemindAdapter adapter;

    BroadcastReceiver broad = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, final Intent intent) {
            if(intent.getStringExtra("flsh")!=null){
                loadData();
                getDelet();
                adapter.notifyDataSetChanged();
            }

        }
    };
    private Calendar mCalendar;


    @Override
    public void initView(View view) {
        remind_jia = (ImageView) view.findViewById(R.id.remind_jia);
        remindPresenter = new RemindPresenter(this);
        listView = (ListView) view.findViewById(R.id.remind_listview);
        IntentFilter filter = new IntentFilter();
        filter.addAction("xushaojie");
        App.activity.registerReceiver(broad,filter);
        remind_back = (ImageView) view.findViewById(R.id.remind_back);
    }

    @Override
    public int getLayoutId() {
        return R.layout.remind;
    }

    @Override
    public void initData() {

    }

    @Override
    public void loadData() {
        remindPresenter.getShow();
    }

    @Override
    public void initListener() {
        remind_jia.setOnClickListener(this);
        remind_back.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.remind_jia:
                FragmentBuilder.getInstance().start(R.id.activity_home,AddRemindFragment.class).isBacked(true);
                break;
            case R.id.remind_back:
                FragmentManager message = App.activity.getSupportFragmentManager();
                message.popBackStackImmediate();
                String lastname = message.getBackStackEntryAt(message.getBackStackEntryCount()-1).getName();
                BaseFragment fragment = (BaseFragment) message.findFragmentByTag(lastname);
                FragmentBuilder.getInstance().setLastFragment(fragment);
                break;
        }
    }
    @Override
    public void getShow(List<Hour> list) {

        adapter = new RemindAdapter(list);
        listView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {

                Dialog dialog = new AlertDialog.Builder(App.activity)
                        .setMessage("确认删除吗？")

                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                remindPresenter.deletData(position);
                                adapter.notifyDataSetChanged();
                            }
                        })
                        .setNegativeButton("取消",null)
                        .create();
                dialog.show();
                adapter.notifyDataSetChanged();
                return true;
            }
        });
    }

    @Override
    public void getDelet() {
        adapter.notifyDataSetChanged();
    }

}
