<%@ page language="java" import="dao.*" pageEncoding="UTF-8" %>
<%@ page language="java" import="java.util.*" %>
<%@page import="util.Info" %>
<%@ page import="com.spring.entity.Jingdiangonglue" %>
<%@ taglib prefix="ssm" uri="http://ssm" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="head.jsp" %>
<%@ include file="header.jsp" %>

<link rel="stylesheet" href="js/swiper/swiper.css">
<script src="js/swiper/swiper.js"></script>
<link rel="stylesheet" href="js/swiper/swiper.css">
<script src="js/swiper/swiper.js"></script>
<script src="js/jquery.validate.js"></script>
<script src="http://api.map.baidu.com/api?v=2.0&ak=AoBYL0LlRkcYBMCeay4fgpq7qaIYlKjs"></script>
<link href="js/baidumap.css" rel="stylesheet">
<script src="js/baidumap.js"></script>


<div class="" style="">

    <% List bhtList = Query.make("lunbotu").order("id desc").limit(5).select();%>


    <div class="swiper-container" id="banner11">
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
        var mySwiper = new Swiper('#banner11', {
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
                            <span>景点攻略详情</span>
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
                                    <div class="swiper-container gallery-thumbs" id="shangpin-thumb">
                                        <div class="swiper-wrapper">
                                        </div>
                                    </div>
                                </div>
                                <div class="goods-right-content">
                                    <h3 class="title">${map.jingdianmingcheng}</h3>
                                    <div class="descount">
                                        <div>
                        <span class="name">
                            景点编号：
                        </span>
                                            <span class="val">
                                                ${map.jingdianbianhao} </span>
                                        </div>
                                        <div>
                        <span class="name">
                            所在城市：
                        </span>
                                            <span class="val">
                                                ${map.suozaichengshi} </span>
                                        </div>
                                        <div>
                        <span class="name">
                            门票价格：
                        </span>
                                            <span class="val">
                                                ${map.menpiaojiage} </span>
                                        </div>
                                        <div>
                        <span class="name">
                            开放时间：
                        </span>
                                            <span class="val">
                                                ${map.kaifangshijian} </span>
                                        </div>
                                        <div>
                        <span class="name">
                            景点位置：
                        </span>
                                            <span class="val">
                            <div id="jingdianweizhi_view" class="address" style="width: 80%;height: 350px;"></div><script>
                        try {
                            showAddressView("jingdianweizhi", ${map.jingdianweizhi});
                        } catch (e) {

                        }</script>                        </span>
                                        </div>
                                    </div>

                                    <div class="mt10">
                                        <button type="button" class="btn btn-default"
                                                onclick="location.href='collect.do?id=${map.id}&biao=jingdiangonglue&ziduan=jingdianmingcheng'">
                                            收藏景点
                                        </button>
                                    </div>
                                </div>
                            </div>
                            <div class="goods-content">
                                ${map.gongluexiangqing}
                            </div>

                            <script>
                                (function () {
                                    var images = "${map.jingdiantupian}".split(",");
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
                            <span>评价区</span>
                        </h2>
                    </div>
                    <div class="section_content">


                        <div class="gr-control-module-table">
                            <div class="">
                                <form action="pingluninsert.do" method="post"><!-- form 标签开始 -->

                                    <%--<div class="form-group" style="display: none">
                                        <div class="row">
                                            <label style="max-width: 120px;min-height:18px;text-align: right"
                                                   class="col-sm-2 hiddex-xs">评分</label>
                                            <div class="col-sm-10">

                                                <select class="form-control" name="pingfen">

                                                    <option value="1">1分</option>
                                                    <option value="2">2分</option>
                                                    <option value="3">3分</option>
                                                    <option value="4">4分</option>
                                                    <option value="5">5分</option>

                                                </select>

                                            </div>

                                        </div>
                                    </div>--%>
                                    <div class="form-group">


                                        <textarea style="width: 80%;height: 120px" class="form-control"
                                                  name="pinglunneirong" placeholder="请输入评论内容"></textarea>

                                    </div>
                                    <input type="hidden" name="biao" value="jingdiangonglue"/>
                                    <input name="biaoid" type="hidden" id="biaoid" value="${map.id}"/>
                                    <input name="biaoti" type="hidden" id="biaoti" value="${map.jingdianmingcheng}"/>
                                    <input name="pinglunren" type="hidden" value="${sessionScope.username}"/>
                                    <div style="text-align: left">

                                        <% if (request.getSession().getAttribute("username") != null ) { %>
                                        <button type="submit" class="btn btn-primary">
                                            发布评论
                                        </button>

                                        <% } else { %>
                                        <button type="button" onclick="alert('你尚未登录,请先登录在评论')" class="btn btn-primary">
                                            发布评论
                                        </button>
                                        <% } %>

                                    </div>

                                    <!--form标签结束--></form>
                            </div>

<%
    Jingdiangonglue map = (Jingdiangonglue) request.getAttribute("map");
    List pinglunList = Query.make("pinglun").where("biao", "jingdiangonglue").where("biaoid", map.getId()).order("id desc").select();
%>

                            <div class="mt10">
                                <c:forEach items="<%=pinglunList%>" var="pl">
                                    ${user = Query.make("yonghu").where("yonghuming", pl.pinglunren).find();""}

                                    <div class="comment clearfix">
                                        <div class="common-avatar J_User">
                                            <c:choose>
                                                <c:when test="${user.touxiang == '' }">

                                                    <img src="images/default.gif" width="100%" height="100%"/>
                                                </c:when><c:otherwise>
                                                <img src="${user.touxiang}" width="100%" height="100%"/>
                                            </c:otherwise></c:choose>
                                        </div>
                                        <div class="comment-block">
                                            <p class="comment-user"><span
                                                    class="comment-username J_User"> ${user.xingming} </span>
                                                <span class="comment-time">${pl.addtime}</span></p>
                                            <div class="comment-content J_CommentContent">${pl.pinglunneirong}</div>
                                        </div>
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
<%@ include file="footer.jsp" %>
<%@ include file="foot.jsp" %>