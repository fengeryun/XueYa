package xueya.jiyun.com.xueya.view.activity;

import android.os.Bundle;
import android.os.Process;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import xueya.jiyun.com.xueya.App;
import xueya.jiyun.com.xueya.R;
import xueya.jiyun.com.xueya.adapter.ZongAdapter;
import xueya.jiyun.com.xueya.tools.FragmentBuilder;
import xueya.jiyun.com.xueya.view.base.BaseFragment;
import xueya.jiyun.com.xueya.view.fragment.mine.CoreFragment;
import xueya.jiyun.com.xueya.view.fragment.blood.BloodFragment;
import xueya.jiyun.com.xueya.view.fragment.doctors.DoctorFragment;

public class HomeActivity extends AppCompatActivity {


    @Bind(R.id.doctor)
    RadioButton doctor;
    @Bind(R.id.blood)
    RadioButton blood;
    @Bind(R.id.core)
    RadioButton core;
    @Bind(R.id.viewpage)
    ViewPager viewpage;
    long firsttime;
    private ArrayList<Fragment> list;
    private ZongAdapter adapter;
    int num = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
        App.activity = this;

        list = new ArrayList<>();
        list.add(new DoctorFragment());
        list.add(new BloodFragment());
        list.add(new CoreFragment());
        adapter = new ZongAdapter(getSupportFragmentManager(), list);
        viewpage.setAdapter(adapter);
        FragmentBuilder.getInstance().start(R.id.viewpage, DoctorFragment.class).isBacked(true);

        setPageChange();


    }

    private void setPageChange() {
        viewpage.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }
            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 0:
                        //viewpage.setCurrentItem(0);
//                        FragmentBuilder.getInstance().start(R.id.viewpage, DoctorFragment.class).isBacked(true);
                        doctor.setChecked(true);
                        break;
                    case 1:
//                        FragmentBuilder.getInstance().start(R.id.viewpage, DoctorFragment.class).isBacked(true);
                        blood.setChecked(true);
                        break;
                    case 2:
//                        FragmentBuilder.getInstance().start(R.id.viewpage, DoctorFragment.class).isBacked(true);
                        core.setChecked(true);
                        break;
                }
            }
            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
    }

    @OnClick({R.id.doctor, R.id.blood, R.id.core})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.doctor:
                viewpage.setCurrentItem(0);
                break;
            case R.id.blood:
                viewpage.setCurrentItem(1);
                break;
            case R.id.core:
                viewpage.setCurrentItem(2);
                break;
        }
    }

    @Override
    public void onBackPressed() {

        FragmentManager message = getSupportFragmentManager();
        String lastback  = message.getBackStackEntryAt(message.getBackStackEntryCount()-1).getName();
        Log.e("--------------lastback",lastback);
        if(lastback.equals("DoctorFragment") || lastback.equals("BloodFragment") || lastback.equals("CoreFragment")){

                if(num<2){
                    firsttime = System.currentTimeMillis();

                    Toast.makeText(this, "再次点击退出血压卫士", Toast.LENGTH_SHORT).show();
                    num++;
                }else {
                    if(System.currentTimeMillis()-firsttime>2000){
                        firsttime = System.currentTimeMillis();

                        Toast.makeText(this, "再次点击退出血压卫士", Toast.LENGTH_SHORT).show();
                    }else {
                        Process.killProcess(Process.myPid());
                        System.exit(0);
                    }
                }

        }else {
            message.popBackStackImmediate();   //立即弹栈
            String lastname = message.getBackStackEntryAt(message.getBackStackEntryCount()-1).getName();
            Log.e("--------------lastname",lastname);
            BaseFragment fragment = (BaseFragment) message.findFragmentByTag(lastname);
            FragmentBuilder.getInstance().setLastFragment(fragment);
        }

    }

}
