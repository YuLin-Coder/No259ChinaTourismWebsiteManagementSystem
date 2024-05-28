<%@ page language="java" import="dao.*" pageEncoding="utf-8" %>
<%@page import="java.util.HashMap" %>
<%@page import="util.*" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>My JSP 'adminyanzheng.jsp' starting page</title>
</head>
<body>
<%
    String id = request.getParameter("id");
    String biao = request.getParameter("biao");
    HashMap order = new CommDAO().getmap(id, biao);

    String sql = "update " + biao + " set iszf='是' where id='" + id + "'";
    new CommDAO().commOper(sql);

    

    out.print("<script>alert('支付成功!!');location.href='"+(Request.get("referer").equals("")?"sy.jsp":Request.get("referer"))+"';</script>");


%>
</body>
</html>

