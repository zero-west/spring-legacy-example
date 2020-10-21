package me.zw.aop.step02.board;

import java.util.List;

public interface BoardService {
    void insertBoard(BoardVO boardVO);
    void updateBoard(BoardVO boardVO);
    void deleteBoard(BoardVO boardVO);
    BoardVO getBoard(BoardVO boardVO);
    List<BoardVO> getBoardList(BoardVO boardVO);
}
