package xueya.jiyun.com.xueya.presenter.bloods;

import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;
import java.util.List;

import xueya.jiyun.com.xueya.App;
import xueya.jiyun.com.xueya.model.db.Hour;
import xueya.jiyun.com.xueya.model.db.MyOrmlit;
import xueya.jiyun.com.xueya.view.viewinter.blooder.RemindView;

/**
 * Created by Asus on 2017/6/13.
 */

public class RemindPresenter {
    RemindView remindView;
    private Dao<Hour, ?> dao;
    private List<Hour> hours;

    public RemindPresenter(RemindView remindView) {
        this.remindView = remindView;
    }

    public void getShow(){

        MyOrmlit myOrmlit = new MyOrmlit(App.activity,"student.db",null,1);
        myOrmlit.getWritableDatabase();
        try {
            dao = myOrmlit.getDao(Hour.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            hours = dao.queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        remindView.getShow(hours);
    }

    public void deletData(int position){
        try {
            dao.delete(hours.get(position));
            dao.queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
