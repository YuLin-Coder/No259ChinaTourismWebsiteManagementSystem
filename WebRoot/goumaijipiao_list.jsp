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
            购买机票        </span>
            <span>列表</span>
        </div>
        <div class="panel-body">
            <div class="pa10 bg-warning">
                <form class="form-inline" action="?"><!-- form 标签开始 -->

                    <div class="form-group">


                        <i class="glyphicon glyphicon-search"></i>

                    </div>


                    <div class="form-group">
                        飞机票编号

                        <input type="text" class="form-control" style="" name="feijipiaobianhao"
                               value="${param.feijipiaobianhao}"/>
                    </div>
                    <div class="form-group">
                        起飞城市

                        <input type="text" class="form-control" style="" name="qifeichengshi"
                               value="${param.qifeichengshi}"/>
                    </div>
                    <div class="form-group">
                        身份证号

                        <input type="text" class="form-control" style="" name="shenfenzhenghao"
                               value="${param.shenfenzhenghao}"/>
                    </div>
                    <div class="form-group">
                        联系电话

                        <input type="text" class="form-control" style="" name="lianxidianhua"
                               value="${param.lianxidianhua}"/>
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
                        <th> 飞机票编号</th>
                        <th> 航班号</th>
                        <th> 所属航空公司</th>
                        <th> 起飞时间</th>
                        <th> 起飞城市</th>
                        <th> 到达城市</th>
                        <th> 到达时间</th>
                        <th> 检票口</th>
                        <th> 机票价格</th>
                        <th> 身份证号</th>
                        <th> 联系电话</th>
                        <th> 姓名</th>
                        <th> 购买用户</th>
                        <th width="80" data-field="iszf">是否支付</th>
                        <th width="120" data-field="addtime">添加时间</th>
                        <th width="220" data-field="handler">操作</th>
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
                            <td> ${map.feijipiaobianhao} </td>
                            <td> ${map.hangbanhao} </td>
                            <td> ${map.suoshuhangkonggongsi} </td>
                            <td> ${map.qifeishijian} </td>
                            <td> ${map.qifeichengshi} </td>
                            <td> ${map.daodachengshi} </td>
                            <td> ${map.daodashijian} </td>
                            <td> ${map.jianpiaokou} </td>
                            <td> ${map.jipiaojiage} </td>
                            <td> ${map.shenfenzhenghao} </td>
                            <td> ${map.lianxidianhua} </td>
                            <td> ${map.xingming} </td>
                            <td> ${map.goumaiyonghu} </td>
                            <td>
                                    ${map.iszf}
                                <c:choose>
                                    <c:when test="${'否' == map.iszf }">


                                    </c:when></c:choose>
                            </td>
                            <td align="center">${map.addtime}</td>
                            <td align="center">


                                <a href="goumaijipiao_updt.do?id=${map.id}">编辑</a>
                                <a href="goumaijipiao_delete.do?id=${map.id}" onclick="return confirm('确定要删除？')">删除</a>
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
