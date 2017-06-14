package xueya.jiyun.com.xueya.view.viewinter.blooder;

import java.util.List;

import xueya.jiyun.com.xueya.model.db.Hour;

/**
 * Created by Asus on 2017/6/13.
 */

public interface RemindView {
    void getShow(List<Hour> list);
    void getDelet();
}
