package xueya.jiyun.com.xueya.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import xueya.jiyun.com.xueya.R;
import xueya.jiyun.com.xueya.model.bean.ZhuanJiaBean;

/**
 * Created by my on 2017/6/12.
 */

public class ZhuanJiaAdapter extends BaseAdapter{

    List<ZhuanJiaBean.DataBean> list;

    public ZhuanJiaAdapter(List<ZhuanJiaBean.DataBean> list) {
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
        ViewHolder hold;
        if(convertView==null){
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_query_experts,null);
            hold = new ViewHolder();

            hold.touxiang = (ImageView) convertView.findViewById(R.id.query_pic);
            hold.name = (TextView) convertView.findViewById(R.id.tv_query_name);
            hold.yiyuan = (TextView) convertView.findViewById(R.id.tv_query_yiyuan);
            hold.zhiwei = (TextView) convertView.findViewById(R.id.tv_query_zhiwei);
            hold.jineng = (TextView) convertView.findViewById(R.id.tv_query_jineng);
            hold.xueli = (TextView) convertView.findViewById(R.id.tv_query_xueli);
            hold.content = (TextView) convertView.findViewById(R.id.tv_query_content);

            convertView.setTag(hold);
        }else {
            hold = (ViewHolder) convertView.getTag();
        }

        Glide.with(parent.getContext()).load(list.get(position).getApp_image()).into(hold.touxiang);
        hold.name.setText(list.get(position).getName());
        hold.yiyuan.setText(list.get(position).getHospital());
        hold.zhiwei.setText(list.get(position).getTitle());
        hold.jineng.setText(list.get(position).getDepart());
        if(list.get(position).getTeach()!=null){
            hold.xueli.setText(list.get(position).getTeach());
        }
        hold.content.setText(list.get(position).getGoodat());

        return convertView;
    }

    class ViewHolder{
        ImageView touxiang;
        TextView name,yiyuan,zhiwei,jineng,xueli,content;
    }

}
