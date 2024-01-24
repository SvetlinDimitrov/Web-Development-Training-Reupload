package com.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(
        urlPatterns = {"/MyServlet"},
        initParams = {
                @WebInitParam(name = "param1", value = "value1"),
                @WebInitParam(name = "param2", value = "value2")
        }
)
public class MyServlet extends HttpServlet {

    private String param1;
    private String param2;

    @Override
    public void init() throws ServletException {
        param1 = getInitParameter("param1");
        param2 = getInitParameter("param2");
        // Additional initialization code
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Access parameters in your servlet logic
        response.getWriter().println("param1: " + param1);
        response.getWriter().println("param2: " + param2);
    }
}
