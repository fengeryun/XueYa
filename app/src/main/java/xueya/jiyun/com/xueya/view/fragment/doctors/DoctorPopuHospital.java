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
import xueya.jiyun.com.xueya.tools.FragmentBuilder;
import xueya.jiyun.com.xueya.view.base.BaseFragment;

/**
 * Created by my on 2017/6/12.
 */

public class DoctorPopuHospital extends BaseFragment {
    @Bind(R.id.hospital_buxian)
    TextView hospitalBuxian;
    @Bind(R.id.three_jia)
    TextView threeJia;
    @Bind(R.id.three_yi)
    TextView threeYi;
    @Bind(R.id.three_bin)
    TextView threeBin;
    @Bind(R.id.three)
    TextView three;
    @Bind(R.id.two_jia)
    TextView twoJia;
    @Bind(R.id.two_yi)
    TextView twoYi;
    @Bind(R.id.two_bin)
    TextView twoBin;
    @Bind(R.id.hospital_yes)
    Button hospitalYes;
    @Bind(R.id.popugroup)
    RelativeLayout popugroup;
    Intent it;

    @Override
    public void initView(View view) {

    }

    @Override
    public int getLayoutId() {
        return R.layout.popu_hospital;
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

    @OnClick({R.id.hospital_buxian, R.id.three_jia, R.id.three_yi, R.id.three_bin, R.id.three, R.id.two_jia, R.id.two_yi, R.id.two_bin, R.id.hospital_yes, R.id.popugroup})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.hospital_buxian:
                it.putExtra("hospitalname",hospitalBuxian.getText().toString().trim());
                hospitalBuxian.setBackground(ContextCompat.getDrawable(App.activity,R.drawable.doctorjobbutt));
                threeJia.setBackground(ContextCompat.getDrawable(App.activity,R.drawable.doctorjobbut));
                threeYi.setBackground(ContextCompat.getDrawable(App.activity,R.drawable.doctorjobbut));
                threeBin.setBackground(ContextCompat.getDrawable(App.activity,R.drawable.doctorjobbut));
                three.setBackground(ContextCompat.getDrawable(App.activity,R.drawable.doctorjobbut));
                twoJia.setBackground(ContextCompat.getDrawable(App.activity,R.drawable.doctorjobbut));
                twoYi.setBackground(ContextCompat.getDrawable(App.activity,R.drawable.doctorjobbut));
                twoBin.setBackground(ContextCompat.getDrawable(App.activity,R.drawable.doctorjobbut));
                break;
            case R.id.three_jia:
                it.putExtra("hospitalname",threeJia.getText().toString().trim());
                hospitalBuxian.setBackground(ContextCompat.getDrawable(App.activity,R.drawable.doctorjobbut));
                threeJia.setBackground(ContextCompat.getDrawable(App.activity,R.drawable.doctorjobbutt));
                threeYi.setBackground(ContextCompat.getDrawable(App.activity,R.drawable.doctorjobbut));
                threeBin.setBackground(ContextCompat.getDrawable(App.activity,R.drawable.doctorjobbut));
                three.setBackground(ContextCompat.getDrawable(App.activity,R.drawable.doctorjobbut));
                twoJia.setBackground(ContextCompat.getDrawable(App.activity,R.drawable.doctorjobbut));
                twoYi.setBackground(ContextCompat.getDrawable(App.activity,R.drawable.doctorjobbut));
                twoBin.setBackground(ContextCompat.getDrawable(App.activity,R.drawable.doctorjobbut));
                break;
            case R.id.three_yi:
                it.putExtra("hospitalname",threeYi.getText().toString().trim());
                hospitalBuxian.setBackground(ContextCompat.getDrawable(App.activity,R.drawable.doctorjobbut));
                threeJia.setBackground(ContextCompat.getDrawable(App.activity,R.drawable.doctorjobbut));
                threeYi.setBackground(ContextCompat.getDrawable(App.activity,R.drawable.doctorjobbutt));
                threeBin.setBackground(ContextCompat.getDrawable(App.activity,R.drawable.doctorjobbut));
                three.setBackground(ContextCompat.getDrawable(App.activity,R.drawable.doctorjobbut));
                twoJia.setBackground(ContextCompat.getDrawable(App.activity,R.drawable.doctorjobbut));
                twoYi.setBackground(ContextCompat.getDrawable(App.activity,R.drawable.doctorjobbut));
                twoBin.setBackground(ContextCompat.getDrawable(App.activity,R.drawable.doctorjobbut));
                break;
            case R.id.three_bin:
                it.putExtra("hospitalname",threeBin.getText().toString().trim());
                hospitalBuxian.setBackground(ContextCompat.getDrawable(App.activity,R.drawable.doctorjobbut));
                threeJia.setBackground(ContextCompat.getDrawable(App.activity,R.drawable.doctorjobbut));
                threeYi.setBackground(ContextCompat.getDrawable(App.activity,R.drawable.doctorjobbut));
                threeBin.setBackground(ContextCompat.getDrawable(App.activity,R.drawable.doctorjobbutt));
                three.setBackground(ContextCompat.getDrawable(App.activity,R.drawable.doctorjobbut));
                twoJia.setBackground(ContextCompat.getDrawable(App.activity,R.drawable.doctorjobbut));
                twoYi.setBackground(ContextCompat.getDrawable(App.activity,R.drawable.doctorjobbut));
                twoBin.setBackground(ContextCompat.getDrawable(App.activity,R.drawable.doctorjobbut));
                break;
            case R.id.three:
                it.putExtra("hospitalname",three.getText().toString().trim());
                hospitalBuxian.setBackground(ContextCompat.getDrawable(App.activity,R.drawable.doctorjobbut));
                threeJia.setBackground(ContextCompat.getDrawable(App.activity,R.drawable.doctorjobbut));
                threeYi.setBackground(ContextCompat.getDrawable(App.activity,R.drawable.doctorjobbut));
                threeBin.setBackground(ContextCompat.getDrawable(App.activity,R.drawable.doctorjobbut));
                three.setBackground(ContextCompat.getDrawable(App.activity,R.drawable.doctorjobbutt));
                twoJia.setBackground(ContextCompat.getDrawable(App.activity,R.drawable.doctorjobbut));
                twoYi.setBackground(ContextCompat.getDrawable(App.activity,R.drawable.doctorjobbut));
                twoBin.setBackground(ContextCompat.getDrawable(App.activity,R.drawable.doctorjobbut));
                break;
            case R.id.two_jia:
                it.putExtra("hospitalname",twoJia.getText().toString().trim());
                hospitalBuxian.setBackground(ContextCompat.getDrawable(App.activity,R.drawable.doctorjobbut));
                threeJia.setBackground(ContextCompat.getDrawable(App.activity,R.drawable.doctorjobbut));
                threeYi.setBackground(ContextCompat.getDrawable(App.activity,R.drawable.doctorjobbut));
                threeBin.setBackground(ContextCompat.getDrawable(App.activity,R.drawable.doctorjobbut));
                three.setBackground(ContextCompat.getDrawable(App.activity,R.drawable.doctorjobbut));
                twoJia.setBackground(ContextCompat.getDrawable(App.activity,R.drawable.doctorjobbutt));
                twoYi.setBackground(ContextCompat.getDrawable(App.activity,R.drawable.doctorjobbut));
                twoBin.setBackground(ContextCompat.getDrawable(App.activity,R.drawable.doctorjobbut));
                break;
            case R.id.two_yi:
                it.putExtra("hospitalname",twoYi.getText().toString().trim());
                hospitalBuxian.setBackground(ContextCompat.getDrawable(App.activity,R.drawable.doctorjobbut));
                threeJia.setBackground(ContextCompat.getDrawable(App.activity,R.drawable.doctorjobbut));
                threeYi.setBackground(ContextCompat.getDrawable(App.activity,R.drawable.doctorjobbut));
                threeBin.setBackground(ContextCompat.getDrawable(App.activity,R.drawable.doctorjobbut));
                three.setBackground(ContextCompat.getDrawable(App.activity,R.drawable.doctorjobbut));
                twoJia.setBackground(ContextCompat.getDrawable(App.activity,R.drawable.doctorjobbut));
                twoYi.setBackground(ContextCompat.getDrawable(App.activity,R.drawable.doctorjobbutt));
                twoBin.setBackground(ContextCompat.getDrawable(App.activity,R.drawable.doctorjobbut));
                break;
            case R.id.two_bin:
                it.putExtra("hospitalname",twoBin.getText().toString().trim());
                hospitalBuxian.setBackground(ContextCompat.getDrawable(App.activity,R.drawable.doctorjobbut));
                threeJia.setBackground(ContextCompat.getDrawable(App.activity,R.drawable.doctorjobbut));
                threeYi.setBackground(ContextCompat.getDrawable(App.activity,R.drawable.doctorjobbut));
                threeBin.setBackground(ContextCompat.getDrawable(App.activity,R.drawable.doctorjobbut));
                three.setBackground(ContextCompat.getDrawable(App.activity,R.drawable.doctorjobbut));
                twoJia.setBackground(ContextCompat.getDrawable(App.activity,R.drawable.doctorjobbut));
                twoYi.setBackground(ContextCompat.getDrawable(App.activity,R.drawable.doctorjobbut));
                twoBin.setBackground(ContextCompat.getDrawable(App.activity,R.drawable.doctorjobbutt));
                break;
            case R.id.hospital_yes:
                it.setAction("provincename");
                App.activity.sendBroadcast(it);
                onBack();
                break;
            case R.id.popugroup:
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
