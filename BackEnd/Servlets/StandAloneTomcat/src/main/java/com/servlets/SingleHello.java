package com.servlets;

import com.HelloEntity;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.stream.Collectors;

@WebServlet("/hello/*")
public class SingleHello extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        if (req.getContentType().equalsIgnoreCase("application/json")) {
            String collect = req.getReader().lines().collect(Collectors.joining());
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            HelloEntity entity = objectMapper.readValue(collect, HelloEntity.class);

            resp.setContentType("application/json");
            objectMapper.writeValue(resp.getWriter(), entity);
        }
    }
}
