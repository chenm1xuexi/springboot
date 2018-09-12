package com.bibi.springboot.model;

import com.bibi.springboot.common.Enum.UserEnum;
import com.bibi.springboot.common.Enum.UserStatusEnum;

public class User extends BaseModel {
    private Long userId;
    private String userName;
    private String password;
    private Long createTime;
    private UserEnum isDeleted;
    private UserStatusEnum status;

    public UserStatusEnum getStatus() {
        return status;
    }

    public void setStatus(UserStatusEnum status) {
        this.status = status;
    }

    public UserEnum getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(UserEnum isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getCreateTime() {
        return createTime == null ? System.currentTimeMillis() : createTime;
    }

    public void setCreateTime(Long createTime) {
        if (createTime == null || createTime <= 0) {
            this.createTime = System.currentTimeMillis();
        } else {
            this.createTime = createTime;
        }
    }
}
