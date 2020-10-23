package me.zw.step01.controller;

import lombok.extern.slf4j.Slf4j;
import me.zw.step01.board.BoardVO;
import me.zw.step01.board.impl.BoardDAO;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
public class UpdateBoardController implements Controller {

    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
        log.info("글 등록 처리");

        // 1. 사용자 입력 정보 추출
        String title = request.getParameter("title");
        String writer = request.getParameter("writer");
        String content = request.getParameter("content");

        // 2. DB 연동 처리
        BoardVO vo = new BoardVO();
        vo.setTitle(title);
        vo.setWriter(writer);
        vo.setContent(content);
        BoardDAO boardDAO = new BoardDAO();
        boardDAO.insertBoard(vo);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:getBoardList");
        return modelAndView;
    }
}
