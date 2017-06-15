package xueya.jiyun.com.xueya.view.fragment.doctors.datapag;

import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import xueya.jiyun.com.xueya.App;
import xueya.jiyun.com.xueya.R;
import xueya.jiyun.com.xueya.tools.FragmentBuilder;
import xueya.jiyun.com.xueya.tools.ThreadUtils;
import xueya.jiyun.com.xueya.view.base.BaseFragment;

/**
 * Created by my on 2017/6/15.
 */

public class FragmentAddNext extends BaseFragment {
    @Bind(R.id.addnext_backs)
    ImageView addnextBacks;
    @Bind(R.id.addnext_name)
    TextView addnextName;
    @Bind(R.id.addnext_location)
    TextView addnextLocation;
    @Bind(R.id.addnext_person)
    TextView addnextPerson;
    @Bind(R.id.up_next)
    Button upNext;
    @Bind(R.id.add_commit)
    Button addCommit;
    @Bind(R.id.addNextLayout)
    LinearLayout addNextLayout;
    ProgressDialog dialog;
    BroadcastReceiver broads = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, final Intent intent) {
            ThreadUtils.runOnMain(new Runnable() {
                @Override
                public void run() {
                    if(intent.getStringExtra("bingOne")!=null){
                        addnextName.setText(intent.getStringExtra("bingOne"));
                    }else {
                        addnextLocation.setText(intent.getStringExtra("bingTwo"));
                    }
                }
            });
        }
    };
    Handler hands = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 666:
                    ThreadUtils.runOnMain(new Runnable() {
                        @Override
                        public void run() {
                            dialog.dismiss();
                            Toast.makeText(App.activity, "上传成功", Toast.LENGTH_SHORT).show();
                        }
                    });
                    break;
            }
        }
    };

    @Override
    public void initView(View view) {

    }

    @Override
    public int getLayoutId() {
        return R.layout.adduser_next;
    }

    @Override
    public void initData() {
        IntentFilter filter = new IntentFilter();
        filter.addAction("jibing");
        App.activity.registerReceiver(broads, filter);

    }

    @Override
    public void loadData() {

    }

    @Override
    public void initListener() {

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

    @OnClick({R.id.addnext_backs, R.id.up_next, R.id.add_commit, R.id.addNextLayout,R.id.addnext_name,R.id.addnext_location,R.id.addnext_person})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.addnext_backs:
                onBack();
                break;
            case R.id.up_next:
                onBack();
                break;
            case R.id.add_commit:
                if(addnextName.getText().length()>1 && addnextLocation.getText().length()>1){
                    dialog = new ProgressDialog(App.activity);
                    dialog.setMessage("loading");
                    dialog.show();
                    hands.sendEmptyMessageDelayed(666,2000);
                }else {
                    Toast.makeText(App.activity, "请填写完整信息", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.addnext_name:
                Bundle bund = new Bundle();
                bund.putBoolean("minebing",true);
                bund.putString("yao","药不能停");
                bund.putString("chi","吃了吐");
                bund.putString("know","不造");
                FragmentBuilder.getInstance().start(R.id.activity_home,FragmentBing.class).isBacked(true).setParams(bund);
                break;
            case R.id.addnext_location:
                Bundle bund2 = new Bundle();
                bund2.putBoolean("minebing",false);
                bund2.putString("yao","劳资不吃药");
                bund2.putString("chi","不想吃饭");
                bund2.putString("know","母鸡啊");
                FragmentBuilder.getInstance().start(R.id.activity_home,FragmentBing.class).isBacked(true).setParams(bund2);
                break;
            case R.id.addnext_person:
                break;
            case R.id.addNextLayout:
                break;
        }
    }
    private void onBack() {
        FragmentManager message = App.activity.getSupportFragmentManager();
        message.popBackStackImmediate();
        String lastname = message.getBackStackEntryAt(message.getBackStackEntryCount() - 1).getName();
        BaseFragment fragment = (BaseFragment) message.findFragmentByTag(lastname);
        FragmentBuilder.getInstance().setLastFragment(fragment);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        App.activity.unregisterReceiver(broads);
    }
}
