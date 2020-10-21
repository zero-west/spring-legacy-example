package me.zw.aop.step01.board;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BoardServiceTest {
    AbstractApplicationContext applicationContext;

    BoardService boardService;


    @BeforeEach
    void init() {
        applicationContext = new GenericXmlApplicationContext("step01/applicationContext.xml");
        boardService = (BoardService) applicationContext.getBean("boardService");
    }

    @Test
    void 글_등록_테스트() {
        BoardVO boardVO = new BoardVO();
        boardVO.setTitle("temp title");
        boardVO.setWriter("zerowest");
        boardVO.setContent("temp content");
        boardService.insertBoard(boardVO);

        List<BoardVO> boardVOList = boardService.getBoardList(boardVO);
        assertThat(boardVOList.get(0).getContent()).isEqualTo(boardVO.getContent());

        applicationContext.close();
    }

}