<%@ page language="java" import="java.util.HashMap" pageEncoding="utf-8" %>
<%@ page import="dao.CommDAO" %>
<%@ page import="com.spring.entity.Shoucangjilu" %>
<%@ page import="dao.Query" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ssm" uri="http://ssm" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>我的收藏</title>
    <link rel="stylesheet" href="css/style.css" type="text/css">
</head>

<body>

<p>我的收藏：</p>
<table width="100%" class="table table-hover table-border">
    <thead>
    <tr>
        <td width="25" bgcolor="#CCFFFF">序号</td>
        <td width="790" bgcolor='#CCFFFF'>标题</td>
        <td width="135" align="center" bgcolor="#CCFFFF">收藏时间</td>
        <td width="75" align="center" bgcolor="#CCFFFF">操作</td>
    </tr>
    </thead>
    <tbody>

    <c:forEach items="${list}" var="map">
    <tr>
        <td width="25">
            ${map.id}
        </td>
        <td>
            <c:set var="ms" value="${map}" scope="page"/>
            <%
                Shoucangjilu ms = (Shoucangjilu) pageContext.getAttribute("ms");
                HashMap m = Query.make((String)ms.getBiao()).find(ms.getXwid());
                out.print(m.get(ms.getZiduan()));
            %>
        </td>
        <td width="135" align="center">${map.addtime}
        </td>
        <td width="75" align="center">
            <a href="shoucangjilu_delete.do?id=${map.id}"
                                         onclick="return confirm('真的要删除？')">删除</a>

            <a href="${map.biao}detail.do?id=${map.xwid}" target="_blank">详细</a>
        </td>
    </tr>
    </c:forEach>
    </tbody>
</table>

${page.info }

</body>
</html>

