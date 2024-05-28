<%@ page language="java" import="dao.*" pageEncoding="UTF-8"%>
<%@ page language="java" import="java.util.*"%>
<%@page import="util.Info"%>
<%@ taglib prefix="ssm" uri="http://ssm" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="head.jsp" %>
<%@ include file="header.jsp" %>



<div class="" style="margin:20px 0 0 0" >

    

<div class="container"><!-- 使用bootstrap css框架，container定宽，并剧中 https://v3.bootcss.com/css/#overview-container -->

        <div class="row">
    
                        <div class="col-sm-12 col-md-12">
    
                

    

<div class="section-dianzi">
        <div class="section_title">
            <h2>
                <span>新闻信息</span>
            </h2>
        </div>
        <div class="section_content">
            


    

<div class="">
                            <div style="margin-bottom: 20px">
                

    

<div class="pa10 bg-warning">
        <form class="form-inline" action="?"><!-- form 标签开始 -->
    
            <div class="form-group">
    
    
                <i class="glyphicon glyphicon-search"></i>
            
</div>
            
                                            <div class="form-group">
    标题
    
                    <input type="text" class="form-control" style="" name="biaoti" value="${param.biaoti}"/>                
</div>
                                            <div class="form-group">
    分类
    
                    <select class="form-control class_fenlei19" data-value="${param.fenlei}" data-rule-required="true" data-msg-required="请填写分类" id="fenlei" name="fenlei">
<option value="">请选择</option><ssm:sql var="select" type="select">SELECT * FROM xinwenfenlei ORDER BY id desc</ssm:sql>
<c:forEach items="${select}" var="m">
<option value="${m.id}">${m.fenleimingcheng}</option>
</c:forEach>

</select>
<script>
$(".class_fenlei19").val($(".class_fenlei19").attr("data-value"))</script>
                
</div>
                                                            <div class="form-group">
    添加人
    
                    <input type="text" class="form-control" style="" name="tianjiaren" value="${param.tianjiaren}"/>                
</div>
                                            <div class="form-group">
    点击率
    
                    <input type="text" class="form-control" style="width:80px;" name="dianjilv_start" value="${param.dianjilv_start}"/>-
<input type="text" class="form-control" style="width:80px;" name="dianjilv_end" value="${param.dianjilv_end}"/>                
</div>
                                            <div class="form-group">
    内容
    
                                    
</div>
            
            <select class="form-control" name="order" id="orderby">

                <option value="id">按发布时间</option>
                            
</select>
            <select class="form-control" name="sort" id="sort">

                <option value="desc">倒序</option>
                <option value="asc">升序</option>
            
</select>
            <script>$("#orderby").val("${orderby}");$("#sort").val("${sort}");</script>
            <button type="submit" class="btn btn-default">
    <i class="glyphicon glyphicon-search"></i> 搜索
</button>
        
<!--form标签结束--></form>
    </div>



            </div>
                <div class="news-list">
            <ul>
                <c:forEach items="${list}" var="r">
                <li class="clearfix">
                                        <a href="xinwenxinxidetail.do?id=${r.id}">
                    <div class="thumb">
                        <div class="img-box pb100">
                            <div class="img" style="background-image: url('${r.tupian}')"></div>
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
                                                        <span>添加人：${r.tianjiaren}</span>
                                                        <span>点击率：${r.dianjilv}</span>
                                                        <span>分类：<ssm:sql var="mapxinwenfenlei3" type="find">SELECT fenleimingcheng FROM xinwenfenlei where id='${r.fenlei}'</ssm:sql>${mapxinwenfenlei3.fenleimingcheng}</span>
                                                    </div>
                                            </div>
                </li>
                </c:forEach>
            </ul>
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