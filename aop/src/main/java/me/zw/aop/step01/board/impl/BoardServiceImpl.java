package me.zw.aop.step01.board.impl;

import me.zw.aop.step01.board.BoardService;
import me.zw.aop.step01.board.BoardVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("boardService")
public class BoardServiceImpl implements BoardService {

    private final BoardDAO boardDAO;

    @Autowired
    public BoardServiceImpl(BoardDAO boardDAO) {
        this.boardDAO = boardDAO;
    }

    @Override
    public void insertBoard(BoardVO boardVO) {
        boardDAO.insertBoard(boardVO);
    }

    @Override
    public void updateBoard(BoardVO boardVO) {
        boardDAO.updateBoard(boardVO);
    }

    @Override
    public void deleteBoard(BoardVO boardVO) {
        boardDAO.deleteBoard(boardVO);
    }

    @Override
    public BoardVO getBoard(BoardVO boardVO) {
        return boardDAO.getBoard(boardVO);
    }

    @Override
    public List<BoardVO> getBoardList(BoardVO boardVO) {
        return boardDAO.getBoardList(boardVO);
    }
}
