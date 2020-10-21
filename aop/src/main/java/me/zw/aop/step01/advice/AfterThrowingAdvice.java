package me.zw.aop.step01.advice;

import org.aspectj.lang.JoinPoint;

public class AfterThrowingAdvice {

    public void exceptionLog(JoinPoint joinPoint, Exception exception) {
        String method = joinPoint.getSignature().getName();

        System.out.println("[예외 처리] " + method + "() 메서드 수행 중 발생된 예외 메세지: " + exception.getMessage());
    }
}
