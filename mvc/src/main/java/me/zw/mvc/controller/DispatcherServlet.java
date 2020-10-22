package me.zw.mvc.controller;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
public class DispatcherServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private HandlerMapping handlerMapping;

    private ViewResolver viewResolver;

    @Override
    public void init() throws ServletException {
        handlerMapping = new HandlerMapping();
        viewResolver = new ViewResolver();
        viewResolver.setPrefix("./");
        viewResolver.setSuffix(".jsp");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        process(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);
        process(req, resp);
    }

    private void process(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 클라이언트 요청의 path 정보를 추출
        String uri = request.getRequestURI();
        String path = uri.substring(uri.lastIndexOf("/"));
        log.info(path);

        // path 에 해당하는 Controller 검색
        Controller controller = handlerMapping.getController(path);

        // 검색된 Controller 를 실행
        String viewName = controller.handleRequest(request, response);

        // ViewResolver 를 통해 viewName 에 맞는 화면 검색
        String view = null;
        if (!viewName.contains(".do")) {
            view = viewResolver.getView(viewName);
        } else {
            view = viewName;
        }

        // 검색된 화면으로 이동
        response.sendRedirect(view);
    }
}
