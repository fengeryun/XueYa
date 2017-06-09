package xueya.jiyun.com.xueya.view.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;

import xueya.jiyun.com.xueya.App;
import xueya.jiyun.com.xueya.R;
import xueya.jiyun.com.xueya.adapter.ZongAdapter;
import xueya.jiyun.com.xueya.view.fragment.BloodFragment;
import xueya.jiyun.com.xueya.view.fragment.CoreFragment;
import xueya.jiyun.com.xueya.view.fragment.DoctorFragment;

public class HomeActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private ArrayList<Fragment> list;
    private ZongAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        App.activity = this;

        viewPager = (ViewPager) findViewById(R.id.viewpage);
        list = new ArrayList<>();
        list.add(new DoctorFragment());
        list.add(new BloodFragment());
        list.add(new CoreFragment());
        adapter = new ZongAdapter(getSupportFragmentManager(),list);
        viewPager.setAdapter(adapter);

    }
}
