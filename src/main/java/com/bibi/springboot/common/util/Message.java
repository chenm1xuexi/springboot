package com.bibi.springboot.common.util;

import java.util.HashMap;
import java.util.Map;

public class Message {
    private Integer code;
    private String message;
    private Map<String, Object> map = new HashMap<>();

    public Message add(String key, Object value) {
        map.put(key, value);
        return this;
    }

    public static Message success() {
        Message msg = new Message();
        msg.setCode(200);
        msg.setMessage("SUCCESS");
        return msg;
    }

    public static Message error() {
        Message msg = new Message();
        msg.setCode(500);
        msg.setMessage("ERROR");
        return msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Map<String, Object> getMap() {
        return map;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }
}
