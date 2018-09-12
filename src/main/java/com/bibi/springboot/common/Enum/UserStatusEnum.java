package com.bibi.springboot.common.Enum;

public enum UserStatusEnum {
    BIBI("BIBI"), LALA("LALA"), HAHA("HAHA");

    private String value;

    private UserStatusEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
