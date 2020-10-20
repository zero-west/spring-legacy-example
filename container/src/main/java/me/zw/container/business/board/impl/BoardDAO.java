package me.zw.container.business.board.impl;

import me.zw.container.business.board.BoardVO;
import me.zw.container.business.common.JDBCUtil;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Repository
public class BoardDAO {

    private Connection connection = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

    private final String BOARD_INSERT = "insert into board(seq,title,writer,content) " +
            "values((select nvl(max(seq), 0)+1 from board),?,?,?)";
    private final String BOARD_UPDATE = "update board set title=?, content=? where seq=?";
    private final String BOARD_DELETE = "delete from board where seq=?";
    private final String BOARD_GET = "select * from board where seq=?";
    private final String BOARD_LIST = "select * from board order by seq desc";

    // 글 등록
    public void insertBoard(BoardVO boardVO) {
        System.out.println("===> JDBC 로 insertBoard() 기능 처리");

        try {
            connection = JDBCUtil.getConnection();
            preparedStatement = connection.prepareStatement(BOARD_INSERT);
            preparedStatement.setString(1, boardVO.getTitle());
            preparedStatement.setString(2, boardVO.getWriter());
            preparedStatement.setString(3, boardVO.getContent());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(preparedStatement, connection);
        }
    }

    // 글 수정
    public void updateBoard(BoardVO boardVO) {
        System.out.println("===> JDBC 로 updateBoard() 기능 처리");

        try {
            connection = JDBCUtil.getConnection();
            preparedStatement = connection.prepareStatement(BOARD_UPDATE);
            preparedStatement.setString(1, boardVO.getTitle());
            preparedStatement.setString(2, boardVO.getContent());
            preparedStatement.setInt(3, boardVO.getSeq());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(preparedStatement, connection);
        }
    }

    // 글 삭제
    public void deleteBoard(BoardVO boardVO) {
        System.out.println("===> JDBC 로 deleteBoard() 기능 처리");

        try {
            connection = JDBCUtil.getConnection();
            preparedStatement = connection.prepareStatement(BOARD_DELETE);
            preparedStatement.setInt(1, boardVO.getSeq());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(preparedStatement, connection);
        }
    }

    // 글 상세 조회
    public BoardVO getBoard(BoardVO boardVO) {
        System.out.println("===> JDBC 로 getBoard() 기능 처리");

        BoardVO board = null;
        try {
            connection = JDBCUtil.getConnection();
            preparedStatement = connection.prepareStatement(BOARD_GET);
            preparedStatement.setInt(1, boardVO.getSeq());
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                board = new BoardVO();
                board.setSeq(resultSet.getInt("SEQ"));
                board.setTitle(resultSet.getString("TITLE"));
                board.setWriter(resultSet.getString("WRITER"));
                board.setContent(resultSet.getString("CONTENT"));
                board.setRegDate(resultSet.getDate("REGDATE"));
                board.setCnt(resultSet.getInt("CNT"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(resultSet, preparedStatement, connection);
        }
        return board;
    }

    // 글 목록 조회
    public List<BoardVO> getBoardList(BoardVO boardVO) {
        System.out.println("===> JDBC로 getBoardList() 기능 처리");

        List<BoardVO> boardList = new ArrayList<>();
        try {
            connection = JDBCUtil.getConnection();
            preparedStatement = connection.prepareStatement(BOARD_LIST);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                BoardVO board = new BoardVO();
                board.setSeq(resultSet.getInt("SEQ"));
                board.setTitle(resultSet.getString("TITLE"));
                board.setWriter(resultSet.getString("WRITER"));
                board.setContent(resultSet.getString("CONTENT"));
                board.setRegDate(resultSet.getDate("REGDATE"));
                board.setCnt(resultSet.getInt("CNT"));
                boardList.add(board);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(resultSet, preparedStatement, connection);
        }
        return boardList;
    }
}
