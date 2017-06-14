package xueya.jiyun.com.xueya.view.fragment.doctors;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import xueya.jiyun.com.xueya.App;
import xueya.jiyun.com.xueya.R;
import xueya.jiyun.com.xueya.adapter.ProvinceAdapter;
import xueya.jiyun.com.xueya.model.urls.LiShiList;
import xueya.jiyun.com.xueya.tools.FragmentBuilder;
import xueya.jiyun.com.xueya.tools.ThreadUtils;
import xueya.jiyun.com.xueya.view.base.BaseFragment;

/**
 * Created by my on 2017/6/12.
 */

public class DoctorSousuo extends BaseFragment {
    @Bind(R.id.sousuo_back)
    TextView sousuoBack;
    @Bind(R.id.sousuo_input)
    EditText sousuoInput;
    @Bind(R.id.sousuo_yes)
    TextView sousuoYes;
    @Bind(R.id.sousuo_list)
    ListView sousuoList;
    @Bind(R.id.sousuo_layout)
    LinearLayout sousuoLayout;
    ProvinceAdapter adapter;
    Intent it;

    @Override
    public void initView(View view) {

    }

    @Override
    public int getLayoutId() {
        return R.layout.sousuo_view;
    }

    @Override
    public void initData() {
        it = new Intent();
    }

    @Override
    public void loadData() {
        View view = LayoutInflater.from(App.activity).inflate(R.layout.sousuo_foot, null);
        TextView tv = (TextView) view.findViewById(R.id.foot_txt);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder2 = new AlertDialog.Builder(App.activity);
                builder2.setTitle("是否清空历史记录").setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        ThreadUtils.runOnMain(new Runnable() {
                            @Override
                            public void run() {
                                LiShiList.getInstance().clears();
                                adapter.notifyDataSetChanged();
                            }
                        });
                        Toast.makeText(App.activity, "清除历史记录成功", Toast.LENGTH_SHORT).show();
                    }
                }).setNegativeButton("取消", null);
                builder2.show();
            }
        });
        adapter = new ProvinceAdapter(LiShiList.getInstance().getList());
        sousuoList.addFooterView(view);
        sousuoList.setAdapter(adapter);
    }

    @Override
    public void initListener() {
        sousuoList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int len=LiShiList.getInstance().getList().size();
                Log.e("setOnItemClickListener",position+"   数量    "+len);
                if(len>=1&&position<len){
                    sousuoInput.setText(LiShiList.getInstance().getList().get(position));
                }

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

    @OnClick({R.id.sousuo_back, R.id.sousuo_yes,R.id.sousuo_layout})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.sousuo_back:
                onBack();
                break;
            case R.id.sousuo_yes:
                if(sousuoInput.getText().toString().trim().length()>=1){
                    LiShiList.getInstance().addlishi(sousuoInput.getText().toString().trim());
                    it.putExtra("sousuoname",sousuoInput.getText().toString().trim());
                    it.setAction("provincename");
                    App.activity.sendBroadcast(it);
                    onBack();
                }else {
                    ThreadUtils.runOnMain(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(App.activity, "输入内容不能为空", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
                break;
            case R.id.sousuo_layout:
                Toast.makeText(App.activity, "页面", Toast.LENGTH_SHORT).show();
                break;
        }
    }
    private void onBack(){
        FragmentManager message = App.activity.getSupportFragmentManager();
        message.popBackStackImmediate();
        String lastname = message.getBackStackEntryAt(message.getBackStackEntryCount() - 1).getName();
        BaseFragment fragment = (BaseFragment) message.findFragmentByTag(lastname);
        FragmentBuilder.getInstance().setLastFragment(fragment);
    }
}
