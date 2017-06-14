package xueya.jiyun.com.xueya.presenter.bloods;

import android.text.TextUtils;

import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;

import xueya.jiyun.com.xueya.App;
import xueya.jiyun.com.xueya.model.db.Hour;
import xueya.jiyun.com.xueya.model.db.MyOrmlit;
import xueya.jiyun.com.xueya.view.viewinter.blooder.AddView;

/**
 * Created by Asus on 2017/6/12.
 */

public class AddPresenter implements IAddPresenter{
    private AddView loginView;
    private Dao<Hour, ?> dao;

    public AddPresenter(AddView loginView) {
        this.loginView = loginView;
    }

    @Override
    public void AddLogin(String name, String dosis, String showtime) {
        MyOrmlit myOrmlit = new MyOrmlit(App.activity,"student.db",null,1);
        try {
            dao = myOrmlit.getDao(Hour.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (TextUtils.isEmpty(name)) {
            loginView.ShowMsg("不能为空");
            return;
        }else {
            Hour hour = new Hour();
            hour.setHour(showtime);
            hour.setName(name);
            hour.setNum(dosis);
            try {
                int i = dao.create(hour);

            } catch (SQLException e) {
                e.printStackTrace();
            }
            App.activity.onBackPressed();
        }
        if (TextUtils.isEmpty(dosis)) {
            loginView.ShowMsg("不能为空");
            return;
        }else {
            loginView.startFragment();
        }

    }
}
