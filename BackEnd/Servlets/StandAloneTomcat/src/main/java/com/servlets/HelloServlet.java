package com.servlets;

import com.HelloEntity;
import com.HelloService;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {
    private final HelloService service = new HelloService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setHeader("Content-Type", "application/json");
        String countryParameter = req.getParameter("country");
        HelloEntity country = service.getByCountry(countryParameter);

        if (country == null) {
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
        } else {
            resp.setHeader("trace-country", country.getCountry());
            resp.setStatus(HttpServletResponse.SC_OK);
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writeValue(resp.getWriter(), country);
        }
    }
}
