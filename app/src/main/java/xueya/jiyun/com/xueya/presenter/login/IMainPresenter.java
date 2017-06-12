package xueya.jiyun.com.xueya.presenter.login;

import android.util.Log;

import com.google.gson.Gson;

import xueya.jiyun.com.xueya.model.bean.GetName;
import xueya.jiyun.com.xueya.model.callback.NewUrlCallback;
import xueya.jiyun.com.xueya.model.modelinter.MineModelInter;
import xueya.jiyun.com.xueya.model.sp.SpUtils;
import xueya.jiyun.com.xueya.view.viewinter.mine.MineView;

/**
 * Created by 123 on 2017/6/12.
 */

public class IMainPresenter implements MinePresenter {
    MineView mineView;
    private String s;
    MineModelInter mineModelInter;
    private String accountstr;

    public IMainPresenter(MineView mineView) {
        this.mineView = mineView;
        mineModelInter=new MineModelInter();
    }

    @Override
    public boolean login() {
        //清空sp文件中的所有内容
        //SpUtils.getInstance("LogIn").CleanVariable();
        s = SpUtils.getInstance("LogIn").GetVariable("userid");
        if(!s.equals("")){
            Log.e("TAG",s);
         mineView.showToux();
            mineView.hideBt();
            return false;
        }else{
            mineView.hideToux();
            mineView.showBt();
        }
        return true;
    }

    @Override
    public String getName() {
      /*  HashMap<String,String> map=new HashMap<>();
        map.put("act","kbb");
        map.put("fun","users");
        map.put("type","pullAccountInfo");
        map.put("tag","wjk");
        map.put("userid",s);
        map.put("sign","ee3dd4651821d3a45f4329a86d459cb7");*/
        mineModelInter.getName(s, new NewUrlCallback() {
            @Override
            public void success(String eryun) {
                if(eryun.contains("accountstr")){
                    Gson gson=new Gson();
                    GetName getName = gson.fromJson(eryun, GetName.class);
                    accountstr = getName.getAccounts().get(0).getAccountstr();
                    mineView.setName(accountstr);

                }
            }

            @Override
            public void error(int code, String erge) {
            }
        });
        return accountstr;
    }
}
