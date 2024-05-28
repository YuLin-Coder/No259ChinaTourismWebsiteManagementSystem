<%@ page language="java" import="dao.*" pageEncoding="UTF-8" %>
<%@ page language="java" import="java.util.*" %>
<%@page import="util.Info" %>
<%@ taglib prefix="ssm" uri="http://ssm" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ include file="head.jsp" %>

<div style="padding: 10px">


    <div class="panel panel-default">
        <div class="panel-heading">
        <span class="module-name">
            评价        </span>
            <span>列表</span>
        </div>
        <div class="panel-body">
            <div class="pa10 bg-warning">
                <form class="form-inline" action="?"><!-- form 标签开始 -->

                    <div class="form-group">


                        <i class="glyphicon glyphicon-search"></i>

                    </div>


                    <div class="form-group">
                        酒店编号

                        <input type="text" class="form-control" style="" name="jiudianbianhao"
                               value="${param.jiudianbianhao}"/>
                    </div>
                    <div class="form-group">
                        酒店名称

                        <input type="text" class="form-control" style="" name="jiudianmingcheng"
                               value="${param.jiudianmingcheng}"/>
                    </div>

                    <button type="submit" class="btn btn-default">
                        搜索
                    </button>


                    <!--form标签结束--></form>
            </div>


            <div class="list-table">
                <table width="100%" border="1" class="table table-list table-bordered table-hover">
                    <thead>
                    <tr align="center">
                        <th width="60" data-field="item">序号</th>
                        <th> 酒店编号</th>
                        <th> 酒店名称</th>
                        <th> 评分</th>
                        <th> 评价</th>
                        <th> 评价用户</th>
                        <th width="120" data-field="addtime">评价时间</th>
                        <th width="80" data-field="handler">操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:set var="i" value="0"/><c:forEach items="${list}" var="map"><c:set var="i" value="${i+1}"/>
                        <tr id="${map.id}" pid="">
                            <td width="30" align="center">
                                <label>
                                        ${i}
                                </label>
                            </td>
                            <td> ${map.jiudianbianhao} </td>
                            <td> ${map.jiudianmingcheng} </td>
                            <td> ${map.pingfen} </td>
                            <td> ${map.pingjia} </td>
                            <td> ${map.pingjiayonghu} </td>
                            <td align="center">${map.addtime}</td>
                            <td align="center">


                                <a href="pingjia_detail.do?id=${map.id}">详情</a>

                                <!--qiatnalijne-->
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>

            ${page.info}
        </div>


    </div>


</div>
<%@ include file="foot.jsp" %>
