package xueya.jiyun.com.xueya.view.fragment.doctors;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import xueya.jiyun.com.xueya.App;
import xueya.jiyun.com.xueya.R;
import xueya.jiyun.com.xueya.model.urls.ProvinceList;
import xueya.jiyun.com.xueya.tools.FragmentBuilder;
import xueya.jiyun.com.xueya.view.base.BaseFragment;

/**
 * Created by my on 2017/6/11.
 */

public class DoctorPopuView extends BaseFragment {
    @Bind(R.id.popu_buxian)
    TextView popuBuxian;
    @Bind(R.id.popu_zhuren)
    TextView popuZhuren;
    @Bind(R.id.popu_fuzhuren)
    TextView popuFuzhuren;
    @Bind(R.id.popu_lao)
    TextView popuLao;
    @Bind(R.id.popu_yishi)
    TextView popuYishi;
    @Bind(R.id.popu_yes)
    Button popuYes;
    @Bind(R.id.populayout)
    RelativeLayout populayout;
    Intent it;

    @Override
    public void initView(View view) {

    }

    @Override
    public int getLayoutId() {
        return R.layout.popu_job;
    }

    @Override
    public void initData() {
        it = new Intent();
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

    @OnClick({R.id.popu_buxian, R.id.popu_zhuren, R.id.popu_fuzhuren, R.id.popu_lao, R.id.popu_yishi, R.id.popu_yes, R.id.populayout})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.popu_buxian:
                it.putExtra("jobname",popuBuxian.getText().toString().trim());
                popuBuxian.setBackground(ContextCompat.getDrawable(App.activity,R.drawable.doctorjobbutt));
                popuZhuren.setBackground(ContextCompat.getDrawable(App.activity,R.drawable.doctorjobbut));
                popuFuzhuren.setBackground(ContextCompat.getDrawable(App.activity,R.drawable.doctorjobbut));
                popuLao.setBackground(ContextCompat.getDrawable(App.activity,R.drawable.doctorjobbut));
                popuYishi.setBackground(ContextCompat.getDrawable(App.activity,R.drawable.doctorjobbut));
                break;
            case R.id.popu_zhuren:
                it.putExtra("jobname",popuZhuren.getText().toString().trim());
                popuBuxian.setBackground(ContextCompat.getDrawable(App.activity,R.drawable.doctorjobbut));
                popuZhuren.setBackground(ContextCompat.getDrawable(App.activity,R.drawable.doctorjobbutt));
                popuFuzhuren.setBackground(ContextCompat.getDrawable(App.activity,R.drawable.doctorjobbut));
                popuLao.setBackground(ContextCompat.getDrawable(App.activity,R.drawable.doctorjobbut));
                popuYishi.setBackground(ContextCompat.getDrawable(App.activity,R.drawable.doctorjobbut));
                break;
            case R.id.popu_fuzhuren:
                it.putExtra("jobname",popuFuzhuren.getText().toString().trim());
                popuBuxian.setBackground(ContextCompat.getDrawable(App.activity,R.drawable.doctorjobbut));
                popuZhuren.setBackground(ContextCompat.getDrawable(App.activity,R.drawable.doctorjobbut));
                popuFuzhuren.setBackground(ContextCompat.getDrawable(App.activity,R.drawable.doctorjobbutt));
                popuLao.setBackground(ContextCompat.getDrawable(App.activity,R.drawable.doctorjobbut));
                popuYishi.setBackground(ContextCompat.getDrawable(App.activity,R.drawable.doctorjobbut));
                break;
            case R.id.popu_lao:
                it.putExtra("jobname",popuLao.getText().toString().trim());
                popuBuxian.setBackground(ContextCompat.getDrawable(App.activity,R.drawable.doctorjobbut));
                popuZhuren.setBackground(ContextCompat.getDrawable(App.activity,R.drawable.doctorjobbut));
                popuFuzhuren.setBackground(ContextCompat.getDrawable(App.activity,R.drawable.doctorjobbut));
                popuLao.setBackground(ContextCompat.getDrawable(App.activity,R.drawable.doctorjobbutt));
                popuYishi.setBackground(ContextCompat.getDrawable(App.activity,R.drawable.doctorjobbut));
                break;
            case R.id.popu_yishi:
                it.putExtra("jobname",popuYishi.getText().toString().trim());
                popuBuxian.setBackground(ContextCompat.getDrawable(App.activity,R.drawable.doctorjobbut));
                popuZhuren.setBackground(ContextCompat.getDrawable(App.activity,R.drawable.doctorjobbut));
                popuFuzhuren.setBackground(ContextCompat.getDrawable(App.activity,R.drawable.doctorjobbut));
                popuLao.setBackground(ContextCompat.getDrawable(App.activity,R.drawable.doctorjobbut));
                popuYishi.setBackground(ContextCompat.getDrawable(App.activity,R.drawable.doctorjobbutt));
                break;
            case R.id.popu_yes:
                it.setAction("provincename");
                App.activity.sendBroadcast(it);
                onBack();
                break;
            case R.id.populayout:
                break;
        }
    }

    private void onBack(){
        FragmentManager message = App.activity.getSupportFragmentManager();
        message.popBackStackImmediate();
        String lastname = message.getBackStackEntryAt(message.getBackStackEntryCount() - 1).getName();
        BaseFragment fragment = (BaseFragment) message.findFragmentByTag(lastname);
        FragmentBuilder.getInstance().setLastFragment(fragment);
    }

}
