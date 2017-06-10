package xueya.jiyun.com.xueya.view.fragment.mine;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import xueya.jiyun.com.xueya.R;
import xueya.jiyun.com.xueya.presenter.login.ForgetPresenter;
import xueya.jiyun.com.xueya.view.base.BaseFragment;
import xueya.jiyun.com.xueya.view.viewinter.ForgetView;

/**
 * Created by 123 on 2017/6/10.
 */

public class ForgetFragment extends BaseFragment implements ForgetView, View.OnClickListener {
    EditText forget_phone;
    TextView forget_user_introduce;
    ImageView forget_ok;
    Button forget_no,forget_send_bt;
    ForgetPresenter forgetPresenter;
    @Override
    public void initView(View view) {
        forget_phone= (EditText) view.findViewById(R.id.forget_phone);
        forget_user_introduce= (TextView) view.findViewById(R.id.forget_user_introduce);
        forget_ok= (ImageView) view.findViewById(R.id.forget_ok);
        forget_no= (Button) view.findViewById(R.id.forget_no);
        forget_send_bt= (Button) view.findViewById(R.id.forget_send_bt);
        forgetPresenter=new ForgetPresenter(this);
    }

    @Override
    public int getLayoutId() {
        return R.layout.forgetpsw;
    }

    @Override
    public void initData() {

    }

    @Override
    public void loadData() {

    }

    @Override
    public void initListener() {
        forget_send_bt.setOnClickListener(this);
        forget_phone.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                forgetPresenter.GetPhone(forget_phone.getText().toString().trim());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    @Override
    public void ShouMessage(String msg) {

    }

    @Override
    public void ShowOkButton() {
        forget_send_bt.setVisibility(View.VISIBLE);
    }

    @Override
    public void ShowNoButton() {
        forget_no.setVisibility(View.VISIBLE);
    }

    @Override
    public void HideOkButton() {
        forget_send_bt.setVisibility(View.GONE);
    }

    @Override
    public void HideNoButton() {
        forget_no.setVisibility(View.GONE);
    }
//输入提示的隐藏显示
    @Override
    public void ShowEtOk() {
        forget_user_introduce.setVisibility(View.VISIBLE);
    }

    @Override
    public void HideEtOk() {
        forget_user_introduce.setVisibility(View.GONE);
    }
//对勾图片的隐藏和显示
    @Override
    public void ShowTextOk() {
        forget_ok.setVisibility(View.VISIBLE);
    }

    @Override
    public void HideTextOk() {
        forget_ok.setVisibility(View.GONE);
    }

    @Override
    public void onClick(View v) {

    }
}