package me.zw.mvc.controller;

import java.util.HashMap;
import java.util.Map;

public class HandlerMapping {

    private Map<String, Controller> mapping;

    public HandlerMapping() {
        mapping = new HashMap<>();
        mapping.put("/login.do", new LoginController());
        mapping.put("/getBoardList.do", new GetBoardListController());
        mapping.put("/getBoard.do", new GetBoardController());
        mapping.put("/insertBoard.do", new InsertBoardController());
        mapping.put("/updateBoard.do", new UpdateBoardController());
        mapping.put("/deleteBoard.do", new DeleteBoardController());
        mapping.put("/logout.do", new LogoutController());
    }

    public Controller getController(String path) {
        return mapping.get(path);
    }

}
