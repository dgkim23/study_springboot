package info.thecodinglive.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/modicookie")
public class CookieModifyServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<html><head><title> cookie 수정 </title></head>");
        out.println("<body>");
        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("ck")) {
                    Cookie modifiedCookie = new Cookie("ck", "chunkind!! 슈퍼천재");
                    resp.addCookie(modifiedCookie);
                }
            }
        }
        out.println("쿠키수정!!!<br/>");
        out.println("<a href='/cookie.jsp'>목록</a></body></html>");
    }

}
