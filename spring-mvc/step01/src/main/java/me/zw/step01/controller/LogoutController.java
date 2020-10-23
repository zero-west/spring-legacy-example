package me.zw.step01.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Slf4j
public class LogoutController implements Controller {

    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
        log.info("로그아웃 처리");

        HttpSession session = request.getSession();
        session.invalidate();

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:login.jsp");
        return modelAndView;
    }
}
