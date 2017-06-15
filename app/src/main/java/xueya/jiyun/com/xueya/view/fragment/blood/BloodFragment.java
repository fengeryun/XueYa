package xueya.jiyun.com.xueya.view.fragment.blood;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import xueya.jiyun.com.xueya.App;
import xueya.jiyun.com.xueya.R;
import xueya.jiyun.com.xueya.adapter.ZongAdapter;
import xueya.jiyun.com.xueya.model.bean.Ha;
import xueya.jiyun.com.xueya.model.bean.Hei;
import xueya.jiyun.com.xueya.model.db.Takes;
import xueya.jiyun.com.xueya.model.sp.SpUtils;
import xueya.jiyun.com.xueya.presenter.bloods.BloodPersenter;
import xueya.jiyun.com.xueya.tools.FragmentBuilder;
import xueya.jiyun.com.xueya.tools.TimerUtils;
import xueya.jiyun.com.xueya.view.base.BaseFragment;
import xueya.jiyun.com.xueya.view.fragment.blood.information.InformFragment;
import xueya.jiyun.com.xueya.view.fragment.blood.tixing.RemindFragment;
import xueya.jiyun.com.xueya.view.fragment.mine.LogInFragment;
import xueya.jiyun.com.xueya.view.fragment.mine.MessageFragment;
import xueya.jiyun.com.xueya.view.viewinter.blooder.BloodView;

/**
 * Created by 123 on 2017/6/9.
 */

public class BloodFragment extends BaseFragment implements View.OnClickListener,BloodView {
    @Bind(R.id.radioButton2)
    RadioButton radioButton2;
    @Bind(R.id.radioButton)
    RadioButton radioButton;
    @Bind(R.id.radioButton4)
    RadioButton radioButton4;
    @Bind(R.id.radioButton3)
    RadioButton radioButton3;
    @Bind(R.id.xueya_fra)
    ViewPager xueyaFra;
    private TextView xueya_gaoya,xueya_diya,xueya_time;
    private RadioButton radioButton_zixun, radioButton_wenyisheng, radioButton_tixing;
    private RelativeLayout shang_img;
    private ArrayList<Fragment> list;
    private ZongAdapter adapter;
    private BloodPersenter bloodPersenter;
    private RelativeLayout relativeLayout;

    @Override
    public int getLayoutId() {
        return R.layout.bloodfragment;
    }

    @Override
    public void initView(View view) {
        EventBus.getDefault().register(BloodFragment.this);
        xueya_gaoya = (TextView) view.findViewById(R.id.xueya_gaoya);
        xueya_diya = (TextView) view.findViewById(R.id.xueya_diya);
        shang_img = (RelativeLayout) view.findViewById(R.id.shang_img);
        relativeLayout = (RelativeLayout) view.findViewById(R.id.blood_main);
        radioButton_zixun = (RadioButton) view.findViewById(R.id.radioButton_zixun);
        radioButton_wenyisheng = (RadioButton) view.findViewById(R.id.radioButton_wenyisheng);
        radioButton_tixing = (RadioButton) view.findViewById(R.id.radioButton_tixing);
        xueya_time = (TextView) view.findViewById(R.id.xueya_time);

    }

    @Override
    public void initData() {
        bloodPersenter = new BloodPersenter(this);
        list = new ArrayList<>();
        list.add(new DayFragment());
        list.add(new WeekFragment());
        list.add(new MoonFragment());
        list.add(new YearFragment());
        adapter = new ZongAdapter(getChildFragmentManager(), list);
        xueyaFra.setAdapter(adapter);
    }

    @Override
    public void loadData() {


        bloodPersenter.getText();
    }

    @Override
    public void initListener() {
        shang_img.setOnClickListener(this);
        radioButton_zixun.setOnClickListener(this);
        radioButton_wenyisheng.setOnClickListener(this);
        radioButton_tixing.setOnClickListener(this);
        xueyaFra.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 0:
                        radioButton2.setChecked(true);
                        break;
                    case 1:
                        radioButton.setChecked(true);
                        break;
                    case 2:
                        radioButton4.setChecked(true);
                        break;
                    case 3:
                        radioButton3.setChecked(true);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
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

    @OnClick({R.id.radioButton2, R.id.radioButton, R.id.radioButton4, R.id.radioButton3})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.radioButton2:
                xueyaFra.setCurrentItem(0);
                break;
            case R.id.radioButton:
                xueyaFra.setCurrentItem(1);
                break;
            case R.id.radioButton4:
                xueyaFra.setCurrentItem(2);
                break;
            case R.id.radioButton3:
                xueyaFra.setCurrentItem(3);
                break;
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.shang_img:
                FragmentBuilder.getInstance().start(R.id.activity_home, RecordFragment.class).isBacked(true);
                break;
            case R.id.radioButton_zixun:
                FragmentBuilder.getInstance().start(R.id.activity_home, InformFragment.class).isBacked(true);
                break;
            case R.id.radioButton_wenyisheng:
                if(SpUtils.getInstance("LogIn").getSp().getBoolean("isLogin",false)){
                    FragmentBuilder.getInstance().start(R.id.activity_home,MessageFragment.class).isBacked(true);
                }else {
                    Toast.makeText(App.activity, "请先登录", Toast.LENGTH_SHORT).show();
                    FragmentBuilder.getInstance().start(R.id.activity_home, LogInFragment.class).isBacked(true);
                }
                break;
            case R.id.radioButton_tixing:
                FragmentBuilder.getInstance().start(R.id.activity_home, RemindFragment.class).isBacked(true);
                break;

        }
    }



    @Override
    public void showText(List<Takes> list) {

        for (Takes takes:list){
            String time = TimerUtils.getTimerUtils().getTime(takes.getShowDate());
            xueya_time.setText(time);
            xueya_gaoya.setText(takes.getHeight());
            xueya_diya.setText(takes.getLow());
        }
    }
    @Subscribe(threadMode = ThreadMode.POSTING,sticky = true)
    public void Wocao(Hei hei){
        if (hei.getMessage()=="add"){

            bloodPersenter.getText();
        }
    }
    @Subscribe(threadMode = ThreadMode.POSTING,sticky = true)
    public void Woca(Ha hei){
        if (hei!=null){
            Toast.makeText(App.activity, "5555", Toast.LENGTH_SHORT).show();
            bloodPersenter.getText();
        }
    }
}
