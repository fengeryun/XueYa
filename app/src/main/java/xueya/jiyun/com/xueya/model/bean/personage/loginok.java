package xueya.jiyun.com.xueya.model.bean.personage;

/**登陆成功返回的Bean对象
 * Created by 123 on 2017/6/10.
 */

public class loginok {

    /**
     * state : 200
     * userid : 116924091
     * isregister : 1
     * phonenum : 15533604305
     * height : 158
     * sex : 女
     * birthday : 1939-09-11
     */

    private int state;
    private String userid;
    private int isregister;
    private String phonenum;
    private int height;
    private String sex;
    private String birthday;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public int getIsregister() {
        return isregister;
    }

    public void setIsregister(int isregister) {
        this.isregister = isregister;
    }

    public String getPhonenum() {
        return phonenum;
    }

    public void setPhonenum(String phonenum) {
        this.phonenum = phonenum;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
}
