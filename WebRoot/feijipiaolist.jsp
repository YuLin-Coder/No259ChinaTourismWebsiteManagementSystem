<%@ page language="java" import="dao.*" pageEncoding="UTF-8" %>
<%@ page language="java" import="java.util.*" %>
<%@page import="util.Info" %>
<%@ taglib prefix="ssm" uri="http://ssm" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="head.jsp" %>
<%@ include file="header.jsp" %>

<link rel="stylesheet" href="js/swiper/swiper.css">
<script src="js/swiper/swiper.js"></script>


<div class="" style="">

    <% List bhtList = Query.make("lunbotu").order("id desc").limit(5).select();%>


    <div class="swiper-container" id="banner34">
        <div class="swiper-wrapper">
            <c:forEach items="<%=bhtList%>" var="bht">
                <div class="swiper-slide">
                    <div class="decoimg_b2">
                        <a class="btn btn-" href="${bht.url}"
                           style="background-image: url('${bht.image}'); height: 400px"></a>
                    </div>
                </div>
            </c:forEach>
        </div>
        <!-- 如果需要分页器 -->
        <div class="swiper-pagination"></div>
        <!-- 如果需要导航按钮 -->
        <div class="swiper-button-prev"></div>
        <div class="swiper-button-next"></div>
    </div>


    <script>
        var mySwiper = new Swiper('#banner34', {
            loop: true, // 循环模式选项
            autoplay: {
                delay: 3000,
                disableOnInteraction: false
            },
            // 如果需要分页器
            pagination: {
                el: '.swiper-pagination',
            },
            // 如果需要前进后退按钮
            navigation: {
                nextEl: '.swiper-button-next',
                prevEl: '.swiper-button-prev',
            },
            // 如果需要滚动条
            /*scrollbar: {
                el: '.swiper-scrollbar',
            },*/
        })
    </script>


</div>
<div class="" style="">


    <div class="container"><!-- 使用bootstrap css框架，container定宽，并剧中 https://v3.bootcss.com/css/#overview-container -->

        <div class="row">

            <div class="col-sm-12 col-md-12">


                <div class="section-dianzi">
                    <div class="section_title">
                        <h2>
                            <span>飞机票列表</span>
                        </h2>
                    </div>
                    <div class="section_content">
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

                                    <input type="text" class="form-control" style="" name="hangbanhao"
                                           value="${param.hangbanhao}"/>
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
                                    <th>操作</th>
                                </tr>
                                </thead>
                                <tbody>

                                <c:set var="$i" value="0"/><c:forEach items="${list}" var="r"><c:set var="$i"
                                                                                                     value="${$i+1}"/>
                                    <tr>
                                        <td> ${r.feijipiaobianhao} </td>
                                        <td> ${r.hangbanhao} </td>
                                        <td> ${r.suoshuhangkonggongsi} </td>
                                        <td> ${r.qifeishijian} </td>
                                        <td> ${r.qifeichengshi} </td>
                                        <td> ${r.daodachengshi} </td>
                                        <td> ${r.daodashijian} </td>
                                        <td> ${r.jianpiaokou} </td>
                                        <td> ${r.jipiaojiage} </td>
                                        <td> ${r.shengyushuliang} </td>
                                        <td> ${r.goupiaoxuzhi} </td>


                                        <td align="center">
                                            <a href="goumaijipiaoadd.do?id=${r.id}">
                                                购票
                                            </a>
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


        </div>

        <!-- container定宽，并剧中结束 --></div>


</div>
<%@ include file="footer.jsp" %>
<%@ include file="foot.jsp" %>