package xueya.jiyun.com.xueya.view.fragment.blood.tixing;

import android.view.View;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

import xueya.jiyun.com.xueya.R;
import xueya.jiyun.com.xueya.view.base.BaseFragment;

/**
 * Created by Asus on 2017/6/10.
 */

public class AddRemindFragment extends BaseFragment{
    int minute = 0;
    int houre = 0;
    private TimePicker time;
    TextView showtime = null;
    @Override
    public void initView(View view) {
        time = (TimePicker) view.findViewById(R.id.main_tp_showTime);
        // 为时间控件设置监听事件
        showtime = (TextView) view.findViewById(R.id.main_tv_showtime);
    }

    @Override
    public int getLayoutId() {
        return R.layout.addremind;
    }

    @Override
    public void initData() {
        showTime(houre, minute);


        Calendar c = Calendar.getInstance();
        // 获取当前的小时数
        houre = c.get(Calendar.HOUR_OF_DAY);
        // 获取当前的分钟数
        minute = c.get(Calendar.MINUTE);

    }

    private void showTime(int houre, int minute) {
        showtime.setText("时间是：" + houre + "时" + minute + "分");
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


    }
}
