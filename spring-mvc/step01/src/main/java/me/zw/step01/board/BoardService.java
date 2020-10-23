package me.zw.step01.board;

import java.util.List;

public interface BoardService {
    void insertBoard(BoardVO boardVO);
    void updateBoard(BoardVO boardVO);
    void deleteBoard(BoardVO boardVO);
    BoardVO getBoard(BoardVO boardVO);
    List<BoardVO> getBoardList(BoardVO boardVO);
}
