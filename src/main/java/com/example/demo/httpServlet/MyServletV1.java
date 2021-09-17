package com.example.demo.httpServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MyServletV1 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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
        }else {
            throw new IllegalStateException("Dont know to do with this url");
        }
    }
}
