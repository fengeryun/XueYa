package xueya.jiyun.com.xueya.model.db;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by Asus on 2017/6/13.
 */
@DatabaseTable(tableName = "takes")
public class Takes {
    @DatabaseField(generatedId = true)
    private int id;
    @DatabaseField(columnName = "device")
    private String device;
    @DatabaseField(columnName = "height")
    private String height;
    @DatabaseField(columnName = "low")
    private String low;
    @DatabaseField(columnName = "showDate")
    private String showDate;
    @DatabaseField(columnName = "showTime")
    private String showTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getLow() {
        return low;
    }

    public void setLow(String low) {
        this.low = low;
    }

    public String getShowDate() {
        return showDate;
    }

    public void setShowDate(String showDate) {
        this.showDate = showDate;
    }

    public String getShowTime() {
        return showTime;
    }

    public void setShowTime(String showTime) {
        this.showTime = showTime;
    }

    @Override
    public String toString() {
        return "Takes{" +
                "id=" + id +
                ", device='" + device + '\'' +
                ", height='" + height + '\'' +
                ", low='" + low + '\'' +
                ", showDate='" + showDate + '\'' +
                ", showTime='" + showTime + '\'' +
                '}';
    }
}
