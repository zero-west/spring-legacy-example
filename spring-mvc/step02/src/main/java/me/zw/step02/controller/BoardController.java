package me.zw.step02.controller;

import lombok.extern.slf4j.Slf4j;
import me.zw.step02.board.BoardVO;
import me.zw.step02.board.impl.BoardDAO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Controller
@SessionAttributes("board")
public class BoardController {

    @ModelAttribute
    public Map<String, String> searchConditionMap() {
        Map<String, String> conditionMap = new HashMap<>();
        conditionMap.put("제목", "TITLE");
        conditionMap.put("내용", "CONTENT");
        return conditionMap;
    }

    // 글 등록
    @RequestMapping(value = "/insertBoard.do")
    public String insertBoard(BoardVO boardVO, BoardDAO boardDAO) {
        log.info("글 등록 처리");

        boardDAO.insertBoard(boardVO);
        return "getBoardList.do";
    }

    // 글 수정
    @RequestMapping("/updateBoard.do")
    public String updateBoard(@ModelAttribute("board") BoardVO boardVO, BoardDAO boardDAO) {
        log.info("글 업데이트 처리");
        log.info("번호: " + boardVO.getSeq());
        log.info("제목: " + boardVO.getTitle());
        log.info("작성자: " + boardVO.getWriter());
        log.info("내용: " + boardVO.getContent());
        log.info("등록일: " + boardVO.getRegDate());
        log.info("조회수: " + boardVO.getCnt());

        boardDAO.updateBoard(boardVO);
        return "getBoardList.do";
    }

    // 글 삭제
    @RequestMapping("/deleteBoard.do")
    public String deleteBoard(BoardVO boardVO, BoardDAO boardDAO) {
        boardDAO.deleteBoard(boardVO);
        return "getBoardList.do";
    }

    // 글 상세 조회
    @RequestMapping("/getBoard.do")
    public String getBoard(BoardVO boardVO, BoardDAO boardDAO, Model model) {
        log.info("글 상세 조회 처리");

        model.addAttribute("board", boardDAO.getBoard(boardVO));
        return "getBoard.jsp";
    }

    // 글 목록 검색
    @RequestMapping("/getBoardList.do")
    public String getBoardList(
            @RequestParam(value = "searchCondition", defaultValue = "TITLE", required = false) String condition,
            @RequestParam(value = "searchKeyword", defaultValue = "", required = false) String keyword,
            BoardVO boardVO, BoardDAO boardDAO, Model model) {
        log.info("글 목록 검색 처리");
        log.info("검색 조건: " + condition);
        log.info("검색 단어: " + keyword);

        model.addAttribute("boardList", boardDAO.getBoardList(boardVO));
        return "getBoardList.jsp";
    }
}
