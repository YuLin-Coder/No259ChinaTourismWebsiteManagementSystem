<%@ page language="java" import="dao.*" pageEncoding="UTF-8" %>
<%@ page language="java" import="java.util.*" %>
<%@page import="util.Info" %>
<%@ taglib prefix="ssm" uri="http://ssm" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="head.jsp" %>
<%@ include file="header.jsp" %>

<link rel="stylesheet" href="js/swiper/swiper.css">
<script src="js/swiper/swiper.js"></script>
<link href="js/owl/owl.carousel.min.css" rel="stylesheet">
<script src="js/owl/owl.carousel.min.js"></script>


<div class="" style="">

        <% List bhtList = Query.make("lunbotu").order("id desc").limit(5).select();%>


    <div class="swiper-container" id="banner21">
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
        var mySwiper = new Swiper('#banner21', {
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
                            <span>酒店列表</span>
                        </h2>
                    </div>
                    <div class="section_content">


                        <div class="blog_carousel clearfix">

                            <div style="margin-bottom: 20px">


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
                                            <i class="glyphicon glyphicon-search"></i> 搜索
                                        </button>

                                        <!--form标签结束--></form>
                                </div>


                            </div>

                            <div class="row clearfix">
                                <c:forEach items="${list}" var="r">
                                    <div class="article-col col-md-3 col-xs-12">
                                        <article class="single_blog">
                                            <figure>
                                                <div class="blog_thumb">
                                                    <a href="jiudiandetail.do?id=${r.id}" class="img-box pb80">
                                                        <div class="img"
                                                             style="background-image: url('${r.jiudiantupian}')">
                                                        </div>
                                                    </a>
                                                </div>
                                                <figcaption class="blog_content">
                                                    <h4 class="post_title">
                                                        <a href="jiudiandetail.do?id=${r.id}">
                                                                ${Info.subStr(r.jiudianmingcheng, 20)}
                                                        </a>
                                                    </h4>
                                                        酒店地址：${r.jiudiandizhi}
                                                    <p class="post_desc">
                                                            介绍：${Info.subStr(r.jiudianjieshao, 45)}
                                                    </p>
                                                    <a href="jiudiandetail.do?id=${r.id}" class="btn-see"> + 查看详情</a>
                                                </figcaption>
                                            </figure>
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