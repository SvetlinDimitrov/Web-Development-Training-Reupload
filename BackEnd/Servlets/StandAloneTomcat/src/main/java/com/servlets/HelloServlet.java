package com.servlets;

import com.HelloService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {
    private final HelloService service = new HelloService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Servlet say hello there");

        Map<String, String[]> parameterMap = req.getParameterMap();
        String country1 = req.getParameter("country");
        System.out.println(country1);
        try {
            String country = Arrays.stream(parameterMap.get("country")).findFirst().get();
            System.out.println("The country that you want is " + country);
            System.out.println(service.getByCountry(country));
        }catch (Exception e){
            System.out.println("There is no country with that name");
        }
//        Not providing the parameter =>
//        Servlet say hello there
//        null
//        There is no country with that name

//        Providing the valid parameter =>
//        Servlet say hello there
//        Bulgaria
//        The country that you want is Bulgaria
//        HelloEntity{country='Bulgaria', message='Здравейте!'}

    }

}
