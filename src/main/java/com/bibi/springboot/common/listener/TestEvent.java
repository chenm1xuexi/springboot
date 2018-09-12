package com.bibi.springboot.common.listener;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"com.bibi.springboot.common.listener"})
public class TestEvent {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext configApplicationContext = new AnnotationConfigApplicationContext(TestEvent.class);
        UserBean userBean = configApplicationContext.getBean(UserBean.class);
        userBean.published();
        configApplicationContext.close();

    }
}
