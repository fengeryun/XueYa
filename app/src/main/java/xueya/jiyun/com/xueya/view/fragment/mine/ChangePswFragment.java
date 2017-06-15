package xueya.jiyun.com.xueya.view.fragment.mine;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import xueya.jiyun.com.xueya.App;
import xueya.jiyun.com.xueya.R;
import xueya.jiyun.com.xueya.model.bean.Event;
import xueya.jiyun.com.xueya.model.sp.SpUtils;
import xueya.jiyun.com.xueya.presenter.login.ChangeNamePresenter;
import xueya.jiyun.com.xueya.presenter.login.ChangePswPresenter;
import xueya.jiyun.com.xueya.tools.FragmentBuilder;
import xueya.jiyun.com.xueya.view.base.BaseFragment;
import xueya.jiyun.com.xueya.view.viewinter.mine.ChangePswView;

/**
 * Created by 123 on 2017/6/14.
 */

public class ChangePswFragment extends BaseFragment implements View.OnClickListener,ChangePswView {    private View view;
    private EditText editText,cg_tpsw,cg_psw;
    private Dialog dialog;
    private Button no,cgpsw_bt;
    private Button ok;
    private String s;
    ChangePswPresenter changeNamePresenter;
    private String trim;
    @Override
    public void initView(View view) {
        cgpsw_bt= (Button) view.findViewById(R.id.cgpsw_bt);
        cg_psw= (EditText) view.findViewById(R.id.cg_psw);
        cg_tpsw= (EditText) view.findViewById(R.id.cg_tpsw);
        changeNamePresenter=new ChangePswPresenter(this);
        EventBus.getDefault().register(ChangePswFragment.this);
    }

    @Override
    public int getLayoutId() {
        return R.layout.changepsw;
    }

    @Override
    public void initData() {
        view = LayoutInflater.from(App.activity).inflate(R.layout.pswpopu,null);
        editText = (EditText) view.findViewById(R.id.psw_et);
        no = (Button) view.findViewById(R.id.no);
        ok = (Button) view.findViewById(R.id.ok);
        dialog = new AlertDialog
                .Builder(App.activity)
                .setTitle("验证密码")
                .setView(view)
                .setCancelable(false)
                .create();
        dialog.show();
        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentBuilder.getInstance().start(R.id.activity_home,SettingFragment.class).isBacked(true);
                dialog.dismiss();
            }
        });
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s = SpUtils.getInstance("LogIn").GetVariable("psw");
                trim = editText.getText().toString().trim();
                boolean b = changeNamePresenter.LoginPsw(s, trim);
                if(b==true){
                    dialog.dismiss();
                }

            }
        });
    }

    @Override
    public void loadData() {

    }

    @Override
    public void initListener() {
        cgpsw_bt.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void ShowOneImage() {

    }

    @Override
    public void HideOneImage() {

    }

    @Override
    public void ShowTwoImage() {

    }

    @Override
    public void HideTwoImage() {

    }

    @Override
    public void ShowMsg(String msg) {
        Toast.makeText(App.activity, msg, Toast.LENGTH_SHORT).show();
    }
    @Subscribe(threadMode = ThreadMode.POSTING,sticky = true)
    public void ononMoonStickyEvent(Event messageEvent){
       if(messageEvent.getMsg()!=null){
           dialog.show();
       }
    }
}
