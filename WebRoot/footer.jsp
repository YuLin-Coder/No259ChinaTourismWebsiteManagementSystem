<%@ page language="java" import="dao.*" pageEncoding="UTF-8"%>
<%@ page language="java" import="java.util.*"%>
<%@page import="util.Info"%>
<%@ taglib prefix="ssm" uri="http://ssm" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>




<div class="footer mt10">
<% List likeList = Query.make("youqinglianjie").order("id desc").select();%>

        <div class="copyrightnr link">
            友情链接 
            <c:forEach items="<%=likeList%>" var="v">
            <a href="${v.wangzhi}" target="_blank">${v.wangzhanmingcheng}</a>  
            </c:forEach>
        </div>

        <div class="copyrightnr">
            地址：xxxxxxxxxxxxx　　电话：0000-00000000　　手机：12312312312
            <br></br>
            版权所有：中国旅游网站 　　ICP备********号        </div>
    </div>



