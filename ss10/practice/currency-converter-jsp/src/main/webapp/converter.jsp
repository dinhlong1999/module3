<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 27/08/2023
  Time: 9:01 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Converter</title>
</head>
<body>
<%
    Float rate = Float.parseFloat(request.getParameter("rate"));
    Float usd = Float.parseFloat(request.getParameter("usd"));

    Float vnd = rate * usd;
%>
<h1> Rate: <%=rate%>
</h1>
<h1> USD: <%=usd%>
</h1>
<h1> VND: <%=vnd%>
</h1>
</body>
</html>
