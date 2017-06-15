package xueya.jiyun.com.xueya.view.fragment.mine;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.NumberPicker;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import xueya.jiyun.com.xueya.App;
import xueya.jiyun.com.xueya.R;
import xueya.jiyun.com.xueya.model.bean.Event;
import xueya.jiyun.com.xueya.tools.FragmentBuilder;
import xueya.jiyun.com.xueya.view.base.BaseFragment;

/**
 * Created by 123 on 2017/6/12.
 */

public class PersonalFragment extends BaseFragment implements View.OnClickListener {
    RelativeLayout personal_name,rl;
    TextView persona_name,personal_sex,personal_height,personal_weight,personal_birthday;
    LinearLayout ll;
    private View view;
    private NumberPicker numberPicker;
    private Button popu_bt;
    final String[] city = {"男","女"};
    private Dialog d;
    private TextView popu_title;
    private Calendar dateAndTime;
    private DatePickerDialog.OnDateSetListener d1;
    private DateFormat fmtDate;
    private String str;
    private String s1;
    private String ss;

    @Override
    public void initView(View view) {
        personal_name= (RelativeLayout) view.findViewById(R.id.personal_name);
        rl= (RelativeLayout) view.findViewById(R.id.rl);
        persona_name= (TextView) view.findViewById(R.id.persona_name);
        personal_sex= (TextView) view.findViewById(R.id.personal_sex);
        personal_height= (TextView) view.findViewById(R.id.personal_height);
        personal_weight= (TextView) view.findViewById(R.id.personal_weight);
        personal_birthday= (TextView) view.findViewById(R.id.personal_birthday);
        ll= (LinearLayout) view.findViewById(R.id.ll);

    }

    @Override
    public int getLayoutId() {
        return R.layout.personaldata;
    }

    @Override
    public void initData() {
        view = LayoutInflater.from(App.activity).inflate(R.layout.popu,null);
        popu_title = (TextView) view.findViewById(R.id.popu_title);
        numberPicker = (NumberPicker) view.findViewById(R.id.hourpicker);
        d = new AlertDialog
                .Builder(App.activity)
                .setView(view)
                .create();
        EventBus.getDefault().register(PersonalFragment.this);

    }

    @Override
    public void loadData() {
        fmtDate = new SimpleDateFormat("yyyy-MM-dd");
        dateAndTime = Calendar.getInstance(Locale.CHINA);
        d1 = new DatePickerDialog.OnDateSetListener()
        {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                dateAndTime.set(Calendar.YEAR, year);
                dateAndTime.set(Calendar.MONTH, monthOfYear);
                dateAndTime.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                //将页面TextView的显示更新为最新时间
          upDateDate();
            }
        };

    }

    @Override
    public void initListener() {
        personal_name.setOnClickListener(this);
        personal_sex.setOnClickListener(this);
        personal_height.setOnClickListener(this);
        personal_weight.setOnClickListener(this);
        personal_birthday.setOnClickListener(this);
        ll.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
    switch (v.getId()){
        case R.id.personal_name:
            FragmentBuilder.getInstance().start(R.id.activity_home,ChangNameFragment.class);
            break;
        case R.id.personal_sex:
            view = LayoutInflater.from(App.activity).inflate(R.layout.popu,null);
            popu_title = (TextView) view.findViewById(R.id.popu_title);
            numberPicker = (NumberPicker) view.findViewById(R.id.hourpicker);
            numberPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
                @Override
                public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                    s1 = city[newVal];
                }
            });
            d = new AlertDialog
                    .Builder(App.activity)
                    .setView(view)
                    .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            personal_sex.setText(s1);
                        }
                    })
                    .create();
            popu_title.setText("选择男女");
            d.show();
            numberPicker.setDisplayedValues(city);
            numberPicker.setMinValue(0);
            numberPicker.setMaxValue(city.length - 1);
            numberPicker.setValue(4);
            break;
        case R.id.personal_height:
            view = LayoutInflater.from(App.activity).inflate(R.layout.popu,null);
            popu_title = (TextView) view.findViewById(R.id.popu_title);
            str = "";
            numberPicker = (NumberPicker) view.findViewById(R.id.hourpicker);
            numberPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
                @Override
                public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                    str =newVal+"";

                }
            });
            d = new AlertDialog
                    .Builder(App.activity)
                    .setView(view)
                    .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            personal_height.setText(str);
                        }
                    })
                    .create();
            popu_title.setText("选择身高");
            d.show();
            numberPicker.setMaxValue(200);
            numberPicker.setMinValue(100);
            numberPicker.setValue(9);
            break;
        case R.id.personal_weight:
            view = LayoutInflater.from(App.activity).inflate(R.layout.popu,null);
            popu_title = (TextView) view.findViewById(R.id.popu_title);
            numberPicker = (NumberPicker) view.findViewById(R.id.hourpicker);

            numberPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
                @Override
                public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                    ss = newVal+"";
                }
            });
            d = new AlertDialog
                    .Builder(App.activity)
                    .setView(view)
                    .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            personal_weight.setText(ss);
                        }
                    })
                    .create();
            popu_title.setText("选择体重");
            d.show();
            numberPicker.setMaxValue(300);
            numberPicker.setMinValue(80);
            numberPicker.setValue(5);
            break;
        case R.id.personal_birthday:
            DatePickerDialog  dateDlg = new DatePickerDialog(App.activity,DatePickerDialog.THEME_HOLO_LIGHT,
                    d1,
                    dateAndTime.get(Calendar.YEAR),
                    dateAndTime.get(Calendar.MONTH),
                    dateAndTime.get(Calendar.DAY_OF_MONTH));
            dateDlg.show();

            break;
    }
    }
    @Subscribe(threadMode = ThreadMode.MAIN,sticky = true)
    public void getEventBus(Event event){
        persona_name.setText(event.getMsg());
    }
    private void upDateDate() {
        personal_birthday.setText(fmtDate.format(dateAndTime.getTime()));
    }
}
