package xueya.jiyun.com.xueya.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import xueya.jiyun.com.xueya.App;
import xueya.jiyun.com.xueya.R;
import xueya.jiyun.com.xueya.model.db.Hour;

/**
 * Created by Asus on 2017/6/13.
 */

public class RemindAdapter extends BaseAdapter{
    private List<Hour> list;

    public RemindAdapter(List<Hour> list) {
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
        ViewHolder holder;
        if (convertView==null){
            holder = new ViewHolder();
            convertView = LayoutInflater.from(App.activity).inflate(R.layout.reminditem,null);
            holder.remind_time = (TextView) convertView.findViewById(R.id.remind_time);
            holder.remind_drug = (TextView) convertView.findViewById(R.id.remind_drug);
            holder.remind_num = (TextView) convertView.findViewById(R.id.remind_num);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.remind_time.setText(list.get(position).getHour());
        holder.remind_drug.setText(list.get(position).getName());
        holder.remind_num.setText(list.get(position).getNum()+"片/次");

        return convertView;
    }

    class ViewHolder{
        private TextView remind_time;
        private TextView remind_drug;
        private TextView remind_num;
    }
}
