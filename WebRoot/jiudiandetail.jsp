<%@ page language="java" import="dao.*" pageEncoding="UTF-8" %>
<%@ page language="java" import="java.util.*" %>
<%@page import="util.Info" %>
<%@ page import="com.spring.entity.Jiudian" %>
<%@ taglib prefix="ssm" uri="http://ssm" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="head.jsp" %>
<%@ include file="header.jsp" %>

<link rel="stylesheet" href="js/swiper/swiper.css">
<script src="js/swiper/swiper.js"></script>
<link rel="stylesheet" href="js/swiper/swiper.css">
<script src="js/swiper/swiper.js"></script>
<script src="js/jquery.validate.js"></script>


<div class="" style="">

    <% List bhtList = Query.make("lunbotu").order("id desc").limit(5).select();%>


    <div class="swiper-container" id="banner9">
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
        var mySwiper = new Swiper('#banner9', {
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
                            <span>酒店详情</span>
                        </h2>
                    </div>
                    <div class="section_content">


                        <div class="">
                            <div class="goods-info clearfix">
                                <div class="gallery-list">
                                    <div class="swiper-container gallery-top" id="shangpin-galler">
                                        <div class="swiper-wrapper">
                                        </div>
                                    </div>

                                </div>
                                <div class="goods-right-content">
                                    <h3 class="title">${map.jiudianmingcheng}</h3>
                                    <div class="descount">
                                        <div>
                        <span class="name">
                            酒店编号：
                        </span>
                                            <span class="val">
                                                ${map.jiudianbianhao} </span>
                                        </div>
                                        <div>
                        <span class="name">
                            酒店类型：
                        </span>
                                            <span class="val">
                                                ${map.jiudianleixing} </span>
                                        </div>
                                        <div>
                        <span class="name">
                            酒店地址：
                        </span>
                                            <span class="val">
                                                ${map.jiudiandizhi} </span>
                                        </div>
                                        <div>
                        <span class="name">
                            联系电话：
                        </span>
                                            <span class="val">
                                                ${map.lianxidianhua} </span>
                                        </div>
                                    </div>

                                    <div class="mt10">
                                        <button type="button" class="btn btn-default"
                                                onclick="location.href='collect.do?id=${map.id}&biao=jiudian&ziduan=jiudianmingcheng'">
                                            收藏酒店
                                        </button>
                                    </div>
                                </div>
                            </div>



                            <div class="goods-content">
                                酒店介绍：${map.jiudianjieshao}
                            </div>

                            <script>
                                (function () {
                                    var images = "${map.jiudiantupian}".split(",");
                                    if (images.length > 0) {
                                        for (var i = 0; i < images.length; i++) {
                                            var path = images[i]
                                            var src = '<div class="swiper-slide"><div class="img-box pb100"><div class="img" style="background-image: url(' + path + ')"></div></div></div>';
                                            $('#shangpin-galler .swiper-wrapper').append(src);
                                            $('#shangpin-thumb .swiper-wrapper').append(src);
                                        }

                                        var thumbsSwiper = new Swiper('#shangpin-thumb', {
                                            spaceBetween: 10,
                                            slidesPerView: 4,
                                            watchSlidesVisibility: true,//防止不可点击
                                        })
                                        var gallerySwiper = new Swiper('#shangpin-galler', {
                                            spaceBetween: 10,
                                            thumbs: {
                                                swiper: thumbsSwiper,
                                            }
                                        })
                                    }

                                })();

                            </script>

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


                <div class="section-dianzi">
                    <div class="section_title">
                        <h2>
                            <span>酒店客房</span>
                        </h2>
                    </div>
                    <div class="section_content">


                        <div class="list-table">
    <% List jiudiankefanglist17 = Query.make("jiudiankefang").where("jiudianid", Info.jstl("map.id")).limit(10).order("id desc").select();%>


                            <table width="100%" border="1" class="table table-list table-bordered table-hover">
                                <thead>
                                <tr align="center">
                                    <th> 酒店编号</th>
                                    <th> 酒店名称</th>
                                    <th> 酒店类型</th>
                                    <th> 客房类型</th>
                                    <th> 客房图片</th>
                                    <th> 客房价格</th>
                                    <th> 剩余客房数</th>
                                    <th>操作</th>
                                </tr>
                                </thead>
                                <tbody>

                                <c:set var="$i" value="0"/><c:forEach items="<%=jiudiankefanglist17%>" var="r"><c:set
                                        var="$i" value="${$i+1}"/>
                                    <tr>
                                        <td> ${r.jiudianbianhao} </td>
                                        <td> ${r.jiudianmingcheng} </td>
                                        <td> ${r.jiudianleixing} </td>
                                        <td> ${r.kefangleixing} </td>
                                        <td><c:choose>
                                            <c:when test="${'' == r.kefangtupian }">
                                                -</c:when><c:otherwise><img width="100"
                                                                            src="${r.kefangtupian}"/></c:otherwise></c:choose>
                                        </td>
                                        <td> ${r.kefangjiage} </td>
                                        <td> ${r.shengyukefangshu} </td>


                                        <td align="center">
                                            <a href="jiudianyudingadd.do?id=${r.id}">
                                                预定
                                            </a>
                                        </td>
                                    </tr>
                                </c:forEach>

                                </tbody>
                            </table>
                        </div>


                    </div>
                </div>
                <%
                    Jiudian map = (Jiudian) request.getAttribute("map");
                    List list = Query.make("pingjia").where("jiudianbianhao", map.getJiudianbianhao()).order("id desc").select();
                    request.setAttribute("list", list);
                %>

                <div class="section_title">
                    <h2>
                        <span>酒店评价</span>
                    </h2>
                </div>
                <div class="list-table">
                    <table width="100%" border="1" class="table table-list table-bordered table-hover">
                        <thead>
                        <tr align="center">
                            <th width="60" data-field="item">序号</th>

                            <th> 评分</th>
                            <th> 评价</th>
                            <th> 评价用户</th>
                            <th width="120" data-field="addtime">评价时间</th>

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

                                <td> ${map.pingfen} </td>
                                <td> ${map.pingjia} </td>
                                <td> ${map.pingjiayonghu} </td>
                                <td align="center">${map.addtime}</td>

                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>

            </div>


        </div>

        <!-- container定宽，并剧中结束 --></div>


</div>
<%@ include file="footer.jsp" %>
<%@ include file="foot.jsp" %>