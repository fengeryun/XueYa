package xueya.jiyun.com.xueya.model.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by my on 2017/6/13.
 */

public class JingYanBean implements Parcelable {

    /**
     * data : [{"id":"8258","title":"蝶腭神经痛","categoryid":"83"},{"id":"8257","title":"带状疱疹后遗痛","categoryid":"83"},{"id":"8255","title":"神经皮肤综合征的病因病机","categoryid":"83"},{"id":"8252","title":"幻肢痛","categoryid":"83"},{"id":"8250","title":"耳颞神经痛","categoryid":"83"},{"id":"8245","title":"舌咽神经痛","categoryid":"83"},{"id":"8241","title":"原发性三叉神经痛治疗方法的比较","categoryid":"83"},{"id":"8238","title":"腕尺管综合征","categoryid":"83"},{"id":"8235","title":"桡管综合征","categoryid":"83"},{"id":"8233","title":"跖管综合征","categoryid":"83"}]
     * code : 10000
     */

    private int code;
    private List<DataBean> data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean implements Parcelable {
        /**
         * id : 8258
         * title : 蝶腭神经痛
         * categoryid : 83
         */

        private String id;
        private String title;
        private String categoryid;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getCategoryid() {
            return categoryid;
        }

        public void setCategoryid(String categoryid) {
            this.categoryid = categoryid;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(this.id);
            dest.writeString(this.title);
            dest.writeString(this.categoryid);
        }

        public DataBean() {
        }

        protected DataBean(Parcel in) {
            this.id = in.readString();
            this.title = in.readString();
            this.categoryid = in.readString();
        }

        public static final Creator<DataBean> CREATOR = new Creator<DataBean>() {
            @Override
            public DataBean createFromParcel(Parcel source) {
                return new DataBean(source);
            }

            @Override
            public DataBean[] newArray(int size) {
                return new DataBean[size];
            }
        };
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.code);
        dest.writeList(this.data);
    }

    public JingYanBean() {
    }

    protected JingYanBean(Parcel in) {
        this.code = in.readInt();
        this.data = new ArrayList<DataBean>();
        in.readList(this.data, DataBean.class.getClassLoader());
    }

    public static final Parcelable.Creator<JingYanBean> CREATOR = new Parcelable.Creator<JingYanBean>() {
        @Override
        public JingYanBean createFromParcel(Parcel source) {
            return new JingYanBean(source);
        }

        @Override
        public JingYanBean[] newArray(int size) {
            return new JingYanBean[size];
        }
    };
}
