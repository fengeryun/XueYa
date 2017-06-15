package xueya.jiyun.com.xueya.view.fragment.doctors.datapag;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import xueya.jiyun.com.xueya.App;
import xueya.jiyun.com.xueya.R;
import xueya.jiyun.com.xueya.adapter.TimesAdapter;
import xueya.jiyun.com.xueya.model.bean.FreeAddBean;
import xueya.jiyun.com.xueya.model.bean.ZhuanJiaBean;
import xueya.jiyun.com.xueya.presenter.doctor.FreeAddPresenter;
import xueya.jiyun.com.xueya.tools.FragmentBuilder;
import xueya.jiyun.com.xueya.tools.ThreadUtils;
import xueya.jiyun.com.xueya.view.base.BaseFragment;
import xueya.jiyun.com.xueya.view.viewinter.doc.FreeAddView;

/**
 * Created by my on 2017/6/14.
 */

public class Fragment_yuyue extends BaseFragment implements FreeAddView {
    @Bind(R.id.yuyue_backs)
    ImageView yuyueBacks;
    @Bind(R.id.yuyue_pic)
    ImageView yuyuePic;
    @Bind(R.id.yuyue_name)
    TextView yuyueName;
    @Bind(R.id.yuyue_yiyuan)
    TextView yuyueYiyuan;
    @Bind(R.id.yuyue_zhiwei)
    TextView yuyueZhiwei;
    @Bind(R.id.yuyue_jineng)
    TextView yuyueJineng;
    @Bind(R.id.yuyue_xueli)
    TextView yuyueXueli;
    @Bind(R.id.yuyue_content)
    TextView yuyueContent;
    @Bind(R.id.yuyue_layout)
    LinearLayout yuyueLayout;
    @Bind(R.id.yuyue_listview)
    ListView yuyueListview;
    ProgressDialog dialog;
    Bundle bun;
    FreeAddPresenter presenter;
    TimesAdapter adapter;


    @Override
    public void initView(View view) {

    }

    @Override
    public int getLayoutId() {
        return R.layout.yuyue;
    }

    @Override
    public void initData() {
        bun = getParams();
        ZhuanJiaBean.DataBean bean = bun.getParcelable("databean");
        Glide.with(App.activity).load(bean.getApp_image()).into(yuyuePic);
        yuyueName.setText(bean.getName());
        yuyueYiyuan.setText(bean.getHospital());
        yuyueZhiwei.setText(bean.getTitle());
        yuyueJineng.setText(bean.getDepart());
        yuyueXueli.setText(bean.getTeach());
        yuyueContent.setText(bean.getGoodat());

        dialog = new ProgressDialog(App.activity);
        dialog.setMessage("loading");
        dialog.show();

        presenter = new FreeAddPresenter(this);
        presenter.getFreeAddDatas(bean.getDocument_id(), bean.getExpert_id());
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


    @OnClick({R.id.yuyue_backs, R.id.yuyue_layout})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.yuyue_backs:
                onBack();
                break;
            case R.id.yuyue_layout:
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

    @Override
    public void showToest(final String cont) {
        ThreadUtils.runOnMain(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(App.activity, cont, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void loadGrid(FreeAddBean.DataBean.ScheduleBean bean) {
        dialog.dismiss();
        List<FreeAddBean.DataBean.ScheduleBean.RdtimeBean> list = bean.getRdtime();
        adapter = new TimesAdapter(list);
        yuyueListview.setAdapter(adapter);
        yuyueListview.setDividerHeight(0);
    }
}
