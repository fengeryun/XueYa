package xueya.jiyun.com.xueya.view.fragment.mine;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.Timer;
import java.util.TimerTask;

import xueya.jiyun.com.xueya.App;
import xueya.jiyun.com.xueya.R;
import xueya.jiyun.com.xueya.model.bean.Event;
import xueya.jiyun.com.xueya.presenter.login.VerificationPresenter;
import xueya.jiyun.com.xueya.presenter.login.VerifyPresenter;
import xueya.jiyun.com.xueya.tools.ThreadUtils;
import xueya.jiyun.com.xueya.view.base.BaseFragment;
import xueya.jiyun.com.xueya.view.viewinter.mine.VerifyView;

import static android.content.ContentValues.TAG;

/**
 * Created by 123 on 2017/6/13.
 */

public class VerificationFragment extends BaseFragment implements View.OnClickListener,VerifyView {
    TextView affirm_text,affirm_dao;
    TextView affirm_edit;
    Button affirm_no_bt,affirm_ok_bt;
    int num=60;
    String str="我们已经下发验证码到这个手机号:";
    VerificationPresenter ver;
    private String trim;

    @Override
    public void initView(View view) {
        affirm_dao= (TextView) view.findViewById(R.id.affirm_dao);
        affirm_text= (TextView) view.findViewById(R.id.affirm_text);
        affirm_edit= (TextView) view.findViewById(R.id.affirm_edit);
        affirm_no_bt= (Button) view.findViewById(R.id.affirm_no_bt);
        affirm_ok_bt= (Button) view.findViewById(R.id.affirm_ok_bt);
        ver=new VerificationPresenter(this);
    }

    @Override
    public int getLayoutId() {
        return R.layout.verification_code;
    }

    @Override
    public void initData() {
        SetText();
        EventBus.getDefault().register(VerificationFragment.this);
    }

    @Override
    public void loadData() {

    }

    @Override
    public void initListener() {
        affirm_ok_bt.setOnClickListener(this);
        affirm_edit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                trim = affirm_edit.getText().toString().trim();
                ver.GetMsg(trim);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    @Override
    public void onClick(View v) {

    }
    //绿色按钮的显示和隐藏
    @Override
    public void ShowOkBt() {
        affirm_ok_bt.setVisibility(View.VISIBLE);
    }

    @Override
    public void HideOkBt() {
        affirm_ok_bt.setVisibility(View.GONE);
    }
    //不可以登录按钮的隐藏和显示
    @Override
    public void ShowNoBt() {
        affirm_no_bt.setVisibility(View.VISIBLE);
    }

    @Override
    public void HideNoBt() {
        affirm_no_bt.setVisibility(View.GONE);
    }

    @Override
    public void ShowMsg(String msg) {
        Toast.makeText(App.activity, msg, Toast.LENGTH_SHORT).show();
    }

    @Subscribe(threadMode = ThreadMode.MAIN,sticky = true)
    public void getEventBus(Event event){
        Log.e("TAG",event.getMsg());
        affirm_text.setText(str+event.getMsg());
    }

    @Override
    public void GoFragment() {

    }
    public void SetText(){
        Timer t=new Timer();
        t.schedule(new TimerTask() {
            @Override
            public void run() {
                if(num<61){
                    num--;
                    ThreadUtils.runOnMain(new Runnable() {
                        @Override
                        public void run() {
                            if(num==0){
                                num=61;
                                affirm_dao.setText("验证码已失效");
                            }else{
                                affirm_dao.setText("接受短信大约需要"+num+"秒");
                            }
                        }
                    });
                }
            }
        },1000,1000);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(VerificationFragment.this);
    }
}
