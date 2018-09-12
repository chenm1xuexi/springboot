package com.bibi.springboot.common.Enum;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public enum RoleEnum {

    CHILDRERN(0), BOY(1), GIRL(2), MAN(3), WOMAN(4);

    private Integer value;

    private RoleEnum(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        RoleEnum roleEnum = Enum.valueOf(RoleEnum.class, "BOY");
        System.out.println(roleEnum.ordinal());
        System.out.println(roleEnum.getValue());
        System.out.println(roleEnum.name());
        roleEnum.valueOf("bibi");
        RoleEnum.values();
        Class clazz = RoleEnum.class;
        Method method = clazz.getMethod("values");
        method.invoke(null);
    }
}
