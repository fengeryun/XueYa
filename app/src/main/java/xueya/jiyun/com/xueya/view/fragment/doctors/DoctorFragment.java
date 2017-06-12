package xueya.jiyun.com.xueya.view.fragment.doctors;

import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RadioButton;
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
 * Created by Asus on 2017/6/9.
 */

public class DoctorFragment extends BaseFragment {
    @Bind(R.id.province)
    TextView province;
    @Bind(R.id.mylocation)
    ImageView mylocation;
    @Bind(R.id.doctorJob)
    TextView doctorJob;
    @Bind(R.id.hospitalGrade)
    TextView hospitalGrade;
    @Bind(R.id.sousuo)
    TextView sousuo;
    @Bind(R.id.freeAdd)
    CheckBox freeAdd;
    @Bind(R.id.queryName)
    Button queryName;
    @Bind(R.id.askDoctor)
    RadioButton askDoctor;
    @Bind(R.id.healthPeople)
    RadioButton healthPeople;
    @Bind(R.id.huan)
    TextView huan;
    ProgressDialog dialoger;
    BroadcastReceiver broad = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, final Intent intent) {
            if(intent.getStringExtra("proname")!=null){
                province.setText(intent.getStringExtra("proname"));
            }else if(intent.getStringExtra("jobname")!=null){
                doctorJob.setText(intent.getStringExtra("jobname")+"  ");
            }else if(intent.getStringExtra("hospitalname")!=null){
                hospitalGrade.setText(intent.getStringExtra("hospitalname")+"  ");
            }else if(intent.getStringExtra("sousuoname")!=null){
                sousuo.setText(intent.getStringExtra("sousuoname"));
            }
        }
    };
    Handler hand = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 555:
                    ThreadUtils.runOnMain(new Runnable() {
                        @Override
                        public void run() {
                            dialoger.dismiss();
                            province.setText("北京市");
                            Toast.makeText(App.activity, "定位成功", Toast.LENGTH_SHORT).show();
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
        return R.layout.doctorfragment;
    }

    @Override
    public void initData() {
        IntentFilter filter = new IntentFilter();
        filter.addAction("provincename");
        App.activity.registerReceiver(broad,filter);
    }

    @Override
    public void loadData() {

    }

    @Override
    public void onResume() {
        super.onResume();
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

    @OnClick({R.id.province, R.id.mylocation, R.id.doctorJob, R.id.hospitalGrade, R.id.sousuo, R.id.queryName, R.id.askDoctor, R.id.healthPeople, R.id.huan})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.province:
                FragmentBuilder.getInstance().start(R.id.activity_home,ProvinceFragment.class).isBacked(true);
                break;
            case R.id.mylocation:
                getLocation();
                break;
            case R.id.doctorJob:
                FragmentBuilder.getInstance().start(R.id.activity_home,DoctorPopuView.class).isBacked(true);
                break;
            case R.id.hospitalGrade:
                FragmentBuilder.getInstance().start(R.id.activity_home,DoctorPopuHospital.class).isBacked(true);
                break;
            case R.id.sousuo:
                FragmentBuilder.getInstance().start(R.id.activity_home,DoctorSousuo.class).isBacked(true);
                break;
            case R.id.queryName:
                break;
            case R.id.askDoctor:
                break;
            case R.id.healthPeople:
                sendPhone();
                break;
            case R.id.huan:
                break;
        }
    }

    private void getLocation(){
        AlertDialog.Builder builder2 = new AlertDialog.Builder(App.activity);
        builder2.setTitle("温馨提示").setMessage("您是否允许血压卫士使用定位功能").setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialoger = new ProgressDialog(App.activity);
                dialoger.setMessage("正在定位");
                dialoger.show();
                hand.sendEmptyMessageDelayed(555,1000);
            }
        }).setNegativeButton("取消", null);
        builder2.show();
    }

    private void sendPhone(){
        AlertDialog.Builder build = new AlertDialog.Builder(App.activity);
        final String phonenumer = "400-9700-120";
        build.setTitle("温馨提示").setMessage("您是否要拨打寻医问药的健康电话:  "+phonenumer).setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + phonenumer));
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        }).setNegativeButton("取消", null);
        build.show();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        App.activity.unregisterReceiver(broad);
    }
}
