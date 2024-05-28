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

    <% List bhtList = Query.make("lunbotu").order("id desc").limit(5).select(); %>

    <div class="swiper-container" id="banner49">
        <div class="swiper-wrapper">
            <c:forEach items="<%=bhtList%>" var="bht">
                <div class="swiper-slide">
                    <div class="decoimg_b2">
                        <a class="btn btn-" href="${bht.url}"
                           style="background-image: url('${bht.image}'); height: 700px"></a>
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
        var mySwiper = new Swiper('#banner49', {
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


                <div class="section-dianzi" style="margin:10px 0 0 0">
                    <div class="section_title">
                        <h2>
                            <span>景点攻略</span>
                        </h2>
                        <a href="jingdiangongluelist.do">更多</a>
                    </div>
                    <div class="section_content">


                        <div class="module-products clearfix">
                            <% List jingdiangongluelist53 = Query.make("jingdiangonglue").limit(4).order("id desc").select();%>

                            <div class="row products clearfix">
                                <c:forEach items="<%=jingdiangongluelist53%>" var="r">
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
                        </div>


                    </div>
                </div>


            </div>


        </div>

        <!-- container定宽，并剧中结束 --></div>


</div>
<div class="" style="">


    <div class="container"><!-- 使用bootstrap css框架，container定宽，并剧中 https://v3.bootcss.com/css/#overview-container -->

        <div class="row">

            <div class="col-sm-12 col-md-12">


                <div class="section-dianzi" style="margin:10px 0 0 0">
                    <div class="section_title">
                        <h2>
                            <span>酒店</span>
                        </h2>
                        <a href="jiudianlist.do">更多</a>
                    </div>
                    <div class="section_content">


                        <div class="blog_carousel clearfix">
                            <% List jiudianlist58 = Query.make("jiudian").limit(4).order("id desc").select();%>

                            <div class="row clearfix">
                                <c:forEach items="<%=jiudianlist58%>" var="r">
                                    <div class="article-col col-md-3 col-xs-12">
                                        <article class="single_blog">
                                            <figure>
                                                <div class="blog_thumb">
                                                    <a href="jiudiandetail.do?id=${r.id}"
                                                       class="img-box pb80 img-scale">
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
                                                       酒店地址： ${r.jiudiandizhi}
                                                    <p class="post_desc">
                                                         介绍：   ${Info.subStr(r.jiudianjieshao, 45)}
                                                    </p>
                                                    <a href="jiudiandetail.do?id=${r.id}" class="btn-see"> + 查看详情</a>
                                                </figcaption>
                                            </figure>
                                        </article>
                                    </div>
                                </c:forEach>
                            </div>

                        </div>


                    </div>
                </div>


            </div>


        </div>

        <!-- container定宽，并剧中结束 --></div>


</div>
<div class="" style="">


    <div class="container"><!-- 使用bootstrap css框架，container定宽，并剧中 https://v3.bootcss.com/css/#overview-container -->

        <div class="row">

            <div class="col-sm-12 col-md-12">


                <div class="section-dianzi" style="margin:10px 0 0 0">
                    <div class="section_title">
                        <h2>
                            <span>飞机票</span>

                        </h2>
                        <a href="feijipiaolist.do">更多</a>
                    </div>
                    <div class="section_content">


                        <div class="list-table">
                            <% List feijipiaolist63 = Query.make("feijipiao").limit(100).order("id desc").select();%>


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

                                </tr>
                                </thead>
                                <tbody>

                                <c:set var="$i" value="0"/><c:forEach items="<%=feijipiaolist63%>" var="r"><c:set var="$i"
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



                                    </tr>
                                </c:forEach>

                                </tbody>
                            </table>
                        </div>


                    </div>
                </div>


            </div>


        </div>

        <!-- container定宽，并剧中结束 --></div>


</div>
<div class="" style="">


    <div class="container"><!-- 使用bootstrap css框架，container定宽，并剧中 https://v3.bootcss.com/css/#overview-container -->

        <div class="row">

            <div class="col-sm-12 col-md-12">


                <div class="section-dianzi" style="margin:10px 0 0 0">
                    <div class="section_title">
                        <h2>
                            <span>新闻栏</span>
                        </h2>
                    </div>
                    <div class="section_content">


                        <div class="">
                            <% List xinwenxinxilist = Query.make("xinwenxinxi").limit(4).select(); %>
                            <div class="news-list">
                                <ul>
                                    <c:forEach items="<%=xinwenxinxilist%>" var="r">
                                        <li class="clearfix">
                                            <a href="xinwenxinxidetail.do?id=${r.id}">
                                                <div class="thumb">
                                                    <div class="img-box pb100">
                                                        <div class="img"
                                                             style="background-image: url('${r.tupian}')"></div>
                                                    </div>
                                                </div>
                                            </a>

                                            <div class="news-content-text ">
                                                <a href="xinwenxinxidetail.do?id=${r.id}">
                                                    <h3>${r.biaoti}</h3>
                                                </a>
                                                <div class="description">
                                                        ${Info.subStr(r.neirong, 80)}
                                                </div>
                                                <div class="other-content">
                                                    <span>点击率：${r.dianjilv}</span>
                                                </div>
                                            </div>
                                        </li>
                                    </c:forEach>
                                </ul>
                            </div>
                        </div>


                    </div>
                </div>


            </div>


        </div>

        <!-- container定宽，并剧中结束 --></div>


</div>
<%@ include file="footer.jsp" %>
<%@ include file="foot.jsp" %>