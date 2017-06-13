package xueya.jiyun.com.xueya.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import xueya.jiyun.com.xueya.R;
import xueya.jiyun.com.xueya.model.bean.HuiFuBean;

/**
 * Created by my on 2017/6/13.
 */

public class HuiFuAdapter extends BaseAdapter{

    List<HuiFuBean.DataBean> list;

    public HuiFuAdapter(List<HuiFuBean.DataBean> list) {
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
        if(convertView==null){
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.hiufu_item,null);
            holder = new ViewHolder();

            holder.huifuTitle = (TextView) convertView.findViewById(R.id.huifu_title);
            holder.huifuContent = (TextView) convertView.findViewById(R.id.huifu_content);

            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.huifuTitle.setText(list.get(position).getTitle());
        holder.huifuContent.setText(list.get(position).getReply());

        return convertView;
    }


    class ViewHolder{
        TextView huifuTitle,huifuContent;
    }
}
