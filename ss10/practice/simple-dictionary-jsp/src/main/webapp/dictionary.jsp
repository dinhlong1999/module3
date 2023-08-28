<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.io.PrintWriter" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 27/08/2023
  Time: 9:13 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Translate</title>
</head>
<body>
  <%
    Map<String, String> dic = new HashMap<>();
  %>
  <%
    dic.put("Book","Quyển sách");
    dic.put("Car","Chiếc xe");
    dic.put("Computer","Máy tính");
    dic.put("Love","Yêu thương");

    String search = request.getParameter("search");
    String result = dic.get(search);
    PrintWriter printWriter = response.getWriter();
    if (result != null){
      printWriter.println("Word: " + search );
      printWriter.println("Result: "+ result);
    }else {
      printWriter.println("No found");
    }
  %>
<% int x =5;%>

</body>
</html>
