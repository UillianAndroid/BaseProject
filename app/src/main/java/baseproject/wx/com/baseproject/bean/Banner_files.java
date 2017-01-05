package baseproject.wx.com.baseproject.bean;

/**
 * @举例Bean,实际开发时可删除该类
 * @
 * @Created by android_wx on 17/1/5.
 */

public class Banner_files {
    public String id;
    public String title;
    public String sub_title;
    public String image_url;
    public String small_image_url;
    public String content;
    public String banner_id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSub_title() {
        return sub_title;
    }

    public void setSub_title(String sub_title) {
        this.sub_title = sub_title;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public String getSmall_image_url() {
        return small_image_url;
    }

    public void setSmall_image_url(String small_image_url) {
        this.small_image_url = small_image_url;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getBanner_id() {
        return banner_id;
    }

    public void setBanner_id(String banner_id) {
        this.banner_id = banner_id;
    }

    @Override
    public String toString() {
        return "Banner_files:" + ",id=" + getId() + ",title=" + getTitle()
                + ",sub_title=" + getSub_title() + ",image_url=" + getImage_url()
                + ",small_image_url=" + getSmall_image_url() + ",content="
                + getContent() + ",banner_id=" + getBanner_id();
    }
}
