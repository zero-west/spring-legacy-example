package me.zw.aop.springjdbc.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class AroundAdvice {

    @Pointcut("execution(* me.zw.aop.springjdbc..*Impl.*(..))")
    public void allPointcut() {
    }

    @Around("allPointcut()")
    public Object aroundLog(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("[BEFORE]: 비즈니스 메서드 수행 전에 처리할 내용...");
        Object returnObj = proceedingJoinPoint.proceed();
        System.out.println("[AFTER]: 비즈니스 메서드 수행 후에 처리할 내용...");
        return returnObj;
    }
}
