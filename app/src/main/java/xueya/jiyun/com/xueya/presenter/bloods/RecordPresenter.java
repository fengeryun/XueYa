package xueya.jiyun.com.xueya.presenter.bloods;

import android.text.TextUtils;
import android.widget.Toast;

import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;

import xueya.jiyun.com.xueya.App;
import xueya.jiyun.com.xueya.model.db.Takes;
import xueya.jiyun.com.xueya.model.db.TakesOrmlit;
import xueya.jiyun.com.xueya.model.sp.SpUtils;
import xueya.jiyun.com.xueya.view.viewinter.blooder.RecordView;

/**
 * Created by Asus on 2017/6/13.
 */

public class RecordPresenter implements IRecordPresenter{
    private RecordView recordView;
    private Dao<Takes, ?> dao;
    private Takes takes;

    public RecordPresenter(RecordView recordView) {
        this.recordView = recordView;
        TakesOrmlit myOrmlit = new TakesOrmlit(App.activity,"notes.db",null,1);
        try {
            dao = myOrmlit.getDao(Takes.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void showSubmit(String device, String height, String low,String showDate,String showTime) {


        if (TextUtils.isEmpty(device)) {
            recordView.getDeviceMess("请填写设备名称");
            return;
        }

        if(height.length()==0){
            recordView.getDeviceMess("请填写高压");
        }else{
            int b =Integer.parseInt(height);
            if(low.length()==0){
                recordView.getDeviceMess("请填写低压");
            }else {
                int a = Integer.parseInt(low);

                if (b>29&&b<201){

                }else{
                    Toast.makeText(App.activity, "高压范围30--200", Toast.LENGTH_SHORT).show();
                }
                if (a>29&&a<201){

                }else{
                    Toast.makeText(App.activity, "低压范围30--200", Toast.LENGTH_SHORT).show();
                }
                if (a>b||a==b){
                    Toast.makeText(App.activity, "低压值不能高于高压值", Toast.LENGTH_SHORT).show();
                }
                if (!TextUtils.isEmpty(device)&&b>29&&b<201&&a>29&&a<201&&a<b&&SpUtils.getInstance("LogIn").getSp().getBoolean("isLogin",false)){
                    takes = new Takes();
                    takes.setDevice(device);
                    takes.setHeight(height);
                    takes.setLow(low);
                    takes.setShowDate(showDate);
                    takes.setShowTime(showTime);
                    try {
                        int i = dao.create(takes);

                    } catch (SQLException e) {

                    }
                    App.activity.onBackPressed();
                } else {
                    Toast.makeText(App.activity, "请先登录", Toast.LENGTH_SHORT).show();
                }
            }
        }

    }
}
