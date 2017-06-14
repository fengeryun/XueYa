package xueya.jiyun.com.xueya.model.db;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by Asus on 2017/6/13.
 */
@DatabaseTable(tableName = "hour")
public class Hour {
    @DatabaseField(generatedId = true)
    private int id;
    @DatabaseField(columnName = "hour")
    private String hour;
    @DatabaseField(columnName = "name")
    private String name;
    @DatabaseField(columnName = "num")
    private String num;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "Hour{" +
                "hour='" + hour + '\'' +
                ", name='" + name + '\'' +
                ", num=" + num +
                '}';
    }
}
