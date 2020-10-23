package me.zw.step01.controller;

import lombok.extern.slf4j.Slf4j;
import me.zw.step01.board.BoardVO;
import me.zw.step01.board.impl.BoardDAO;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@Slf4j
public class GetBoardListController implements Controller {

    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
        log.info("글 목록 검색 처리");

        BoardVO boardVO = new BoardVO();
        BoardDAO boardDAO = new BoardDAO();
        List<BoardVO> boardList = boardDAO.getBoardList(boardVO);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("boardList", boardList);
        modelAndView.setViewName("getBoardList");
        return modelAndView;
    }
}
