package com.example.product_discount;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "com.example.product_discount.ProductDiscount", value = "/calculator")
public class ProductDiscount extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String productName = request.getParameter("productName");
    Double productPrice = Double.parseDouble(request.getParameter("productPrice"));
    Double productPercent = Double.parseDouble(request.getParameter("productPercent"));

    Double discountAmount = productPrice * productPercent * 0.01;
    Double result = productPrice - discountAmount;
    request.setAttribute("productName",productName);
    request.setAttribute("productPrice",productPrice);
    request.setAttribute("discount_Amount",discountAmount);
    request.setAttribute("result",result);
    RequestDispatcher requestDispatcher = request.getRequestDispatcher("/display-discount.jsp");
    requestDispatcher.forward(request,response);
    }
}