<%@ page language="java" import="dao.*" pageEncoding="UTF-8"%>
<%@ page language="java" import="java.util.*"%>
<%@page import="util.Info"%>
<%@ taglib prefix="ssm" uri="http://ssm" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ include file="head.jsp" %>

<div style="padding: 10px">



<style>
    .admin-detail {
        display: flex;
        flex-wrap: wrap;
    }
    .admin-detail .detail {
        width: 50%;
        padding: 5px;
        display: flex;
        margin-bottom: 10px;
        border-bottom: 1px solid #DEDEDE;
    }
    .admin-detail .detail .detail-title {
        width: 120px;
        text-align: right;
    }
    .admin-detail .detail .detail-content {
        flex-grow: 1;
    }
    .admin-detail .detail.detail-editor {
        width: 100%;
        flex-wrap: wrap;
    }
    .admin-detail .detail.detail-editor .detail-title {
        width: 100%;
        padding: 10px;
        margin-top: 10px;
        background: #9a0606;
        color: #ffffff;
        text-align: left;
    }
    .admin-detail .detail.detail-editor .detail-content{
        padding: 10px;
    }

</style>




<div class="panel panel-default">
    <div class="panel-heading">
        新闻信息详情
    </div>
    <div class="panel-body">

        <div class="admin-detail clearfix">
                            <div class="detail detail-longtext">
                    <div class="detail-title">
                        标题：
                    </div>
                    <div class="detail-content">
                        ${map.biaoti}                    </div>
                </div>
                            <div class="detail detail-select">
                    <div class="detail-title">
                        分类：
                    </div>
                    <div class="detail-content">
                        <ssm:sql var="mapxinwenfenlei4" type="find">SELECT fenleimingcheng FROM xinwenfenlei where id='${map.fenlei}'</ssm:sql>${mapxinwenfenlei4.fenleimingcheng}                    </div>
                </div>
                            <div class="detail detail-image">
                    <div class="detail-title">
                        图片：
                    </div>
                    <div class="detail-content">
                        <img src="${map.tupian}" style="width: 350px"/>                    </div>
                </div>
                            <div class="detail detail-textuser">
                    <div class="detail-title">
                        添加人：
                    </div>
                    <div class="detail-content">
                        ${map.tianjiaren}                    </div>
                </div>
                            <div class="detail detail-number">
                    <div class="detail-title">
                        点击率：
                    </div>
                    <div class="detail-content">
                        ${map.dianjilv}                    </div>
                </div>
                            <div class="detail detail-editor">
                    <div class="detail-title">
                        内容：
                    </div>
                    <div class="detail-content">
                        ${map.neirong}                    </div>
                </div>
                    </div>

        <div class="button-list mt10">
            <div class="">
                <button type="button" class="btn btn-default" onclick="history.go(-1);">
    返回
                
</button>
                <button type="button" class="btn btn-default" onclick="window.print()">
    打印本页
                
</button>
            </div>
        </div>

    </div>
</div>







</div>
<%@ include file="foot.jsp" %>
