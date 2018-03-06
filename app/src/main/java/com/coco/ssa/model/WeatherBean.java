package com.coco.ssa.model;

import java.util.List;

/**
 * Created by Hoyn on 17/3/24.
 */

public class WeatherBean {

    /**
     * desc : OK
     * status : 1000
     * data : {"wendu":"24","ganmao":"各项气象条件适宜，无明显降温过程，发生感冒机率较低。","forecast":[{"fengxiang":"无持续风向","fengli":"微风级","high":"高温 27℃","type":"多云","low":"低温 20℃","date":"24日星期五"},{"fengxiang":"无持续风向","fengli":"微风级","high":"高温 24℃","type":"阵雨","low":"低温 17℃","date":"25日星期六"},{"fengxiang":"东北风","fengli":"3-4级","high":"高温 17℃","type":"雷阵雨","low":"低温 14℃","date":"26日星期天"},{"fengxiang":"东北风","fengli":"3-4级","high":"高温 21℃","type":"多云","low":"低温 16℃","date":"27日星期一"},{"fengxiang":"无持续风向","fengli":"微风级","high":"高温 23℃","type":"多云","low":"低温 18℃","date":"28日星期二"}],"yesterday":{"fl":"微风","fx":"无持续风向","high":"高温 26℃","type":"多云","low":"低温 20℃","date":"23日星期四"},"aqi":"53","city":"深圳"}
     */

    private String desc;
    private int status;
    private DataBean data;

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * wendu : 24
         * ganmao : 各项气象条件适宜，无明显降温过程，发生感冒机率较低。
         * forecast : [{"fengxiang":"无持续风向","fengli":"微风级","high":"高温 27℃","type":"多云","low":"低温 20℃","date":"24日星期五"},{"fengxiang":"无持续风向","fengli":"微风级","high":"高温 24℃","type":"阵雨","low":"低温 17℃","date":"25日星期六"},{"fengxiang":"东北风","fengli":"3-4级","high":"高温 17℃","type":"雷阵雨","low":"低温 14℃","date":"26日星期天"},{"fengxiang":"东北风","fengli":"3-4级","high":"高温 21℃","type":"多云","low":"低温 16℃","date":"27日星期一"},{"fengxiang":"无持续风向","fengli":"微风级","high":"高温 23℃","type":"多云","low":"低温 18℃","date":"28日星期二"}]
         * yesterday : {"fl":"微风","fx":"无持续风向","high":"高温 26℃","type":"多云","low":"低温 20℃","date":"23日星期四"}
         * aqi : 53
         * city : 深圳
         */

        private String wendu;
        private String ganmao;
        private YesterdayBean yesterday;
        private String aqi;
        private String city;
        private List<ForecastBean> forecast;

        public String getWendu() {
            return wendu;
        }

        public void setWendu(String wendu) {
            this.wendu = wendu;
        }

        public String getGanmao() {
            return ganmao;
        }

        public void setGanmao(String ganmao) {
            this.ganmao = ganmao;
        }

        public YesterdayBean getYesterday() {
            return yesterday;
        }

        public void setYesterday(YesterdayBean yesterday) {
            this.yesterday = yesterday;
        }

        public String getAqi() {
            return aqi;
        }

        public void setAqi(String aqi) {
            this.aqi = aqi;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public List<ForecastBean> getForecast() {
            return forecast;
        }

        public void setForecast(List<ForecastBean> forecast) {
            this.forecast = forecast;
        }

        public static class YesterdayBean {
            /**
             * fl : 微风
             * fx : 无持续风向
             * high : 高温 26℃
             * type : 多云
             * low : 低温 20℃
             * date : 23日星期四
             */

            private String fl;
            private String fx;
            private String high;
            private String type;
            private String low;
            private String date;

            public String getFl() {
                return fl;
            }

            public void setFl(String fl) {
                this.fl = fl;
            }

            public String getFx() {
                return fx;
            }

            public void setFx(String fx) {
                this.fx = fx;
            }

            public String getHigh() {
                return high;
            }

            public void setHigh(String high) {
                this.high = high;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getLow() {
                return low;
            }

            public void setLow(String low) {
                this.low = low;
            }

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }
        }

        public static class ForecastBean {
            /**
             * fengxiang : 无持续风向
             * fengli : 微风级
             * high : 高温 27℃
             * type : 多云
             * low : 低温 20℃
             * date : 24日星期五
             */

            private String fengxiang;
            private String fengli;
            private String high;
            private String type;
            private String low;
            private String date;

            public String getFengxiang() {
                return fengxiang;
            }

            public void setFengxiang(String fengxiang) {
                this.fengxiang = fengxiang;
            }

            public String getFengli() {
                return fengli;
            }

            public void setFengli(String fengli) {
                this.fengli = fengli;
            }

            public String getHigh() {
                return high;
            }

            public void setHigh(String high) {
                this.high = high;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getLow() {
                return low;
            }

            public void setLow(String low) {
                this.low = low;
            }

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }
        }
    }
}
