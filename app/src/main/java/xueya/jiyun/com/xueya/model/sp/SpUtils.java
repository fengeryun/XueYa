package xueya.jiyun.com.xueya.model.sp;

import android.content.SharedPreferences;

import xueya.jiyun.com.xueya.App;

/**
 * Created by 123 on 2017/6/12.
 */

public class SpUtils {
    /*SharedPreferences preferences= App.activity.getSharedPreferences("OSZG", App.activity.MODE_PRIVATE);
    name = preferences.getString("UID", "");*/
    private static SpUtils spUtils;
    private static SharedPreferences preferences;
    private static String SPName;
    private static String Variable;
    private static SharedPreferences.Editor edit;

    private SpUtils (){}
    //创建对象时传入SP文件的名字
    public static synchronized SpUtils getInstance(String SpName) {
        if (spUtils == null) {
            SPName=SpName;
            spUtils = new SpUtils();
            preferences=App.activity.getSharedPreferences(SPName,App.activity.MODE_PRIVATE);
            edit = preferences.edit();
        }
        return spUtils;
    }
    //获取需要的字符串
    public  String GetVariable(String VariableName){
        Variable=preferences.getString(VariableName,"");
      return  Variable;
    }
    //清空sp文件的所有内容
    public  void CleanVariable(){
        edit.clear();
        edit.commit();

    }
}
