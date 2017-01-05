package baseproject.wx.com.baseproject.interf;

import java.io.InputStream;

import baseproject.wx.com.baseproject.bean.Resp;

/**
 * Created by android_wx on 17/1/5.
 */

public interface RespParser {

    public Resp parse(InputStream is) throws Exception;

    public String serialize(Resp resp) throws Exception;
}
