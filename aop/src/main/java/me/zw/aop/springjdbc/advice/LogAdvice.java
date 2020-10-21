package me.zw.aop.springjdbc.advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class LogAdvice {
    @Pointcut("execution(* me.zw.aop.springjdbc..*Impl.*(..))")
    public void allPointcut() {
    }

    @Before("allPointcut()")
    public void printLog(JoinPoint joinPoint) {
        System.out.println("[공통 로그] 비즈니스 로직 수행 전 동작");
    }
}
