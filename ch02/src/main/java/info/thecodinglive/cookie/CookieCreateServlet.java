package info.thecodinglive.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

@WebServlet(urlPatterns = "/newcookie")
public class CookieCreateServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<html><head><title> 쿠키 예제</title></head><body>");
        out.println("<br/>");
//        Cookie jcookie = new Cookie("ck", "fjiwjeofjfaowejfoijwoej;");
        Cookie jcookie = new Cookie("ck", "fjiwjeofjfaowejfoijwoej");
        jcookie.setMaxAge(3600);
        resp.addCookie(jcookie);
        out.println("쿠키생성!!!<br/>");
        out.println("<a href='/cookie.jsp'>목록</a></body></html>");
    }
}
