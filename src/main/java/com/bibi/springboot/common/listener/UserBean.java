package com.bibi.springboot.common.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * 发布类（事件的发布类。通过此类来通知event事件的执行，从而会被监听类所监听到并执行相应的处理方法）
 */
@Component
public class UserBean {

    @Autowired
    private ApplicationContext context;


   public void published() {
       //发布事件
       context.publishEvent(new UserEvent(this, "发布成功"));
   }
}
