package baseproject.wx.com.baseproject.xml;

import android.util.Xml;

import org.xmlpull.v1.XmlPullParser;

import java.io.InputStream;

import baseproject.wx.com.baseproject.bean.Resp;
import baseproject.wx.com.baseproject.interf.RespParser;

/**
 * Created by android_wx on 17/1/5.
 */

public class PullRespPraser implements RespParser {

    @Override
    public Resp parse(InputStream is) throws Exception {
        Resp resp = null;
        XmlPullParser parser = Xml.newPullParser();
        parser.setInput(is, "UTF-8");
        int eventType = parser.getEventType();
        while (eventType != XmlPullParser.END_DOCUMENT) {
            switch (eventType) {
                case XmlPullParser.START_DOCUMENT:
                    resp = new Resp();
                    break;
                case XmlPullParser.START_TAG:
                    if (parser.getName().equals("resp")) {
                        resp = new Resp();
                    } else if (parser.getName().equals("city")) {
                        eventType = parser.next();
                        resp.setCity(parser.getText());
                    } else if (parser.getName().equals("updatetime")) {
                        eventType = parser.next();
                        resp.setUpdatetime(parser.getText());
                    } else if (parser.getName().equals("wendu")) {
                        eventType = parser.next();
                        resp.setWendu(parser.getText());
                    } else if (parser.getName().equals("fengli")) {
                        eventType = parser.next();
                        resp.setFengli(parser.getText());
                    } else if (parser.getName().equals("shidu")) {
                        eventType = parser.next();
                        resp.setShidu(parser.getText());
                    } else if (parser.getName().equals("fengxiang")) {
                        eventType = parser.next();
                        resp.setFengxiang(parser.getText());
                    } else if (parser.getName().equals("sunrise_1")) {
                        eventType = parser.next();
                        resp.setSunrise_1(parser.getText());
                    } else if (parser.getName().equals("sunset_1")) {
                        eventType = parser.next();
                        resp.setSunset_1(parser.getText());
                    } else if (parser.getName().equals("sunrise_2")) {
                        eventType = parser.next();
                        resp.setSunrise_2(parser.getText());
                    } else if (parser.getName().equals("sunset_2")) {
                        eventType = parser.next();
                        resp.setSunset_2(parser.getText());
                    }
                    break;
                case XmlPullParser.END_TAG:
//                    用于数组形式最后一个判断完add对象
                    break;
            }
            eventType = parser.next();
        }
        return resp;
    }

    @Override
    public String serialize(Resp resp) throws Exception {
        return null;
    }
}
