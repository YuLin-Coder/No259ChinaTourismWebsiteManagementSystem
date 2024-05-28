<%@ page language="java" import="dao.*" pageEncoding="UTF-8"%>
<%@ page language="java" import="java.util.*"%>
<%@page import="util.Info"%>
<%@ taglib prefix="ssm" uri="http://ssm" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="head.jsp" %>
<%@ include file="header.jsp" %>



<div class="" style="" >

    

<div class="container"><!-- 使用bootstrap css框架，container定宽，并剧中 https://v3.bootcss.com/css/#overview-container -->

        <div class="row">
    
                        <div class="col-sm-12 col-md-12">
    
                

    

<div class="section-dianzi">
        <div class="section_title">
            <h2>
                <span>新闻详情</span>
            </h2>
        </div>
        <div class="section_content">
            

    

<div class="news-info">
        <h3 class="title">
            ${map.biaoti}
        </h3>
        <div class="descount">
                        <span class="title">
                分类：
                <ssm:sql var="mapxinwenfenlei5" type="find">SELECT fenleimingcheng FROM xinwenfenlei where id='${map.fenlei}'</ssm:sql>${mapxinwenfenlei5.fenleimingcheng}            </span>
                        <span class="title">
                点击率：
                ${map.dianjilv}            </span>
                        <span class="title">
                添加人：
                ${map.tianjiaren}            </span>
                    </div>
        <div class="content">
            ${map.neirong}
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