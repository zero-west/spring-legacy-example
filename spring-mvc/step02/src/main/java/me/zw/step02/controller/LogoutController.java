package me.zw.step02.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Slf4j
@Controller
public class LogoutController {

    @RequestMapping("/logout.do")
    public String logout(HttpSession session) {
        log.info("로그아웃 처리");

        session.invalidate();
        return "login.jsp";
    }
}
