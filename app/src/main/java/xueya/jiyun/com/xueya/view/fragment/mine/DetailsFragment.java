package xueya.jiyun.com.xueya.view.fragment.mine;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import xueya.jiyun.com.xueya.R;
import xueya.jiyun.com.xueya.view.base.BaseFragment;

/**
 * Created by 123 on 2017/6/13.
 */

public class DetailsFragment extends BaseFragment {
    Bundle bundle;
    TextView details_tv1,details_tv2,details_tv3,details_tv5,details_tv6,details_tv7;
    @Override
    public void initView(View view) {
        details_tv1= (TextView) view.findViewById(R.id.details_tv1);
        details_tv2= (TextView) view.findViewById(R.id.details_tv2);
        details_tv3= (TextView) view.findViewById(R.id.details_tv3);
        details_tv5= (TextView) view.findViewById(R.id.details_tv5);
        details_tv6= (TextView) view.findViewById(R.id.details_tv6);
        details_tv7= (TextView) view.findViewById(R.id.details_tv4);
    }

    @Override
    public int getLayoutId() {
        return R.layout.detailsfragment;
    }

    @Override
    public void initData() {
        details_tv2.setText("专家姓名:"+(String) bundle.get("expert"));
        details_tv3.setText("预约就诊时间:"+(String) bundle.get("todate"));
        details_tv7.setText("门诊类型:"+(String) bundle.get("depart"));
        details_tv1.setText((String) bundle.get("hopital"));
        details_tv6.setText("就诊地址:"+(String) bundle.get("hopital")+"东大直街199号");
    }

    @Override
    public void loadData() {

    }

    @Override
    public void initListener() {

    }

    @Override
    public void setParams(Bundle b) {
        super.setParams(b);
        bundle=b;
    }
}
