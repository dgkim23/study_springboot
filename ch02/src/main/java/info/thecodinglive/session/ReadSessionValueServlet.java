package info.thecodinglive.session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/readSessionValue")
public class ReadSessionValueServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter out = resp.getWriter();
        out.println("<html><head><title>세션</title></head><body>");

        HttpSession session = req.getSession();
        String sessionValue = (String) session.getAttribute("jpub");
        out.println("sessionId::" + session.getId() + "<br/>");//세션의 고유 아이디
        out.println("session created::" + session.getCreationTime() + "<br/>");//세션이 생성된 시간을 얻을 수 있는 메서드
        out.println("session lastAccessTime" + session.getLastAccessedTime() + "<br/>");//웹 브라우저가 가장 마지막에 세션에 접근한 시간을 얻을 수 있는 메서드
        out.println("생성된 세션 값:" + sessionValue + "<br/>");
        out.println("<a href='/session.jsp'>목록</a><br/>");
        out.println("</body></html>");
        out.close();
    }
}

