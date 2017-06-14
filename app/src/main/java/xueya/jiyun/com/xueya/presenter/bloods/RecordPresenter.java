package xueya.jiyun.com.xueya.presenter.bloods;

import android.text.TextUtils;
import android.widget.Toast;

import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;

import xueya.jiyun.com.xueya.App;
import xueya.jiyun.com.xueya.model.db.MyOrmlit;
import xueya.jiyun.com.xueya.model.db.Takes;
import xueya.jiyun.com.xueya.view.viewinter.blooder.RecordView;

/**
 * Created by Asus on 2017/6/13.
 */

public class RecordPresenter implements IRecordPresenter{
    private RecordView recordView;
    private Dao<Takes, ?> dao;
    public RecordPresenter(RecordView recordView) {
        this.recordView = recordView;
    }


    @Override
    public void showSubmit(String device, String height, String low,String showDate,String showTime) {

        MyOrmlit myOrmlit = new MyOrmlit(App.activity,"notes.db",null,1);
        try {
            dao = myOrmlit.getDao(Takes.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }


        if(height.length()==0){
            recordView.getDeviceMess("请填写高压");
        }else{
            int b =Integer.parseInt(height);
            if(low.length()==0){
                recordView.getDeviceMess("请填写低压");
            }else {
                int a = Integer.parseInt(low);
                if (TextUtils.isEmpty(device)) {
                    recordView.getDeviceMess("请填写设备名称");
                    return;
                }
                if (b>30&&b<200){

                }else{
                    Toast.makeText(App.activity, "高压范围30--200", Toast.LENGTH_SHORT).show();
                }
                if (a>30&&a<200){

                }else{
                    Toast.makeText(App.activity, "低压范围30--200", Toast.LENGTH_SHORT).show();
                }
                if (!TextUtils.isEmpty(device)&&!TextUtils.isEmpty(height)&&!TextUtils.isEmpty(low)){
                    Toast.makeText(App.activity, "aaaaa", Toast.LENGTH_SHORT).show();
                    Takes takes = new Takes();
                    takes.setDevice(device);
                    takes.setHeight(height);
                    takes.setLow(low);
                    takes.setShowDate(showDate);
                    takes.setShowTime(showTime);
                    try {
                        dao.create(takes);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    App.activity.onBackPressed();
                }
            }
        }

    }
}
