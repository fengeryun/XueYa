package xueya.jiyun.com.xueya.view.fragment.mine;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import xueya.jiyun.com.xueya.App;
import xueya.jiyun.com.xueya.R;
import xueya.jiyun.com.xueya.view.base.BaseFragment;

/**
 * Created by 123 on 2017/6/12.
 */

public class AboutFragment extends BaseFragment implements View.OnClickListener {
    RelativeLayout about_go,set_opinion;
    LinearLayout about_linear;
    @Override
    public void initView(View view) {
        about_go= (RelativeLayout) view.findViewById(R.id.about_go);
        set_opinion= (RelativeLayout) view.findViewById(R.id.set_opinion);
        about_linear= (LinearLayout) view.findViewById(R.id.about_linear);
    }

    @Override
    public int getLayoutId() {
        return R.layout.about_xueya;
    }

    @Override
    public void initData() {

    }

    @Override
    public void loadData() {

    }

    @Override
    public void initListener() {
        about_go.setOnClickListener(this);
        set_opinion.setOnClickListener(this);
        about_linear.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.about_go:
                Uri uri = Uri.parse("market://details?id=" + App.activity.getPackageName());
                Intent goToMarket = new Intent(Intent.ACTION_VIEW, uri);
                try {
                    startActivity(goToMarket);
                } catch (ActivityNotFoundException e) {
                    Toast.makeText(App.activity, "Couldn't launch the market !", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.set_opinion:
                Intent in=new Intent(App.activity,OpinionActivity.class);
                App.activity.startActivity(in);
                break;
            case R.id.about_linear:
                Toast.makeText(App.activity, "跳Activity", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
