package xueya.jiyun.com.xueya.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import xueya.jiyun.com.xueya.App;
import xueya.jiyun.com.xueya.R;
import xueya.jiyun.com.xueya.model.bean.Nous;

/**
 * Created by Asus on 2017/6/12.
 */

public class NousAdapter extends BaseAdapter{
    private ArrayList<Nous.DataBean> list;

    public NousAdapter(ArrayList<Nous.DataBean> list) {
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
            convertView = LayoutInflater.from(App.activity).inflate(R.layout.nousitem,null);
            holder.nous_title = (TextView) convertView.findViewById(R.id.nous_title);
            holder.nous_pubdate = (TextView) convertView.findViewById(R.id.nous_pubdate);
            holder.nous_description = (TextView) convertView.findViewById(R.id.nous_description);
            convertView.setTag(holder);
        }else{
           holder = (ViewHolder) convertView.getTag();
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd   HH:mm:ss");
        long time = Long.parseLong(list.get(position).getPubdate());
        String fa = dateFormat.format(new Date(time*1000));

        holder.nous_title.setText(list.get(position).getTitle());
        holder.nous_pubdate.setText(fa);
        holder.nous_description.setText(list.get(position).getDescription());
        return convertView;
    }

    class ViewHolder{
        private TextView nous_title;
        private TextView nous_pubdate;
        private TextView nous_description;
    }
}
