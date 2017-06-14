package xueya.jiyun.com.xueya.view.fragment.doctors.datapag;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
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
 * Created by my on 2017/6/13.
 */

public class Fragment_Web extends BaseFragment {
    @Bind(R.id.web_txt)
    TextView webTxt;
    @Bind(R.id.web_vi)
    WebView webVi;
    @Bind(R.id.web_parent)
    RelativeLayout webParent;
    String webId;
    String id;
    String cateid;
    Bundle bun;

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
        id = bun.getString("id");
        cateid = bun.getString("cateid");

        webTxt.setText(webId);
        //setWebView(addUrl(id,cateid));
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

    @OnClick(R.id.web_txt)
    public void onViewClicked() {
        onBack();
    }

    /*public void setWebView(String url){
        webVi.loadUrl(url);
        webVi.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                webVi.loadUrl(url);
                return true;
            }
        });
    }*/

   /* public static String addUrl(String id,String cateid){
        String remengurl = "http://api.wws.xywy.com/index.php?&tag=BloodAndroid&sign=2c19b2821ebc5306c3ac37bac5b4288b&act=zhuanjia&fun=ArticleDetails&id="+id+"&cateid="+cateid+"&source=cdsb";
        return remengurl;
    }*/

    private void onBack(){
        FragmentManager message = App.activity.getSupportFragmentManager();
        message.popBackStackImmediate();
        String lastname = message.getBackStackEntryAt(message.getBackStackEntryCount() - 1).getName();
        BaseFragment fragment = (BaseFragment) message.findFragmentByTag(lastname);
        FragmentBuilder.getInstance().setLastFragment(fragment);
    }
}
