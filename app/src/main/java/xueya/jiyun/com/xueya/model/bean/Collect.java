package xueya.jiyun.com.xueya.model.bean;

import java.util.List;

/**
 * Created by 123 on 2017/6/14.
 */

public class Collect {

    /**
     * data : [{"categoryid":"770333","document_id":"0","meta":"zhuzhan_ys,7938","title":"老年性高血压如何通过药粥治疗呢"},{"categoryid":"770882","document_id":"0","meta":"zhuzhan_ys,7938","title":"高血压患者饮食食谱有哪些"},{"categoryid":"1495225","document_id":"0","meta":"zhuanti_nk,18033","title":""}]
     * error :
     * state : 200
     */

    private String error;
    private int state;
    private List<DataBean> data;

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * categoryid : 770333
         * document_id : 0
         * meta : zhuzhan_ys,7938
         * title : 老年性高血压如何通过药粥治疗呢
         */

        private String categoryid;
        private String document_id;
        private String meta;
        private String title;

        public String getCategoryid() {
            return categoryid;
        }

        public void setCategoryid(String categoryid) {
            this.categoryid = categoryid;
        }

        public String getDocument_id() {
            return document_id;
        }

        public void setDocument_id(String document_id) {
            this.document_id = document_id;
        }

        public String getMeta() {
            return meta;
        }

        public void setMeta(String meta) {
            this.meta = meta;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }
}
