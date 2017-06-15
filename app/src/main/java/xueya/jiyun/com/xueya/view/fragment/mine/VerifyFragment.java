package xueya.jiyun.com.xueya.view.fragment.mine;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;

import xueya.jiyun.com.xueya.App;
import xueya.jiyun.com.xueya.R;
import xueya.jiyun.com.xueya.model.bean.Event;
import xueya.jiyun.com.xueya.model.sp.SpUtils;
import xueya.jiyun.com.xueya.presenter.login.VerifyPresenter;
import xueya.jiyun.com.xueya.tools.FragmentBuilder;
import xueya.jiyun.com.xueya.view.base.BaseFragment;
import xueya.jiyun.com.xueya.view.viewinter.mine.VerifyView;

/**
 * Created by 123 on 2017/6/13.
 */

public class VerifyFragment extends BaseFragment implements View.OnClickListener,VerifyView {
    String str="更改成功后,下次登录可以使用新的手机号码,当前手机号码为:";
    TextView change_tv;
    EditText change_et;
    Button verify_no_bt,verify_ok_bt;
    VerifyPresenter verifyPresenter;
    private String trim;

    @Override
    public void initView(View view) {
        verify_ok_bt= (Button) view.findViewById(R.id.verify_ok_bt);
        verify_no_bt= (Button) view.findViewById(R.id.verify_no_bt);
        change_tv= (TextView) view.findViewById(R.id.change_tv);
        change_et= (EditText) view.findViewById(R.id.change_et);
        verifyPresenter=new VerifyPresenter(this);
    }

    @Override
    public int getLayoutId() {
        return R.layout.verify_phone;
    }

    @Override
    public void initData() {
        change_tv.setText(str+SpUtils.getInstance("LogIn").GetVariable("phonenum"));
        change_et.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                trim = change_et.getText().toString().trim();
                verifyPresenter.GetPhone(trim);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    @Override
    public void loadData() {

    }

    @Override
    public void initListener() {
        verify_ok_bt.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        verifyPresenter.JundePhone(trim);
    }
//绿色按钮的显示和隐藏
    @Override
    public void ShowOkBt() {
        verify_ok_bt.setVisibility(View.VISIBLE);
    }

    @Override
    public void HideOkBt() {
        verify_ok_bt.setVisibility(View.GONE);
    }
//不可以登录按钮的隐藏和显示
    @Override
    public void ShowNoBt() {
        verify_no_bt.setVisibility(View.VISIBLE);
    }

    @Override
    public void HideNoBt() {
        verify_no_bt.setVisibility(View.GONE);
    }

    @Override
    public void ShowMsg(String msg) {
        Toast.makeText(App.activity, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void GoFragment() {
        EventBus.getDefault().postSticky(new Event(trim));
        FragmentBuilder.getInstance().start(R.id.activity_home,VerificationFragment.class).isBacked(true);
    }
}
