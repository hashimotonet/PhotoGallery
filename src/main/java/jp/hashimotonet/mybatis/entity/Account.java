package jp.hashimotonet.mybatis.entity;

import java.util.Date;
import javax.annotation.Generated;

public class Account {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2023-06-22T14:25:50.603+09:00", comments="Source field: account.id")
    private Integer id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2023-06-22T14:25:50.608+09:00", comments="Source field: account.identity")
    private String identity;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2023-06-22T14:25:50.608+09:00", comments="Source field: account.authority")
    private Integer authority;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2023-06-22T14:25:50.608+09:00", comments="Source field: account.created_at")
    private Date createdAt;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2023-06-22T14:25:50.608+09:00", comments="Source field: account.updated_at")
    private Date updatedAt;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2023-06-22T14:25:50.609+09:00", comments="Source field: account.password")
    private String password;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2023-06-22T14:25:50.607+09:00", comments="Source field: account.id")
    public Integer getId() {
        return id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2023-06-22T14:25:50.608+09:00", comments="Source field: account.id")
    public void setId(Integer id) {
        this.id = id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2023-06-22T14:25:50.608+09:00", comments="Source field: account.identity")
    public String getIdentity() {
        return identity;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2023-06-22T14:25:50.608+09:00", comments="Source field: account.identity")
    public void setIdentity(String identity) {
        this.identity = identity;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2023-06-22T14:25:50.608+09:00", comments="Source field: account.authority")
    public Integer getAuthority() {
        return authority;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2023-06-22T14:25:50.608+09:00", comments="Source field: account.authority")
    public void setAuthority(Integer authority) {
        this.authority = authority;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2023-06-22T14:25:50.608+09:00", comments="Source field: account.created_at")
    public Date getCreatedAt() {
        return createdAt;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2023-06-22T14:25:50.608+09:00", comments="Source field: account.created_at")
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2023-06-22T14:25:50.608+09:00", comments="Source field: account.updated_at")
    public Date getUpdatedAt() {
        return updatedAt;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2023-06-22T14:25:50.608+09:00", comments="Source field: account.updated_at")
    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2023-06-22T14:25:50.609+09:00", comments="Source field: account.password")
    public String getPassword() {
        return password;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2023-06-22T14:25:50.609+09:00", comments="Source field: account.password")
    public void setPassword(String password) {
        this.password = password;
    }
}