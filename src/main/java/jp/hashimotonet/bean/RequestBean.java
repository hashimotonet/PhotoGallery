package jp.hashimotonet.bean;

import java.io.Serializable;

/**
 * 要求電文をPOJOに置き換えたクラスです。
 *
 * @author Osamu Hashimoto
 *
 */
public class RequestBean implements Serializable {

	/**
	 * ユーザID
	 */
	private String id;

	/**
	 * Base64形式である画像データ
	 */
	private String data;

	public final String getId() {
		return id;
	}

	public final void setId(String id) {
		this.id = id;
	}

	public final String getData() {
		return data;
	}

	public final void setData(String data) {
		this.data = data;
	}

}
