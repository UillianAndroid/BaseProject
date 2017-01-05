package baseproject.wx.com.baseproject.bean;

/**
 * @Status类，判断数据请求状态 Created by android_wx on 17/1/5.
 */

public class Status {
    public String code;//20000,50000,500001,51003......
    public String message;
    public String no;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    @Override
    public String toString() {
        return "Status:" + "\n" + "code:" + getCode() + "message:" + getMessage() + "no:" + getNo();
    }
}
