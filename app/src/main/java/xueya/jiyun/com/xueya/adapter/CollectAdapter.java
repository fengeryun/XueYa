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
import xueya.jiyun.com.xueya.model.bean.SignBean;

/**
 * Created by 123 on 2017/6/13.
 */

public class CollectAdapter extends BaseAdapter {
    SignBean signBean;

    public CollectAdapter(SignBean signBean) {
        this.signBean = signBean;
    }

    @Override
    public int getCount() {
        return signBean.getData().getData().size();
    }

    @Override
    public Object getItem(int position) {
        return signBean.getData().getData().get(position);
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
            convertView= LayoutInflater.from(App.activity).inflate(R.layout.jiahao_item,null);
            holder.jiahao_img= (ImageView) convertView.findViewById(R.id.jiahao_img);
            holder.jiahao_name= (TextView) convertView.findViewById(R.id.jiahao_name);
            holder.jiahao_time= (TextView) convertView.findViewById(R.id.jiahao_time);
            holder.jiahao_shenhe= (TextView) convertView.findViewById(R.id.jiahao_shenhe);
            holder.jiahao_tishi= (TextView) convertView.findViewById(R.id.jiahao_tishi);
            convertView.setTag(holder);
        }else {
            holder= (ViewHolder) convertView.getTag();
        }
         holder.jiahao_name.setText(signBean.getData().getData().get(position).getExpert());
         holder.jiahao_shenhe.setText(signBean.getData().getData().get(position).getReason());
        holder.jiahao_time.setText(signBean.getData().getData().get(position).getTodate());
        holder.jiahao_tishi.setText(signBean.getData().getData().get(position).getGoodat());
        Glide.with(App.activity).load(signBean.getData().getData().get(position).getExpert_pic()).into(holder.jiahao_img);
        return convertView;
    }
    class ViewHolder{
        ImageView jiahao_img;
        TextView jiahao_name,jiahao_time,jiahao_shenhe,jiahao_tishi;
    }
}
