package xueya.jiyun.com.xueya.view.fragment.blood.information;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

import xueya.jiyun.com.xueya.App;
import xueya.jiyun.com.xueya.R;
import xueya.jiyun.com.xueya.model.bean.Eaasys;
import xueya.jiyun.com.xueya.presenter.bloods.EaasyPresenter;
import xueya.jiyun.com.xueya.presenter.bloods.EssayPersenter;
import xueya.jiyun.com.xueya.tools.FragmentBuilder;
import xueya.jiyun.com.xueya.view.base.BaseFragment;
import xueya.jiyun.com.xueya.view.viewinter.Dialogs;
import xueya.jiyun.com.xueya.view.viewinter.blooder.EaasyView;
import xueya.jiyun.com.xueya.view.viewinter.blooder.EssayView;

/**
 * Created by Asus on 2017/6/12.
 */

public class EaasyFragment extends BaseFragment implements EaasyView,EssayView, View.OnClickListener {
    private TextView eaasy_title,eaasy_pubdate,eaasy_body;
    EaasyPresenter eaasyPresenter;
    private LinearLayout eass_linear;
    private String id;
    private String type;
    private CheckBox essay_check;
    private EssayPersenter essayPersenter;
    private String typeid;
    private ImageView eaasy_back;

    @Override
    public void initView(View view) {
        Dialogs.Show2Dialog();
        eaasy_title = (TextView) view.findViewById(R.id.eaasy_title);
        eaasy_pubdate = (TextView) view.findViewById(R.id.eaasy_pubdate);
        eaasy_body = (TextView) view.findViewById(R.id.eaasy_body);
        eass_linear = (LinearLayout) view.findViewById(R.id.eass_linear);
        essay_check = (CheckBox) view.findViewById(R.id.essay_check);
        eaasy_back = (ImageView) view.findViewById(R.id.eaasy_back);
    }
    @Override
    public int getLayoutId() {
        return R.layout.blood_essay;
    }
    @Override
    public void initData() {
        eaasyPresenter = new EaasyPresenter(this,type,id,this);
        essayPersenter = new EssayPersenter(this);
    }
    @Override
    public void loadData() {
        eaasyPresenter.click();
    }
    @Override
    public void initListener() {

        eass_linear.setOnClickListener(this);
        eaasy_back.setOnClickListener(this);
    }

    @Override
    public void setParams(Bundle bundle) {
        super.setParams(bundle);
        id = bundle.getString("id");
        type = bundle.getString("type");
        typeid = bundle.getString("typeid");

    }

    @Override
    public void EaasyData(Eaasys eaasys) {
        eaasy_title.setText(eaasys.getData().getTitle());
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd   HH:mm:ss");
        long time = Long.parseLong(eaasys.getData().getPubdate());
        String fa = dateFormat.format(new Date(time*1000));
        eaasy_pubdate.setText(fa);
        //转换为文本模式
        eaasy_body.setText(Html.fromHtml(eaasys.getData().getBody()));




    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.eass_linear:
                break;
            case R.id.eaasy_back:
                FragmentManager message = App.activity.getSupportFragmentManager();
                message.popBackStackImmediate();
                String lastname = message.getBackStackEntryAt(message.getBackStackEntryCount()-1).getName();
                BaseFragment fragment = (BaseFragment) message.findFragmentByTag(lastname);
                FragmentBuilder.getInstance().setLastFragment(fragment);
                break;
        }
    }

    @Override
    public void getStatus(final Eaasys eaasys) {
        final String meta=type+","+typeid;
        Log.e("AAA","===="+meta);
        essay_check.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked==false){
                    essayPersenter.getAsk(eaasys.getData().getTitle(),eaasys.getData().getId(),meta);
                    Toast.makeText(App.activity, "收藏成功", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(App.activity, "取消收藏", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
