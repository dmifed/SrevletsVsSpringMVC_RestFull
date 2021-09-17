package com.example.demo.httpServlet;

import com.example.demo.httpServlet.userDAO.User;
import com.example.demo.httpServlet.userDAO.UserDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author dmifed
 */
public class MyServletJSON extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        if(req.getRequestURI().equals("/")){
            resp.setContentType("text/html");
            resp.getWriter().print(
                    "<html>" +
                            "<head>" +
                            "</head>" +
                            "<body>" +
                            "<h1>Welcome!</h1>" +
                            "<p>This is a very cool page!</p>" +
                            "</body>" +
                            "</html>"
            );
        }
        else if(req.getRequestURI().startsWith("/api/users/")){
            int userId = Integer.parseInt(req.getRequestURI().substring(req.getRequestURI().lastIndexOf("/") + 1));
            resp.setContentType("application/json");

            User user = UserDAO.getUser(userId);
            resp.getWriter().print(user.toJSON());

        }else {
            throw new IllegalStateException("Don't know to do with this url");
        }
    }
}
