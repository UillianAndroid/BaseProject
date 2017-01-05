package baseproject.wx.com.baseproject.bean;

import java.util.List;

/**
 * @把所有要从接口获得的Data下模型均放入该类中，
 *
 * Created by android_wx on 17/1/5.
 */

public class Data {
    public List<Banners> banners;

    public List<Banners> getBanners() {
        return banners;
    }

    public void setBanners(List<Banners> banners) {
        this.banners = banners;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
