package me.zw.step02.advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class AfterThrowingAdvice {

    @Pointcut("execution(* me.zw.step02..*Impl.*(..))")
    public void allPointcut() {
    }

    @AfterThrowing(pointcut = "allPointcut()", throwing = "exception")
    public void exceptionLog(JoinPoint joinPoint, Exception exception) {
        String method = joinPoint.getSignature().getName();

        System.out.println("[예외 처리] " + method + "() 메서드 수행 중 발생된 예외 메세지: " + exception.getMessage());
    }
}
