package com.bibi.springboot.model;

public class BaseModel {
    private Long lastModifiedTime;

    public Long getLastModifiedTime() {
        return lastModifiedTime == null ? System.currentTimeMillis() : lastModifiedTime;
    }

    public void setLastModifiedTime(Long lastModifiedTime) {
        if (lastModifiedTime == null || lastModifiedTime <= 0) {
            this.lastModifiedTime = System.currentTimeMillis();
        } else {
            this.lastModifiedTime = lastModifiedTime;
        }
    }
}
