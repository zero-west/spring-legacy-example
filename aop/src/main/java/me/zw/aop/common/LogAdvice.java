package me.zw.aop.common;

import org.aspectj.lang.JoinPoint;

public class LogAdvice {
    public void printLog(JoinPoint joinPoint) {
        System.out.println("[공통 로그] 비즈니스 로직 수행 전 동작");
    }
}
