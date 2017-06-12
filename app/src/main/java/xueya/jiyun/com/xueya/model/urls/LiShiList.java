package xueya.jiyun.com.xueya.model.urls;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by my on 2017/5/24.
 */

public class LiShiList {
    private List<String> lishilist;
    private static LiShiList instance;
    private LiShiList(){
        lishilist = new ArrayList<>();
    }
    public static LiShiList getInstance(){
        if(instance==null){
            synchronized (LiShiList.class){
                if(instance==null){
                    instance = new LiShiList();
                }
            }
        }
        return instance;
    }

    public void addlishi(String name){
        lishilist.add(name);
    }

    public void clears(){
        lishilist.clear();
    }

    public List<String> getList(){
        return lishilist;
    }

}
