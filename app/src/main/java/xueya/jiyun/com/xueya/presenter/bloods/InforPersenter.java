package xueya.jiyun.com.xueya.presenter.bloods;

import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;
import java.util.List;

import xueya.jiyun.com.xueya.App;
import xueya.jiyun.com.xueya.model.db.Takes;
import xueya.jiyun.com.xueya.model.db.TakesOrmlit;
import xueya.jiyun.com.xueya.view.viewinter.blooder.InforView;

/**
 * Created by Asus on 2017/6/14.
 */

public class InforPersenter {
    private InforView inforView;
    private Dao<Takes, ?> dao;
    private List<Takes> takes;
    public InforPersenter(InforView inforView) {
        this.inforView = inforView;
    }

    public void getTextDate(){

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
        inforView.getDate(takes);
    }
}
