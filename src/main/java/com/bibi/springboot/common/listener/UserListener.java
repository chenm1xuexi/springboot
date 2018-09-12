package com.bibi.springboot.common.listener;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * 监听类（对事件进行监听，当事件执行时，则被监听到，事件执行完后执行监听器的处理方法）
 */
@Component
public class UserListener implements ApplicationListener<UserEvent> {

    //对消息进行接收处理
    @Override
    public void onApplicationEvent(UserEvent userEvent) {
        System.out.println("userEvent:" + userEvent.getMessage());
    }
}
