package xueya.jiyun.com.xueya.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import xueya.jiyun.com.xueya.R;
import xueya.jiyun.com.xueya.model.urls.LiShiList;

/**
 * Created by my on 2017/6/10.
 */

public class ProvinceAdapter extends BaseAdapter{

    List<String> list;

    public ProvinceAdapter(List<String> list) {
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
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.txtitem,null);
            hold = new ViewHolder();

            hold.listtxt = (TextView) convertView.findViewById(R.id.list_content);

            convertView.setTag(hold);
        }else {
            hold = (ViewHolder) convertView.getTag();
        }

        hold.listtxt.setText(list.get(position));

//       convertView.setOnClickListener(new View.OnClickListener() {
//           @Override
//           public void onClick(View v) {
//               sousuoInput.setText(LiShiList.getInstance().getList().get(position));
//           }
//       });


        return convertView;
    }

    class ViewHolder{
        TextView listtxt;
    }
}
