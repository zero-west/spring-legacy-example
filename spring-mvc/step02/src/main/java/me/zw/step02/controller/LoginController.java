package me.zw.step02.controller;

import lombok.extern.slf4j.Slf4j;
import me.zw.step02.user.UserVO;
import me.zw.step02.user.impl.UserDAO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Slf4j
@Controller
public class LoginController {

    @RequestMapping(value = "/login.do", method = RequestMethod.POST)
    public String login(UserVO userVO, UserDAO userDAO, HttpSession httpSession) {
        log.info("로그인 처리");

        UserVO user = userDAO.getUser(userVO);
        if (user!= null){
            httpSession.setAttribute("userName", user.getName());
            return "getBoardList.do";
        }
        else return "login.jsp";
    }

    @RequestMapping(value = "/login.do", method = RequestMethod.GET)
    public String loginView(@ModelAttribute("userVO") UserVO userVO) {
        log.info("로그인 화면으로 이동");
        userVO.setId("test");
        userVO.setPassword("test123");
        return "login.jsp";
    }
}
