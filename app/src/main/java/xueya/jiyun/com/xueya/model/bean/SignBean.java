package xueya.jiyun.com.xueya.model.bean;

import java.util.List;

/**
 * Created by 123 on 2017/6/13.
 */

public class SignBean {

    /**
     * code : 10000
     * total : 1
     * data : {"audit_total":"0","doctor_total":"0","all_total":"1","plus_total":"1","data":[{"expert":"李为民","expert_pic":"http://static.i2.xywy.com/zhuanjia/20141211/c9334b9a40aa134ae02ec0d6dc11ecc134614_a.jpg","title":"主任医师","expert_id":"8143","goodat":"高血压病、冠心病、心力衰竭、心律失常的诊断和药物治疗","hopital":"哈医大一院","depart":"心血管内科","reason":"您的预约订单信息填写不准确","plus_id":"818824","todate":"2017年06月21日 星期三 上午","plus_week":"星期三","plus_halfday":"上午","plus_day":"1497974400","uname":"","is_cancel":"0","state":"3","is_get":"4"}]}
     * msg :
     */

    private int code;
    private String total;
    private DataBeanX data;
    private String msg;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public DataBeanX getData() {
        return data;
    }

    public void setData(DataBeanX data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public static class DataBeanX {
        /**
         * audit_total : 0
         * doctor_total : 0
         * all_total : 1
         * plus_total : 1
         * data : [{"expert":"李为民","expert_pic":"http://static.i2.xywy.com/zhuanjia/20141211/c9334b9a40aa134ae02ec0d6dc11ecc134614_a.jpg","title":"主任医师","expert_id":"8143","goodat":"高血压病、冠心病、心力衰竭、心律失常的诊断和药物治疗","hopital":"哈医大一院","depart":"心血管内科","reason":"您的预约订单信息填写不准确","plus_id":"818824","todate":"2017年06月21日 星期三 上午","plus_week":"星期三","plus_halfday":"上午","plus_day":"1497974400","uname":"","is_cancel":"0","state":"3","is_get":"4"}]
         */

        private String audit_total;
        private String doctor_total;
        private String all_total;
        private String plus_total;
        private List<DataBean> data;

        public String getAudit_total() {
            return audit_total;
        }

        public void setAudit_total(String audit_total) {
            this.audit_total = audit_total;
        }

        public String getDoctor_total() {
            return doctor_total;
        }

        public void setDoctor_total(String doctor_total) {
            this.doctor_total = doctor_total;
        }

        public String getAll_total() {
            return all_total;
        }

        public void setAll_total(String all_total) {
            this.all_total = all_total;
        }

        public String getPlus_total() {
            return plus_total;
        }

        public void setPlus_total(String plus_total) {
            this.plus_total = plus_total;
        }

        public List<DataBean> getData() {
            return data;
        }

        public void setData(List<DataBean> data) {
            this.data = data;
        }

        public static class DataBean {
            /**
             * expert : 李为民
             * expert_pic : http://static.i2.xywy.com/zhuanjia/20141211/c9334b9a40aa134ae02ec0d6dc11ecc134614_a.jpg
             * title : 主任医师
             * expert_id : 8143
             * goodat : 高血压病、冠心病、心力衰竭、心律失常的诊断和药物治疗
             * hopital : 哈医大一院
             * depart : 心血管内科
             * reason : 您的预约订单信息填写不准确
             * plus_id : 818824
             * todate : 2017年06月21日 星期三 上午
             * plus_week : 星期三
             * plus_halfday : 上午
             * plus_day : 1497974400
             * uname :
             * is_cancel : 0
             * state : 3
             * is_get : 4
             */

            private String expert;
            private String expert_pic;
            private String title;
            private String expert_id;
            private String goodat;
            private String hopital;
            private String depart;
            private String reason;
            private String plus_id;
            private String todate;
            private String plus_week;
            private String plus_halfday;
            private String plus_day;
            private String uname;
            private String is_cancel;
            private String state;
            private String is_get;

            public String getExpert() {
                return expert;
            }

            public void setExpert(String expert) {
                this.expert = expert;
            }

            public String getExpert_pic() {
                return expert_pic;
            }

            public void setExpert_pic(String expert_pic) {
                this.expert_pic = expert_pic;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getExpert_id() {
                return expert_id;
            }

            public void setExpert_id(String expert_id) {
                this.expert_id = expert_id;
            }

            public String getGoodat() {
                return goodat;
            }

            public void setGoodat(String goodat) {
                this.goodat = goodat;
            }

            public String getHopital() {
                return hopital;
            }

            public void setHopital(String hopital) {
                this.hopital = hopital;
            }

            public String getDepart() {
                return depart;
            }

            public void setDepart(String depart) {
                this.depart = depart;
            }

            public String getReason() {
                return reason;
            }

            public void setReason(String reason) {
                this.reason = reason;
            }

            public String getPlus_id() {
                return plus_id;
            }

            public void setPlus_id(String plus_id) {
                this.plus_id = plus_id;
            }

            public String getTodate() {
                return todate;
            }

            public void setTodate(String todate) {
                this.todate = todate;
            }

            public String getPlus_week() {
                return plus_week;
            }

            public void setPlus_week(String plus_week) {
                this.plus_week = plus_week;
            }

            public String getPlus_halfday() {
                return plus_halfday;
            }

            public void setPlus_halfday(String plus_halfday) {
                this.plus_halfday = plus_halfday;
            }

            public String getPlus_day() {
                return plus_day;
            }

            public void setPlus_day(String plus_day) {
                this.plus_day = plus_day;
            }

            public String getUname() {
                return uname;
            }

            public void setUname(String uname) {
                this.uname = uname;
            }

            public String getIs_cancel() {
                return is_cancel;
            }

            public void setIs_cancel(String is_cancel) {
                this.is_cancel = is_cancel;
            }

            public String getState() {
                return state;
            }

            public void setState(String state) {
                this.state = state;
            }

            public String getIs_get() {
                return is_get;
            }

            public void setIs_get(String is_get) {
                this.is_get = is_get;
            }
        }
    }
}
