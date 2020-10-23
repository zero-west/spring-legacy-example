package me.zw.step01.advice;

import me.zw.step01.user.UserVO;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class AfterReturningAdvice {

    @AfterReturning(pointcut = "PointcutCommon.getPointcut()", returning = "returnObj")
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
