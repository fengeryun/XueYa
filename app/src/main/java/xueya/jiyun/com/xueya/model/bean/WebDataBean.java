package xueya.jiyun.com.xueya.model.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by my on 2017/6/14.
 */

public class WebDataBean implements Parcelable {

    /**
     * data : {"contents":"<p style=\"text-indent:2em;\">\r\n\t带状疱疹后遗痛是指带状疱疹消失后疼痛仍持续存在并达半年以上者，是常见的困扰中老年人的顽固性疼痛之一。带状疱疹治愈后，患区仍存在持续的或阵发性剧烈疼痛，患区皮肤有明显的痛觉过敏和感觉异常，疼痛主要表现为持续烧灼痛或阵发性刀割样痛，难以忍受。\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t药物治疗包括神经营养药、镇痛剂和糖皮质激素等，同时应辅助以神经阻滞和理疗。当保守治疗无效时可考虑手术治疗，方法包括周围神经毁损术、脊髓背根进入区切开术和鞘内持续输注系统植入术等，大多数患者可获得较满意的疼痛缓解。\r\n<\/p>","expertid":"10636","title":"带状疱疹后遗痛","addtime":"1351344048","doctorid":"197332"}
     * code : 10000
     */

    private DataBean data;
    private int code;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public static class DataBean implements Parcelable {
        /**
         * contents : <p style="text-indent:2em;">
         带状疱疹后遗痛是指带状疱疹消失后疼痛仍持续存在并达半年以上者，是常见的困扰中老年人的顽固性疼痛之一。带状疱疹治愈后，患区仍存在持续的或阵发性剧烈疼痛，患区皮肤有明显的痛觉过敏和感觉异常，疼痛主要表现为持续烧灼痛或阵发性刀割样痛，难以忍受。
         </p>
         <p style="text-indent:2em;">
         药物治疗包括神经营养药、镇痛剂和糖皮质激素等，同时应辅助以神经阻滞和理疗。当保守治疗无效时可考虑手术治疗，方法包括周围神经毁损术、脊髓背根进入区切开术和鞘内持续输注系统植入术等，大多数患者可获得较满意的疼痛缓解。
         </p>
         * expertid : 10636
         * title : 带状疱疹后遗痛
         * addtime : 1351344048
         * doctorid : 197332
         */

        private String contents;
        private String expertid;
        private String title;
        private String addtime;
        private String doctorid;

        public String getContents() {
            return contents;
        }

        public void setContents(String contents) {
            this.contents = contents;
        }

        public String getExpertid() {
            return expertid;
        }

        public void setExpertid(String expertid) {
            this.expertid = expertid;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getAddtime() {
            return addtime;
        }

        public void setAddtime(String addtime) {
            this.addtime = addtime;
        }

        public String getDoctorid() {
            return doctorid;
        }

        public void setDoctorid(String doctorid) {
            this.doctorid = doctorid;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(this.contents);
            dest.writeString(this.expertid);
            dest.writeString(this.title);
            dest.writeString(this.addtime);
            dest.writeString(this.doctorid);
        }

        public DataBean() {
        }

        protected DataBean(Parcel in) {
            this.contents = in.readString();
            this.expertid = in.readString();
            this.title = in.readString();
            this.addtime = in.readString();
            this.doctorid = in.readString();
        }

        public static final Parcelable.Creator<DataBean> CREATOR = new Parcelable.Creator<DataBean>() {
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
        dest.writeParcelable(this.data, flags);
        dest.writeInt(this.code);
    }

    public WebDataBean() {
    }

    protected WebDataBean(Parcel in) {
        this.data = in.readParcelable(DataBean.class.getClassLoader());
        this.code = in.readInt();
    }

    public static final Parcelable.Creator<WebDataBean> CREATOR = new Parcelable.Creator<WebDataBean>() {
        @Override
        public WebDataBean createFromParcel(Parcel source) {
            return new WebDataBean(source);
        }

        @Override
        public WebDataBean[] newArray(int size) {
            return new WebDataBean[size];
        }
    };
}
