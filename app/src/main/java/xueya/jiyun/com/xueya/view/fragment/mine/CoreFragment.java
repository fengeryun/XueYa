package xueya.jiyun.com.xueya.view.fragment.mine;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

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
    LinearLayout login_lin,mine_nologin,mine_sign,mine_collect,mine_data,mine_msg,mine_set;
    Button loginbut;
    IMainPresenter iMainPresenter;
    boolean IsOk;
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
        iMainPresenter=new IMainPresenter(this);
    }

    @Override
    public int getLayoutId() {
        return R.layout.corefragment;
    }

    @Override
    public void initData() {
        IsOk=iMainPresenter.login();
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


    }

    @Override
    public void hideToux() {

    }
    //判断登录状态来控制登录按钮的隐藏显示
    @Override
    public void showBt() {

    }

    @Override
    public void hideBt() {

    }

}
