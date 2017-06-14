package xueya.jiyun.com.xueya.model.bean;

/**
 * Created by Asus on 2017/6/14.
 */

public class Hei {
    private String message;

    public Hei(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Hei{" +
                "message='" + message + '\'' +
                '}';
    }
}
