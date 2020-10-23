package me.zw.step01.controller;

import lombok.extern.slf4j.Slf4j;
import me.zw.step01.board.BoardVO;
import me.zw.step01.board.impl.BoardDAO;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
public class GetBoardController implements Controller {

    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
        log.info("글 상세 조회 처리");

        String seq = request.getParameter("seq");

        BoardVO boardVO = new BoardVO();
        boardVO.setSeq(Integer.parseInt(seq));

        BoardDAO boardDAO = new BoardDAO();
        BoardVO board = boardDAO.getBoard(boardVO);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("board", board);
        modelAndView.setViewName("getBoard");
        return modelAndView;
    }
}
