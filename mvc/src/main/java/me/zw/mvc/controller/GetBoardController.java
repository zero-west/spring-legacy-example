package me.zw.mvc.controller;

import lombok.extern.slf4j.Slf4j;
import me.zw.mvc.board.BoardVO;
import me.zw.mvc.board.impl.BoardDAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Slf4j
public class GetBoardController implements Controller {

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        log.info("글 상세 조회 처리");

        String seq = request.getParameter("seq");

        BoardVO boardVO = new BoardVO();
        boardVO.setSeq(Integer.parseInt(seq));

        BoardDAO boardDAO = new BoardDAO();
        BoardVO board = boardDAO.getBoard(boardVO);

        HttpSession session = request.getSession();
        session.setAttribute("board", board);
        return "getBoard";
    }
}
