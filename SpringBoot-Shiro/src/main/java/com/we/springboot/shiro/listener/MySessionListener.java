package com.we.springboot.shiro.listener;

import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.SessionListenerAdapter;
import org.springframework.stereotype.Component;


@Component
@Slf4j
public class MySessionListener extends SessionListenerAdapter {
    @Override
    public void onStart(Session session) {
        //会话创建时触发
        log.info("会话创建***************************：" + session.getId());

    }

    @Override
    public void onExpiration(Session session) {
        //会话过期时触发
        log.info("会话过期***************************：" + session.getId());
    }

    @Override
    public void onStop(Session session) {
        //退出时触发
        log.info("会话停止***************************：" + session.getId());
    }
}

