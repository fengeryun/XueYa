package xueya.jiyun.com.xueya.model.urls;

/**
 * Created by 123 on 2017/6/10.
 */

public class Urls {
    public static String BaseUrl = "http://api.wws.xywy.com/";

    public static String LogIn_url=BaseUrl+"index.php?&tag=BloodAndroid&sign=2c19b2821ebc5306c3ac37bac5b4288b&act=kbb&fun=users&type=login"; //登录

    public static String ZhuanJiaList = BaseUrl+"index.php?&tag=BloodAndroid&sign=2c19b2821ebc5306c3ac37bac5b4288b&act=zhuanjia&fun=SearchDoctor&pageCount=10&pageNum=1&province=&title=&keyword=&illid=%E9%AB%98%E8%A1%80%E5%8E%8B&IsPlus=0&level= HTTP/1.1";  //砖家列表
    public static String NOUSURL = BaseUrl+"index.php?act=zixun&fun=getHealthPlazeList&version=version2&tag=zj&sign=2e0d0887581be1c35794ee4c13b00cae&typeid=18031&dir=zhuanti_nk";
    public static String COOKBOOKURL = BaseUrl+"index.php?act=zixun&fun=getHealthPlazeList&version=version2&tag=zj&sign=2e0d0887581be1c35794ee4c13b00cae&typeid=7938&dir=zhuzhan_ys";
    public static String PREVENTURL = BaseUrl+"index.php?act=zixun&fun=getHealthPlazeList&version=version2&tag=zj&sign=2e0d0887581be1c35794ee4c13b00cae&typeid=18033&dir=zhuanti_nk";
    public static String TREATURL = BaseUrl+"index.php?act=zixun&fun=getHealthPlazeList&version=version2&tag=zj&sign=2e0d0887581be1c35794ee4c13b00cae&typeid=18035&dir=zhuanti_nk";
    public static String INSPECTURL = BaseUrl+"index.php?act=zixun&fun=getHealthPlazeList&version=version2&tag=zj&sign=2e0d0887581be1c35794ee4c13b00cae&typeid=18032&dir=zhuanti_nk";
    public static String EAASYURL = BaseUrl+"index.php?act=zixun&fun=getHealthPlazeDetail&version=version2&tag=zj&sign=2e0d0887581be1c35794ee4c13b00cae";
}
