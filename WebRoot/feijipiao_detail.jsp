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
        飞机票详情
    </div>
    <div class="panel-body">

        <div class="admin-detail clearfix">
                            <div class="detail detail-text">
                    <div class="detail-title">
                        飞机票编号：
                    </div>
                    <div class="detail-content">
                        ${map.feijipiaobianhao}                    </div>
                </div>
                            <div class="detail detail-text">
                    <div class="detail-title">
                        航班号：
                    </div>
                    <div class="detail-content">
                        ${map.hangbanhao}                    </div>
                </div>
                            <div class="detail detail-text">
                    <div class="detail-title">
                        所属航空公司：
                    </div>
                    <div class="detail-content">
                        ${map.suoshuhangkonggongsi}                    </div>
                </div>
                            <div class="detail detail-datetime">
                    <div class="detail-title">
                        起飞时间：
                    </div>
                    <div class="detail-content">
                        ${map.qifeishijian}                    </div>
                </div>
                            <div class="detail detail-text">
                    <div class="detail-title">
                        起飞城市：
                    </div>
                    <div class="detail-content">
                        ${map.qifeichengshi}                    </div>
                </div>
                            <div class="detail detail-text">
                    <div class="detail-title">
                        到达城市：
                    </div>
                    <div class="detail-content">
                        ${map.daodachengshi}                    </div>
                </div>
                            <div class="detail detail-datetime">
                    <div class="detail-title">
                        到达时间：
                    </div>
                    <div class="detail-content">
                        ${map.daodashijian}                    </div>
                </div>
                            <div class="detail detail-text">
                    <div class="detail-title">
                        检票口：
                    </div>
                    <div class="detail-content">
                        ${map.jianpiaokou}                    </div>
                </div>
                            <div class="detail detail-money">
                    <div class="detail-title">
                        机票价格：
                    </div>
                    <div class="detail-content">
                        ${map.jipiaojiage}                    </div>
                </div>
                            <div class="detail detail-number">
                    <div class="detail-title">
                        剩余数量：
                    </div>
                    <div class="detail-content">
                        ${map.shengyushuliang}                    </div>
                </div>
                            <div class="detail detail-textarea">
                    <div class="detail-title">
                        购票须知：
                    </div>
                    <div class="detail-content">
                        ${map.goupiaoxuzhi}                    </div>
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
