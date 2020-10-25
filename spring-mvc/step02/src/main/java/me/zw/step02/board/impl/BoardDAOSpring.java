package me.zw.step02.board.impl;

import me.zw.step02.board.BoardVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

//@Repository
public class BoardDAOSpring {

    private JdbcTemplate jdbcTemplate;

//    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private final String BOARD_INSERT = "insert into board(seq,title,writer,content) " +
            "values((select nvl(max(seq), 0)+1 from board),?,?,?)";
    private final String BOARD_UPDATE = "update board set title=?, content=? where seq=?";
    private final String BOARD_DELETE = "delete from board where seq=?";
    private final String BOARD_GET = "select * from board where seq=?";
    private final String BOARD_LIST = "select * from board order by seq desc";

    // 글 등록
    public void insertBoard(BoardVO boardVO) {
        System.out.println("===> JDBC 로 insertBoard() 기능 처리");
        jdbcTemplate.update(BOARD_INSERT, boardVO.getTitle(), boardVO.getWriter(), boardVO.getContent());
    }

    // 글 수정
    public void updateBoard(BoardVO boardVO) {
        System.out.println("===> JDBC 로 updateBoard() 기능 처리");
        jdbcTemplate.update(BOARD_UPDATE, boardVO.getTitle(), boardVO.getContent(), boardVO.getSeq());
    }

    // 글 삭제
    public void deleteBoard(BoardVO boardVO) {
        System.out.println("===> JDBC 로 deleteBoard() 기능 처리");
        jdbcTemplate.update(BOARD_DELETE, boardVO.getSeq());
    }

    // 글 상세 조회
    public BoardVO getBoard(BoardVO boardVO) {
        System.out.println("===> JDBC 로 getBoard() 기능 처리");
        Object[] args = {boardVO.getSeq()};
        return jdbcTemplate.queryForObject(BOARD_GET, args, new BoardRowMapper());
    }

    // 글 목록 조회
    public List<BoardVO> getBoardList(BoardVO boardVO) {
        System.out.println("===> JDBC 로 getBoardList() 기능 처리");
        return jdbcTemplate.query(BOARD_LIST, new BoardRowMapper());
    }
}

class BoardRowMapper implements RowMapper<BoardVO> {
    @Override
    public BoardVO mapRow(ResultSet rs, int rowNum) throws SQLException {
        BoardVO board = new BoardVO();
        board.setSeq(rs.getInt("SEQ"));
        board.setTitle(rs.getString("TITLE"));
        board.setWriter(rs.getString("WRITER"));
        board.setContent(rs.getString("CONTENT"));
        board.setRegDate(rs.getDate("REGDATE"));
        board.setCnt(rs.getInt("CNT"));
        return board;
    }
}
