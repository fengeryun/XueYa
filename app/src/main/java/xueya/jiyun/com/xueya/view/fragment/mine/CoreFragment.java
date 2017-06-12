package xueya.jiyun.com.xueya.view.fragment.mine;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import xueya.jiyun.com.xueya.App;
import xueya.jiyun.com.xueya.R;
import xueya.jiyun.com.xueya.presenter.login.IMainPresenter;
import xueya.jiyun.com.xueya.tools.FragmentBuilder;
import xueya.jiyun.com.xueya.view.base.BaseFragment;
import xueya.jiyun.com.xueya.view.fragment.mine.LogInFragment;
import xueya.jiyun.com.xueya.view.viewinter.mine.MineView;


/**
 * 个人中心
 * Created by Asus on 2017/6/9.
 */

public class CoreFragment extends BaseFragment implements View.OnClickListener,MineView {
    //          顶层LinearLayout  登录   加号        收藏        资料     消息  设置
    LinearLayout login_lin,mine_nologin,mine_sign,mine_collect,mine_data,mine_msg,mine_set,mine_oklogin;
    Button loginbut;
    IMainPresenter iMainPresenter;
    boolean IsOk;
    TextView mine_okname;
    BroadcastReceiver broad = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, final Intent intent) {
            if(intent.getStringExtra("shuaxin")!=null){
                initData();
            }

        }
    };
    @Override
    public void initView(View view) {
        login_lin= (LinearLayout) view.findViewById(R.id.login_lin);
        mine_nologin= (LinearLayout) view.findViewById(R.id.mine_nologin);
        mine_sign= (LinearLayout) view.findViewById(R.id.mine_sign);
        mine_collect= (LinearLayout) view.findViewById(R.id.mine_collect);
        mine_data= (LinearLayout) view.findViewById(R.id.mine_data);
        mine_msg= (LinearLayout) view.findViewById(R.id.mine_msg);
        mine_set= (LinearLayout) view.findViewById(R.id.mine_set);
        loginbut = (Button) view.findViewById(R.id.loginbut);
        mine_oklogin= (LinearLayout) view.findViewById(R.id.mine_oklogin);
        iMainPresenter=new IMainPresenter(this);
        mine_okname= (TextView) view.findViewById(R.id.mine_okname);

        //注册广播
        IntentFilter filter = new IntentFilter();
        filter.addAction("login");
        App.activity.registerReceiver(broad,filter);
    }

    @Override
    public int getLayoutId() {
        return R.layout.corefragment;
    }

    @Override
    public void initData() {
        IsOk=iMainPresenter.login();
        iMainPresenter.getName();
    }
    @Override
    public void loadData() {
    }
    @Override
    public void initListener() {
        login_lin.setOnClickListener(this);
        loginbut.setOnClickListener(this);
        mine_msg.setOnClickListener(this);
        login_lin.setOnClickListener(this);
        mine_set.setOnClickListener(this);
        mine_data.setOnClickListener(this);
        mine_collect.setOnClickListener(this);
        mine_sign.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        if (IsOk){
            FragmentBuilder.getInstance().start(R.id.activity_home,LogInFragment.class).isBacked(true);
        }else{
            switch (v.getId()){
                case R.id.loginbut:

                    FragmentBuilder.getInstance().start(R.id.activity_home,LogInFragment.class).isBacked(true);
                    break;
                case R.id.mine_msg:
                    FragmentBuilder.getInstance().start(R.id.activity_home,MessageFragment.class).isBacked(true);
                    break;
                case R.id.mine_set:
                    FragmentBuilder.getInstance().start(R.id.activity_home,SettingFragment.class).isBacked(true);
                    break;
                case R.id.mine_data:
                    FragmentBuilder.getInstance().start(R.id.activity_home,PersonalFragment.class).isBacked(true);
                    break;
                case R.id.mine_collect:
                    FragmentBuilder.getInstance().start(R.id.activity_home,CollectFragment.class).isBacked(true);
                    break;
                case R.id.mine_sign:
                    FragmentBuilder.getInstance().start(R.id.activity_home,SignFragment.class).isBacked(true);
                    break;
            }

        }
    }
    //判断登录状态来控制头像的隐藏显示
    @Override
    public void showToux() {
        mine_oklogin.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideToux() {
        mine_oklogin.setVisibility(View.GONE);
    }
    //判断登录状态来控制登录按钮的隐藏显示
    @Override
    public void showBt() {
        mine_nologin.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideBt() {
        mine_nologin.setVisibility(View.GONE);
    }

    @Override
    public void setName(String name) {
        mine_okname.setText(name);
    }

}
