package xueya.jiyun.com.xueya.view.fragment.blood.tixing;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

import xueya.jiyun.com.xueya.App;
import xueya.jiyun.com.xueya.R;
import xueya.jiyun.com.xueya.presenter.bloods.AddPresenter;
import xueya.jiyun.com.xueya.tools.FragmentBuilder;
import xueya.jiyun.com.xueya.view.base.BaseFragment;
import xueya.jiyun.com.xueya.view.viewinter.blooder.AddView;

/**
 * Created by Asus on 2017/6/10.
 */

public class AddRemindFragment extends BaseFragment implements AddView, View.OnClickListener {
    int minute = 0;
    int houre = 0;
    private TimePicker time;
    TextView showtime = null;
    private EditText add_name,add_dosis;
    private TextView add_lay;
    AddPresenter addPresenter ;
    private LinearLayout add_linear;
    private ImageView add_back;

    @Override
    public void initView(View view) {
        time = (TimePicker) view.findViewById(R.id.main_tp_showTime);
        // 为时间控件设置监听事件
        showtime = (TextView) view.findViewById(R.id.main_tv_showtime);

        add_name = (EditText) view.findViewById(R.id.add_name);
        add_dosis = (EditText) view.findViewById(R.id.add_dosis);
        add_lay = (TextView) view.findViewById(R.id.add_lay);
        add_linear = (LinearLayout) view.findViewById(R.id.add_linear);
        add_back = (ImageView) view.findViewById(R.id.add_back);
    }
    @Override
    public int getLayoutId() {
        return R.layout.addremind;
    }

    @Override
    public void initData() {

        addPresenter = new AddPresenter(this);
        showTime(houre, minute);


        Calendar c = Calendar.getInstance();
        // 获取当前的小时数
        houre = c.get(Calendar.HOUR_OF_DAY);
        // 获取当前的分钟数
        minute = c.get(Calendar.MINUTE);
        showtime.setText(houre+":"+minute);

    }

    private void showTime(int houre, int minute) {
        showtime.setText( houre + ":" + minute);
    }

    @Override
    public void loadData() {

    }

    @Override
    public void initListener() {
        time.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                showTime(hourOfDay, minute);
            }
        });

        add_lay.setOnClickListener(this);
        add_linear.setOnClickListener(this);
        add_back.setOnClickListener(this);
    }

    @Override
    public String NameData() {
        return add_name.getText().toString().trim();
    }

    @Override
    public String DosisData() {
        return add_dosis.getText().toString().trim();
    }

    @Override
    public void ShowMsg(String msg) {
        Toast.makeText(App.activity, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void startFragment() {


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.add_lay:
        addPresenter.AddLogin(add_name.getText().toString().trim(),add_dosis.getText().toString().trim(),showtime.getText().toString().trim());
        Intent it = new Intent();
        it.setAction("xushaojie");
        it.putExtra("flsh","flsh");
        App.activity.sendBroadcast(it);
                break;
            case R.id.add_linear:
                break;
            case R.id.add_back:
                FragmentManager message = App.activity.getSupportFragmentManager();
                message.popBackStackImmediate();
                String lastname = message.getBackStackEntryAt(message.getBackStackEntryCount()-1).getName();
                BaseFragment fragment = (BaseFragment) message.findFragmentByTag(lastname);
                FragmentBuilder.getInstance().setLastFragment(fragment);
                break;
        }


    }
}
