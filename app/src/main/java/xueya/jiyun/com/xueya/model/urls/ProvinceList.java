package xueya.jiyun.com.xueya.model.urls;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by my on 2017/6/10.
 */

public class ProvinceList {
    private static ProvinceList province;
    private List<String> provincelist;
    private ProvinceList(){
        provincelist = new ArrayList<>();
        provincelist.add("北京市");
        provincelist.add("山东省");
        provincelist.add("山西省");
        provincelist.add("河北省");
        provincelist.add("河南省");
        provincelist.add("天津市");
        provincelist.add("辽宁省");
        provincelist.add("黑龙江省");
        provincelist.add("吉林省");
        provincelist.add("湖北省");
        provincelist.add("湖南省");
        provincelist.add("上海市");
        provincelist.add("四川省");
        provincelist.add("重庆市");
        provincelist.add("山西省");
        provincelist.add("甘肃省");
        provincelist.add("云南省");
        provincelist.add("新疆维吾尔自治区");
        provincelist.add("内蒙古自治区");
        provincelist.add("海南省");
        provincelist.add("贵州省");
        provincelist.add("青海省");
        provincelist.add("广东省");
        provincelist.add("宁夏回族自治区");
        provincelist.add("西藏自治区");
        provincelist.add("广西壮族自治区");
        provincelist.add("江苏省");
        provincelist.add("浙江省");
        provincelist.add("安徽省");
        provincelist.add("江西省");
        provincelist.add("福建省");
    }
    public static ProvinceList getProvince(){
        if(province==null){
            synchronized (ProvinceList.class){
                if(province==null){
                    province = new ProvinceList();
                }
            }
        }
        return province;
    }

    public List<String> getProvinces(){
        return provincelist;
    }

    public void addProvince(String province){
        provincelist.add(province);
    }

}
