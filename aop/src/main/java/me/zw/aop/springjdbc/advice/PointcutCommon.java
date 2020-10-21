package me.zw.aop.springjdbc.advice;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class PointcutCommon {

    @Pointcut("execution(* me.zw.aop.springjdbc..*Impl.*(..))")
    public void allPointcut() {
    }

    @Pointcut("execution(* me.zw.aop.springjdbc..*Impl.get*(..))")
    public void getPointcut() {
    }
}
