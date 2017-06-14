package xueya.jiyun.com.xueya.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import xueya.jiyun.com.xueya.App;
import xueya.jiyun.com.xueya.R;
import xueya.jiyun.com.xueya.model.db.Takes;

/**
 * Created by Asus on 2017/6/14.
 */

public class TakenAdapter extends BaseAdapter{
    private List<Takes> list;

    public TakenAdapter(List<Takes> list) {
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
            convertView= LayoutInflater.from(App.activity).inflate(R.layout.takenotesitem,null);
            holder.taken_gaoya = (TextView) convertView.findViewById(R.id.taken_gaoya);
            holder.taken_diya = (TextView) convertView.findViewById(R.id.taken_diya);
            holder.taken_date = (TextView) convertView.findViewById(R.id.taken_date);
            holder.taken_time = (TextView) convertView.findViewById(R.id.taten_time);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.taken_gaoya.setText(list.get(position).getHeight());
        holder.taken_diya.setText(list.get(position).getLow());
        holder.taken_date.setText(list.get(position).getShowDate());
        holder.taken_time.setText(list.get(position).getShowTime());
        return convertView;
    }
    class ViewHolder{
        private TextView taken_gaoya;
        private TextView taken_diya;
        private TextView taken_date;
        private TextView taken_time;
    }
}
