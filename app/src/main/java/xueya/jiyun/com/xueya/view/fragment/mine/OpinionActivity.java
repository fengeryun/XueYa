package xueya.jiyun.com.xueya.view.fragment.mine;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import xueya.jiyun.com.xueya.App;
import xueya.jiyun.com.xueya.R;
import xueya.jiyun.com.xueya.model.bean.Event;
import xueya.jiyun.com.xueya.presenter.login.OpinionPresenter;
import xueya.jiyun.com.xueya.tools.ThreadUtils;
import xueya.jiyun.com.xueya.view.base.BaseActivity;
import xueya.jiyun.com.xueya.view.viewinter.Dialogs;
import xueya.jiyun.com.xueya.view.viewinter.mine.OpinionView;

public class OpinionActivity extends BaseActivity implements View.OnClickListener, OpinionView {
    TextView opinion_send,opinion_num;
    EditText opinion_et;
    OpinionPresenter opinionPresenter;
    @Override
    public int getLayoutId() {
        return R.layout.msg_opinion;
    }

    @Override
    public void initView() {

        opinion_send= (TextView) this.findViewById(R.id.opinion_send);
        opinion_num= (TextView) this.findViewById(R.id.opinion_num);
        opinion_et= (EditText) this.findViewById(R.id.opinion_et);
        opinionPresenter=new OpinionPresenter(this);
        EventBus.getDefault().register(OpinionActivity.this);
    }

    @Override
    public void initData() {

    }

    @Override
    public void initListener() {
        opinion_send.setOnClickListener(this);
        opinion_et.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                opinionPresenter.GetMsgNum(opinion_et.getText().toString().trim());

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
    public void onClick(View v) {
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.show();
        ThreadUtils.runOnSubThread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                    ThreadUtils.runOnMain(new Runnable() {
                        @Override
                        public void run() {
                            progressDialog.dismiss();
                            Toast.makeText(OpinionActivity.this, "提交成功！", Toast.LENGTH_SHORT).show();
                        }
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

       // Dialogs.Show2Dialog();

        Dialogs.ShowDialog();
    }

    @Override
    public void ChangeTv(int num) {
//        opinion_num.setText();
    }
    @Subscribe(threadMode = ThreadMode.POSTING,sticky = true)
    public void ononMoonStickyEvent(Event messageEvent){
        opinion_num.setText(messageEvent.getMsg()+"/500");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
