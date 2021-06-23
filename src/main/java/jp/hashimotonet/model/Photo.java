package jp.hashimotonet.model;

import java.util.Date;

public class Photo {
	
	/**
	 * id
	 */
	private int id;

    /**
     * ユーザの識別子
     */
    private String identity;

    /**
     * ユーザの権限
     */
    private int authority;

    /**
     * 画像データ
     */
    private byte[] data;

    /**
     * サムネイル画像データ
     */
    private byte[] thumnail;
    
    /**
     * alt テキスト
     */
    private String alt;

    /**
     * 作成日
     *
     * 当項目は、MySQLでは自動採番で操作されるため、
     * 未使用である。
     *
     * @deprecated
     */
    @Deprecated
    private Date createdAt;

    /**
     * 更新日
     *
     * 当項目は、MySQLでは自動採番で操作されるため、
     * 未使用である。
     *
     * @deprecated
     */
    @Deprecated
    private Date updatedAt;

    /**
     * デフォルトコンストラクタ
     */
    public Photo() {

    }

    /**
	 * @return id
	 */
	public final int getId() {
		return id;
	}

	/**
	 * @param id セットする id
	 */
	public final void setId(int id) {
		this.id = id;
	}

	/**
     * @return identity
     */
    public String getIdentity() {
        return identity;
    }

    /**
     * @param identity セットする identity
     */
    public void setIdentity(String identity) {
        this.identity = identity;
    }

    /**
     * @return authority
     */
    public int getAuthority() {
        return authority;
    }

    /**
     * @param authority セットする authority
     */
    public void setAuthority(int authority) {
        this.authority = authority;
    }

    /**
     * @return data
     */
    public byte[] getData() {
        return data;
    }

    /**
     * @param data セットする data
     */
    public void setData(byte[] data) {
        this.data = data;
    }

    /**
     * @return thumnail
     */
    public final byte[] getThumnail() {
        return thumnail;
    }

    /**
     * @param thumnail セットする thumnail
     */
    public final void setThumnail(byte[] thumnail) {
        this.thumnail = thumnail;
    }

    /**
	 * @return alt
	 */
	public final String getAlt() {
		return alt;
	}

	/**
	 * @param alt セットする alt
	 */
	public final void setAlt(String alt) {
		this.alt = alt;
	}

	/**
     * @return createdAt
     */
    public Date getCreatedAt() {
        return createdAt;
    }

    /**
     * @param createdAt セットする createdAt
     */
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * @return updatedAt
     */
    public Date getUpdatedAt() {
        return updatedAt;
    }

    /**
     * @param updatedAt セットする updatedAt
     */
    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

}
