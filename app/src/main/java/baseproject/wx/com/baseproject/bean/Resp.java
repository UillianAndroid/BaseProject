package baseproject.wx.com.baseproject.bean;

/**
 * Created by android_wx on 17/1/5.
 */

public class Resp {
    public String city;
    public String updatetime;
    public String wendu;
    public String fengli;
    public String shidu;
    public String fengxiang;
    public String sunrise_1;
    public String sunset_1;
    public String sunrise_2;
    public String sunset_2;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(String updatetime) {
        this.updatetime = updatetime;
    }

    public String getWendu() {
        return wendu;
    }

    public void setWendu(String wendu) {
        this.wendu = wendu;
    }

    public String getFengli() {
        return fengli;
    }

    public void setFengli(String fengli) {
        this.fengli = fengli;
    }

    public String getShidu() {
        return shidu;
    }

    public void setShidu(String shidu) {
        this.shidu = shidu;
    }

    public String getFengxiang() {
        return fengxiang;
    }

    public void setFengxiang(String fengxiang) {
        this.fengxiang = fengxiang;
    }

    public String getSunrise_1() {
        return sunrise_1;
    }

    public void setSunrise_1(String sunrise_1) {
        this.sunrise_1 = sunrise_1;
    }

    public String getSunset_1() {
        return sunset_1;
    }

    public void setSunset_1(String sunset_1) {
        this.sunset_1 = sunset_1;
    }

    public String getSunrise_2() {
        return sunrise_2;
    }

    public void setSunrise_2(String sunrise_2) {
        this.sunrise_2 = sunrise_2;
    }

    public String getSunset_2() {
        return sunset_2;
    }

    public void setSunset_2(String sunset_2) {
        this.sunset_2 = sunset_2;
    }

    @Override
    public String toString() {
        return "城市=" + getCity() + ",最近更新=" + getUpdatetime() + ",温度=" + getWendu() + ",风力=" + getFengli()
                + ",湿度=" + getShidu() + ",风向=" + getFengxiang() + ",日出时间1=" + getSunrise_1() + ",日落时间1="
                + getSunset_1() + ",日出时间2=" + getSunrise_2() + ",日落时间2=" + getSunset_2();
    }
}
