package xueya.jiyun.com.xueya.view.fragment.blood;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.DatePicker;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TimePicker;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import xueya.jiyun.com.xueya.App;
import xueya.jiyun.com.xueya.R;
import xueya.jiyun.com.xueya.tools.FragmentBuilder;
import xueya.jiyun.com.xueya.view.base.BaseFragment;

/**
 * Created by Asus on 2017/6/9.
 */

public class RecordFragment extends BaseFragment implements View.OnClickListener {
    @Bind(R.id.record_back)
    ImageView recordBack;
    @Bind(R.id.record_titlle)
    TextView recordTitlle;
    @Bind(R.id.shebei)
    TextView shebei;
    @Bind(R.id.gaoya)
    TextView gaoya;
    @Bind(R.id.diya)
    TextView diya;
    @Bind(R.id.record_commit)
    Button recordCommit;
    @Bind(R.id.record_txt)
    TextView recordTxt;
    private ImageView record_back;
    private TextView showDate;
    private TextView record_time;

    //获取日期格式器对象
    DateFormat fmtDate = new SimpleDateFormat("yyyy-MM-dd");
    DateFormat fmtTime = new java.text.SimpleDateFormat("HH:mm");
    Calendar dateAndTime = Calendar.getInstance(Locale.CHINA);
    //当点击DatePickerDialog控件的设置按钮时，调用该方法
    DatePickerDialog.OnDateSetListener d = new DatePickerDialog.OnDateSetListener()
    {
        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear,
                              int dayOfMonth) {
            //修改日历控件的年，月，日
            //这里的year,monthOfYear,dayOfMonth的值与DatePickerDialog控件设置的最新值一致
            dateAndTime.set(Calendar.YEAR, year);
            dateAndTime.set(Calendar.MONTH, monthOfYear);
            dateAndTime.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            //将页面TextView的显示更新为最新时间
            upDateDate();
        }
    };
    TimePickerDialog.OnTimeSetListener t = new TimePickerDialog.OnTimeSetListener() {

        //同DatePickerDialog控件
        @Override
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            dateAndTime.set(Calendar.HOUR_OF_DAY, hourOfDay);
            dateAndTime.set(Calendar.MINUTE, minute);
            upDateTime();

        }
    };

    @Override
    public void initView(View view) {
        record_back = (ImageView) view.findViewById(R.id.record_back);
        showDate = (TextView) view.findViewById(R.id.record_date);
        record_time = (TextView) view.findViewById(R.id.record_time);

    }
    @Override
    public int getLayoutId() {
        return R.layout.record;
    }

    @Override
    public void initData() {


    }

    @Override
    public void loadData() {

    }

    @Override
    public void initListener() {
        record_back.setOnClickListener(this);
        showDate.setOnClickListener(this);
        record_time.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.record_back:
                FragmentManager message = App.activity.getSupportFragmentManager();
                message.popBackStackImmediate();
                String lastname = message.getBackStackEntryAt(message.getBackStackEntryCount() - 1).getName();
                BaseFragment fragment = (BaseFragment) message.findFragmentByTag(lastname);
                FragmentBuilder.getInstance().setLastFragment(fragment);
                break;
            case R.id.record_date:

                DatePickerDialog  dateDlg = new DatePickerDialog(App.activity,
                        d,
                        dateAndTime.get(Calendar.YEAR),
                        dateAndTime.get(Calendar.MONTH),
                        dateAndTime.get(Calendar.DAY_OF_MONTH));
                dateDlg.show();
                break;
            case R.id.record_time:
                TimePickerDialog timeDlg = new TimePickerDialog(App.activity,
                        t,
                        dateAndTime.get(Calendar.HOUR_OF_DAY),
                        dateAndTime.get(Calendar.MINUTE),
                        true);
                timeDlg.show();
                break;
        }
    }
   //更新日期
    private void upDateDate() {
        showDate.setText(fmtDate.format(dateAndTime.getTime()));
    }
    //更新时间
    private void upDateTime() {
        record_time.setText(fmtTime.format(dateAndTime.getTime()));
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

    @OnClick(R.id.record_txt)
    public void onViewClicked() {
    }
}
