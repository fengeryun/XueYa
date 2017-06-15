package xueya.jiyun.com.xueya.view.fragment.mine;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import org.greenrobot.eventbus.EventBus;

import xueya.jiyun.com.xueya.App;
import xueya.jiyun.com.xueya.R;
import xueya.jiyun.com.xueya.model.bean.Event;
import xueya.jiyun.com.xueya.model.sp.SpUtils;
import xueya.jiyun.com.xueya.tools.FragmentBuilder;
import xueya.jiyun.com.xueya.view.base.BaseFragment;
import xueya.jiyun.com.xueya.view.fragment.doctors.DoctorFragment;

/**
 * Created by 123 on 2017/6/12.
 */

public class AccountFragment extends BaseFragment implements View.OnClickListener {
    Button exit_bt;
    ImageView zhanghu_back;
    RelativeLayout zhanghu_rl1,zhanghu_psw;
    @Override
    public void initView(View view) {
        exit_bt= (Button) view.findViewById(R.id.exit_bt);
        zhanghu_rl1= (RelativeLayout) view.findViewById(R.id.zhanghu_rl1);
        zhanghu_psw= (RelativeLayout) view.findViewById(R.id.zhanghu_psw);
        zhanghu_back= (ImageView) view.findViewById(R.id.zhanghu_back);
    }

    @Override
    public int getLayoutId() {
        return R.layout.account;
    }

    @Override
    public void initData() {

    }

    @Override
    public void loadData() {

    }

    @Override
    public void initListener() {
        zhanghu_rl1.setOnClickListener(this);
        zhanghu_psw.setOnClickListener(this);
        exit_bt.setOnClickListener(this);
        zhanghu_back.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.exit_bt:
                Dialog dialog=new AlertDialog.Builder(App.activity)
                        .setTitle("退出登录")
                        .setMessage("退出不会删除任何数据,下次登录可使用本账号")
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                SpUtils.getInstance("LogIn").CleanVariable();
                                Intent it = new Intent();
                                it.setAction("login");
                                it.putExtra("shuaxin","shuaxin");
                                App.activity.sendBroadcast(it);
                                FragmentBuilder.getInstance().start(R.id.viewpage, DoctorFragment.class).isBacked(true).isBacked(true);
                            }
                        })
                        .setNegativeButton("取消",null)
                        .create();
                dialog.show();
                break;
            case R.id.zhanghu_rl1:
            FragmentBuilder.getInstance().start(R.id.activity_home,PhoneFragment.class);
                 break;
            case R.id.zhanghu_psw:
                FragmentBuilder.getInstance().start(R.id.activity_home,ChangePswFragment.class);
                break;
            case R.id.zhanghu_back:
                FragmentManager message = App.activity.getSupportFragmentManager();
                message.popBackStackImmediate();
                String lastname = message.getBackStackEntryAt(message.getBackStackEntryCount()-1).getName();
                BaseFragment fragment = (BaseFragment) message.findFragmentByTag(lastname);
                FragmentBuilder.getInstance().setLastFragment(fragment);
                break;
        }
    }
}
