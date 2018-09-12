package com.bibi.springboot.common.Enum;

public enum UserEnum {
    IN_ACTIVCE(1), NOT_IN_ACTIVE(2);

    private Integer value;

    private UserEnum(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return this.value;
    }

}
