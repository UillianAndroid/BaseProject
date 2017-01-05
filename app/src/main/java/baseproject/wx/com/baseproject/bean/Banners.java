package baseproject.wx.com.baseproject.bean;

import java.util.List;

/**
 * @举例Bean,实际开发时可删除该类
 * @
 * @Created by android_wx on 17/1/5.
 */

public class Banners {
    public String id;
    public String usage;
    public String status;
    public List<Banner_files> banner_files;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsage() {
        return usage;
    }

    public void setUsage(String usage) {
        this.usage = usage;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Banner_files> getBanner_files() {
        return banner_files;
    }

    public void setBanner_files(List<Banner_files> banner_files) {
        this.banner_files = banner_files;
    }

    @Override
    public String toString() {
        String str = "Banners" + ",id=" + getId() + ",usage=" + getUsage() + ",status=" + getStatus();
        for (int i = 0; i < getBanner_files().size(); i++) {
            str = str + "banner_files" + i + "," + getBanner_files().get(i).toString();
        }
        return str.toString();
    }
}
