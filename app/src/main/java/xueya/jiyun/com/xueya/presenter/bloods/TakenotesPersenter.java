package xueya.jiyun.com.xueya.presenter.bloods;

import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;
import java.util.List;

import xueya.jiyun.com.xueya.App;
import xueya.jiyun.com.xueya.model.db.Takes;
import xueya.jiyun.com.xueya.model.db.TakesOrmlit;
import xueya.jiyun.com.xueya.view.viewinter.blooder.TakenotesView;

/**
 * Created by Asus on 2017/6/14.
 */

public class TakenotesPersenter {
    private TakenotesView bloodView;
    private Dao<Takes, ?> dao;
    private List<Takes> takes;

    public TakenotesPersenter(TakenotesView bloodView) {
        this.bloodView = bloodView;
    }

    public void getListview(){

        TakesOrmlit myOrmlit = new TakesOrmlit(App.activity,"notes.db",null,1);
        myOrmlit.getWritableDatabase();
        try {
            dao = myOrmlit.getDao(Takes.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            takes = dao.queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        bloodView.showListview(takes);
    }
    public void deletData(int position){
        try {
            dao.delete(takes.get(position));
            dao.queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
