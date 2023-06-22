package jp.hashimotonet.mybatis.entity;

import java.util.Date;
import javax.annotation.Generated;

public class Photo {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2023-06-22T14:25:50.632+09:00", comments="Source field: photo.id")
    private Integer id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2023-06-22T14:25:50.633+09:00", comments="Source field: photo.identity")
    private String identity;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2023-06-22T14:25:50.633+09:00", comments="Source field: photo.authority")
    private Integer authority;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2023-06-22T14:25:50.633+09:00", comments="Source field: photo.alt")
    private String alt;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2023-06-22T14:25:50.633+09:00", comments="Source field: photo.created_at")
    private Date createdAt;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2023-06-22T14:25:50.633+09:00", comments="Source field: photo.updated_at")
    private Date updatedAt;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2023-06-22T14:25:50.634+09:00", comments="Source field: photo.data")
    private byte[] data;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2023-06-22T14:25:50.634+09:00", comments="Source field: photo.thumbnail")
    private byte[] thumbnail;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2023-06-22T14:25:50.633+09:00", comments="Source field: photo.id")
    public Integer getId() {
        return id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2023-06-22T14:25:50.633+09:00", comments="Source field: photo.id")
    public void setId(Integer id) {
        this.id = id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2023-06-22T14:25:50.633+09:00", comments="Source field: photo.identity")
    public String getIdentity() {
        return identity;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2023-06-22T14:25:50.633+09:00", comments="Source field: photo.identity")
    public void setIdentity(String identity) {
        this.identity = identity;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2023-06-22T14:25:50.633+09:00", comments="Source field: photo.authority")
    public Integer getAuthority() {
        return authority;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2023-06-22T14:25:50.633+09:00", comments="Source field: photo.authority")
    public void setAuthority(Integer authority) {
        this.authority = authority;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2023-06-22T14:25:50.633+09:00", comments="Source field: photo.alt")
    public String getAlt() {
        return alt;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2023-06-22T14:25:50.633+09:00", comments="Source field: photo.alt")
    public void setAlt(String alt) {
        this.alt = alt;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2023-06-22T14:25:50.633+09:00", comments="Source field: photo.created_at")
    public Date getCreatedAt() {
        return createdAt;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2023-06-22T14:25:50.633+09:00", comments="Source field: photo.created_at")
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2023-06-22T14:25:50.633+09:00", comments="Source field: photo.updated_at")
    public Date getUpdatedAt() {
        return updatedAt;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2023-06-22T14:25:50.633+09:00", comments="Source field: photo.updated_at")
    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2023-06-22T14:25:50.634+09:00", comments="Source field: photo.data")
    public byte[] getData() {
        return data;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2023-06-22T14:25:50.634+09:00", comments="Source field: photo.data")
    public void setData(byte[] data) {
        this.data = data;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2023-06-22T14:25:50.634+09:00", comments="Source field: photo.thumbnail")
    public byte[] getThumbnail() {
        return thumbnail;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2023-06-22T14:25:50.634+09:00", comments="Source field: photo.thumbnail")
    public void setThumbnail(byte[] thumbnail) {
        this.thumbnail = thumbnail;
    }
}