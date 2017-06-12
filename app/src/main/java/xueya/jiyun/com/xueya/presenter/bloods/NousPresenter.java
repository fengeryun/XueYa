package xueya.jiyun.com.xueya.presenter.bloods;

import android.widget.ListView;

import com.google.gson.Gson;

import java.util.ArrayList;

import xueya.jiyun.com.xueya.adapter.NousAdapter;
import xueya.jiyun.com.xueya.model.bean.Nous;
import xueya.jiyun.com.xueya.model.callback.NewUrlCallback;
import xueya.jiyun.com.xueya.model.modelinter.XueyaModelInter;

/**
 * Created by Asus on 2017/6/12.
 */

public class NousPresenter implements INousPresenter{

    private ListView listView;

    public NousPresenter(ListView listView) {
        this.listView = listView;
    }

    ArrayList<Nous.DataBean> list = new ArrayList<>();
    NousAdapter adapter;
    @Override
    public void click() {
        XueyaModelInter xueyaModelInter = new XueyaModelInter();
        xueyaModelInter.goLogin(new NewUrlCallback() {
            @Override
            public void success(String eryun) {
                Gson gson = new Gson();
                Nous nous = gson.fromJson(eryun, Nous.class);
                list.addAll(nous.getData());
                adapter = new NousAdapter(list);
                listView.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void error(int code, String erge) {

            }
        });
    }
}
