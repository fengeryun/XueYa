package xueya.jiyun.com.xueya.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import xueya.jiyun.com.xueya.App;
import xueya.jiyun.com.xueya.R;
import xueya.jiyun.com.xueya.model.bean.Collect;

/**
 * Created by 123 on 2017/6/14.
 */

public class CollAdapter extends BaseAdapter {
    Collect collect;

    public CollAdapter(Collect collect) {
        this.collect = collect;
    }

    @Override
    public int getCount() {
        return collect.getData().size();
    }

    @Override
    public Object getItem(int position) {
        return collect.getData().get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView==null){
          holder=new ViewHolder();
            convertView= LayoutInflater.from(App.activity).inflate(R.layout.collect_item,null);
            holder.collect_item= (TextView) convertView.findViewById(R.id.collect_item);
            convertView.setTag(holder);
        }else {
            holder= (ViewHolder) convertView.getTag();
        }
        holder.collect_item.setText(collect.getData().get(position).getTitle());
        return convertView;
    }
    class ViewHolder{
        TextView collect_item;
    }
}
