package com.example.javawebcurrencyconverter;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ConverterServlet", value = "/convert")
public class ConverterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    float rate = Float.parseFloat(request.getParameter("rate"));
    float usd = Float.parseFloat(request.getParameter("usd"));

    float vnd = usd * rate;
    request.setAttribute("vnd",vnd);
    request.setAttribute("rate",rate);
    request.setAttribute("usd",usd);
    RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/test.jsp");
    requestDispatcher.forward(request,response);
    }
}