package xueya.jiyun.com.xueya;

/**
 * Created by Asus on 2017/6/8.
 */

public class Student {
    String name;
    String psw;

    public String getPsw() {
        return psw;
    }

    public void setPsw(String psw) {
        this.psw = psw;
    }

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
