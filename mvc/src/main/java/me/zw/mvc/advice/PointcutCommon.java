package me.zw.mvc.advice;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class PointcutCommon {

    @Pointcut("execution(* me.zw.mvc..*Impl.*(..))")
    public void allPointcut() {
    }

    @Pointcut("execution(* me.zw.mvc..*Impl.get*(..))")
    public void getPointcut() {
    }
}
