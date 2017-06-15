package xueya.jiyun.com.xueya.view.fragment.doctors.datapag;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import xueya.jiyun.com.xueya.App;
import xueya.jiyun.com.xueya.R;
import xueya.jiyun.com.xueya.model.bean.WebDataBean;
import xueya.jiyun.com.xueya.presenter.doctor.WebDataPresenter;
import xueya.jiyun.com.xueya.tools.FragmentBuilder;
import xueya.jiyun.com.xueya.tools.ThreadUtils;
import xueya.jiyun.com.xueya.view.base.BaseFragment;
import xueya.jiyun.com.xueya.view.viewinter.doc.WebDataView;

/**
 * Created by my on 2017/6/13.
 */

public class Fragment_Web extends BaseFragment implements WebDataView {

    @Bind(R.id.web_txt)
    TextView webTxt;
    @Bind(R.id.web_layout)
    RelativeLayout webLayout;
    @Bind(R.id.web_title)
    TextView webTitle;
    @Bind(R.id.web_pubdate)
    TextView webPubdate;
    @Bind(R.id.web_body)
    TextView webBody;
    @Bind(R.id.web_parent)
    LinearLayout webParent;
    String webId;
    String id;
    String cateid;
    Bundle bun;
    WebDataPresenter presenter;

    @Override
    public void initView(View view) {

    }

    @Override
    public int getLayoutId() {
        return R.layout.frag_web;
    }

    @Override
    public void initData() {
        bun = getParams();
        webId = bun.getString("title");
        webTxt.setText(webId);
        if(webId.equals("文章详情")){
            id = bun.getString("id");
            cateid = bun.getString("cateid");

            presenter = new WebDataPresenter(this);
            presenter.getWebDatas(id, cateid);
        }

    }

    @Override
    public void loadData() {

    }

    @Override
    public void initListener() {

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
    public void loadGrid(WebDataBean.DataBean bean) {
        webTitle.setText(bean.getTitle());
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd   HH:mm:ss");
        long time = Long.parseLong(bean.getAddtime());
        String fa = dateFormat.format(new Date(time * 1000));
        webPubdate.setText(fa);
        webBody.setText(Html.fromHtml(bean.getContents()));
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

    @OnClick(R.id.web_txt)
    public void onViewClicked() {
        onBack();
    }
}
