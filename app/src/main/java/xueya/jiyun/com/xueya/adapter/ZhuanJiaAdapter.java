package xueya.jiyun.com.xueya.adapter;

import android.os.Bundle;
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
import xueya.jiyun.com.xueya.tools.FragmentBuilder;
import xueya.jiyun.com.xueya.view.fragment.doctors.ZhuanJiaData;
import xueya.jiyun.com.xueya.view.fragment.doctors.datapag.Fragment_yuyue;

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
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder hold;
        if(convertView==null){
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_query_experts,null);
            hold = new ViewHolder();

            hold.queryPic = (ImageView) convertView.findViewById(R.id.query_ispush);
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

        hold.queryPic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bun = new Bundle();
                bun.putParcelable("databean",list.get(position));
                FragmentBuilder.getInstance().start(R.id.activity_home,Fragment_yuyue.class).isBacked(true).setParams(bun);
            }
        });

        return convertView;
    }

    class ViewHolder{
        ImageView touxiang,queryPic;
        TextView name,yiyuan,zhiwei,jineng,xueli,content;
    }

}
