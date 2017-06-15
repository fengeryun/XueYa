package xueya.jiyun.com.xueya.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import xueya.jiyun.com.xueya.App;
import xueya.jiyun.com.xueya.R;
import xueya.jiyun.com.xueya.model.bean.ZhuanJiaBean;

/**
 * Created by my on 2017/6/13.
 */

public class GridAdapter extends BaseAdapter{

    List<ZhuanJiaBean.DataBean> list;

    public GridAdapter(List<ZhuanJiaBean.DataBean> list) {
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
        if(convertView == null){
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.griditem,null);
            holder = new ViewHolder();

            holder.gridImage = (ImageView) convertView.findViewById(R.id.grid_img);
            holder.gridText = (TextView) convertView.findViewById(R.id.grid_txt);

            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }

        Glide.with(App.activity).load(list.get(position).getApp_image()).into(holder.gridImage);
        holder.gridText.setText(list.get(position).getName());

        return convertView;
    }

    class ViewHolder{
        ImageView gridImage;
        TextView gridText;
    }
}
