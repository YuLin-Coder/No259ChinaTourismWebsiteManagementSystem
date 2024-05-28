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
            飞机票        </span>
            <span>列表</span>
        </div>
        <div class="panel-body">
            <div class="pa10 bg-warning">
                <form class="form-inline" action="?"><!-- form 标签开始 -->

                    <div class="form-group">


                        <i class="glyphicon glyphicon-search"></i>

                    </div>

                    <div class="form-group">
                        关键字

                        <input type="text" class="form-control" name="keyword" value="${param.keyword}"
                               placeholder="输入关键字"/>

                    </div>

                    <div class="form-group">
                        航班号

                        <input type="text" class="form-control" style="" name="hangbanhao" value="${param.hangbanhao}"/>
                    </div>
                    <div class="form-group">
                        所属航空公司

                        <input type="text" class="form-control" style="" name="suoshuhangkonggongsi"
                               value="${param.suoshuhangkonggongsi}"/>
                    </div>
                    <div class="form-group">
                        起飞城市

                        <input type="text" class="form-control" style="" name="qifeichengshi"
                               value="${param.qifeichengshi}"/>
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
                        <th> 剩余数量</th>
                        <th> 购票须知</th>
                        <th width="120" data-field="addtime">添加时间</th>
                        <th width="180" data-field="handler">操作</th>
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
                            <td> ${map.shengyushuliang} </td>
                            <td> ${map.goupiaoxuzhi} </td>
                            <td align="center">${map.addtime}</td>
                            <td align="center">



                                <a href="feijipiao_detail.do?id=${map.id}">详情</a>
                                <a href="feijipiao_updt.do?id=${map.id}">编辑</a>
                                <a href="feijipiao_delete.do?id=${map.id}" onclick="return confirm('确定要删除？')">删除</a>
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
