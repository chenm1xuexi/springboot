package com.bibi.springboot;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TestJSONObject {

    /**
     * json字符串转对象
     */
    @Test
    public void jsonToObject() throws IOException {
        //json字符串转对象
        String str = "{\"name\" : \"bibi\", \"age\" : \"12\", \"address\" : \"湖北武汉\"}";
        ObjectMapper objectMapper = new ObjectMapper();
        User user = objectMapper.readValue(str, User.class);
        System.out.println(user);

        //json字符串数组转对象集合
        String strArr = "[{\"name\":\"zhangsan\",\"age\":20,\"address\":\"湖北南昌\"},{\"name\":\"bibi\",\"age\":18,\"address\":\"湖北武汉\"},{\"name\":\"bibi\",\"age\":18,\"address\":\"湖北武汉\"},{\"name\":\"bibi\",\"age\":18,\"address\":\"湖北武汉\"}]";
        List<User> list = objectMapper.readValue(strArr, new TypeReference<List<User>>(){});
        System.out.println(list);
    }

    /**
     * 对象转json字符串
     */
    @Test
    public void objectToJson() throws JsonProcessingException {
        User user = new User();
        user.setName("zhangsan");
        user.setAddress("湖北南昌");
        user.setAge(20);

        User user1 = new User();
        user1.setName("bibi");
        user1.setAddress("湖北武汉");
        user1.setAge(18);

        //单个对象转json字符串
        ObjectMapper objectMapper = new ObjectMapper();
        String str = objectMapper.writeValueAsString(user);
        System.out.println(str);

        //集合转json字符串
        List<User> list = new ArrayList<>();
        list.add(user);
        list.add(user);
        list.add(user);
        list.add(user1);
        list.add(user1);
        list.add(user1);
        String str1 = objectMapper.writeValueAsString(list);
        System.out.println(str1);
    }


}
