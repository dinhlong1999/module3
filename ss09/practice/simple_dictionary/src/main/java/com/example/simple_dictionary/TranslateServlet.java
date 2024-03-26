package com.example.simple_dictionary;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "TranslateServlet", value = "/translate")
public class TranslateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            Map<String, String> dictionary = new HashMap<>();
            dictionary.put("hello","Xin Chào");
            dictionary.put("car","Xe oto");
            dictionary.put("how","Thế nào");
            dictionary.put("book","Quyển vở");
            dictionary.put("computer","Máy tính");
            String search = request.getParameter("txtSearch");
            String result = dictionary.get(search);
            if (result != null){
                request.setAttribute("txtSearch",search);
                request.setAttribute("result",result);
            }
            else {
                result = "No found";
                request.setAttribute("result", result );
            }
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/result.jsp");
            requestDispatcher.forward(request,response);


    }
}