package info.thecodinglive.basic;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(
    name="Init", urlPatterns = {"/init"},
    initParams = { @WebInitParam(name="siteName", value="jpub") }
)
public class InitServlet extends HttpServlet {
    private String myParam = "";

    @Override
    public void init() throws ServletException {
        System.out.println("init call....");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().println("hello");
    }
}
