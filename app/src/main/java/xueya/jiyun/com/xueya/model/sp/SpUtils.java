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
    private SpUtils (){}
    //创建对象时传入SP文件的名字
    public static synchronized SpUtils getInstance(String SpName) {
        if (spUtils == null) {
            SPName=SpName;
            spUtils = new SpUtils();
        }
        return spUtils;
    }
    //创建SP对象的单例对象
    public static synchronized SharedPreferences getSp(){
        if(preferences==null){
            preferences=App.activity.getSharedPreferences(SPName,App.activity.MODE_PRIVATE);
        }
        return preferences;
    }
    //获取需要的字符串
    public static String GetVariable(String VariableName){
        Variable=preferences.getString(VariableName,"");
      return  Variable;
    }
}
