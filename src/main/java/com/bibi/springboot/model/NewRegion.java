package com.bibi.springboot.model;

public class NewRegion {
    private String regionCode;
    private String regionName;
    private String parentCode;
    private String fullName;
    private Integer level;

    public String getRegionCode() {
        return regionCode;
    }

    public void setRegionCode(String regionCode) {
        this.regionCode = regionCode;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public String getParentCode() {
        return parentCode;
    }

    public void setParentCode(String parentCode) {
        this.parentCode = parentCode;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "{" +
                "regionCode:'" + regionCode + '\'' +
                ", regionName:'" + regionName + '\'' +
                ", parentCode:'" + parentCode + '\'' +
                ", fullName:'" + fullName + '\'' +
                ", level:" + level +
                '}';
    }
}
