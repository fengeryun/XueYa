package xueya.jiyun.com.xueya.view.fragment.blood.information;

import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

import xueya.jiyun.com.xueya.R;
import xueya.jiyun.com.xueya.model.bean.Eaasys;
import xueya.jiyun.com.xueya.presenter.bloods.EaasyPresenter;
import xueya.jiyun.com.xueya.view.base.BaseFragment;
import xueya.jiyun.com.xueya.view.viewinter.Dialogs;
import xueya.jiyun.com.xueya.view.viewinter.blooder.EaasyView;

/**
 * Created by Asus on 2017/6/12.
 */

public class EaasyFragment extends BaseFragment implements EaasyView, View.OnClickListener {
    private TextView eaasy_title,eaasy_pubdate,eaasy_body;
    EaasyPresenter eaasyPresenter;
    private LinearLayout eass_linear;
    private String id;
    private String type;
    private CheckBox essay_check;

    @Override
    public void initView(View view) {
        Dialogs.Show2Dialog();
        eaasy_title = (TextView) view.findViewById(R.id.eaasy_title);
        eaasy_pubdate = (TextView) view.findViewById(R.id.eaasy_pubdate);
        eaasy_body = (TextView) view.findViewById(R.id.eaasy_body);
        eass_linear = (LinearLayout) view.findViewById(R.id.eass_linear);
        essay_check = (CheckBox) view.findViewById(R.id.essay_check);
    }
    @Override
    public int getLayoutId() {
        return R.layout.blood_essay;
    }
    @Override
    public void initData() {
        eaasyPresenter = new EaasyPresenter(this,type,id);
    }
    @Override
    public void loadData() {
        eaasyPresenter.click();
    }
    @Override
    public void initListener() {
        essay_check.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked==false){
                  /*  EssayModelInter modelInter = new EssayModelInter();
                    modelInter.goLogin("116924084", new NewUrlCallback() {
                        @Override
                        public void success(String eryun) {
                            Log.e("AAA",eryun.toString());
                        }

                        @Override
                        public void error(int code, String erge) {

                        }
                    });*/
                }
            }
        });
        eass_linear.setOnClickListener(this);
    }

    @Override
    public void setParams(Bundle bundle) {
        super.setParams(bundle);
        id = bundle.getString("id");
        type = bundle.getString("type");
        Log.e("AAAAA",type+"");

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

    }
}
