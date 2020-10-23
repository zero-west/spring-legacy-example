package me.zw.step01.controller;

import lombok.extern.slf4j.Slf4j;
import me.zw.step01.user.UserVO;
import me.zw.step01.user.impl.UserDAO;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
public class LoginController implements Controller {

    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
        log.info("로그인 처리");

        String id = request.getParameter("id");
        String password = request.getParameter("password");

        UserVO userVO = new UserVO();
        userVO.setId(id);
        userVO.setPassword(password);

        UserDAO userDAO = new UserDAO();
        UserVO user = userDAO.getUser(userVO);

        ModelAndView modelAndView = new ModelAndView();
        if (user != null) {
            modelAndView.setViewName("redirect:getBoardList.do");
        } else {
            modelAndView.setViewName("redirect:login.jsp");
        }
        return modelAndView;
    }
}
