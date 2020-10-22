package me.zw.mvc.controller;

import lombok.extern.slf4j.Slf4j;
import me.zw.mvc.user.UserVO;
import me.zw.mvc.user.impl.UserDAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
public class LoginController implements Controller {

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        log.info("로그인 처리");

        String id = request.getParameter("id");
        String password = request.getParameter("password");

        UserVO userVO = new UserVO();
        userVO.setId(id);
        userVO.setPassword(password);

        UserDAO userDAO = new UserDAO();
        UserVO user = userDAO.getUser(userVO);

        if (user != null) {
            return "getBoardList.do";
        } else {
            return "login";
        }
    }
}
