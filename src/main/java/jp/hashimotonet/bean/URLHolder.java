/**
 *
 */
package jp.hashimotonet.bean;

/**
 * @author Osamu Hashimoto
 *
 */
public class URLHolder {

    private String url;

    private String thumbnail;

    /**
     * デフォルトコンストラクタ
     */
    public URLHolder() {
        super();
    }

    /**
     * @return url
     */
    public final String getUrl() {
        return url;
    }

    /**
     * @param url セットする url
     */
    public final void setUrl(String url) {
        this.url = url;
    }

    /**
     * @return thumbnail
     */
    public final String getThumbnail() {
        return thumbnail;
    }

    /**
     * @param thumbnail セットする thumbnail
     */
    public final void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

}
