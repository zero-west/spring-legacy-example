package me.zw.model2.advice;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class PointcutCommon {

    @Pointcut("execution(* me.zw.model2.step01..*Impl.*(..))")
    public void allPointcut() {
    }

    @Pointcut("execution(* me.zw.model2.step01..*Impl.get*(..))")
    public void getPointcut() {
    }
}
