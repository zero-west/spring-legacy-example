package me.zw.aop.common;

import org.aspectj.lang.JoinPoint;

public class BeforeAdvice {
    public void beforeLog(JoinPoint joinPoint) {
        String method = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();

        System.out.println("[사전 처리] " + method + "() 메서드 args 정보: " + args[0].toString());
    }
}
