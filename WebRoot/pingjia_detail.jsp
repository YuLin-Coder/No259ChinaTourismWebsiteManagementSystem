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
        评价详情
    </div>
    <div class="panel-body">

        <div class="admin-detail clearfix">
                            <div class="detail detail-text">
                    <div class="detail-title">
                        酒店编号：
                    </div>
                    <div class="detail-content">
                        ${map.jiudianbianhao}                    </div>
                </div>
                            <div class="detail detail-text">
                    <div class="detail-title">
                        酒店名称：
                    </div>
                    <div class="detail-content">
                        ${map.jiudianmingcheng}                    </div>
                </div>
                            <div class="detail detail-select">
                    <div class="detail-title">
                        评分：
                    </div>
                    <div class="detail-content">
                        ${map.pingfen}                    </div>
                </div>
                            <div class="detail detail-textarea">
                    <div class="detail-title">
                        评价：
                    </div>
                    <div class="detail-content">
                        ${map.pingjia}                    </div>
                </div>
                            <div class="detail detail-textuser">
                    <div class="detail-title">
                        评价用户：
                    </div>
                    <div class="detail-content">
                        ${map.pingjiayonghu}                    </div>
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
