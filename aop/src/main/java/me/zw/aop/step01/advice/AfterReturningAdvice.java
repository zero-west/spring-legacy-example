package me.zw.aop.step01.advice;

import me.zw.aop.step01.user.UserVO;
import org.aspectj.lang.JoinPoint;

public class AfterReturningAdvice {

    public void afterLog(JoinPoint joinPoint, Object returnObj) {
        String method = joinPoint.getSignature().getName();
        if (returnObj instanceof UserVO) {
            UserVO userVO = (UserVO) returnObj;
            if (userVO.getRole().equals("Admin")) {
                System.out.println(userVO.getName() + " 로그인(Admin)");
            }
        }
        System.out.println("[사후 처리] " + method + "() 메서드 리턴값 : " + returnObj.toString());
    }
}
