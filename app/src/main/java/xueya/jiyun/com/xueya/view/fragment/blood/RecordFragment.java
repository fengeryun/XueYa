package xueya.jiyun.com.xueya.view.fragment.blood;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import butterknife.Bind;
import butterknife.ButterKnife;
import xueya.jiyun.com.xueya.App;
import xueya.jiyun.com.xueya.R;
import xueya.jiyun.com.xueya.presenter.bloods.RecordPresenter;
import xueya.jiyun.com.xueya.tools.FragmentBuilder;
import xueya.jiyun.com.xueya.view.base.BaseFragment;
import xueya.jiyun.com.xueya.view.viewinter.blooder.RecordView;

/**
 * Created by Asus on 2017/6/9.
 */

public class RecordFragment extends BaseFragment implements View.OnClickListener,RecordView{
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
    private Button recordCommit;
    private ImageView record_back;
    private TextView showDate;
    private TextView record_time;
    private LinearLayout record_linear;
    private EditText record_device,record_height,record_low;

    private RecordPresenter rp;
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
        recordCommit = (Button) view.findViewById(R.id.record_commit);
        record_back = (ImageView) view.findViewById(R.id.record_back);
        showDate = (TextView) view.findViewById(R.id.record_date);
        record_time = (TextView) view.findViewById(R.id.record_time);
        record_linear = (LinearLayout) view.findViewById(R.id.record_linear);
        record_device = (EditText) view.findViewById(R.id.record_device);
        record_height = (EditText) view.findViewById(R.id.record_height);
        record_low = (EditText) view.findViewById(R.id.record_low);
    }
    @Override
    public int getLayoutId() {
        return R.layout.record;
    }

    @Override
    public void initData() {
        rp = new RecordPresenter(this);

    }

    @Override
    public void loadData() {

    }

    @Override
    public void initListener() {
        record_back.setOnClickListener(this);
        showDate.setOnClickListener(this);
        record_time.setOnClickListener(this);
        record_linear.setOnClickListener(this);
        recordCommit.setOnClickListener(this);
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

                DatePickerDialog  dateDlg = new DatePickerDialog(App.activity,DatePickerDialog.THEME_HOLO_LIGHT,
                        d,
                        dateAndTime.get(Calendar.YEAR),
                        dateAndTime.get(Calendar.MONTH),
                        dateAndTime.get(Calendar.DAY_OF_MONTH));
                dateDlg.show();
                break;
            case R.id.record_time:
                TimePickerDialog timeDlg = new TimePickerDialog(App.activity,TimePickerDialog.THEME_HOLO_LIGHT,
                        t,
                        dateAndTime.get(Calendar.HOUR_OF_DAY),
                        dateAndTime.get(Calendar.MINUTE),
                        true);
                timeDlg.show();
                break;
            case R.id.record_commit:
               rp.showSubmit(record_device.getText().toString().trim(),record_height.getText().toString().trim(),record_low.getText().toString().toString(),showDate.getText().toString(),record_time.getText().toString());
                break;
            case R.id.record_linear:

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


    @Override
    public String getDevice() {
        return record_device.getText().toString().trim();
    }

    @Override
    public String getHeight() {
        return record_height.getText().toString().trim();
    }

    @Override
    public String getLow() {
        return record_low.getText().toString().trim();
    }

    @Override
    public void getDeviceMess(String msg) {
        Toast.makeText(App.activity, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void getHeightMess(String msg) {
        Toast.makeText(App.activity, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void getLowMess(String msg) {
        Toast.makeText(App.activity, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void getButtonMess(String msg) {

    }

}
