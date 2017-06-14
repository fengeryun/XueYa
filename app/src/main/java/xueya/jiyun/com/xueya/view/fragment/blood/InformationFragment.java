package xueya.jiyun.com.xueya.view.fragment.blood;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import xueya.jiyun.com.xueya.App;
import xueya.jiyun.com.xueya.R;
import xueya.jiyun.com.xueya.model.db.Takes;
import xueya.jiyun.com.xueya.presenter.bloods.InforPersenter;
import xueya.jiyun.com.xueya.tools.FragmentBuilder;
import xueya.jiyun.com.xueya.view.base.BaseFragment;
import xueya.jiyun.com.xueya.view.viewinter.blooder.InforView;

/**
 * Created by Asus on 2017/6/10.
 */

public class InformationFragment extends BaseFragment implements InforView, View.OnClickListener {
    @Bind(R.id.reco_back)
    ImageView recoBack;
    @Bind(R.id.record_titlle)
    TextView recordTitlle;
    @Bind(R.id.information_data)
    ImageView informationData;
     private InforPersenter inforPersenter;
    private TextView infor_date;
    private LinearLayout infor_linear;
    @Override
    public void initView(View view) {
        infor_date = (TextView) view.findViewById(R.id.infor_date);
        infor_linear = (LinearLayout) view.findViewById(R.id.infor_linear);
    }

    @Override
    public int getLayoutId() {
        return R.layout.information;
    }

    @Override
    public void initData() {
        inforPersenter = new InforPersenter(this);
    }

    @Override
    public void loadData() {
        inforPersenter.getTextDate();
    }

    @Override
    public void initListener() {
        infor_linear.setOnClickListener(this);
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

    @OnClick(R.id.reco_back)
    public void onViewClicked() {
        FragmentManager message = App.activity.getSupportFragmentManager();
        message.popBackStackImmediate();
        String lastname = message.getBackStackEntryAt(message.getBackStackEntryCount()-1).getName();
        BaseFragment fragment = (BaseFragment) message.findFragmentByTag(lastname);
        FragmentBuilder.getInstance().setLastFragment(fragment);
    }

    @Override
    public void getDate(List<Takes> list) {
        for (Takes takes:list){
            infor_date.setText(takes.getShowDate());
        }
    }

    @Override
    public void onClick(View v) {

    }
}
