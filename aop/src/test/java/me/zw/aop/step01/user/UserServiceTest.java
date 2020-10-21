package me.zw.aop.step01.user;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

class UserServiceTest {

    AbstractApplicationContext applicationContext;

    UserService userService;

    @BeforeEach
    void init() {
        applicationContext = new GenericXmlApplicationContext("step01/applicationContext.xml");
        userService = (UserService) applicationContext.getBean("userService");
    }

    @Test
    void 로그인_기능_테스트() {
        UserVO userVO = new UserVO();
        userVO.setId("test");
        userVO.setPassword("test123");

        UserVO user = userService.getUser(userVO);
        if (user != null) {
            System.out.println(user.getName() + "님 환영합니다");
        } else {
            System.out.println("로그인 실패");
        }

        applicationContext.close();
    }
}
