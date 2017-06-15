package xueya.jiyun.com.xueya.view.fragment.doctors.datapag;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import xueya.jiyun.com.xueya.App;
import xueya.jiyun.com.xueya.R;
import xueya.jiyun.com.xueya.tools.FragmentBuilder;
import xueya.jiyun.com.xueya.view.base.BaseFragment;

/**
 * Created by my on 2017/6/15.
 */

public class FragmentBing extends BaseFragment {
    @Bind(R.id.bing_backs)
    ImageView bingBacks;
    @Bind(R.id.bing_txt1)
    TextView bingTxt1;
    @Bind(R.id.bing_txt2)
    TextView bingTxt2;
    @Bind(R.id.bing_txt3)
    TextView bingTxt3;
    @Bind(R.id.bing_txt4)
    TextView bingTxt4;
    @Bind(R.id.bing_txt5)
    TextView bingTxt5;
    @Bind(R.id.bing_txt6)
    TextView bingTxt6;
    @Bind(R.id.bing_txt7)
    TextView bingTxt7;
    @Bind(R.id.bing_txt8)
    TextView bingTxt8;
    @Bind(R.id.bing_layout)
    LinearLayout bingLayout;
    Boolean flag =false;

    @Override
    public void initView(View view) {

    }

    @Override
    public int getLayoutId() {
        return R.layout.bing;
    }

    @Override
    public void initData() {
        Bundle bun = getParams();
        flag = bun.getBoolean("minebing");
        bingTxt8.setText(bun.getString("yao"));
        bingTxt5.setText(bun.getString("chi"));
        bingTxt6.setText(bun.getString("know"));
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

    @OnClick({R.id.bing_backs, R.id.bing_txt1, R.id.bing_txt2, R.id.bing_txt3, R.id.bing_txt4, R.id.bing_txt5, R.id.bing_txt6, R.id.bing_txt7, R.id.bing_txt8, R.id.bing_layout})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bing_backs:
                onBack();
                break;
            case R.id.bing_txt1:
                getBroad(bingTxt1.getText().toString().trim());
                break;
            case R.id.bing_txt2:
                getBroad(bingTxt2.getText().toString().trim());
                break;
            case R.id.bing_txt3:
                getBroad(bingTxt3.getText().toString().trim());
                break;
            case R.id.bing_txt4:
                getBroad(bingTxt4.getText().toString().trim());
                break;
            case R.id.bing_txt5:
                getBroad(bingTxt5.getText().toString().trim());
                break;
            case R.id.bing_txt6:
                getBroad(bingTxt6.getText().toString().trim());
                break;
            case R.id.bing_txt7:
                getBroad(bingTxt7.getText().toString().trim());
                break;
            case R.id.bing_txt8:
                getBroad(bingTxt8.getText().toString().trim());
                break;
            case R.id.bing_layout:
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

    private void getBroad(String str){
        Intent it = new Intent();
        it.setAction("jibing");
        if(flag){
            it.putExtra("bingOne",str);
        }else {
            it.putExtra("bingTwo",str);
        }
        App.activity.sendBroadcast(it);
        onBack();
    }

}
