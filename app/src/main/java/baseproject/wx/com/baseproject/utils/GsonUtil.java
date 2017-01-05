package baseproject.wx.com.baseproject.utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import baseproject.wx.com.baseproject.bean.Bean;

/**
 * Created by android_wx on 17/1/5.
 */

public class GsonUtil {
    //    传入json.toString()解析成bean;
    public static Bean analyzeJson(String jsonToString) {
        Gson gson = new Gson();
        Bean bean = gson.fromJson(jsonToString, new TypeToken<Bean>() {
        }.getType());
        return bean;
    }
}
