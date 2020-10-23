package me.zw.step01.controller;

import lombok.extern.slf4j.Slf4j;
import me.zw.step01.board.BoardVO;
import me.zw.step01.board.impl.BoardDAO;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
public class DeleteBoardController implements Controller {

    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
        log.info("글 삭제 처리");

        // 1. 사용자 입력 정보 추출
        String seq = request.getParameter("seq");

        // 2. DB 연동 처리
        BoardVO vo = new BoardVO();
        vo.setSeq(Integer.parseInt(seq));
        BoardDAO boardDAO = new BoardDAO();
        boardDAO.deleteBoard(vo);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:getBoardList.do");
        return modelAndView;
    }
}
