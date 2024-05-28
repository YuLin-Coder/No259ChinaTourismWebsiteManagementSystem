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


    <div class="swiper-container" id="banner4">
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
        var mySwiper = new Swiper('#banner4', {
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
                            <span>景点攻略列表</span>
                        </h2>
                    </div>
                    <div class="section_content">


                        <div class="module-products clearfix">

                            <div style="margin-bottom: 20px">


                                <div class="pa10 bg-warning">
                                    <form class="form-inline" action="?"><!-- form 标签开始 -->

                                        <div class="form-group">


                                            <i class="glyphicon glyphicon-search"></i>

                                        </div>

                                        <div class="form-group">
                                            景点编号

                                            <input type="text" class="form-control" style="" name="jingdianbianhao"
                                                   value="${param.jingdianbianhao}"/>
                                        </div>
                                        <div class="form-group">
                                            景点名称

                                            <input type="text" class="form-control" style="" name="jingdianmingcheng"
                                                   value="${param.jingdianmingcheng}"/>
                                        </div>
                                        <div class="form-group">
                                            所在城市

                                            <input type="text" class="form-control" style="" name="suozaichengshi"
                                                   value="${param.suozaichengshi}"/>
                                        </div>


                                        <button type="submit" class="btn btn-default">
                                            <i class="glyphicon glyphicon-search"></i> 搜索
                                        </button>

                                        <!--form标签结束--></form>
                                </div>


                            </div>

                            <div class="row products clearfix">
                                <c:forEach items="${list}" var="r">
                                    <div class="products-col col-md-3 col-xs-12">
                                        <article>
                                            <a href="jingdiangongluedetail.do?id=${r.id}" class="pro-btn pro-btn-add">
                                                查看
                                            </a>
                                            <div class="figure-grid">
                                                <div class="image">
                                                    <div class="img-box pb100 img-scale">
                                                        <a class="img" href="jingdiangongluedetail.do?id=${r.id}"
                                                           style="background-image: url('${Info.images(r.jingdiantupian)}')"></a>
                                                    </div>
                                                </div>
                                                <div class="text">
                                                    <h2 class="title h4">
                                                        <a href="jingdiangongluedetail.do?id=${r.id}">
                                                                ${r.jingdianmingcheng}
                                                        </a>
                                                    </h2>
                                                    <sup>门票价格： ${r.menpiaojiage}</sup>
                                                    <span class="description clearfix">
                                                            ${Info.subStr(r.gongluexiangqing , 12)}
                                                    </span>
                                                </div>
                                            </div>
                                        </article>
                                    </div>
                                </c:forEach>
                            </div>
                            ${page.info}
                        </div>


                    </div>
                </div>


            </div>


        </div>

        <!-- container定宽，并剧中结束 --></div>


</div>
<%@ include file="footer.jsp" %>
<%@ include file="foot.jsp" %>