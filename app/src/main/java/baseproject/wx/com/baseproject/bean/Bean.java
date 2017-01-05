package baseproject.wx.com.baseproject.bean;

/**
 * @因采用Gson解析方法，解析所有网络方法均使用该类
 * @
 * @使用方法：
 * @Gson gson = new Gson();
 * @Bean bean = gson.fromJson(s, new TypeToken<Bean>(){}.getType());
 * @Log.d("HTTP", bean.getData().getBanners().get(0).getId() + "***" + bean.getData().getBanners().get(0).getUsage() + "***" + bean.getData().getBanners().get(0).getStatus());
 * <p>
 * @注：是否命名为Data根据接口返回数据字段定义
 * @Created by android_wx on 17/1/5.
 */

public class Bean {
    public Status status;
    public Data data;

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }
}
