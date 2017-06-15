package xueya.jiyun.com.xueya.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import xueya.jiyun.com.xueya.R;
import xueya.jiyun.com.xueya.model.bean.FreeAddBean;
import xueya.jiyun.com.xueya.tools.FragmentBuilder;
import xueya.jiyun.com.xueya.view.fragment.doctors.datapag.FragmentAddUser;

/**
 * Created by my on 2017/6/14.
 */

public class TimesAdapter extends BaseAdapter{

    List<FreeAddBean.DataBean.ScheduleBean.RdtimeBean> list;

    public TimesAdapter(List<FreeAddBean.DataBean.ScheduleBean.RdtimeBean> list) {
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHelder helder;
        if(convertView==null){
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_times,null);
            helder = new ViewHelder();

            helder.timesWeek = (TextView) convertView.findViewById(R.id.times_week);
            helder.timesTxt1 = (TextView) convertView.findViewById(R.id.times_txt1);
            helder.timesTxt2 = (TextView) convertView.findViewById(R.id.times_txt2);

            convertView.setTag(helder);
        }else {
            helder = (ViewHelder) convertView.getTag();
        }

        //Log.e("TTTTTTTTTTTTTTTTT",list.get(position).getHalfday());
        helder.timesWeek.setText(getTimes(list.get(position).getDate())+"\n"+"周"+getWeek(list.get(position).getWeek()));
        if(list.get(position).getHalfday().equals("1")){
            helder.timesTxt1.setText(list.get(position).getMsg()+"\n"+"剩余"+list.get(position).getSurplus()+"个");
            helder.timesTxt2.setText(" \n"+" ");

            helder.timesTxt1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    FragmentBuilder.getInstance().start(R.id.activity_home, FragmentAddUser.class).isBacked(true);
                }
            });
        }else {
            helder.timesTxt1.setText(" \n"+" ");
            helder.timesTxt2.setText(list.get(position).getMsg()+"\n"+"剩余"+list.get(position).getSurplus()+"个");

            helder.timesTxt1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    FragmentBuilder.getInstance().start(R.id.activity_home, FragmentAddUser.class).isBacked(true);
                }
            });
        }

        return convertView;
    }

    public class ViewHelder{
        TextView timesWeek,timesTxt1,timesTxt2;
    }

    private String getTimes(String times){
        SimpleDateFormat dateFormat = new SimpleDateFormat("M月dd日");
        long time = Long.parseLong(times);
        String fa = dateFormat.format(new Date(time * 1000));

        /*Date  dd=new Date(time*1000);
        Calendar  calendar=Calendar.getInstance();
        calendar.setTime(dd);
        // 本周几
        int week = calendar.get(Calendar.DAY_OF_WEEK);
        int  mouth=calendar.get(Calendar.MONTH);
        int  day=calendar.get(Calendar.DAY_OF_MONTH);
        Log.e("WWWWWWWWWWWW",mouth+"月"+day+"日"+"周"+week);*/

        return fa;
    }

    private String getWeek(String week){
        String weekname = null;
        switch (week){
            case "1":
                weekname = "一";
                break;
            case "2":
                weekname = "二";
                break;
            case "3":
                weekname = "三";
                break;
            case "4":
                weekname = "四";
                break;
            case "5":
                weekname = "五";
                break;
            case "6":
                weekname = "六";
                break;
            case "7":
                weekname = "七";
                break;
        }
        return weekname;
    }
}
