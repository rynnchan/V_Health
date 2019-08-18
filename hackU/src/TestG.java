import java.io.*;
import java.rmi.ServerException;

import javax.servlet.http.HttpServlet;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/TestGet")
public class TestG extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public TestG() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServerException, IOException {
        request.setCharacterEncoding("UTF8");
        response.setContentType("text/html; charset=UTF8");
        response.getWriter().append("get1:").append(request.getParameter("aaa"));
        response.getWriter().append("<BR>");
		response.getWriter().append("get2:").append(request.getParameter("bbb"));
    }
}