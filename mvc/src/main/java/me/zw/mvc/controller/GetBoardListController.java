package me.zw.mvc.controller;

import lombok.extern.slf4j.Slf4j;
import me.zw.mvc.board.BoardVO;
import me.zw.mvc.board.impl.BoardDAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@Slf4j
public class GetBoardListController implements Controller {

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        log.info("글 목록 검색 처리");

        BoardVO boardVO = new BoardVO();
        BoardDAO boardDAO = new BoardDAO();
        List<BoardVO> boardList = boardDAO.getBoardList(boardVO);

        HttpSession session = request.getSession();
        session.setAttribute("boardList", boardList);
        return "getBoardList";
    }
}
