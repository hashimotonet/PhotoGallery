/**
 *
 */
package jp.hashimotonet.bean.json;

/**
 * @author Osamu Hashimoto
 */
public class ResponseBean {

    /**
     * 処理結果応答値
     */
    private String result;

    /**
     * @return result
     */
    public final String getResult() {
        return result;
    }

    /**
     * @param result セットする result
     */
    public final void setResult(String result) {
        this.result = result;
    }
}
