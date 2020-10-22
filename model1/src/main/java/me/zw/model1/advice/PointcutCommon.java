package me.zw.model1.advice;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class PointcutCommon {

    @Pointcut("execution(* me.zw.model1..*Impl.*(..))")
    public void allPointcut() {
    }

    @Pointcut("execution(* me.zw.model1..*Impl.get*(..))")
    public void getPointcut() {
    }
}
