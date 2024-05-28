<%@ page language="java" import="dao.*" pageEncoding="UTF-8" %>
<%@ page language="java" import="java.util.*" %>
<%@page import="util.Info" %>
<%@ taglib prefix="ssm" uri="http://ssm" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ include file="head.jsp" %>
<script src="js/datepicker/WdatePicker.js"></script>

<div style="padding: 10px">


    <div class="panel panel-default">
        <div class="panel-heading">
        <span class="module-name">
            酒店预定        </span>
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
                    <div class="form-group">
                        客房类型

                        <select class="form-control class_kefangleixing7" data-value="${param.kefangleixing}"
                                id="kefangleixing" name="kefangleixing">
                            <option value="">请选择</option>
                            <option value="单人房">单人房</option>
                            <option value="双人房">双人房</option>
                            <option value="套房">套房</option>

                        </select>
                        <script>
                            $(".class_kefangleixing7").val($(".class_kefangleixing7").attr("data-value"))</script>

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
                        <th> 预定单号</th>
                        <th> 酒店编号</th>
                        <th> 酒店名称</th>
                        <th> 酒店类型</th>
                        <th> 客房类型</th>
                        <th> 客房图片</th>
                        <th> 客房价格</th>
                        <th> 预计入住时间</th>
                        <th> 预定间数</th>
                        <th> 联系电话</th>
                        <th> 身份证号</th>
                        <th> 姓名</th>
                        <th> 预定用户</th>
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
                            <td> ${map.yudingdanhao} </td>
                            <td> ${map.jiudianbianhao} </td>
                            <td> ${map.jiudianmingcheng} </td>
                            <td> ${map.jiudianleixing} </td>
                            <td> ${map.kefangleixing} </td>
                            <td><c:choose>
                                <c:when test="${'' == map.kefangtupian }">
                                    -</c:when><c:otherwise><img width="100"
                                                                src="${map.kefangtupian}"/></c:otherwise></c:choose>
                            </td>
                            <td> ${map.kefangjiage} </td>
                            <td> ${map.yujiruzhushijian} </td>
                            <td> ${map.yudingjianshu} </td>
                            <td> ${map.lianxidianhua} </td>
                            <td> ${map.shenfenzhenghao} </td>
                            <td> ${map.xingming} </td>
                            <td> ${map.yudingyonghu} </td>
                            <td>
                                    ${map.iszf}
                                <c:choose>
                                    <c:when test="${'否' == map.iszf }">

                                        <a href="zhifu/index.jsp?id=${map.id}&biao=jiudianyuding&ordersn=${map.yudingdanhao}&zongji=${map.kefangjiage}">
                                            去支付
                                        </a>
                                    </c:when></c:choose>
                            </td>
                            <td align="center">${map.addtime}</td>
                            <td align="center">

                                <c:choose>
                                    <c:when test="${'是' == map.iszf }">
                                        <% if( Query.make("pingjia").where("jiudianyudingid" ,
                                                Info.makeTableParam(pageContext.getAttribute("map") , "id")
                                        ).count() == 0){ %>
                                        <a href="pingjia_add.do?id=${map.id}">评价</a>
                                        <% } %>

                                    </c:when></c:choose>


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
